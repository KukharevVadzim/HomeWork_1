package com.example.task_9;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Callable;


public class SecondActivity extends AppCompatActivity {
    Thread thread2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initThreadClickSecondActivity();
        initToastClicKSecondActivity();
        }

    private void initThreadClickSecondActivity(){
        Button click = findViewById(R.id.clickTestSecondActivity);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thread2 = new Thread(new RunnebleTaskSecondActivity());
                Log.d("RunnebleLoop", String.valueOf(thread2.getState()));
                thread2.start();
                Log.d("RunnebleLoop", String.valueOf(thread2.getState()));
            }
        };
        click.setOnClickListener(listener);

    }

    private void initToastClicKSecondActivity(){
        Button button = findViewById(R.id.btnSecondActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Messeg" + thread2.getState(), Toast.LENGTH_LONG).show();
            }
        });
    }
}