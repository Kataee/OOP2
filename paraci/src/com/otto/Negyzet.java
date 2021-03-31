package com.otto;

public class Negyzet  extends  MertaniAlakzat{

    protected double oldalhossz;
    protected double terulet;
    protected double kerulet;
    protected Negyzet(String asd, double oldalhossz) {
        super(asd);
        this.oldalhossz = oldalhossz;
        this.kerulet = 4 * oldalhossz;
        this.terulet = oldalhossz * oldalhossz;
    }

    public double getOldalhossz() {
        return oldalhossz;
    }

    @Override
    public String toString() {
        return "Negyzet " + id + ", melynek oldalai " + oldalhossz + " kerulete: " + kerulet + " es terulete " + terulet + ".\n";
    }


}
