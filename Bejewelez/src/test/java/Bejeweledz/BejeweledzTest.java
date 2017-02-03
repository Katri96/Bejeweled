/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bejeweledz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
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
public class BejeweledzTest {

    Bejeweledz peli;

    public BejeweledzTest() {
        peli = new Bejeweledz();
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
    public void testaaJalovienLuonti() {

        assertEquals(100, peli.getPelilauta());
    }

    @Test
    public void pituus() {

        assertEquals(6, peli.getPituus());
    }

    @Test
    public void leveys() {
        assertEquals(6, peli.getKorkeus());
    }

    @Test
    public void peliLaudassaNollaJalokivea()  {
        
        assertEquals(peli.returnJalokivet(), 0);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
