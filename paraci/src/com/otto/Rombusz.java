package com.otto;

public class Rombusz extends MertaniAlakzat {
    protected double atlo1;
    protected double atlo2;
    protected double oldalhossz;

    public Rombusz(String asd, double atlo1, double atlo2, double oldalhossz) {
        super(asd);
        this.atlo1 = atlo1;
        this.atlo2 = atlo2;
        this.oldalhossz = oldalhossz;
        terulet = (atlo1 * atlo2) /2;
        kerulet = 4 * oldalhossz;
    }

    public double getAtlo1() {
        return atlo1;
    }

    public double getAtlo2() {
        return atlo2;
    }

    public double getOldalhossz() {
        return oldalhossz;
    }

    @Override
    public  String toString() {
        return "Rombusz " + id + ", melynek atloi " + atlo1 + " " + atlo2 + " es oldala " + oldalhossz + " hosszu, kerulete: " + kerulet + " es terulete " + terulet + ".\n";
    }
}
