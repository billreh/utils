package net.tralfamadore;

import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Class: JobMonitor
 * Created by billreh on 4/29/17.
 */
@SuppressWarnings("WeakerAccess")
public class JobMonitor {
    private static ExecutorService executorService;
    private DirectoryMonitor directoryMonitor;

    /**
     * Create a new JobMonitor that will watch the given directory.
     * @param directoryName The directory to watch.
     */
    public JobMonitor(String directoryName) {
        directoryMonitor = new DirectoryMonitor(directoryName);
        executorService = Executors.newFixedThreadPool(10);
    }

    /**
     * Monitors the configured directory for appearance of new files.  When a new file appears, reads all lines
     * and feeds them to <code>callback</code>.
     * @param callback The callback to process the contents of the file, given as a list of lines.
     */
    public void monitor(Consumer<List<String>> callback) {
        try {
            directoryMonitor.monitor(file -> {
                try {
                    List<String> lines = Files.readAllLines(file.toPath());
                    executorService.submit(() -> callback.accept(lines));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
