package com.example.taskagitmakas;



public class Tas extends Nesneler {

    private int katilik;

    public Tas(double dayaniklilik, int seviyePuani, int katilik) {
        super(dayaniklilik, seviyePuani);
        this.katilik = katilik;
    }

    public Tas() {
    }

    public int getKatilik() {
        return katilik;
    }

    public void setKatilik(int katilik) {
        this.katilik = katilik;
    }

    @Override
    public int nesnePuaniGoster() {
        return this.getSeviyePuani();
    }

    @Override
    public double etkiHesapla(Nesneler n) {

        double etki=0;

        if (n instanceof Makas) {
            n = (Makas) n;

            etki = katilik / (Sabit.a * ((Makas) n).getKeskinlik() + (1-Sabit.a)*0);
        }
        if (n instanceof UstaMakas) {
            n = (UstaMakas) n;

            etki = katilik / (Sabit.a * ((Makas) n).getKeskinlik()*((UstaMakas) n).getHiz() + (1-Sabit.a)*0);
        }

        if (n instanceof Kagit) {
            n = (Kagit) n;

            etki = katilik / (Sabit.a * 0 + (1-Sabit.a)*((Kagit) n).getNufus());
        }

        if (n instanceof OzelKagit) {
            n = (OzelKagit) n;

            etki = katilik / (Sabit.a * 0 + (1-Sabit.a)*((Kagit) n).getNufus()*((OzelKagit) n).getKalinlik());
        }



        return etki;
    }

    @Override
    public void durumGuncelle(double hasar,int seviye) {

        this.setDayaniklilik(getDayaniklilik()-hasar);
        this.setSeviyePuani(getSeviyePuani()+seviye);

    }
}
