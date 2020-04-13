package sample;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;


public class Combat extends Main {

    static StackPane stack = new StackPane();


    public static void start() {

        Media media = new Media("file:///E:/PokeX/src/bgm.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        GridPane gridPane = new GridPane();
        gridPane.getRowConstraints().add(new RowConstraints(500));
        gridPane.getRowConstraints().add(new RowConstraints(300));
        gridPane.getColumnConstraints().add(new ColumnConstraints(800));

        StackPane backGround = new StackPane();
        backGround.setStyle("-fx-background-color: black;");

        Image CombatBackground = new Image("FightingBackground1.jpg");
        ImageView imageHolder = new ImageView();
        imageHolder.setImage(CombatBackground);

        Image playerCharacter = new Image("knight1.png");
        ImageView player = new ImageView();
        player.setImage(playerCharacter);

        Image opponentCharacter = new Image("opponent2.png");
        ImageView opponent = new ImageView();
        opponent.setImage(opponentCharacter);


        AnchorPane foreGround = new AnchorPane();

        Label playerHP = new Label("Player's Health");
        playerHP.setStyle("-fx-text-fill: white;" + "-fx-background-color: grey;" + "-fx-font-weight: bold;");

        Label opponentHP = new Label("Opponent's Health");
        opponentHP.setStyle("-fx-text-fill: white;" + "-fx-background-color: grey;" + "-fx-font-weight: bold;");


        ProgressBar playerHealthBar = new ProgressBar(100);
        playerHealthBar.setPrefSize(250, 30);

        ProgressBar opponentHealthBar = new ProgressBar(100);
        opponentHealthBar.setPrefSize(250, 30);

        foreGround.setTopAnchor(playerHealthBar, 40.0);
        foreGround.setLeftAnchor(playerHealthBar, 20.0);
        foreGround.setTopAnchor(playerHP, 20.0);
        foreGround.setLeftAnchor(playerHP, 20.0);
        foreGround.setTopAnchor(opponentHealthBar, 40.0);
        foreGround.setRightAnchor(opponentHealthBar, 20.0);
        foreGround.setTopAnchor(opponentHP, 20.0);
        foreGround.setRightAnchor(opponentHP, 20.0);
        foreGround.setTopAnchor(player, 130.0);
        foreGround.setLeftAnchor(player, -25.0);
        foreGround.setTopAnchor(opponent, 130.0);
        foreGround.setRightAnchor(opponent, 20.0);

        foreGround.getChildren().addAll(playerHP, opponentHP, playerHealthBar, opponentHealthBar, player,opponent);

        backGround.getChildren().addAll(imageHolder, foreGround);


        stack.setStyle("-fx-background-color: black");

        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(80);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.DARKGRAY);
        dropShadow.setOffsetY(5);
        dropShadow.setRadius(20);


        Button block = new Button("Block");
        block.setPrefWidth(200);
        block.setPrefHeight(80);
        block.setOnMouseEntered(e -> block.setEffect(dropShadow));
        block.setOnMouseExited(e -> block.setEffect(null));
        block.setStyle("-fx-background-radius: 30;" + "-fx-background-color:  #778899;" +
                "-fx-text-fill: black;" + "-fx-font-weight: bold;");

        Button swordAttack = new Button("Sword Attack");
        swordAttack.setPrefWidth(200);
        swordAttack.setPrefHeight(80);
        swordAttack.setOnMouseEntered(e -> swordAttack.setEffect(dropShadow));
        swordAttack.setOnMouseExited(e -> swordAttack.setEffect(null));
        swordAttack.setStyle("-fx-background-color: #1e90ff;" +
                "-fx-font-weight: bold;" + "-fx-background-radius: 30;" + "-fx-text-fill: white;");

        Button magic = new Button("Magic");
        magic.setPrefWidth(200);
        magic.setPrefHeight(80);
        magic.setOnMouseEntered(e -> magic.setEffect(dropShadow));
        magic.setOnMouseExited(e -> magic.setEffect(null));
        magic.setStyle("-fx-background-color:  #9932cc;" + "-fx-font-weight: bold;" +
                "-fx-background-radius: 30;" + "-fx-text-fill: white;");

        Button atkBuff = new Button("Power of Hercueles");
        atkBuff.setPrefWidth(200);
        atkBuff.setPrefHeight(80);
        atkBuff.setOnMouseEntered(e -> atkBuff.setEffect(dropShadow));
        atkBuff.setOnMouseExited(e -> atkBuff.setEffect(null));
        atkBuff.setStyle("-fx-background-color:  #8b0000;" +
                "-fx-font-weight: bold;" + "-fx-background-radius: 30;" + "-fx-text-fill: white;");

        Button defBuff = new Button("Protection of Athena");
        defBuff.setPrefWidth(200);
        defBuff.setPrefHeight(80);
        defBuff.setOnMouseEntered(e -> defBuff.setEffect(dropShadow));
        defBuff.setOnMouseExited(e -> defBuff.setEffect(null));
        defBuff.setStyle("-fx-background-color: #228b22;" +
                "-fx-font-weight: bold;" + "-fx-background-radius: 30;" + "-fx-text-fill: white;");


        grid.add(swordAttack, 0, 0);
        grid.add(magic, 0, 1);
        grid.add(atkBuff, 1, 0);
        grid.add(defBuff, 1, 1);
        grid.add(block, 0, 2,2,1);

        grid.setHalignment(block, HPos.CENTER);


        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: black;");

        stack.getChildren().add(grid);

        gridPane.add(stack, 0, 1);
        gridPane.add(backGround, 0, 0);

        Scene scene = new Scene(gridPane, 800, 800);
        window.setScene(scene);
    }
}

