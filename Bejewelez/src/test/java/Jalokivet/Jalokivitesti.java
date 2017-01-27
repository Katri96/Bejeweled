/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalokivet;

import Bejeweledz.Jalokivet;
import Bejeweledz.Jalokivi;
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
public class Jalokivitesti {
    
    public Jalokivitesti() {
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
    public void randomJalokivet() {
        Jalokivi a = new Jalokivi();
        
        
        int i = a.randomJalokivi();
        
        if (i<1) {
            fail("pienempi kuin yksi");
        }
        
        if (i>5) {
            fail("isompi kuin 5");
        }
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
