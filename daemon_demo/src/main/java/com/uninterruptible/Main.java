package daemon_demo.src.main.java.com.uninterruptible;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.Uninterruptibles;

public class Main{

    public static void main(String[] args) {
        Thread t = new Thread( () -> {
            // com.google.common.util.concurrent.Uninterruptibles
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
            System.out.println("yo!");
        });
        t.setDaemon(true);
        t.start();
        // Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        System.out.println("main");
    }
}