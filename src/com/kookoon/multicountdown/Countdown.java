package com.kookoon.multicountdown;

public class Countdown {
    //TODO: Support multiple timers.
    private final Timer timer;
    private final Alarm alarm;

    public Countdown(Timer timer) {
        this.timer = timer;
        alarm = new Alarm();
    }

    public void start() {
        timer.elapsed = false;
        timer.start();
    }

    public boolean isElapsed() {
        return timer.elapsed;
    }

    public void set(int hours, int minutes, int seconds) {
        timer.set(hours, minutes, seconds);
    }

    public long getMillisLeft() {
        return timer.getMillisLeft();
    }

    public void playSound() {
        alarm.playSound();
    }
}
