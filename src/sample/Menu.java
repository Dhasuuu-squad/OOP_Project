package sample;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;


public class Menu {

    public static Scene menu() throws Exception {

        StackPane all = new StackPane();
        Scene scene = new Scene(all,800,780);
        final int width = 200;

        Image background = new Image("startingBackground1.jpg");
        ImageView imageHolder = new ImageView();
        imageHolder.setImage(background);

//        Label txt = new Label("Come to the Path of Glory....");
//        txt.setMinSize(width * 2, 50);
//        txt.setStyle("-fx-background-color:  black;"+"-fx-text-fill: black;"+"-fx-background-image: url('txt2.jpg');"+
//                "-fx-font-size: 20px; "+"-fx-font-weight: bold;"+"-fx-font-family: Georgia, serif;"
//                  +"-fx-background-radius: 50;"+"-fx-blend: lighten;");
//
//        //txt.setBorder((new Border(new BorderStroke(Color.LIGHTGREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(3)))));
//        txt.setAlignment(Pos.CENTER);

        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(7);
        shadow.setRadius(10);

        Button startGame = new Button("Start Game");
        startGame.setPrefSize(150,60);
        startGame.setOnMouseEntered(e->startGame.setEffect(shadow));
        startGame.setOnMouseExited(e->startGame.setEffect(null));
        startGame.setOnMouseClicked(e ->{


            startGame.setOnMousePressed(event -> startGame.setTranslateY(2));
            startGame.setTranslateY(-2);

        });
        startGame.setOnAction(e -> Combat.start());

        startGame.setStyle("-fx-background-color: linear-gradient(#32cd32,#006400);"+"-fx-text-fill: black;"+
                 "-fx-font-weight: bold;"+"-fx-background-radius: 30");



        Button settings = new Button("Settings");
        settings.setPrefSize(150,60);
        settings.setOnMouseEntered(e->settings.setEffect(shadow));
        settings.setOnMouseExited(e->settings.setEffect(null));
        settings.setOnMouseClicked(e ->{

            settings.setOnMousePressed(event -> settings.setTranslateY(2));
            settings.setTranslateY(-2);

        });
        settings.setStyle("-fx-background-color: linear-gradient(#ffd700,#FF8C00);"+"-fx-text-fill: black;"+
                "-fx-font-weight: bold;"+"-fx-background-radius: 30");


        Button exitGame = new Button("Exit Game");
        exitGame.setPrefSize(150,60);
        exitGame.setOnMouseEntered(e->exitGame.setEffect(shadow));
        exitGame.setOnMouseExited(e->exitGame.setEffect(null));
        exitGame.setOnMouseClicked(e ->{


            exitGame.setOnMousePressed(event -> exitGame.setTranslateY(2));
            exitGame.setTranslateY(-2);

        });

        exitGame.setStyle("-fx-background-color: linear-gradient(#DC143C,#ff0000);"+"-fx-text-fill: black;"+
                "-fx-font-weight: bold;"+"-fx-background-radius: 30;");
        exitGame.setOnAction(e -> Main.exitProgram());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(startGame,settings,exitGame);
        layout.setAlignment(Pos.BOTTOM_CENTER);

        all.getChildren().addAll(imageHolder,layout);





        return scene;

    }
}
