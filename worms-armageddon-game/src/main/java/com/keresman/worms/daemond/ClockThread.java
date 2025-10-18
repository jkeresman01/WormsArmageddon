package com.keresman.worms.daemond;

import com.keresman.worms.time.TimeUpdatable;
import javafx.application.Platform;

public class ClockThread extends Thread {

    private static final int SLEEP_TIME_MS = 1000;

    private volatile boolean isRunning = true;
    private final TimeUpdatable timeUpdatable;

    public ClockThread(TimeUpdatable timeUpdatable) {
        this.timeUpdatable = timeUpdatable;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (isRunning && !isInterrupted()) {
            Platform.runLater(timeUpdatable::updateTime);
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(SLEEP_TIME_MS);
        } catch (InterruptedException e) {
            isRunning = false;
            interrupt();
        }
    }

    public void stopClockThread() {
        isRunning = false;
        interrupt();
    }
}
