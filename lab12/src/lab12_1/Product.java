package lab12_1;

public class Product implements Comparable<Product>{
    private int ID;
    private String name;
    private int amount;
    private int price;

    public Product(int ID, String name, int amount, int price) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void increaseAMount(int newAmout) {
        amount += newAmout;
    }

    public void updateAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", name: " + name + ", amount: " + amount + ", price: " + price;
    }

    @Override
    public int compareTo(Product o) {
        if (this.ID < o.ID) {
            return -1;
        }
        if (this.ID == o.ID) {
            return 0;
        }
        return 1;
    }
}
