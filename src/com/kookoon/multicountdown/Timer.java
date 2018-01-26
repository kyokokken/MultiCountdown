package com.kookoon.multicountdown;

import java.util.TimerTask;

public class Timer {
    private long startTimeMillis;
    private long time;
    boolean elapsed;

    public Timer(int hours, int minutes, int seconds) {
        set(hours, minutes, seconds);
    }

    public void start() {
        startTimeMillis = System.currentTimeMillis();
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                elapsed = true;
            }
        }, time);
    }

    public long getMillisElapsed() {
        return System.currentTimeMillis() - startTimeMillis;
    }

    public long getMillisLeft() {
        long millisLeft = time - getMillisElapsed();
        if (millisLeft < 0) millisLeft = 0;
        return millisLeft;
    }

    public void set(int hours, int minutes, int seconds) {
        time = seconds * 1000 + minutes * 60 * 1000 + hours * 60 * 60 * 1000;
    }
}
