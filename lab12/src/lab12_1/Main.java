package lab12_1;

public class Main {

    public static void main(String[] args) {
        Storage asd = new Storage();
        asd.read("data1000.txt");
        asd.printProducts();
        asd.update("update1000.txt");

        asd.readHash("data1000.txt");
        asd.printProductsH();
        asd.updateH("update1000.txt");
    }
}
