package sample;

import javafx.animation.AnimationTimer;

public class Timer extends Main implements Runnable {


    public void run() {


        final long[] startingTime = {System.nanoTime()};
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                long endingTime = System.nanoTime();
                long elapsedTime = (endingTime - startingTime[0]) / 1000000000;
                if (elapsedTime >= 1) {

                    startingTime[0] = endingTime;
                    counterTime++;
                    System.out.println(counterTime);
                    window.setTitle("Eldritch Knight "+"  "+"Elapsed Time: "+counterTime+" seconds");


                }
            }
        };
        timer.start();


    }

}