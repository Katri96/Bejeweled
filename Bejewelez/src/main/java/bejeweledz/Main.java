package bejeweledz;

import peli.Pelipaneeli;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {

    public Pelipaneeli jalokivet;

    /*Luodaan Pelipaneeli Main luokassa ja tuodaan se näkyviin */
    @Override
    public void start(Stage primaryStage) throws Exception {
        jalokivet = new Pelipaneeli();
        primaryStage.setScene(new Scene(jalokivet.pelipaneeli()));
        primaryStage.show();
    }

    public void main(String[] args, Stage primaryStage) throws Exception {
        
        start(primaryStage);
    }
}
