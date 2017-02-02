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
    public void jalokivienLisays() {
        a.lisaaJalokivi(Point2D.ZERO);
        assertEquals(a.getRivi(), 1);
    }
    @Test
    public void korkeus()  {
        assertEquals(100, a.getPelilauta());

    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
