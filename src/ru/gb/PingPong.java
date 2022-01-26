package ru.gb;

public class PingPong implements Runnable{
    private static String status = "ping";
    private final String word;
    private static int i = 0;
    public PingPong(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            synchronized (PingPong.class){
                while (word.equals(status)){
                    try {
                        PingPong.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                System.out.println(word);
                i++;
                System.out.println(i);
                status = word;
                try {
                    Thread.sleep(1000);
                    PingPong.class.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PingPong("ping")).start();
        new Thread(new PingPong("pong")).start();
        while (true){
            if (i > 5) {
                System.out.println("Program is finish work, good bye");
                Runtime.getRuntime().exit(0);
            }
        }

    }
}
