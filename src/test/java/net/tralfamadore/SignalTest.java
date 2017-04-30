package net.tralfamadore;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * Class: SignalTest
 * Created by billreh on 4/30/17.
 */
public class SignalTest {
    public static void main(String[] args) {
        SignalHandler hupHandler = signal -> {
            System.out.println("Reloading...");
            ApplicationProperties.getInstance().reload();
        };
        SignalHandler termHandler = signal -> {
            System.out.println("Exiting gracefully");
            System.exit(0);
        };
        Signal.handle(new Signal("HUP"), hupHandler);
        Signal.handle(new Signal("TERM"), termHandler);
        Signal.handle(new Signal("INT"), SignalHandler.SIG_IGN);
        Signal.handle(new Signal("QUIT"), SignalHandler.SIG_IGN);
        Signal.handle(new Signal("ABRT"), SignalHandler.SIG_IGN);

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
