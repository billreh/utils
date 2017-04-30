package net.tralfamadore;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * Class: SignalTest
 * Created by billreh on 4/30/17.
 */
public class SignalTest {
    public static void main(String[] args) {
        SignalHandler signalHandler = signal -> {
            System.out.println("Reloading...");
            ApplicationProperties.getInstance().reload();
        };
        Signal.handle(new Signal("HUP"), signalHandler);

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
