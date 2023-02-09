package com.example.taskagitmakas;

public abstract class Nesneler {

    private double dayaniklilik;
    private int seviyePuani;

    public Nesneler(double dayaniklilik, int seviyePuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyePuani = seviyePuani;
    }

    public Nesneler() {
    }

    public double getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik(double dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public int getSeviyePuani() {
        return seviyePuani;
    }

    public void setSeviyePuani(int seviyePuani) {
        this.seviyePuani = seviyePuani;
    }



    public abstract int nesnePuaniGoster();
    public abstract double etkiHesapla(Nesneler n);
    public abstract void durumGuncelle(double hasar, int seviye);

}
