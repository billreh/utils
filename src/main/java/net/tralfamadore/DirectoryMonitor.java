package net.tralfamadore;

import java.io.File;
import java.util.function.Consumer;

/**
 * Class: DirectoryMonitor
 * Created by billreh on 4/29/17.
 */
public class DirectoryMonitor {
    private File directory;

    public DirectoryMonitor(String directoryName) {
        this.directory = new File(directoryName);
    }

    public void monitor(Consumer<File> callback) throws InterruptedException {
        while(true) {
            File[] files = directory.listFiles();
            if(files != null && files.length > 0) {
                for (File file : files) {
                    callback.accept(file);
                    file.delete();
                }
            }
            Thread.sleep(100);
        }
    }
}
