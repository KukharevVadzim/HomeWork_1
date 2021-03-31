package com.example.task_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.task_9.R;
import com.example.task_9.SecondActivity;

public class MainActivity extends AppCompatActivity {
    Thread thread1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initThreadClick();
        initToastClicK();
        Button click = findViewById(R.id.btnActTwo);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                startActivity(intent);
            }
        };
        click.setOnClickListener(listener);
    }
    private void initThreadClick(){
        Button click = findViewById(R.id.clickTest);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thread1 = new Thread(new RunnebleTask());
                Log.d("RunnebleLoop", String.valueOf(thread1.getState()));
                thread1.start();
                Log.d("RunnebleLoop", String.valueOf(thread1.getState()));
            }
        };
        click.setOnClickListener(listener);

        }

    private void initToastClicK(){
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Messeg" + thread1.getState(), Toast.LENGTH_LONG).show();
            }
        });
    }

}

