/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bejeweledz;

import java.util.Random;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

/**
 *
 * @author mkatri
 */
public class Jalokivi extends Parent {

    Random random;

    public Jalokivi() {
        int i = randomJalokivi();

    }


    public int randomJalokivi() {
        
        int randjalo = random.nextInt(5) +1;
        return 3;
    }
    

}
