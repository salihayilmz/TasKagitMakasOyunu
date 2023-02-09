package com.example.taskagitmakas;

public class OzelKagit extends Kagit{
    int kalinlik;

    public OzelKagit(double dayaniklilik, int seviyePuani, int nufus, int kalinlik) {
        super(dayaniklilik, seviyePuani, nufus);
        this.kalinlik = kalinlik;
    }

    public OzelKagit() {
    }

    public int getKalinlik() {
        return kalinlik;
    }

    public void setKalinlik(int kalinlik) {
        this.kalinlik = kalinlik;
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

            etki = this.getNufus()*kalinlik / (Sabit.a * ((Tas) n).getKatilik() + (1-Sabit.a)*0);
        }
        if (n instanceof AgirTas) {
            n= (AgirTas)n;
            etki = this.getNufus()*kalinlik / (Sabit.a * ((Tas) n).getKatilik()*((AgirTas) n).getSicaklik() + (1-Sabit.a)*0);
        }

        if (n instanceof Makas) {
            n= (Makas)n;
            etki = this.getNufus()*kalinlik / (Sabit.a * 0 + (1-Sabit.a)*((Makas) n).getKeskinlik());
        }

        if (n instanceof UstaMakas) {
            n= (UstaMakas)n;
            etki = this.getNufus()*kalinlik / (Sabit.a * 0 + (1-Sabit.a)*((Makas) n).getKeskinlik()*((UstaMakas) n).getHiz());
        }

        return etki;
    }

    @Override
    public void durumGuncelle(double hasar,int seviye) {

        this.setDayaniklilik(getDayaniklilik()-hasar);
        this.setSeviyePuani(getSeviyePuani()+seviye);

    }
}
