package sample;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Combat extends Main {

    static StackPane stack = new StackPane();
    static DropShadow dropShadow = new DropShadow();
    static MediaPlayer hepticClicked;
    static int buttonWidth = 150;
    static int buttonHeight = 80;
    static AnchorPane foreGround = new AnchorPane();
    static  Label info;
    public static void start() {


        Media media = new Media("file:///E:/PokeX/src/bgm.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        GridPane gridPane = new GridPane();
        gridPane.getRowConstraints().add(new RowConstraints(600));
        gridPane.getRowConstraints().add(new RowConstraints(200));
        gridPane.getColumnConstraints().add(new ColumnConstraints(800));

        StackPane backGround = new StackPane();
        backGround.setStyle("-fx-background-color: black;");

        Image CombatBackground = new Image("FightingBackgroundL.jpg");
        ImageView imageHolder = new ImageView();
        imageHolder.setImage(CombatBackground);

        Image playerCharacter = new Image("knight1.png");
        ImageView player = new ImageView();
        player.setImage(playerCharacter);

        Image opponentCharacter = new Image("opponent2.png");
        ImageView opponent = new ImageView();
        opponent.setImage(opponentCharacter);




        Label playerHP = new Label("Player's Health");
        playerHP.setStyle("-fx-text-fill: black;" + "-fx-background-color: grey;" +
                "-fx-background-radius: 5;"+"-fx-font-weight: bold;");

        Label opponentHP = new Label("Opponent's Health");
        opponentHP.setStyle("-fx-text-fill: black;" + "-fx-background-color: grey;" +
                "-fx-background-radius: 5;" +"-fx-font-weight: bold;");


        Rectangle playerHealthBar = new Rectangle();
        playerHealthBar.setFill(Color.rgb(50,205,50,.87));
        playerHealthBar.setHeight(30);
        playerHealthBar.setWidth(250);
        playerHealthBar.setArcWidth(30.0);
        playerHealthBar.setArcHeight(30.0);
        playerHealthBar.setStroke(Color.rgb(0,0,0,.5));
        playerHealthBar.setStrokeWidth(4.0);


        Rectangle opponentHealthBar = new Rectangle();
        opponentHealthBar.setFill(Color.rgb(50,205,50,.87));
        opponentHealthBar.setHeight(30);
        opponentHealthBar.setWidth(250);
        opponentHealthBar.setArcWidth(30.0);
        opponentHealthBar.setArcHeight(30.0);
        opponentHealthBar.setStroke(Color.rgb(0,0,0,.5));
        opponentHealthBar.setStrokeWidth(4.0);

        foreGround.setTopAnchor(playerHealthBar, 40.0);
        foreGround.setLeftAnchor(playerHealthBar, 20.0);
        foreGround.setTopAnchor(playerHP, 20.0);
        foreGround.setLeftAnchor(playerHP, 25.0);
        foreGround.setTopAnchor(opponentHealthBar, 40.0);
        foreGround.setRightAnchor(opponentHealthBar, 20.0);
        foreGround.setTopAnchor(opponentHP, 20.0);
        foreGround.setRightAnchor(opponentHP, 25.0);
        foreGround.setTopAnchor(player, 280.0);
        foreGround.setLeftAnchor(player, -25.0);
        foreGround.setTopAnchor(opponent, 280.0);
        foreGround.setRightAnchor(opponent, 20.0);

        foreGround.getChildren().addAll(playerHP, opponentHP, opponentHealthBar, player,opponent,playerHealthBar);

        backGround.getChildren().addAll(imageHolder, foreGround);

        info = new Label();
        info.setPrefSize(700,100);
        info.setAlignment(Pos.CENTER);
        info.setStyle("-fx-background-color: rgb(0,0,0,.7);"+"-fx-background-radius:20;"+
                "-fx-border-color: white;"+"-fx-border-width: 5;"+"-fx-font-size: 18px;"
        +"-fx-font-weight: bold;"+"-fx-text-fill:white;"+"-fx-border-radius: 20");

        foreGround.setTopAnchor(info,500.0);
        foreGround.setLeftAnchor(info,50.0);

        Media heptic1 = new Media("file:///E:/PokeX/src/clicked.mp3");
        hepticClicked = new MediaPlayer(heptic1);


        dropShadow.setColor(Color.BLACK);
        dropShadow.setOffsetY(5);
        dropShadow.setRadius(20);

        Button fight = new Button("Fight");
        fight.setPrefSize(buttonWidth,buttonHeight);

        fight.setOnMouseEntered(e -> fight.setEffect(dropShadow));
        fight.setOnMouseExited(e -> fight.setEffect(null));
        fight.setOnAction(e ->{
            hepticClicked.stop(); //always use stop() before play()
            hepticClicked.play();
            fight.setOnMousePressed(event -> fight.setTranslateY(2));
            fight.setTranslateY(-2);
            fightingOptions();
        });
        fight.setStyle("-fx-background-radius: 30;" + "-fx-background-color: linear-gradient(#FF0000,#8B0000);" +
                "-fx-text-fill: black;" + "-fx-font-weight: bold;");

        Button block = new Button("Block");
        block.setPrefSize(buttonWidth,buttonHeight);
        block.setOnMouseEntered(e -> block.setEffect(dropShadow));
        block.setOnMouseExited(e -> block.setEffect(null));
        block.setOnAction(e ->{
            hepticClicked.stop(); //always use stop() before play()
            hepticClicked.play();
            block.setOnMousePressed(event -> block.setTranslateY(2));
            block.setTranslateY(-2);
        });
        block.setStyle("-fx-background-radius: 30;" + "-fx-background-color: linear-gradient(#20B2AA,#2F4F4F);" +
                "-fx-text-fill: black;" + "-fx-font-weight: bold;");

        HBox hBox = new HBox(50,fight,block);
        hBox.setStyle("-fx-background-image: url('openning0L.jpg');");
        hBox.setAlignment(Pos.CENTER);






        stack.getChildren().add(hBox);

        gridPane.add(stack, 0, 1);
        gridPane.add(backGround, 0, 0);

        Scene scene = new Scene(gridPane, 800, 800);

        window.setScene(scene);
    }
    static void fightingOptions(){

        GridPane grid = new GridPane();
        grid.setVgap(15);
        grid.setHgap(80);

        Button swordAttack = new Button("Sword Attack");
        swordAttack.setPrefSize(buttonWidth-30,buttonHeight-30);
        swordAttack.setOnMouseEntered(e -> {
            swordAttack.setEffect(dropShadow);

            info.setText("Swings the sword with great momentum towards the enemy");
            foreGround.getChildren().add(info);
        });
        swordAttack.setOnMouseExited(e -> {
            swordAttack.setEffect(null);
            info.setText(null);
            foreGround.getChildren().remove(info);
        });
        swordAttack.setOnMouseClicked(e ->{
            hepticClicked.stop(); //always use stop() before play()
            hepticClicked.play();

            swordAttack.setOnMousePressed(event -> {

                swordAttack.setTranslateY(2);
            });
           swordAttack.setTranslateY(-2);

        });
        swordAttack.setStyle("-fx-background-color: linear-gradient(#ADD8E6,#2F4F4F);" +
                "-fx-font-weight: bold;" + "-fx-background-radius: 30;" + "-fx-text-fill: white;");

        Button magic = new Button("Magic");
        magic.setPrefSize(buttonWidth-30,buttonHeight-30);
        magic.setOnMouseEntered(e -> {
            magic.setEffect(dropShadow);
            info.setText("Uses magical daggers and throw them at the enemy");
            foreGround.getChildren().add(info);
        });
        magic.setOnMouseExited(e -> {
            magic.setEffect(null);
            info.setText(null);
            foreGround.getChildren().remove(info);
        });
        magic.setOnMouseClicked(e ->{
            hepticClicked.stop(); //always use stop() before play()
            hepticClicked.play();

            magic.setOnMousePressed(event -> magic.setTranslateY(2));
            magic.setTranslateY(-2);

        });
        magic.setStyle("-fx-background-color: linear-gradient(#DA70D6,#800080);" + "-fx-font-weight: bold;" +
                "-fx-background-radius: 30;" + "-fx-text-fill: white;");

        Button atkBuff = new Button("Power of Hercueles");
        atkBuff.setPrefSize(buttonWidth,buttonHeight-30);
        atkBuff.setOnMouseEntered(e -> {
            atkBuff.setEffect(dropShadow);
            info.setText("By the name of Hercueles, your strength increases ");
            foreGround.getChildren().add(info);
        });
        atkBuff.setOnMouseExited(e -> {
            atkBuff.setEffect(null);
            info.setText(null);
            foreGround.getChildren().remove(info);
        });
        atkBuff.setOnMouseClicked(e ->{
            hepticClicked.stop(); //always use stop() before play()
            hepticClicked.play();

            atkBuff.setOnMousePressed(event -> atkBuff.setTranslateY(2));
            atkBuff.setTranslateY(-2);

        });
        atkBuff.setStyle("-fx-background-color:  linear-gradient(#FF6347,#8b0000);" +
                "-fx-font-weight: bold;" + "-fx-background-radius: 30;" + "-fx-text-fill: white;");

        Button defBuff = new Button("Protection of Athena");
        defBuff.setPrefSize(buttonWidth,buttonHeight-30);
        defBuff.setOnMouseEntered(e -> {
            defBuff.setEffect(dropShadow);
            info.setText("By the grace of Goddess Athena, you become more resistive");
            foreGround.getChildren().add(info);

        });
        defBuff.setOnMouseExited(e -> {
            defBuff.setEffect(null);
            info.setText(null);
            foreGround.getChildren().remove(info);
        });
        defBuff.setOnMouseClicked(e ->{
            hepticClicked.stop(); //always use stop() before play()
            hepticClicked.play();

            defBuff.setOnMousePressed(event -> defBuff.setTranslateY(2));
            defBuff.setTranslateY(-2);

        });
        defBuff.setStyle("-fx-background-color: linear-gradient(#00FF00,#006400);" +
                "-fx-font-weight: bold;" + "-fx-background-radius: 30;" + "-fx-text-fill: white;");

        Button back = new Button("Back");
        back.setPrefSize(50,50);
        back.setOnMouseEntered(e -> back.setEffect(dropShadow));
        back.setOnMouseExited(e -> back.setEffect(null));

         back.setOnMouseClicked(e ->{
            hepticClicked.stop(); //always use stop() before play()
            hepticClicked.play();
            back.setOnMousePressed(event -> back.setTranslateY(2));
            back.setTranslateY(-2);
        });
        back.setStyle("-fx-background-radius: 40;"+"-fx-background-color: linear-gradient(#FF6347,#800000);"+
                "-fx-text-fill: black;"+"-fx-font-weight: bold;");
        back.setOnAction(e -> stack.getChildren().remove(grid));


        grid.add(swordAttack, 0, 0);
        grid.add(magic, 0, 1);
        grid.add(atkBuff, 1, 0);
        grid.add(defBuff, 1, 1);
        grid.add(back,2,0,1,2);

        grid.setValignment(back, VPos.CENTER);

        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-image: url('openning1L.jpg');");
        stack.getChildren().add(grid);
    }
}

