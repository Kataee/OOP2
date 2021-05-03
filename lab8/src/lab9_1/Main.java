package lab9_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int monthL = 12;
        int dayL = 31;

        ArrayList<MyDate> dateTimes = new ArrayList<>();
        int year = 2021;
        for (int i=0; i<10; ++i) {
            int month = rand.nextInt(monthL);
            int day = rand.nextInt(dayL) ;
            MyDate date = new MyDate(year, month, day);
            if (DateUtil.isValidDate(year, month, day)) {
                dateTimes.add(date);
                i++;
                //add to arraylist
            }
        }


        //kiiratas
        System.out.println("Before sorting:");
        for (MyDate data:dateTimes) {
            System.out.println(data);
        }

        //rendezes
        Collections.sort(dateTimes);

        //kiiratas
        System.out.println("After sorting");
        for (MyDate data:dateTimes) {
            System.out.println(data);
        }
    }
}
