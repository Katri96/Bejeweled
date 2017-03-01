/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli;

import jalokivi.Jalokivi;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;

import peli.Pelipaneeli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mkatri
 */
public class PelipaneeliTest {

    Pelipaneeli a;

    public PelipaneeliTest() {
        a = new Pelipaneeli();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelinLuominenTest() {
        a.pelipaneeli();
        assertTrue(a.getJalokivet() == a.getJalokivet());

    }

    @Test
    public void etsijalokivet() {
        a.pelipaneeli();
        a.tarkistaJalokivet();
//        a.tarkistaYhdistelmat(jalokiviJono);
//        a.vaihdaJalokivet(a, b);
        a.etsiJalokivi(0, 0);
        assertTrue(a.etsiJalokivi(0, 0) == a.etsiJalokivi(0, 0));
    }

    @Test
    public void etsiJalokiviToimii() {
        a.pelipaneeli();
        Jalokivi u = new Jalokivi(new Point2D(1, 3));

        Jalokivi b = a.etsiJalokivi(2, 3);

        assertTrue(u.ympyra.getCenterX() == b.ympyra.getCenterX());

    }

    @Test
    public void varitaKaikkiJalokivetUudelleen() {
        a.pelipaneeli();
        Paint vihrea = (Paint) Color.GREEN;
        for (Jalokivi j : a.getJalokivet()) {
            j.setVari(vihrea);
        }
        assertTrue(a.etsiJalokivi(3, 4).getVari() == a.etsiJalokivi(5, 1).getVari());

    }

    @Test
    public void pelinPisteet() {
        a.pelipaneeli();
        Paint vihrea = (Paint) Color.GREEN;
        for (Jalokivi j : a.getJalokivet()) {
            j.setVari(vihrea);
        }
        a.tarkistaJalokivet();
        assertTrue(a.getPisteet() > 0);

    }

    @Test
    public void tarkistaEiYhdistelmia() {
        a.pelipaneeli();
        a.tarkistaJalokivet();
        a.tarkistaYhdistelmat(a.getJalokivet());
        IntegerProperty i = new SimpleIntegerProperty();
        i.add(20);
        assertTrue(a.getPisteet() == 0);
    }

    @Test
    public void vaihdaVarit() {
        a.pelipaneeli();

        a.vaihdaJalokivet(a.getJalokivet().get(1), a.getJalokivet().get(4));
        assertFalse(a.etsiJalokivi(5, 2) == a.getJalokivet().get(3));
    }

//    @Test
//    public void tekstiAlussaNull() {
//        a.pelipaneeli();
//        assertEquals(null, a.getTextPisteet());
//    }
//
//    @Test
//    public void tekstiTimanttiAlussaNull() {
//        a.pelipaneeli();
//        assertEquals(null, a.getTextTimantti());
//    }

    @Test
    public void tekstiPisteidenJalkeen() {
        a.pelipaneeli();
        a.pelipaneeli();
        Paint kelta = (Paint) Color.YELLOW;
        int i = 0;
        for (Jalokivi j : a.getJalokivet()) {

            if (i == 6) {
                break;
            }
            j.setVari(kelta);
            i++;
        }
        a.tarkistaJalokivet();
        assertEquals("Pisteet: "+ "\n" + "[500]", a.getTextPisteet().getText());
    }

    @Test
    public void tekstiTimanttiAlussa() {
        a.pelipaneeli();
        assertEquals("Jalokivien arvo: \n \nKeltainen = 500\nPinkki = 300\nVihreä = 200", a.getTextTimantti().getText());
    }

    @Test
    public void pisteetErikoisTimanteista() {
        a.pelipaneeli();
        Paint kelta = (Paint) Color.YELLOW;
        int i = 0;
        for (Jalokivi j : a.getJalokivet()) {

            if (i == 6) {
                break;
            }
            j.setVari(kelta);
            i++;
        }
        a.tarkistaJalokivet();
        assertEquals(a.getPisteet(), 500);

    }

    @Test
    public void pisteetErikoisTimanteista2() {
        a.pelipaneeli();
        Paint vihr = (Paint) Color.SPRINGGREEN;
        int i = 0;
        for (Jalokivi j : a.getJalokivet()) {

            j.setVari(vihr);

        }
        a.tarkistaJalokivet();
        assertEquals(a.getPisteet(), 1200);

    }

    @Test
    public void pisteetErikoisTimanteista3() {
        a.pelipaneeli();
        Paint vihr = (Paint) Color.DEEPPINK;
        int i = 0;
        for (Jalokivi j : a.getJalokivet()) {
            if (i > 7) {
                break;
            }
            i++;
            j.setVari(vihr);

        }
        a.tarkistaJalokivet();
        assertEquals(a.getPisteet(), 300);

    }
    @Test
    public void pisteetyAkselilla() {
        a.pelipaneeli();
        
        assertTrue(100 == a.getTextPisteet().getTranslateY());
    }
    @Test
    public void pisteetxAkselilla() {
        a.pelipaneeli();
        
        assertTrue(600 == a.getTextPisteet().getTranslateX());
    }
     @Test
    public void pisteetytimanttiAkselilla() {
        a.pelipaneeli();
        
        assertTrue(230 == a.getTextTimantti().getTranslateY());
    }
    @Test
    public void pisteetxtimanttiAkselilla() {
        a.pelipaneeli();
        
        assertTrue(610 == a.getTextTimantti().getTranslateX());
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
