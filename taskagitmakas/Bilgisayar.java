package com.example.taskagitmakas;

public class Bilgisayar extends Oyuncu{

    public Bilgisayar(int oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    public Bilgisayar() {
    }

    @Override
    public double scorGoster() {
        double skor=0;
        for (Nesneler n : this.nesneler) {
            skor+=n.getDayaniklilik();
        }
        this.setSkor(skor);
        return skor;

    }

    @Override
    public Nesneler nesneSec(int nesne) {
        return nesneler.get(nesne);
    }
}
