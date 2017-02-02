/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bejeweledz;

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
    
    public BejeweledzTest() {
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
        Bejeweledz peli = new Bejeweledz();
        assertEquals(100, peli.getPelilauta());
    }
    @Test
    public void pituus() {
        
        Bejeweledz peli = new Bejeweledz();
        assertEquals(6, peli.getPituus());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
