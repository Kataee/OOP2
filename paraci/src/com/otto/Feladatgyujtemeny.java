package com.otto;

import java.util.ArrayList;

public class Feladatgyujtemeny {
    protected String cim;
    protected String szerzo;

    public ArrayList<MertaniAlakzat> alakzatok = new ArrayList<>();

    public Feladatgyujtemeny(String cim, String szerzo) {
        this.cim = cim;
        this.szerzo = szerzo;
    }

    //probably not the best way to add new stuff
    public void addMertaniAlakzat(String asd) {
        if (0 == Character.compare(asd.charAt(0), 'R')) {
            alakzatok.add(new Rombusz("Rombusz", 1,2,3));
        }
    }

    public void listazas() {
        for (MertaniAlakzat i : alakzatok) {
            System.out.println(i);
        }
    }

    public void megoldas(String id) {
        for (MertaniAlakzat i : alakzatok) {
            if (i.id.equals(id)) {
                System.out.println(i.toString());
            }
        }
    }
}
