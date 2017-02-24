/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalokivi;

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

    private int koko;
    private Color[] varit = new Color[]{
        Color.DEEPPINK, Color.BLUEVIOLET, Color.SPRINGGREEN,
        Color.CORAL, Color.YELLOW, Color.CRIMSON};

    public Circle ympyra;

    public Jalokivi(Point2D point) {
      
        /* Luodaan uusi ympyrä ja luodaan sen keskipiste kohtaan x = 50 ja Y = 50. 
        Seuraavaksi asetetaan ympyrälle random väri kuudesta eri vaihtoehdosta.
        Lopuksi asetetaan ympyrä haluttuun kohtaan eli pointtiin kertomallalla X ja Y koordinaatti sadalla,
        koska alueen max Y = 600 ja X = 600 ja ympyröitä tulee yhteensä 36.
        Luodaan ympyrästä objekti ja palautetaan tämä.
        */
        koko = 100;
        ympyra = new Circle(koko / 2);
        ympyra.setCenterX(50);
        ympyra.setCenterY(50);
        ympyra.setFill(varit[new Random().nextInt(varit.length)]);

        setTranslateX(point.getX() * koko);
        setTranslateY(point.getY() * koko);
        

        getChildren().add(ympyra);
        

    }
    

    public void randomi() {
        /*Asetetaan ympyrälle väri, valiten se randomilla kuudesta eri värivaihroehosta varit taulusta. */
        ympyra.setFill(varit[new Random().nextInt(varit.length)]);
    }

    public int getSarake() {
        /*Etsitään ympyrän piste ja jaetaan se sadalla, jotta vaihtoehdoksi saadaan jokin sarake väliltä 0-5. */
        return (int) getTranslateX() / koko;
    }

    public int getRivi() {
         /*Etsitään ympyrän piste ja jaetaan se sadalla, jotta vaihtoehdoksi saadaan jokin rivi väliltä 0-5. */
        return (int) getTranslateY() / koko;
    }

    public void setVari(Paint color) {
        ympyra.setFill(color);
    }

    public Paint getVari() {
        return ympyra.getFill();
    }

}
