package com.otto;

public class MertaniAlakzat {
    protected static int counter=0;
    protected String id;
    public double terulet;
    public double kerulet;

    protected MertaniAlakzat(String asd) {
        counter++;
        char alakzat =  asd.charAt(0);
        id = alakzat+Integer.toString(counter);
    }

    public double getTerulet() {
        return terulet;
    }

    public double getKerulet() {
        return kerulet;
    }

    @Override
    public String toString() {
        return id + ", kerulet: " + kerulet + ", terulet: " + terulet + "\n";
    }

}
