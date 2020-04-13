package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage window = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window= primaryStage;
        window.setResizable(false);
        window.setMaxHeight(780);
        window.setMinWidth(800);
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProgram();
        });


        window.setScene(Menu.menu());
        Timer t1 = new Timer();
        Thread showRunTime = new Thread(t1);
        showRunTime.setDaemon(true);
        showRunTime.start();

        window.show();

    }


    public static void main(String[] args)
    {
        launch(args);
    }

    public static void exitProgram() {
        if (ConfirmBox.display("Exit?", "Are you sure you want to exit?")) {



            window.close();

        }
    }

}

