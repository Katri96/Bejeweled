/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalokivi;

import Jalokivi.Jalokivi;
import javafx.geometry.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Peli.Pelipaneeli;
import Peli.Pelipaneeli;
import static java.awt.PageAttributes.ColorType.COLOR;
import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author mkatri
 */
public class JalokiviTest {

    Jalokivi a;
    Pelipaneeli b;

    public JalokiviTest() {

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
    public void jalokivetRiveilla() {
        a = new Jalokivi(new Point2D(2, 3));
        assertEquals(3, a.getRivi());
    }

    @Test
    public void jalokivetSarakkeilla() {
        a = new Jalokivi(new Point2D(2, 3));
        assertEquals(2, a.getSarake());
    }

    @Test
    public void aluksiRivitTyhjat() {
        a = new Jalokivi(new Point2D(0, 0));

        assertEquals(0, a.getRivi());
    }

    @Test
    public void aluksiSarakkeetTyhjat() {
        a = new Jalokivi(new Point2D(0, 0));

        assertEquals(0, a.getSarake());
    }

    @Test
    public void randomiVariToimii() {
        a = new Jalokivi(new Point2D(3, 5));
        a.randomi();
        assertEquals(3, a.getSarake());

    }

    @Test
    public void varinLisaysToimii() {
        a = new Jalokivi(new Point2D(3, 5));
        Paint u = a.getVari();
        assertTrue(true == u.isOpaque());
    }

    @Test
    public void ympyranVarinLisays() {
        a = new Jalokivi(new Point2D(3, 5));
        Paint color = a.getVari();
        a.setVari(color);
        Paint u = a.getVari();
        assertTrue(true == u.isOpaque());

    }

    @Test
    public void ympyranX() {
        a = new Jalokivi(new Point2D(3, 5));
        int i = (int) a.ympyra.getCenterX();
        assertEquals(50, i);
    }

    @Test
    public void ympyranY() {
        a = new Jalokivi(new Point2D(3, 5));
        int i = (int) a.ympyra.getCenterY();
        assertEquals(50, i);
    }

    @Test
    public void randomiTestaus() {
        a = new Jalokivi(new Point2D(3, 5));
        Paint p = a.getVari();
        a.randomi();
        Color v = Color.YELLOW;
        
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
