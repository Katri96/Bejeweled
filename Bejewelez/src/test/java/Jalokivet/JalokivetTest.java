/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalokivet;

import Bejeweledz.Bejeweledz;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
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
public class JalokivetTest {
    Jalokivet a;
    public JalokivetTest() {
        a = new Jalokivet();
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
    public void alussaJalokiviaNolla() {
        
        assertEquals(a.getRivi(), 0);
        
    }
    @Test
    public void eiLisaaJalokivia() {
        a.lisaaJalokivi(Point2D.ZERO);
        assertEquals(0, a.getRivi());
    }
    @Test
    public void lisaaNollakohtaanJalokivet() {
        Point2D i = new Point2D(2,0);
        a.lisaaJalokivi(i);
        assertEquals(0, a.getRivi());
    }
    
    @Test
    public void lisaaJalokiviaKolme() {
        Point2D i = new Point2D(2,3);
        a.lisaaJalokivi(i);
        assertEquals(3, a.getRivi());
    }
    @Test
    public void lisaaJalokiviaNelja() {
        Point2D i = new Point2D(0,4);
        
        a.lisaaJalokivi(i);
        assertEquals(4, a.getRivi());
    }
    @Test
    public void lisaaJalokivia() {
        Point2D i = new Point2D(0,0);
        Point2D z = new Point2D(6,6);
        a.lisaaJalokivi(z);
        
        assertEquals(6, a.getRivi());
    }
    
    @Test
    public void korkeus()  {
        assertEquals(100, a.getPelilauta());

    }
    @Test
    public void leveys() {

        assertEquals(6, a.getLeveys());
    }
    @Test
    public void lisaaKaikkiJalokivet() {
        Point2D i = new Point2D(6,6);
        a.lisaaJalokivi(i);
        assertEquals(6, a.getRivi());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
