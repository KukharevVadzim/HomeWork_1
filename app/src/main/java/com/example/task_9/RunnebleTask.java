package com.example.task_9;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.concurrent.TimeUnit;

class RunnebleTaskFirstActivity implements Runnable {
    @Override
    public void run(){
        long delay = 1;
            for (int i =0; i <= 10; i++){
                Log.d("RunnebleLoop", String.valueOf(i));
                try{
                    TimeUnit.SECONDS.sleep(delay);
                } catch (InterruptedException e){}
            }
    }
}

