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




public class Menu {

    public static Scene menu() throws Exception {

        StackPane all = new StackPane();
        Scene scene = new Scene(all,800,780);
        final int width = 200;

        Image background = new Image("startingBackground1.jpg");
        ImageView imageHolder = new ImageView();
        imageHolder.setImage(background);

        Label txt = new Label("Come to the Path of Glory....");
        txt.setMinSize(width * 2, 50);
        txt.setStyle("-fx-background-color:  black;"+"-fx-text-fill: #90ee90;"+
                "-fx-font-size: 20px; "+"-fx-font-weight: bold;"+"-fx-font-family: Georgia, serif;");

        txt.setBorder((new Border(new BorderStroke(Color.LIGHTGREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(3)))));
        txt.setAlignment(Pos.CENTER);

        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(7);
        shadow.setRadius(10);

        Button startGame = new Button("Start Game");
        startGame.setPrefSize(150,60);
        startGame.setOnMouseEntered(e->startGame.setEffect(shadow));
        startGame.setOnMouseExited(e->startGame.setEffect(null));
        startGame.setStyle("-fx-background-color: #32cd32;"+"-fx-text-fill: black;"+
                 "-fx-font-weight: bold;"+"-fx-background-radius: 30");
        startGame.setOnAction(e ->Combat.start());

        Button settings = new Button("Settings");
        settings.setPrefSize(150,60);
        settings.setOnMouseEntered(e->settings.setEffect(shadow));
        settings.setOnMouseExited(e->settings.setEffect(null));
        settings.setStyle("-fx-background-color: #ffd700;"+"-fx-text-fill: black;"+
                "-fx-font-weight: bold;"+"-fx-background-radius: 30");


        Button exitGame = new Button("Exit Game");
        exitGame.setPrefSize(150,60);
        exitGame.setOnMouseEntered(e->exitGame.setEffect(shadow));
        exitGame.setOnMouseExited(e->exitGame.setEffect(null));

        exitGame.setStyle("-fx-background-color: #ff0000;"+"-fx-text-fill: black;"+
                "-fx-font-weight: bold;"+"-fx-background-radius: 30;");
        exitGame.setOnAction(e -> Main.exitProgram());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(txt,startGame,settings,exitGame);
        layout.setAlignment(Pos.BOTTOM_CENTER);

        all.getChildren().addAll(imageHolder,layout);





        return scene;

    }
}
