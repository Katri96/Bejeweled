package peli;

import jalokivi.Jalokivi;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pelipaneeli {

    private static final int Leveys = 6;
    private static final int Korkeus = 6;
    private static final int Koko = 100;
    private Jalokivi valittuJalokivi = null;

    private List<Jalokivi> jalokivet;

    private IntegerProperty pisteet = new SimpleIntegerProperty();

    public Parent pelipaneeli() {

        /*Luodaan root ja asetetaan ikkunan leveys ja korkeus ja lisätään sinne jalokivet
        Jalokivi luokan kautta. Lisätään toiminto joka aktivoituu hiiren klikkauksella, ja etsitään
        eventin x ja y pisteet, ja verrataan niitä jalokivien riveihin (y) ja sarakkeisiin (x).*/
        Pane root = new Pane();
        root.setPrefSize(Leveys * Koko + 250, Korkeus * Koko);

        jalokivet = IntStream.range(0, Leveys * Korkeus)
                .mapToObj(i -> new Point2D(i % Leveys, i / Korkeus))
                .map(point -> new Jalokivi(point))
                .collect(Collectors.toList());

        root.getChildren().addAll(jalokivet);
        root.setOnMouseClicked(event -> {

            if (valittuJalokivi == null) {
                valittuJalokivi = this.etsiJalokivi((int) event.getX() / 100, (int) event.getY() / 100);
            } else {
                vaihdaJalokivet(this.etsiJalokivi((int) event.getX() / 100, (int) event.getY() / 100), valittuJalokivi);
                tarkistaJalokivet();
                valittuJalokivi = null;

            }
        });
        /*Lisätään ikkunaan tekstikenttä, johon tulee pisteet, jotka lisääntyvät aina uudesta yhdistelmästä.
        Lisätään myös toinen tekstikenttä, jossa lukee ohjeistusta eri timanttien arvoista. Lisätään nämä Pane muuttujaan
        ja palautetaan se.*/

        Text pisteytys = new Text();
        pisteytys.setTranslateX(Leveys * Koko);
        pisteytys.setTranslateY(100);
        pisteytys.setFont(Font.font(68));
        pisteytys.textProperty().bind(pisteet.asString("Pisteet: " + "\n" + "[%d]"));
        Text timanttiPisteet = new Text();
        timanttiPisteet.setTranslateX(Leveys * Koko + 10);
        timanttiPisteet.setTranslateY(230);
        timanttiPisteet.setFont(Font.font(15));
        
        timanttiPisteet.setText("Jalokivien arvo: \n \nKeltainen = 500\nPinkki = 300\nVihreä = 200");
        root.getChildren().add(timanttiPisteet);

        root.getChildren().add(pisteytys);
        return root;
    }

    public Jalokivi etsiJalokivi(int x, int y) {
        /*Metodi etsii kaikista jalokivistä sen, johon on klikattu hiirellä ja palauttaa sen jalokiven.
        Jos klikkaus ei koske jalokiviin, niin palauttaa metodi null.*/

        for (Jalokivi a : jalokivet) {

            if (a.getSarake() == x && a.getRivi() == y) {

                return a;
            }

        }
        return null;
    }

    public void tarkistaJalokivet() {
        /* Tässä metodissa jaetaan jokainen rivi ja sarake omiin jonoihinsa ja annetaan nämä tarkistaYhdistelmat() metodille,
        jotta saadaan selville, onko jalokivistä muodostunut rivin tai sarakkeen pituisia samanväristen jalokivien yhdistelmiä.*/

        Map<Integer, List<Jalokivi>> rows = jalokivet.stream().collect(Collectors.groupingBy(Jalokivi::getRivi));
        Map<Integer, List<Jalokivi>> columns = jalokivet.stream().collect(Collectors.groupingBy(Jalokivi::getSarake));

        rows.values().forEach(this::tarkistaYhdistelmat);
        columns.values().forEach(this::tarkistaYhdistelmat);
    }

    public void tarkistaYhdistelmat(List<Jalokivi> jalokiviJono) {
        /* Tarkistetaan jalokivet jono jonolta, jos niissä kaikissa on samat värit. Jos jono  */

        Jalokivi jalokivi = jalokiviJono.get(0);
        Color vari = (Color) jalokivi.getVari();
        long count = jalokiviJono.stream().filter(j -> j.getVari() != jalokivi.getVari()).count();
        if (count == 0) {
            if (vari == Color.BLUEVIOLET) {
                pisteet.set(pisteet.get() + 50);
            }
             if (vari == Color.CRIMSON) {
                pisteet.set(pisteet.get() + 50);
            }
             if (vari == Color.CORAL) {
                pisteet.set(pisteet.get() + 50);
            }
             if (vari == Color.SPRINGGREEN) {
                pisteet.set(pisteet.get() + 200);
            }
             if (vari == Color.YELLOW) {
                pisteet.set(pisteet.get() + 500);
            }
              if (vari == Color.DEEPPINK) {
                pisteet.set(pisteet.get() + 300);
            }
            jalokiviJono.forEach(Jalokivi::randomi);
        }
    }

    public void vaihdaJalokivet(Jalokivi a, Jalokivi b) {
        /* Metodi vaihtaa jalokivien värejä keskenään. */

        Paint vari = a.getVari();
        a.setVari(b.getVari());
        b.setVari(vari);
    }

}
