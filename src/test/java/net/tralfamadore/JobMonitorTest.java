package net.tralfamadore;

/**
 * Class: JobMonitorTest
 * Created by billreh on 4/29/17.
 */
public class JobMonitorTest {
    public static void main(String[] args) {
        JobMonitor jobMonitor = new JobMonitor("/tmp/monitor");
        jobMonitor.monitor(lines -> lines.forEach(System.out::println));
    }
}
