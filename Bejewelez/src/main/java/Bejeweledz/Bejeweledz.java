package Bejeweledz;

import Jalokivet.Jalokivet;
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

public class Bejeweledz extends Application {

    private static final int Pituus = 6;
    private static final int Korkeus = 6;
    private static final int Pelilauta = 100;

    private Color[] varit = new Color[]{
        Color.AQUA, Color.DEEPPINK, Color.BLUEVIOLET, Color.CORAL, Color.YELLOW, Color.CRIMSON};

    private Jalokivi selected = null;
    private List<Jalokivi> jalokivet = new ArrayList<>();

    public Parent logiikka() {
        Pane p = new Pane();
        p.setPrefSize(Pituus * Pelilauta + 250, Korkeus * Pelilauta);

        jalokivet = IntStream.range(0, Pituus * Korkeus)
                .mapToObj(i -> new Point2D(i % Pituus, i / Korkeus))
                .map(point -> new Jalokivi(point))
                .collect(Collectors.toList());

        p.getChildren().addAll(jalokivet);

        
        return p;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(logiikka()));
        primaryStage.show();
    }

    private class Jalokivi extends Parent {

        private Circle circle = new Circle(Pelilauta / 2);

        public Jalokivi(Point2D point) {
            circle.setCenterX(Pelilauta / 2);
            circle.setCenterY(Pelilauta / 2);
            circle.setFill(varit[new Random().nextInt(varit.length)]);

            setTranslateX(point.getX() * Pelilauta);
            setTranslateY(point.getY() * Pelilauta);
            getChildren().add(circle);

        }

        public void randomVari() {
            circle.setFill(varit[new Random().nextInt(varit.length)]);
        }

        public void lisaaVari(Paint color) {
            circle.setFill(color);
        }

        public Paint tulostaVari() {
            return circle.getFill();
        }
    }

    public int getPituus() {
        return Pituus;
    }

    public int getKorkeus() {
        return Korkeus;
    }

    public int getPelilauta() {
        return Pelilauta;
    }
    public int returnJalokivet() {
        if (!jalokivet.isEmpty()) {
            return jalokivet.size();
        }
        return 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
