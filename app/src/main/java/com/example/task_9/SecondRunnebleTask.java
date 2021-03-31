package com.example.task_9;

import android.util.Log;

import java.util.concurrent.TimeUnit;

public class SecondRunnebleTask implements Runnable {
    @Override
    public void run() {
        long delay = 3;
        for (int i = 20; i >= 1; i--) {
            Log.d("RunnebleLoop", String.valueOf(i));
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {

            }
        }
    }
}
