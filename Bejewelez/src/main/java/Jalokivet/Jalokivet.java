/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalokivet;

import Bejeweledz.Bejeweledz;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Jalokivet extends Application {

    private static final int Leveys = 6;
    private static final int Korkeus = 6;
    private static final int Koko = 100;
    private Color[] varit = new Color[]{
        Color.AQUA, Color.DEEPPINK, Color.BLUEVIOLET, Color.CORAL, Color.YELLOW, Color.CRIMSON};

    private jalokivi selected = null;
    private List<jalokivi> jalokivet;

    private IntegerProperty pisteet = new SimpleIntegerProperty();

    private Circle ympyra = new Circle(Koko / 2);

    public Parent pelipaneeli() {
        Pane root = new Pane();
        root.setPrefSize(Leveys * Koko + 250, Korkeus * Koko);

        jalokivet = IntStream.range(0, Leveys * Korkeus)
                .mapToObj(i -> new Point2D(i % Leveys, i / Korkeus))
                .map(point -> new jalokivi(point))
                .collect(Collectors.toList());

        root.getChildren().addAll(jalokivet);

        Text textScore = new Text();
        textScore.setTranslateX(Leveys * Koko);
        textScore.setTranslateY(100);
        textScore.setFont(Font.font(68));
        textScore.textProperty().bind(pisteet.asString("Pisteet: " + "\n" + "[%d]"));

        root.getChildren().add(textScore);
        return root;
    }

    public void tarkistaJalokivet() {
        Map<Integer, List<jalokivi>> rows = jalokivet.stream().collect(Collectors.groupingBy(jalokivi::getRivi));
        Map<Integer, List<jalokivi>> columns = jalokivet.stream().collect(Collectors.groupingBy(jalokivi::getSarake));

        rows.values().forEach(this::tarkistaYhdistelmat);
        columns.values().forEach(this::tarkistaYhdistelmat);
    }

    public void tarkistaYhdistelmat(List<jalokivi> jewelsLine) {
        jalokivi jewel = jewelsLine.get(0);
        long count = jewelsLine.stream().filter(j -> j.getVari() != jewel.getVari()).count();
        if (count == 0) {
            pisteet.set(pisteet.get() + 1000);
            jewelsLine.forEach(jalokivi::randomi);
        }
    }

    public void vaihdaJalokivet(jalokivi a, jalokivi b) {
        Paint color = a.getVari();
        a.setVari(b.getVari());
        b.setVari(color);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(pelipaneeli()));
        primaryStage.show();
    }

    // ei private
    public class jalokivi extends Parent {

        private Circle ympyra = new Circle(Koko / 2);

        public jalokivi(Point2D point) {
            ympyra.setCenterX(Koko / 2);
            ympyra.setCenterY(Koko / 2);
            ympyra.setFill(varit[new Random().nextInt(varit.length)]);

            setTranslateX(point.getX() * Koko);
            setTranslateY(point.getY() * Koko);
            getChildren().add(ympyra);

            setOnMouseClicked(event -> {
                if (selected == null) {
                    selected = this;
                } else {
                    vaihdaJalokivet(selected, this);
                    tarkistaJalokivet();
                    selected = null;
                }
            });
        }

        public void randomi() {
            ympyra.setFill(varit[new Random().nextInt(varit.length)]);
        }

        public int getSarake() {
            return (int) getTranslateX() / Koko;
        }

        public int getRivi() {
            return (int) getTranslateY() / Koko;
        }

        public void setVari(Paint color) {
            ympyra.setFill(color);
        }

        public Paint getVari() {
            return ympyra.getFill();
        }
    }
}
