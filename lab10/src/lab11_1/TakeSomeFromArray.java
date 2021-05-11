package lab11_1;

public class TakeSomeFromArray extends Thread {

    private String[] array;
    private int numberOfReplacements;
    private String stringToBeReplaced;
    private int currentNumberOfReplacements = 0;

    public TakeSomeFromArray(String[] array, int numberOfReplacements, String stringToBeReplaced) {
        this.array = array;
        this.numberOfReplacements = numberOfReplacements;
        this.stringToBeReplaced = stringToBeReplaced;
    }


    @Override
    public void run() {
        while (currentNumberOfReplacements < numberOfReplacements) {
            //try to replace;
            //megkeressuk az adott karakterlancot
            int findAt = findItem();

            //successful replace esetén currentNumberOfReplacements++
            if (findAt != -1) {
                array[findAt] = " ";
                currentNumberOfReplacements++;
                Main.maxOperations--;

                System.out.println("\n" + Thread.currentThread().getName() + " replaced: " + stringToBeReplaced + "\n");

                if (Main.maxOperations > 0) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " stopped\n");
                    break;
                }
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " stopped\n");


    }

    private int findItem() {
        for (int i = 0; i < array.length; ++i) {
            if (stringToBeReplaced.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
}
