package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class Execution extends Combat{
    double damage1;
    double damage2;
    double HP1=300;
    double HP2=300;
    double buff1;
    double buff2;
    int option1;
    int option2;
    ImageView power;
    ImageView defense;
    Glow glow;
    boolean flag = false;


    void inputBucket1(int option,double damage,double defBuff){


        damage1=damage*.5;
        buff1=defBuff;
        option1=option;



        playerAnimation();


    }

    void inputBucket2(int option,double damage,double defBuff){
        damage2=damage*.5;
        buff2=defBuff;
        option2=option;

    }

    static SepiaTone blood;
    static TranslateTransition enemyHurt;
    Image defend1;
    Label label;
    MediaPlayer playerHurt;
    void playerAnimation()  {

        Media sound1 = new Media("file:///E:/PokeX/src/playerHurtSound.mp3");
        playerHurt = new MediaPlayer(sound1);
        Media sound2 = new Media("file:///E:/PokeX/src/opponentHurtSound.mp3");
        MediaPlayer opponentHurt = new MediaPlayer(sound2);

        HP1= HP1-(damage2-(damage2*buff1));
        HP2= HP2-(damage1-(damage1*buff2));

        Image playerAttack = new Image("swordAnimation1.png");

        Image playerFree = new Image("freeHand3.png");
        ImageView freeHand = new ImageView();
        freeHand.setImage(playerFree);

        Image dagger = new Image("magic.png");
        ImageView magicPower = new ImageView();
        magicPower.setImage(dagger);

        Image playerDagger = new Image("daggerInHand1.png");

        Image powerEffect = new Image("atkbuff.png");
        power = new ImageView();
        power.setImage(powerEffect);

        Image defenseEffect = new Image("defbuff.png");
        defense = new ImageView();
        defense.setImage(defenseEffect);

        Image defend = new Image("block.png");
        defend1 = new Image("blockOpp.png");

        foreGround.setTopAnchor(magicPower, 310.0);
        foreGround.setLeftAnchor(magicPower, 240.0);
        foreGround.setTopAnchor(defense, 320.0);
        foreGround.setLeftAnchor(defense, 65.0);

        transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1));
        transition.setToX(300);
        transition.setNode(player);




        TranslateTransition transitionPause = new TranslateTransition();
        transitionPause.setDuration(Duration.seconds(.7));
        transitionPause.setFromX(320);
        transitionPause.setToX(320);
        transitionPause.setNode(player);



        TranslateTransition transitionRev =  new TranslateTransition();
        transitionRev.setDuration(Duration.seconds(1));
        transitionRev.setFromX(300);
        transitionRev.setToX(8);
        transitionRev.setNode(player);

        enemyHurt = new TranslateTransition();
        enemyHurt.setDuration(Duration.seconds(.8));
        enemyHurt.setToY(5);
        enemyHurt.setAutoReverse(true);
        enemyHurt.setCycleCount(2);

        TranslateTransition playerMagic = new TranslateTransition();
        playerMagic.setDuration(Duration.seconds(1));
        playerMagic.setFromX(85);
        playerMagic.setToX(85);
        playerMagic.setNode(player);

        TranslateTransition freeKnight = new TranslateTransition();
        freeKnight.setDuration(Duration.seconds(1));
        freeKnight.setFromX(85);
        freeKnight.setToX(85);
        freeKnight.setNode(freeHand);

        TranslateTransition daggerMovement = new TranslateTransition();
        daggerMovement.setDuration(Duration.seconds(1));
        daggerMovement.setToX(350);
        daggerMovement.setNode(magicPower);

        RotateTransition daggerRotation = new RotateTransition();
        daggerRotation.setDuration(Duration.seconds(1));
        daggerRotation.setAxis(Rotate.Z_AXIS);
        daggerRotation.setByAngle(360);
        daggerRotation.setNode(magicPower);

        ParallelTransition daggerAnimation = new ParallelTransition(magicPower,daggerMovement,daggerRotation,freeKnight);

        TranslateTransition transitionPause1 = new TranslateTransition();
        transitionPause1.setNode(player);
        transitionPause1.setDuration(Duration.seconds(1.5));

        TranslateTransition hercules = new TranslateTransition();
        hercules.setDuration(Duration.seconds(1));
        hercules.setFromY(0);
        hercules.setToY(-90);

        hercules.setCycleCount(3);

        RotateTransition buffAttack = new RotateTransition();
        buffAttack.setDuration(Duration.seconds(1));
        buffAttack.setAxis(Rotate.Y_AXIS);
        buffAttack.setFromAngle(0);
        buffAttack.setByAngle(39);
        buffAttack.setCycleCount(3);

        ParallelTransition buffHercules = new ParallelTransition(power,hercules,buffAttack);
        ParallelTransition buffAthena = new ParallelTransition(defense,hercules,buffAttack);

        TranslateTransition blockDefend = new TranslateTransition();
        blockDefend.setDuration(Duration.seconds(1.5));
        blockDefend.setNode(player);

        blood = new SepiaTone();

        glow = new Glow();
        glow.setLevel(.8);

        label = new Label();
        label.setPrefSize(700,100);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color: rgb(0,0,0,.7);"+"-fx-background-radius:20;"+
                "-fx-border-color: white;"+"-fx-border-width: 5;"+"-fx-font-size: 18px;"
                +"-fx-font-weight: bold;"+"-fx-text-fill:white;"+"-fx-border-radius: 20");


        if(option1==0&&(option2==1||option2==2)){
            foreGround.setTopAnchor(player,240.0);
            player.setImage(defend);
            blockDefend.play();
            label.setText("You have Blocked Enemy's Attack");
            stack.getChildren().addAll(pane,label);

            blockDefend.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    foreGround.setTopAnchor(player,280.0);
                    player.setImage(playerCharacter);
                    stack.getChildren().removeAll(pane,label);

                }
            });
        }
        else if(option1==0&&(option2==3||option2==4||option2==0)){
            foreGround.setTopAnchor(player,240.0);
            player.setImage(defend);
            blockDefend.play();
            stack.getChildren().add(pane);
            blockDefend.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    foreGround.setTopAnchor(player,280.0);
                    player.setImage(playerCharacter);
                    if(option2==3){
                        opponentAtkBuff();
                    }
                    else if(option2==4){
                        opponentDefBuff();
                    }
                    else if(option2==0){
                        opponentBlock();
                    }
                }
            });
        }
        if(option2==0&&(option1==1||option1==2)){
            label.setText("Enemy has Blocked Player's Attack");
            stack.getChildren().addAll(pane,label);
            flag= true;
            opponentBlock();
        }
        else if(option2!=0&&option1==1){
            stack.getChildren().add(pane);
            transition.play();
            transition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    player.setImage(playerAttack);
                    transitionPause.play();
                    opponentHurt.stop();
                    opponentHurt.play();
                    opponent.setEffect(blood);
                    enemyHurt.setNode(opponent);
                    enemyHurt.setToX(20);
                    enemyHurt.play();
                    opponentHurtBar.setWidth(HP2);
                    if(HP2<=0)
                    {
                        label.setText(" YOU HAVE WON ");
                        backGround.getChildren().remove(foreGround);

                        backGround.getChildren().addAll(player,label);
                    }
                    transitionPause.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            opponent.setEffect(null);
                            player.setImage(playerCharacter);
                            transitionRev.play();
                            transitionRev.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    if(option2==1){
                                        opponentSword();
                                    }
                                    else if(option2==2){
                                        opponentMagic();
                                    }
                                    else if(option2==3){
                                        opponentAtkBuff();
                                    }
                                    else if(option2==4){
                                        opponentDefBuff();
                                    }


                                }
                            });
                        }
                    });
                }
            });
        }

        else if(option2!=0&&option1==2){

            stack.getChildren().add(pane);
            playerMagic.play();
            player.setImage(playerDagger);
            playerMagic.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    foreGround.getChildren().add(magicPower);
                    daggerAnimation.play();

                    player.setImage(playerFree);
                    daggerAnimation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            opponentHurt.stop();
                            opponentHurt.play();
                            foreGround.getChildren().remove(magicPower);
                            opponent.setEffect(blood);
                            enemyHurt.setNode(opponent);
                            enemyHurt.setToX(20);
                            enemyHurt.play();
                            opponentHurtBar.setWidth(HP2);

                            if(HP2<=0)
                            {
                                label.setText(" YOU HAVE WON ");
                                backGround.getChildren().remove(foreGround);

                                backGround.getChildren().addAll(player,label);
                            }
                            transitionPause1.play();
                            transitionPause1.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    opponent.setEffect(null);
                                    player.setImage(playerCharacter);
                                    magicPower.setTranslateX(-80);
                                    player.setTranslateX(-10);
                                    if(option2==1){

                                        opponentSword();
                                    }
                                    else if(option2==2){
                                        opponentMagic();
                                    }
                                    else if(option2==3){
                                        opponentAtkBuff();
                                    }
                                    else if(option2==4){
                                        opponentDefBuff();
                                    }
                                }
                            });

                        }
                    });
                }
            });

        }

        else if(option1==3){
            stack.getChildren().add(pane);
            foreGround.setTopAnchor(power, 320.0);
            foreGround.setLeftAnchor(power, 65.0);
            hercules.setNode(power);
            buffAttack.setNode(power);
            buffHercules.play();
            player.setEffect(glow);
            foreGround.getChildren().add(power);
            buffHercules.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    foreGround.getChildren().remove(power);
                    player.setEffect(null);

                    if(option2==1){
                        opponentSword();
                    }
                    else if(option2==2){
                        opponentMagic();
                    }
                    else if(option2==3){
                        opponentAtkBuff();
                    }
                    else if(option2==4){
                        opponentDefBuff();
                    }
                    else if(option2==0){
                        opponentBlock();
                    }

                }
            });
        }

        else if(option1==4){
            stack.getChildren().add(pane);
            hercules.setNode(defense);
            buffAttack.setNode(defense);
            buffAthena.play();
            player.setEffect(glow);
            foreGround.getChildren().add(defense);
            buffAthena.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    foreGround.getChildren().remove(defense);

                    player.setEffect(null);
                    if(option2==1){
                        opponentSword();
                    }
                    else if(option2==2){
                        opponentMagic();
                    }
                    else if(option2==3){
                        opponentAtkBuff();
                    }
                    else if(option2==4){
                        opponentDefBuff();
                    }
                    else if(option2==0){
                        opponentBlock();
                    }


                }
            });

        }


    }

    void opponentSword(){

        Image opponentSword = new Image("opponentSword4.png");

        Image opponentAttack =new Image("opponentAttack.png");

        TranslateTransition transition1 = new TranslateTransition();
        transition1.setDuration((Duration.seconds(1)));
        transition1.setToX(-300);
        transition1.setNode(opponent);

        TranslateTransition transitionPause2 = new TranslateTransition();
        transitionPause2.setDuration(Duration.seconds(.7));
        transitionPause2.setFromX(-320);
        transitionPause2.setToX(-320);
        transitionPause2.setNode(opponent);

        TranslateTransition transitionRev2 =  new TranslateTransition();
        transitionRev2.setDuration(Duration.seconds(1));
        transitionRev2.setFromX(-320);
        transitionRev2.setToX(15);
        transitionRev2.setNode(opponent);

        transition1.play();
        opponent.setImage(opponentSword);
        foreGround.setTopAnchor(opponent, 235.0);

        transition1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                foreGround.setTopAnchor(opponent, 280.0);
                opponent.setImage(opponentAttack);
                transitionPause2.play();
                playerHurt.stop();
                playerHurt.play();
                player.setEffect(blood);
                enemyHurt.setNode(player);
                enemyHurt.setToX(-20);
                enemyHurt.play();
                playerHurtBar.setWidth(HP1);

                if(HP1<=0){
                    {
                        label.setText(" YOU HAVE LOST ");
                        backGround.getChildren().remove(foreGround);

                        backGround.getChildren().addAll(opponent,label);
                    }
                }
                transitionPause2.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        player.setEffect(null);
                        opponent.setImage(opponentCharacter);
                        transitionRev2.play();
                        transitionRev2.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                stack.getChildren().remove(pane);

                            }
                        });
                    }
                });
            }
        });
        

    }

    void opponentMagic(){

        Image swordStance = new Image("magicStance.png");
        Image swordAttack = new Image("magicAttack1.png");
        Image image = new Image("magicSlash.png");
        ImageView magic = new ImageView();
        magic.setImage(image);

        TranslateTransition swordMagic = new TranslateTransition();
        swordMagic.setDuration(Duration.seconds(1));
        swordMagic.setNode(opponent);

        TranslateTransition swordSlash = new TranslateTransition();
        swordSlash.setDuration(Duration.seconds(1));
        swordSlash.setToX(-220);
        swordSlash.setNode(magic);


        foreGround.setTopAnchor(magic, 300.8);
        foreGround.setRightAnchor(magic, 290.0);

        swordMagic.play();
        foreGround.setTopAnchor(opponent,210.0);
        opponent.setImage(swordStance);
        swordMagic.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                foreGround.setTopAnchor(opponent,220.0);
                opponent.setImage(swordAttack);
                foreGround.getChildren().add(magic);
                swordSlash.play();
                swordSlash.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        playerHurt.stop();
                        playerHurt.play();
                        foreGround.getChildren().remove(magic);
                        player.setEffect(blood);
                        enemyHurt.setNode(player);
                        enemyHurt.setToX(-20);
                        enemyHurt.play();
                        playerHurtBar.setWidth(HP1);

                        if(HP1<=0){
                            {
                                label.setText(" YOU HAVE LOST ");
                                backGround.getChildren().remove(foreGround);

                                backGround.getChildren().addAll(opponent,label);
                            }
                        }
                        enemyHurt.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                player.setEffect(null);
                                foreGround.setTopAnchor(opponent,280.0);
                                opponent.setImage(opponentCharacter);
                                stack.getChildren().removeAll(pane,grid);
                            }
                        });
                    }
                });
            }
        });



    }

    void opponentAtkBuff(){

        TranslateTransition hercules = new TranslateTransition();
        hercules.setDuration(Duration.seconds(1));
        hercules.setFromY(0);
        hercules.setToY(-90);
        hercules.setCycleCount(3);

        RotateTransition buffAttack = new RotateTransition();
        buffAttack.setDuration(Duration.seconds(1));
        buffAttack.setAxis(Rotate.Y_AXIS);
        buffAttack.setFromAngle(0);
        buffAttack.setByAngle(39);
        buffAttack.setCycleCount(3);

        ParallelTransition buffHercules = new ParallelTransition(power,hercules,buffAttack);

        foreGround.setTopAnchor(power, 320.0);
        foreGround.setLeftAnchor(power, 570.0);
        hercules.setNode(power);
        buffAttack.setNode(power);
        buffHercules.play();
        opponent.setEffect(glow);
        foreGround.getChildren().add(power);
        buffHercules.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                foreGround.getChildren().remove(power);
                opponent.setEffect(null);
                stack.getChildren().removeAll(pane,grid);



            }
        });

    }

    void opponentDefBuff(){

        TranslateTransition hercules = new TranslateTransition();
        hercules.setDuration(Duration.seconds(1));
        hercules.setFromY(0);
        hercules.setToY(-90);
        hercules.setCycleCount(3);

        RotateTransition buffAttack = new RotateTransition();
        buffAttack.setDuration(Duration.seconds(1));
        buffAttack.setAxis(Rotate.Y_AXIS);
        buffAttack.setFromAngle(0);
        buffAttack.setByAngle(39);
        buffAttack.setCycleCount(3);

        ParallelTransition buffAthena = new ParallelTransition(defense,hercules,buffAttack);

        foreGround.setTopAnchor(defense, 320.0);
        foreGround.setLeftAnchor(defense, 570.0);

        hercules.setNode(defense);
        buffAttack.setNode(defense);
        buffAthena.play();
        opponent.setEffect(glow);
        foreGround.getChildren().add(defense);
        buffAthena.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                foreGround.getChildren().remove(defense);

                opponent.setEffect(null);

                stack.getChildren().removeAll(pane,grid);

            }
        });
    }

    void opponentBlock(){
        TranslateTransition blockDefend1 = new TranslateTransition();
        blockDefend1.setDuration(Duration.seconds(1.5));
        blockDefend1.setNode(opponent);

        foreGround.setTopAnchor(opponent,230.0);
        foreGround.setRightAnchor(opponent, -50.0);
        opponent.setImage(defend1);
        blockDefend1.play();
        blockDefend1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                foreGround.setTopAnchor(opponent,280.0);
                foreGround.setRightAnchor(opponent, 20.0);
                opponent.setImage(opponentCharacter);
                stack.getChildren().removeAll(pane,grid);
                if(flag){
                    flag= false;
                    stack.getChildren().remove(label);
                }
            }
        });
    }
}

