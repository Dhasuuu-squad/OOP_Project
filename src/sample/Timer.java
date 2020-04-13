package sample;

import javafx.animation.AnimationTimer;

public class Timer extends Main implements Runnable {
    public static long counterTimeSec = 0;
    public static long counterTimeMin = 0;
    public static long counterTimeHours = 0;

    public void run() {


        final long[] startingTime = {System.nanoTime()};
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                long endingTime = System.nanoTime();
                long elapsedTime = (endingTime - startingTime[0]) / 1000000000;
                if (elapsedTime >= 1) {

                    startingTime[0] = endingTime;
                    counterTimeSec++;
                    if(counterTimeSec==60){
                        counterTimeSec=0;
                        counterTimeMin++;
                    }
                    if(counterTimeMin==60){
                        counterTimeMin=0;
                        counterTimeHours++;
                    }
                    if(counterTimeHours!=0){
                        window.setTitle("Eldritch Knight " + "  " + "Elapsed Time: " +counterTimeHours+" hours "+ counterTimeMin + " mins " + counterTimeSec + " seconds");
                    }


                    if(counterTimeMin!=0) {
                        window.setTitle("Eldritch Knight " + "  " + "Elapsed Time: " + counterTimeMin + " mins " + counterTimeSec + " seconds");
                    }
                    else{
                        window.setTitle("Eldritch Knight " + "  " + "Elapsed Time: " + counterTimeSec + " seconds");
                    }


                }
            }
        };
        timer.start();


    }

}