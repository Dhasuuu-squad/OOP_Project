package sample;

public class Timer extends Thread {



        public void run () {
            long counterTime = 0L;
            boolean flag = true;
            Main main = new Main();
            long startingTime = System.nanoTime();
            System.out.println(startingTime);

            while (flag) {
                long endingTime = System.nanoTime();
                System.out.println(endingTime);
                long elapsedTime = (endingTime - startingTime) / 1000000000L;
                System.out.println(elapsedTime);
                if (elapsedTime >= 1L) {
                    startingTime = endingTime;
                    ++counterTime;
                    main.window.setTitle("Eldritch Knight  Elapsed Time: " + counterTime);
                    System.out.println("counter: " + counterTime);
                }
            }

        }
}
