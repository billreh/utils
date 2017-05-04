package net.tralfamadore;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Class: DirectoryMonitorTest
 * Created by billreh on 4/29/17.
 */
public class DirectoryMonitorTest {
    private static ExecutorService executorService;

    public static void setUp() {
        executorService = Executors.newFixedThreadPool(10);
    }

    public static void tearDown() {
        executorService.shutdown();
    }

    public static void main() {
        setUp();
        DirectoryMonitor directoryMonitor = new DirectoryMonitor("/tmp/monitor");
        Consumer<File> fileProcessor = file -> {
            try {
                System.out.println("Processing " + file.getName());
                List<String> lines = Files.readAllLines(file.toPath());
                executorService.submit(() -> parseLines(lines));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        try {
            directoryMonitor.monitor(fileProcessor);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tearDown();
    }

    private static void parseLines(List<String> lines) {
        lines.forEach(System.out::println);
    }
}
