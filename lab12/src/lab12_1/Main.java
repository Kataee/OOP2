package lab12_1;

public class Main {

    public static void main(String[] args) {
        Storage asd = new Storage();
        asd.read("data10.txt");
        asd.printProducts();
        asd.update("update10.txt");

        asd.readHash("data10.txt");
        asd.printProductsH();
        asd.updateH("update10.txt");
    }
}
