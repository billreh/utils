package net.tralfamadore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    private ExecutorService executorService;

    @Before
    public void setUp() {
        executorService = Executors.newFixedThreadPool(10);
    }

    @After
    public void tearDown() {
        executorService.shutdown();
    }

    @Test
    public void testDirectoryMonitor() throws Exception {
        DirectoryMonitor directoryMonitor = new DirectoryMonitor("/tmp/monitor");
        Consumer<File> fileProcessor = file -> {
            try {
                System.out.println("Processing " + file.getName());
                List<String> lines = Files.readAllLines(file.toPath());
                executorService.submit(() -> {
                    parseLines(lines);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        directoryMonitor.monitor(fileProcessor);
    }

    private void parseLines(List<String> lines) {
        lines.forEach(System.out::println);
    }
}
