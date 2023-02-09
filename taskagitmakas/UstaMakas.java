package com.example.taskagitmakas;

public class UstaMakas extends Makas{
   private int hiz;

    public UstaMakas(double dayaniklilik, int seviyePuani, int keskinlik, int hiz) {
        super(dayaniklilik, seviyePuani, keskinlik);
        this.hiz = hiz;
    }

    public UstaMakas(int hiz) {
        this.hiz = hiz;
    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
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

            etki = this.getKeskinlik()*hiz / (Sabit.a * ((Kagit) n).getNufus() + (1-Sabit.a)*0);
        }

        if (n instanceof OzelKagit) {
            n = (OzelKagit) n;

            etki =this.getKeskinlik()*hiz / (Sabit.a * ((Kagit) n).getNufus()*((OzelKagit) n).getKalinlik() + (1-Sabit.a)*0);
        }

        if (n instanceof Tas) {
            n = (Tas) n;

            etki =this.getKeskinlik()*hiz / (Sabit.a * 0 + (1-Sabit.a)*((Tas) n).getKatilik());
        }

        if (n instanceof AgirTas) {
            n = (AgirTas) n;

            etki = this.getKeskinlik()*hiz / (Sabit.a * 0 + (1-Sabit.a)*((Tas) n).getKatilik())*((AgirTas) n).getSicaklik();
        }


        return etki;
    }

    @Override
    public void durumGuncelle(double hasar,int seviye) {

        this.setDayaniklilik(getDayaniklilik()-hasar);
        this.setSeviyePuani(getSeviyePuani()+seviye);

    }
}
