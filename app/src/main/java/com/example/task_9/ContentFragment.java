package com.example.task_9;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import java.util.concurrent.TimeUnit;

public class ContentFragment extends RunnebleTask {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_content, container, false);
        TextView textViewF = v.findViewById(R.id.btnActThree);
        for (int a = 15; a < 20; a++) {
            textViewF.setText("a is = " + a);
        }
        return v;
    }
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













