/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author mkatri
 */
public class Jalokivi extends Parent {

    private static final int Leveys = 6;
    private static final int Korkeus = 6;
    private static final int Koko = 100;
    private Color[] varit = new Color[]{
        Color.AQUA, Color.DEEPPINK, Color.BLUEVIOLET, Color.CORAL, Color.YELLOW, Color.CRIMSON};

    Jalokivi selected = null;
    private List<Jalokivi> jalokivet;
    private Pelipaneeli paneeli;

    public Circle ympyra = new Circle(Koko / 2);

    public Jalokivi(Point2D point) {

        ympyra.setCenterX(Koko / 2);
        ympyra.setCenterY(Koko / 2);
        ympyra.setFill(varit[new Random().nextInt(varit.length)]);

        setTranslateX(point.getX() * Koko);
        setTranslateY(point.getY() * Koko);

        getChildren().add(ympyra);

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
