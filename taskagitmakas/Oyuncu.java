package com.example.taskagitmakas;

import java.util.LinkedList;

public abstract class Oyuncu {
    private int oyuncuID;
    private String oyuncuAdi;
    private double skor;
    LinkedList<Nesneler> nesneler = new LinkedList<>();

    public Oyuncu(int oyuncuID, String oyuncuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
    }

    public Oyuncu() {
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public double getSkor() {
        return skor;
    }

    public void setSkor(double skor) {
        this.skor = skor;
    }

    public LinkedList<Nesneler> getNesneler() {
        return nesneler;
    }

    public void setNesneler(LinkedList<Nesneler> nesneler) {
        this.nesneler = nesneler;
    }

    public abstract double scorGoster();
    public abstract Nesneler nesneSec(int nesne);

}
