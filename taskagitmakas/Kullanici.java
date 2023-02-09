package com.example.taskagitmakas;

public class Kullanici extends Oyuncu{


    public Kullanici(int oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    public Kullanici() {
    }

    @Override
    public double scorGoster() {

        double skor=0;
        for (Nesneler n : this.nesneler) {
            skor+=n.getDayaniklilik();
        }
        System.out.println("skor :"+skor);
        this.setSkor(skor);
        return skor;

    }

    @Override
    public Nesneler nesneSec(int nesne) {
        return nesneler.get(nesne);
    }
}
