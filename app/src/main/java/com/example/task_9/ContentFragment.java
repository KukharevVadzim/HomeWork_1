package com.example.task_9;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.concurrent.TimeUnit;

class RunnebleTaskSecondActivity implements Runnable {
    @Override
    public void run(){
        long delay = 3;
        for (int i =20; i >= 1; i--){
            Log.d("RunnebleLoop", String.valueOf(i));
            try{
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e){}
        }
    }
}
