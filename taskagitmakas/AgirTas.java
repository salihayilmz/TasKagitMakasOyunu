package com.example.taskagitmakas;

public class AgirTas extends  Tas{

   private int sicaklik;

    public AgirTas(double dayaniklilik, int seviyePuani, int katilik, int sicaklik) {
        super(dayaniklilik, seviyePuani, katilik);
        this.sicaklik = sicaklik;
    }

    public AgirTas() {
    }

    public int getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
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

            etki = this.getKatilik()*sicaklik / (Sabit.a * ((Makas) n).getKeskinlik() + (1-Sabit.a)*0);
        }
        if (n instanceof UstaMakas) {
            n = (UstaMakas) n;

            etki = this.getKatilik()*sicaklik / (Sabit.a * ((Makas) n).getKeskinlik()*((UstaMakas) n).getHiz() + (1-Sabit.a)*0);
        }

        if (n instanceof Kagit) {
            n = (Kagit) n;

            etki = this.getKatilik()*sicaklik / (Sabit.a * 0 + (1-Sabit.a)*((Kagit) n).getNufus());
        }

        if (n instanceof OzelKagit) {
            n = (OzelKagit) n;

            etki = this.getKatilik()*sicaklik / (Sabit.a * 0 + (1-Sabit.a)*((Kagit) n).getNufus()*((OzelKagit) n).getKalinlik());
        }



        return etki;
    }

    @Override
    public void durumGuncelle(double hasar,int seviye) {

        this.setDayaniklilik(getDayaniklilik()-hasar);
        this.setSeviyePuani(getSeviyePuani()+seviye);

    }

}
