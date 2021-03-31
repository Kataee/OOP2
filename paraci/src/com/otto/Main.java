package com.otto;

public class Main {

    public static void main(String[] args) {
        Rombusz r1 = new Rombusz("Rombusz", 2, 3,4);
        System.out.println(r1.toString());

        Negyzet n1 = new Negyzet("Negyzet", 24);
        System.out.println(n1.toString());

        Haromszog h1 = new Haromszog("Haromszog", 3,3,3);
        Haromszog h2 = new Haromszog("Haromszog", 3,4, 5);
        System.out.println(h1.toString());
        System.out.println(h2.toString());

        Feladatgyujtemeny f1 = new Feladatgyujtemeny("Gyujt1", "Almas Marta");
        f1.addMertaniAlakzat("Rombusz");
        System.out.println("Alakzatok a gyujtemenyben:\n");
        f1.listazas();
        System.out.println("Megadott alakzatnak a megoldasa:");
        f1.megoldas("R5");
    }
}
