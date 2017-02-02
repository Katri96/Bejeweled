/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bejeweledz;

import javafx.geometry.Point2D;
import static java.lang.Byte.SIZE;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Bejeweledz extends Application {

    private static final int W = 6;
    private static final int H = 6;
    private static final int SIZE = 100;

    private Color[] colors = new Color[]{
        Color.ROYALBLUE, Color.GOLD, Color.TURQUOISE,
        Color.DARKORCHID, Color.ORANGE, Color.DARKRED};

    private Jalokivi selected = null;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(W * SIZE, H * SIZE);

        List<Jalokivi> jewels = IntStream.range(0, H * W)
                .mapToObj(i -> new Point2D( i / H, i % W))
                .map(point -> new Jalokivi(point))
                .collect(Collectors.toList());

        root.getChildren().addAll(jewels);

        return root;
    }
    
    private class Jalokivi extends Parent {
        private Circle circle = new Circle(SIZE / 2);

        public Jalokivi(Point2D point) {
            
            circle.setCenterX(SIZE / 2);
            circle.setCenterY(SIZE / 2);
            circle.setFill(colors[new Random().nextInt(colors.length)]);

            setTranslateX(point.getX() * SIZE);
            setTranslateY(point.getX() * SIZE);
            getChildren().add(circle);
            
            setOnMouseClicked(event -> {
                
                if (selected == null) {
                    selected = this;
                }
                else {
                    swap(selected, this);
                    selected = null;
                }
            });
        }
    }

    
    private void swap(Jalokivi a, Jalokivi b) {
        
    }
    /*public Paint getColor() {
        return;
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
