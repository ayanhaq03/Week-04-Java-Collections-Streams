package junit;

import org.junit.jupiter.api.*;
class PerformanceTestingUsingTimeoutTest {

    @Test
    @Timeout(2)
    void longRunningTask() throws InterruptedException {
        Thread.sleep(300);
    }

    @Test
    @Timeout(2)
    void longRunningTask2() throws InterruptedException {
        Thread.sleep(3000);
    }
}