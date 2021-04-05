package com.example.task_9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;


public class SecondActivity extends AppCompatActivity {
    Thread thread2;
    TextView textViewShow;
    Button buttonShowText;

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
        textViewShow = findViewById(R.id.textViewShowText);
        buttonShowText = findViewById(R.id.buttonShowText);
        buttonShowText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textViewShowText)).setText(getIntent().getStringExtra("Vadim"));
                FileAdd  fileAdd = new FileAdd ();
                textViewShow.setText(fileAdd.getDataFromFIle());
                try {
                    FileInputStream fileInPut = openFileInput("‪D:\\Android\\file.txt");
                    InputStreamReader reader = new InputStreamReader(fileInPut);
                    BufferedReader buff = new BufferedReader(reader);
                    StringBuffer strBuff = new StringBuffer();
                    String lines;
                    while ((lines = buff.readLine()) != null) {
                        strBuff.append(lines);
                    }
                    textViewShow.setText(strBuff.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
