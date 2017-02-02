/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalokivet;

import Bejeweledz.Bejeweledz;
import java.util.List;
import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author mkatri
 */
public class Jalokivet extends Parent {

    private static final int Korkeus = 6;
    private static final int Leveys = 6;
    private static final int Pelilauta = 100;

    private Color[] varit = new Color[]{
        Color.AQUA, Color.DEEPPINK, Color.BLUEVIOLET, Color.CORAL, Color.YELLOW, Color.CRIMSON};

    private Jalokivet selected = null;

    private List<Jalokivet> jalokivet;

    private Circle jalokivi = new Circle(Pelilauta / 2);

    public void lisaaJalokivi(Point2D point) {
        jalokivi.setCenterX(Pelilauta / 2);
        jalokivi.setCenterY(Pelilauta / 2);
        jalokivi.setFill(varit[new Random().nextInt(varit.length)]);

        setTranslateX(point.getX() * Pelilauta);
        setTranslateY(point.getY() * Pelilauta);
        getChildren().add(jalokivi);

    }

    public void randomVari() {
        jalokivi.setFill(varit[new Random().nextInt(varit.length)]);
    }

    public void setVari(Paint color) {
        jalokivi.setFill(color);
    }

    public Paint getVari() {
        return jalokivi.getFill();
    }

    public int getColumn() {
        return (int) getTranslateX() / Pelilauta;
    }

    public int getRivi() {
        return (int) getTranslateY() / Pelilauta;
    }
    
    public int getLeveys() {
        return Leveys;
    }

    public int getKorkeus() {
        return Korkeus;
    }

    public int getPelilauta() {
        return Pelilauta;
    }


}
