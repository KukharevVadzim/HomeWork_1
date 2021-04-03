package com.example.task_9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;


public class SecondActivity extends AppCompatActivity {
    Thread thread2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initThreadClickSecondActivity();
        initToastClicKSecondActivity();
        TextView textView = findViewById(R.id.text);
        Intent intent = getIntent();
        String string1 = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_DATA);
        textView.setText(string1);
        }

    private void initThreadClickSecondActivity(){
        Button click = findViewById(R.id.clickTestSecondActivity);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                thread2 = new Thread(new SecondRunnebleTask());
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
    static void main(String[] args) throws Exception{
       InputStream input = new FileInputStream("File.txt");
       int size = input.available();

          for(int j = 0; j < size; j++){
              System.out.println((char)input.read()+ " ");
       }
    input.close();
    }
}