package com.example.taskagitmakas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class GameController implements Initializable {

    /* private ObservableList<String> options =
             observableArrayList(
                     "Taş",
                     "Kağıt",
                     "Makas"
             );*/
    File file;
    Image imgTas;
    Image imgKagit;
    Image imgMakas;

    LinkedList<Nesneler> nesneler = new LinkedList<>();
    LinkedList<Nesneler> nesnelerBilgisayar = new LinkedList<>();
    Kullanici kullanici;
    Bilgisayar bilgisayar;
    int hamleSayisi;

    @FXML
    private TextField txtHamleSayisi;
    @FXML
    private TextArea txtSonuc;
    @FXML
    private TextField txtOyuncuAd;
    @FXML
    private TextField txtBilgisayarAd;
    @FXML
    private TextField txtOyuncuSkor;
    @FXML
    private TextField txtBilgisayarSkor;

    @FXML
    private Button btn1;
    @FXML
    private ImageView img1;
    @FXML
    private Button btn2;
    @FXML
    private ImageView img2;
    @FXML
    private Button btn3;
    @FXML
    private ImageView img3;
    @FXML
    private Button btn4;
    @FXML
    private ImageView img4;
    @FXML
    private Button btn5;

    @FXML
    private Button btnStart;

    @FXML
    private ImageView img5;

    @FXML
    private ComboBox<String> cmb1;
    @FXML
    private ComboBox<String> cmb2;
    @FXML
    private ComboBox<String> cmb3;
    @FXML
    private ComboBox<String> cmb4;
    @FXML
    private ComboBox<String> cmb5;

    private ObservableList<String> options = FXCollections.observableArrayList("Tas", "Kagit", "Makas");


    @FXML
    private void handleComboBoxAction(ActionEvent event) {
        ComboBox cmb = (ComboBox) event.getSource();
        String choose = cmb.getValue().toString();


        if (((ComboBox<?>) event.getSource()).getId().endsWith("cmb1")) {
            //System.out.println(cmb.getValue());

            btn1.setDisable(false);
            switch (choose) {

                case "Tas":
                    img1.setImage(imgTas);

                    nesneler.set(0, new Tas(20, 0, 2));
                    break;
                case "Kagit":
                    img1.setImage(imgKagit);
                    nesneler.set(0, new Kagit(20, 0, 2));
                    break;
                case "Makas":
                    img1.setImage(imgMakas);
                    nesneler.set(0, new Makas(20, 0, 2));
                    break;

            }

        }
        if (((ComboBox<?>) event.getSource()).getId().endsWith("cmb2")) {
            //System.out.println(cmb.getValue());

            btn2.setDisable(false);
            switch (choose) {

                case "Tas":
                    img2.setImage(imgTas);
                    nesneler.set(1, new Tas(20, 0, 2));
                    break;
                case "Kagit":
                    img2.setImage(imgKagit);
                    nesneler.set(1, new Kagit(20, 0, 2));
                    break;
                case "Makas":
                    img2.setImage(imgMakas);
                    nesneler.set(1, new Makas(20, 0, 2));
                    break;

            }

        }
        if (((ComboBox<?>) event.getSource()).getId().endsWith("cmb3")) {
            //System.out.println(cmb.getValue());

            btn3.setDisable(false);
            switch (choose) {

                case "Tas":
                    img3.setImage(imgTas);
                    nesneler.set(2, new Tas(20, 0, 2));
                    break;
                case "Kagit":
                    img3.setImage(imgKagit);
                    nesneler.set(2, new Kagit(20, 0, 2));
                    break;
                case "Makas":
                    img3.setImage(imgMakas);
                    nesneler.set(2, new Makas(20, 0, 2));
                    break;

            }

        }


        if (((ComboBox<?>) event.getSource()).getId().endsWith("cmb4")) {
            //System.out.println(cmb.getValue());

            btn4.setDisable(false);
            switch (choose) {

                case "Tas":
                    img4.setImage(imgTas);
                    nesneler.set(3, new Tas(20, 0, 2));
                    break;
                case "Kagit":
                    img4.setImage(imgKagit);
                    nesneler.set(3, new Kagit(20, 0, 2));
                    break;
                case "Makas":
                    img4.setImage(imgMakas);
                    nesneler.set(3, new Makas(20, 0, 2));
                    break;

            }

        }

        if (((ComboBox<?>) event.getSource()).getId().endsWith("cmb5")) {
            //System.out.println(cmb.getValue());

            btn5.setDisable(false);
            switch (choose) {

                case "Tas":
                    img5.setImage(imgTas);
                    nesneler.set(4, new Tas(20, 0, 2));
                    break;
                case "Kagit":
                    img5.setImage(imgKagit);
                    nesneler.set(4, new Kagit(20, 0, 2));
                    break;
                case "Makas":
                    img5.setImage(imgMakas);
                    nesneler.set(4, new Makas(20, 0, 2));
                    break;

            }

        }


    }


    @FXML
    private void handleStart() {
        cmb1.setDisable(true);
        cmb2.setDisable(true);
        cmb3.setDisable(true);
        cmb4.setDisable(true);
        cmb5.setDisable(true);
        txtSonuc.setText("");
      /*  btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);*/
        hamleSayisi = Integer.parseInt(txtHamleSayisi.getText());

        kullanici = new Kullanici(1, txtOyuncuAd.getText(), 0);
        kullanici.setNesneler(nesneler);

        Random rnd = new Random();

        int nesneNo;


        for (int i = 0; i < 5; i++) {
            nesneNo = rnd.nextInt(0, 3);


            switch (nesneNo) {
                case 0:
                    nesnelerBilgisayar.add(i, new Tas(20, 0, 2));
                    break;
                case 1:
                    nesnelerBilgisayar.add(i, new Kagit(20, 0, 2));
                    break;
                case 2:
                    nesnelerBilgisayar.add(i, new Makas(20, 0, 2));

            }
        }

        bilgisayar = new Bilgisayar(1, "Bilgisayar", 0);
        bilgisayar.setNesneler(nesnelerBilgisayar);

        txtOyuncuAd.setText(kullanici.getOyuncuAdi());
        txtOyuncuSkor.setText("0");
        txtBilgisayarAd.setText(bilgisayar.getOyuncuAdi());
        txtBilgisayarSkor.setText("0");

        for (Nesneler n : nesnelerBilgisayar)
            System.out.println(n.getClass().getName());

    }

    @FXML
    private void handleMove(ActionEvent event) {

        Button btn = (Button) event.getSource();
        Nesneler oyuncuNesne;
        Nesneler bilgisayarNesne;
        oyuncuNesne = null;
        int k = 0;
        int b = 0;


        if (((Button) event.getSource()).getId().endsWith("btn1")) {

            oyuncuNesne = kullanici.nesneSec(0);
            if (oyuncuNesne instanceof Tas)
                oyuncuNesne = (Tas) oyuncuNesne;
            if (oyuncuNesne instanceof Kagit)
                oyuncuNesne = (Kagit) oyuncuNesne;
            if (oyuncuNesne instanceof Makas)
                oyuncuNesne = (Makas) oyuncuNesne;
            if (oyuncuNesne instanceof AgirTas)
                oyuncuNesne = (AgirTas) oyuncuNesne;
            if (oyuncuNesne instanceof OzelKagit)
                oyuncuNesne = (OzelKagit) oyuncuNesne;
            if (oyuncuNesne instanceof UstaMakas)
                oyuncuNesne = (UstaMakas) oyuncuNesne;

            k = 0;

        }
        if (((Button) event.getSource()).getId().endsWith("btn2")) {

            oyuncuNesne = kullanici.nesneSec(1);
            if (oyuncuNesne instanceof Tas)
                oyuncuNesne = (Tas) oyuncuNesne;
            if (oyuncuNesne instanceof Kagit)
                oyuncuNesne = (Kagit) oyuncuNesne;
            if (oyuncuNesne instanceof Makas)
                oyuncuNesne = (Makas) oyuncuNesne;
            if (oyuncuNesne instanceof AgirTas)
                oyuncuNesne = (AgirTas) oyuncuNesne;
            if (oyuncuNesne instanceof OzelKagit)
                oyuncuNesne = (OzelKagit) oyuncuNesne;
            if (oyuncuNesne instanceof UstaMakas)
                oyuncuNesne = (UstaMakas) oyuncuNesne;
            k = 1;
        }
        if (((Button) event.getSource()).getId().endsWith("btn3")) {

            oyuncuNesne = kullanici.nesneSec(2);
            if (oyuncuNesne instanceof Tas)
                oyuncuNesne = (Tas) oyuncuNesne;
            if (oyuncuNesne instanceof Kagit)
                oyuncuNesne = (Kagit) oyuncuNesne;
            if (oyuncuNesne instanceof Makas)
                oyuncuNesne = (Makas) oyuncuNesne;
            if (oyuncuNesne instanceof AgirTas)
                oyuncuNesne = (AgirTas) oyuncuNesne;
            if (oyuncuNesne instanceof OzelKagit)
                oyuncuNesne = (OzelKagit) oyuncuNesne;
            if (oyuncuNesne instanceof UstaMakas)
                oyuncuNesne = (UstaMakas) oyuncuNesne;
            k = 2;
        }
        if (((Button) event.getSource()).getId().endsWith("btn4")) {

            oyuncuNesne = kullanici.nesneSec(3);
            if (oyuncuNesne instanceof Tas)
                oyuncuNesne = (Tas) oyuncuNesne;
            if (oyuncuNesne instanceof Kagit)
                oyuncuNesne = (Kagit) oyuncuNesne;
            if (oyuncuNesne instanceof Makas)
                oyuncuNesne = (Makas) oyuncuNesne;
            if (oyuncuNesne instanceof AgirTas)
                oyuncuNesne = (AgirTas) oyuncuNesne;
            if (oyuncuNesne instanceof OzelKagit)
                oyuncuNesne = (OzelKagit) oyuncuNesne;
            if (oyuncuNesne instanceof UstaMakas)
                oyuncuNesne = (UstaMakas) oyuncuNesne;
            k = 3;
        }

        if (((Button) event.getSource()).getId().endsWith("btn5")) {

            oyuncuNesne = kullanici.nesneSec(4);
            if (oyuncuNesne instanceof Tas)
                oyuncuNesne = (Tas) oyuncuNesne;
            if (oyuncuNesne instanceof Kagit)
                oyuncuNesne = (Kagit) oyuncuNesne;
            if (oyuncuNesne instanceof Makas)
                oyuncuNesne = (Makas) oyuncuNesne;
            if (oyuncuNesne instanceof AgirTas)
                oyuncuNesne = (AgirTas) oyuncuNesne;
            if (oyuncuNesne instanceof OzelKagit)
                oyuncuNesne = (OzelKagit) oyuncuNesne;
            if (oyuncuNesne instanceof UstaMakas)
                oyuncuNesne = (UstaMakas) oyuncuNesne;

            k = 4;
        }

        Random rnd = new Random();
        b = rnd.nextInt(0, bilgisayar.nesneler.size());
        bilgisayarNesne = bilgisayar.nesneSec(b);

        if (bilgisayarNesne instanceof Tas)
            bilgisayarNesne = (Tas) bilgisayarNesne;
        if (bilgisayarNesne instanceof Kagit)
            bilgisayarNesne = (Kagit) bilgisayarNesne;
        if (bilgisayarNesne instanceof Makas)
            bilgisayarNesne = (Makas) bilgisayarNesne;
        if (bilgisayarNesne instanceof AgirTas)
            bilgisayarNesne = (AgirTas) bilgisayarNesne;
        if (bilgisayarNesne instanceof OzelKagit)
            bilgisayarNesne = (OzelKagit) bilgisayarNesne;
        if (bilgisayarNesne instanceof UstaMakas)
            bilgisayarNesne = (UstaMakas) bilgisayarNesne;

        Class oyn = oyuncuNesne.getClass();
        Class bil = bilgisayarNesne.getClass();

        String oyuncu = oyn.getSimpleName();
        ;
        String bilgisayar = bil.getSimpleName();


        String sonuc = " Kullanici " + oyuncu + " seçti \n" +
                " bilgisayar " + bilgisayar + " seçti";

        txtSonuc.setText(sonuc);

        hamleSayisi--;
        battle(k, b);

        txtHamleSayisi.setText(hamleSayisi + "");
        //
    }


    @FXML
    private void battle(int k, int b) {

        if ((hamleSayisi <= 0)||(bilgisayar.scorGoster()<=0) ||(kullanici.scorGoster()<=0)||(bilgisayar.nesneler.size()<3) ){
            String sonucMetni;
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn4.setDisable(true);
            btn5.setDisable(true);
            cmb1.setDisable(false);
            cmb2.setDisable(false);
            cmb3.setDisable(false);
            cmb4.setDisable(false);
            cmb5.setDisable(false);
            if (kullanici.getSkor() > bilgisayar.getSkor()) {
                sonucMetni = "Oyuncu Kazandı";
            } else if (kullanici.getSkor() < bilgisayar.getSkor()) {
                sonucMetni = "Bilgisayar Kazandı";
            } else {
                sonucMetni = "Berabere kaldi";

            }

            txtSonuc.setText(sonucMetni+"\n"+"Yeni oyun için nesneleri seçin!");
            nesnelerBilgisayar.clear();
            hamleSayisi=10;
            return;
        }
        double oyuncuEtki = kullanici.nesneSec(k).etkiHesapla(bilgisayar.nesneSec(b));
        double bilgisayarEtki = bilgisayar.nesneSec(b).etkiHesapla(kullanici.nesneSec(k));

        txtSonuc.setText(txtSonuc.getText() + "\n " + "Oyuncu etki :" + oyuncuEtki);
        txtSonuc.setText(txtSonuc.getText() + "\n " + "Bilgisayar etki :" + bilgisayarEtki);

        System.out.println("kullanıcı nesne sayisi :" + kullanici.nesneler.size());

        if (oyuncuEtki > bilgisayarEtki) {
            txtSonuc.setText(txtSonuc.getText() + "\n " + "Oyuncu kazandı");
            bilgisayar.nesneSec(b).durumGuncelle(oyuncuEtki, 0);
            kullanici.nesneSec(k).durumGuncelle(bilgisayarEtki, 20);

        } else if (oyuncuEtki < bilgisayarEtki) {
            txtSonuc.setText(txtSonuc.getText() + "\n " + "Bilgisayar kazandı");
            bilgisayar.nesneSec(b).durumGuncelle(oyuncuEtki, 20);
            kullanici.nesneSec(k).durumGuncelle(bilgisayarEtki, 0);
        } else {
            txtSonuc.setText(txtSonuc.getText() + "\n " + "Berabere kaldı");
        }


        System.out.println("Oyuncu etki :" + oyuncuEtki);
        System.out.println("Bilgisayar etki :" + bilgisayarEtki);
        txtOyuncuSkor.setText(kullanici.scorGoster() + "");
        txtBilgisayarSkor.setText(bilgisayar.scorGoster() + "");

        if (bilgisayar.nesneSec(b).getDayaniklilik() <= 0) {

            LinkedList<Nesneler> nesneler = bilgisayar.getNesneler();
            nesneler.remove(b);
            System.out.println(b + "nesnesi silindi");
            bilgisayar.setNesneler(nesneler);
        }

        if (kullanici.nesneSec(k).getDayaniklilik() <= 0) {

            switch (k) {
                case 0:
                    btn1.setDisable(true);
                    break;
                case 1:
                    btn2.setDisable(true);
                    break;
                case 2:
                    btn3.setDisable(true);
                    break;
                case 3:
                    btn4.setDisable(true);
                    break;
                case 4:
                    btn5.setDisable(true);
                    break;
            }
        }

        if (kullanici.nesneSec(k).getSeviyePuani() > 30) {
            LinkedList<Nesneler> nesneler = kullanici.getNesneler();
            Nesneler kN = kullanici.nesneSec(k);
            Nesneler yN = null;
            String nesneTipi = kN.getClass().getSimpleName();
            switch (nesneTipi) {
                case "Tas":
                    yN = new AgirTas(kN.getDayaniklilik(), kN.getSeviyePuani(), 2, 2);
                    break;
                case "Kagit":
                    yN = new OzelKagit(kN.getDayaniklilik(), kN.getSeviyePuani(), 2, 2);
                    break;
                case "Makas":
                    yN = new UstaMakas(kN.getDayaniklilik(), kN.getSeviyePuani(), 2, 2);
                    break;

            }
            if (yN != null) {
                nesneler.set(k, yN);
                kullanici.setNesneler(nesneler);
            }

        }


        if (bilgisayar.nesneSec(b).getSeviyePuani() > 30) {
            LinkedList<Nesneler> nesneler = bilgisayar.getNesneler();
            Nesneler kN = bilgisayar.nesneSec(k);
            Nesneler yN = null;
            String nesneTipi = kN.getClass().getSimpleName();
            switch (nesneTipi) {
                case "Tas":
                    yN = new AgirTas(kN.getDayaniklilik(), kN.getSeviyePuani(), 2, 2);
                    break;
                case "Kagit":
                    yN = new OzelKagit(kN.getDayaniklilik(), kN.getSeviyePuani(), 2, 2);
                    break;
                case "Makas":
                    yN = new UstaMakas(kN.getDayaniklilik(), kN.getSeviyePuani(), 2, 2);
                    break;

            }
            if (yN != null) {
                nesneler.set(k, yN);
                bilgisayar.setNesneler(nesneler);
            }

        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //  cmb1.setItems(observableArrayList("Taş", "Kağıt","Makas"));
        cmb1.setItems(options);
        cmb2.setItems(options);
        cmb3.setItems(options);
        cmb4.setItems(options);
        cmb5.setItems(options);

        file = new File("rock.png");
        imgTas = new Image(file.toURI().toString());
        file = new File("paper.png");
        imgKagit = new Image(file.toURI().toString());
        file = new File("scissors.png");
        imgMakas = new Image(file.toURI().toString());

        nesneler.add(0, new Tas(20, 0, 2));
        nesneler.add(1, new Kagit(20, 0, 2));
        nesneler.add(2, new Makas(20, 0, 2));
        nesneler.add(3, new Tas(20, 0, 2));
        nesneler.add(4, new Kagit(20, 0, 2));


        hamleSayisi = Integer.parseInt(txtHamleSayisi.getText());
    }
}