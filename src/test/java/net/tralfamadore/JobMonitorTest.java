package net.tralfamadore;

import org.junit.Test;

/**
 * Class: JobMonitorTest
 * Created by billreh on 4/29/17.
 */
public class JobMonitorTest {
    @Test
    public void testJobMonitor() {
        JobMonitor jobMonitor = new JobMonitor("/tmp/monitor");
        jobMonitor.monitor(lines -> lines.forEach(System.out::println));
    }
}
