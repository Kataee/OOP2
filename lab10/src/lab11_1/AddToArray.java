package lab11_1;

import java.sql.SQLOutput;


public class AddToArray extends Thread {
    private String[] array;
    //Random r = new Random();

    public AddToArray(String[] array) {
        this.array = array;
    }


    //ide kell írni, amit akarunk hogy a szál futtasson
    @Override
    public void run() {


        while(true){
            if (Main.maxOperations < 0) {
                System.out.println(Thread.currentThread().getName() + " Thread ended.");
                break;
            }
            synchronized (array) {
                work();
                //print the array
                printArray();
            }


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;

            }
        }


    }

    private void printArray() {

        System.out.println("\n##################################################\n");
        System.out.println(Thread.currentThread().getName() + " print started...");
        for (String s : array) {
            System.out.printf("%s ", s);
        }

        System.out.println("\n" + Thread.currentThread().getName() + " print ended");
    }

    private void work() {
        //general egy karakterlancot
        String asd;
        int number = (int) Math.floor(Math.random()*(122-97+1)+97);
        char zxc = (char) number;
        asd = String.valueOf(zxc);
        asd += String.valueOf(zxc);
        asd += String.valueOf(zxc);

        /*
        String character = String.valueOf(random.nextInt('z' - 'a') + 'a');
        String generatedString = character.repeat(3);
         */

        //min pozicio
        int minPosition = findMinPosition();
        //System.out.println(minPosition + " rand:" + number);


        //generalt String behelyezese a tombbe
        array[minPosition] = asd;
        Main.maxOperations--;
    }

    private int findMinPosition() {
        String min = array[0];
        int minPoz = 0;
        for (int i=1; i< array.length; ++i) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
                minPoz = i;
            }
        }
        return minPoz;
    }
}

