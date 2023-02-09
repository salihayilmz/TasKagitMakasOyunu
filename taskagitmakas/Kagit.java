package com.example.taskagitmakas;

public class Kagit extends  Nesneler{
   private int nufus;

    public Kagit(double dayaniklilik, int seviyePuani, int nufus) {
        super(dayaniklilik, seviyePuani);
        this.nufus = nufus;
    }

    public Kagit() {
    }

    public int getNufus() {
        return nufus;
    }

    public void setNufus(int nufus) {
        this.nufus = nufus;
    }

    @Override
    public int nesnePuaniGoster() {
        return this.getSeviyePuani();
    }

    @Override
    public double etkiHesapla(Nesneler n) {
        double etki=0;

        if (n instanceof Tas) {
          n = (Tas) n;

            etki = nufus / (Sabit.a * ((Tas) n).getKatilik() + (1-Sabit.a)*0);
        }
        if (n instanceof AgirTas) {
            n= (AgirTas)n;
            etki = nufus / (Sabit.a * ((Tas) n).getKatilik()*((AgirTas) n).getSicaklik() + (1-Sabit.a)*0);
        }

        if (n instanceof Makas) {
            n= (Makas)n;
            etki = nufus / (Sabit.a * 0 + (1-Sabit.a)*((Makas) n).getKeskinlik());
        }

        if (n instanceof UstaMakas) {
            n= (UstaMakas)n;
            etki = nufus / (Sabit.a * 0 + (1-Sabit.a)*((Makas) n).getKeskinlik()*((UstaMakas) n).getHiz());
        }

        return etki;
    }

    @Override
    public void durumGuncelle(double hasar,int seviye) {

        this.setDayaniklilik(getDayaniklilik()-hasar);
        this.setSeviyePuani(getSeviyePuani()+seviye);

    }
}
