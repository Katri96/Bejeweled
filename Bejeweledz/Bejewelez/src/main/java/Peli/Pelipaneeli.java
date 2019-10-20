package Peli;

import java.util.List;
import java.util.Map;
import java.util.Random;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.event.MouseInputAdapter;

public class Pelipaneeli extends Application {

    private static final int Leveys = 6;
    private static final int Korkeus = 6;
    private static final int Koko = 100;
    private Jalokivi valittuJalokivi = null;

    private List<Jalokivi> jalokivet;

    private IntegerProperty pisteet = new SimpleIntegerProperty();

    public Parent pelipaneeli() {
        
        /*Luodaan root ja asetetaan ikkunan leveys ja korkeus ja lisätään sinne jalokivet
        Jalokivi luokan kautta. Lisätään toiminto joka aktivoituu hiiren klikkauksella, ja etsitään
        eventin x ja y pisteet, ja verrataan niitä jalokivien riveihin (y) ja sarakkeisiin (x).
        Lisätään ikkunaan myös tekstikenttä, johon tulee pisteet, jotka lisääntyvät aina uudesta yhdistelmästä.*/
        
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
        Text textScore = new Text();
        textScore.setTranslateX(Leveys * Koko);
        textScore.setTranslateY(100);
        textScore.setFont(Font.font(68));
        textScore.textProperty().bind(pisteet.asString("Pisteet: " + "\n" + "[%d]"));

        root.getChildren().add(textScore);
        return root;
    }

    public void tarkistaJalokivet() {
        /* Tässä metodissa tarkistetaan jokainen rivi ja sarake, jos jalokivistä on muodostunut yhdistelmiä.*/

        Map<Integer, List<Jalokivi>> rows = jalokivet.stream().collect(Collectors.groupingBy(Jalokivi::getRivi));
        Map<Integer, List<Jalokivi>> columns = jalokivet.stream().collect(Collectors.groupingBy(Jalokivi::getSarake));

        rows.values().forEach(this::tarkistaYhdistelmat);
        columns.values().forEach(this::tarkistaYhdistelmat);
    }

    public void tarkistaYhdistelmat(List<Jalokivi> jalokiviJono) {
        /* Tarkistetaan jalokivet jono jonolta, jos niissä kaikissa on samat värit. Jos jono  */

        Jalokivi jewel = jalokiviJono.get(0);
        long count = jalokiviJono.stream().filter(j -> j.getVari() != jewel.getVari()).count();
        if (count == 0) {
            pisteet.set(pisteet.get() + 100);
            jalokiviJono.forEach(Jalokivi::randomi);
        }
    }

    public void vaihdaJalokivet(Jalokivi a, Jalokivi b) {

        System.out.println("onnistu");
        Paint vari = a.getVari();
        a.setVari(b.getVari());
        b.setVari(vari);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(pelipaneeli()));
        primaryStage.show();
    }

    public Jalokivi etsiJalokivi(int x, int y) {

        for (Jalokivi a : jalokivet) {

            if (a.getSarake() == x && a.getRivi() == y) {

                return a;
            }

        }
        return null;
    }

}
