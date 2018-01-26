package com.kookoon.multicountdown;

public class Utilities {
    public static Time fromMillisToTime(long millisLeft) {
        long millis = millisLeft;
        Time t = new Time();
        t.millis = (int) millis % 1000;
        millis = millis / 1000;
        t.seconds = (int) millis % 60;
        millis = millis / 60;
        t.minutes = (int) millis % 60;
        millis = millis / 60;
        t.hours = (int) millis % 60;
        return t;
    }
}

