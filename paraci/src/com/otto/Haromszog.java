package com.otto;

public class Haromszog extends MertaniAlakzat{
    protected double oldalhossz1;
    protected double oldalhossz2;
    protected double oldalhossz3;
    protected double magassag;
    protected String tipus;

    //constructor
    /*
    public Haromszog(String asd, double oldalhossz1, double oldalhossz2, double oldalhossz3, String tipus) {
        super(asd);
        this.oldalhossz1 = oldalhossz1;
        this.oldalhossz2 = oldalhossz2;
        this.oldalhossz3 = oldalhossz3;
        this.tipus = tipus;
    }

     */


    //tipusok
    enum Haromszogek {
        DEREKSZOGU,
        EGYENLOOLDALU,
        EGYENLOSZARU,
        ALTALANOS
    }
    public Haromszog(String asd, double oldalhossz1, double oldalhossz2, double oldalhossz3 ) {
        super(asd);
        this.oldalhossz1 = oldalhossz1;
        this.oldalhossz2 = oldalhossz2;
        this.oldalhossz3 = oldalhossz3;
        this.kerulet = oldalhossz1 + oldalhossz2 + oldalhossz3;

        //ha egyenlo oldalu
        if (oldalhossz1 == oldalhossz2 && oldalhossz1 == oldalhossz3 && oldalhossz2 == oldalhossz3 ) {
            tipus = Haromszogek.EGYENLOOLDALU.name();
            this.magassag = (Math.sqrt(3)/2)/oldalhossz1;
            this.terulet = (oldalhossz1 * magassag) /2;


            //ha egyenloszaru
        } else if (oldalhossz1 == oldalhossz2 || oldalhossz1 == oldalhossz3 || oldalhossz2 == oldalhossz3) {
            tipus = Haromszogek.EGYENLOSZARU.name();
            //isert magassagkeplet
            //insert teruletkeplet
            this.terulet = 1;


            //ha derekszogu
        } else if ( oldalhossz1 * oldalhossz1 + oldalhossz2 * oldalhossz2 == oldalhossz3 * oldalhossz3 ||
                    oldalhossz1 * oldalhossz1 +  oldalhossz3 * oldalhossz3 == oldalhossz2 * oldalhossz2 ||
                    oldalhossz2 * oldalhossz2 +  oldalhossz3 * oldalhossz3 == oldalhossz1 * oldalhossz1) {
            tipus = Haromszogek.DEREKSZOGU.name();
            //isert magassagkeplet
            //insert teruletkeplet
            this.terulet = 1;
        } else {
            tipus = Haromszogek.ALTALANOS.name();
            //isert magassagkeplet
            //insert teruletkeplet
            this.terulet = 1;
        }
    }

    public double getOldalhossz1() {
        return oldalhossz1;
    }
    public double getOldalhossz2() {
        return oldalhossz2;
    }
    public double getOldalhossz3() {
        return oldalhossz3;
    }
    public String getTipus() {
        return tipus;
    }

    @Override
    public String toString() {
        return "Haromszog " + id +", oldalai: " + oldalhossz1 + ", " + oldalhossz2 + ", " + oldalhossz3 +", tipusa " + tipus + " haromszog, melynek kerulete: " + kerulet + " es terulete: " + terulet + ".\n";
    }
}
