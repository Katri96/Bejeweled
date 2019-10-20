package Bejeweledz;

import Peli.Pelipaneeli;
import Peli.Pelipaneeli;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bejeweledz extends Application {
    
    public Pelipaneeli jalokivet;


    @Override
    public void start(Stage primaryStage) throws Exception {
        jalokivet = new Pelipaneeli();
        primaryStage.setScene(new Scene(jalokivet.pelipaneeli()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
