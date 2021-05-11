package lab11_1;


import java.util.Arrays;

public class Main {
    public static int maxOperations = 300;

    public static void main(String[] args) {
        String[] sa_array = new String[10];
        Arrays.fill(sa_array, " ");

        Thread addition1 = new AddToArray(sa_array);
        Thread addition2 = new AddToArray(sa_array);
        Thread addition3 = new AddToArray(sa_array);

        addition1.start();
        addition2.start();
        addition3.start();

        Thread replace1 = new TakeSomeFromArray(sa_array, 3, "aaa");
        Thread replace2 = new TakeSomeFromArray(sa_array, 3, "sss");
        Thread replace3 = new TakeSomeFromArray(sa_array, 3, "ddd");

        replace1.start();
        replace2.start();
        replace3.start();

    }
}
