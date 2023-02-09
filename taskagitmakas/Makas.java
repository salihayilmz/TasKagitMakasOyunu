package com.example.taskagitmakas;

public class Makas extends Nesneler{

    private int keskinlik;

    public Makas(double dayaniklilik, int seviyePuani, int keskinlik) {
        super(dayaniklilik, seviyePuani);
        this.keskinlik = keskinlik;
    }

    public Makas() {
    }

    public int getKeskinlik() {
        return keskinlik;
    }

    public void setKeskinlik(int keskinlik) {
        this.keskinlik = keskinlik;
    }

    @Override
    public int nesnePuaniGoster() {
        return this.getSeviyePuani();
    }

    @Override
    public double etkiHesapla(Nesneler n) {

        double etki=0;

        if (n instanceof Kagit) {
            n = (Kagit) n;

            etki = keskinlik / (Sabit.a * ((Kagit) n).getNufus() + (1-Sabit.a)*0);
        }

        if (n instanceof OzelKagit) {
            n = (OzelKagit) n;

            etki = keskinlik / (Sabit.a * ((Kagit) n).getNufus()*((OzelKagit) n).getKalinlik() + (1-Sabit.a)*0);
        }

        if (n instanceof Tas) {
            n = (Tas) n;

            etki = keskinlik / (Sabit.a * 0 + (1-Sabit.a)*((Tas) n).getKatilik());
        }

        if (n instanceof AgirTas) {
            n = (AgirTas) n;

            etki = keskinlik / (Sabit.a * 0 + (1-Sabit.a)*((Tas) n).getKatilik())*((AgirTas) n).getSicaklik();
        }


        return etki;
    }

    @Override
    public void durumGuncelle(double hasar, int seviye) {

        this.setDayaniklilik(getDayaniklilik()-hasar);
        this.setSeviyePuani(getSeviyePuani()+seviye);

    }
}
