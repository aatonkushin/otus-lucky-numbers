package org.tonkushin.ln;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StopwatchImpl implements Stopwatch {
    private LocalDateTime start;
    long elapsedTime=0;

    public void start(){
        start = LocalDateTime.now();
    }

    public void stop(){
        elapsedTime = ChronoUnit.MILLIS.between(start, LocalDateTime.now());
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
