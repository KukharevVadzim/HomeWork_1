package com.example.task_9;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    TextView textViewShow;
    Button buttonShowText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        textViewShow = findViewById(R.id.textViewShowText);
        buttonShowText = findViewById(R.id.buttonShowText);
        FileAdd  fileAdd = new FileAdd ();
        buttonShowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textViewShowText)).setText(getIntent().getStringExtra("Вадим красавчик, сделал все правильно"));
                textViewShow.setText(fileAdd.getDataFromFIle());
                try {
                    FileInputStream fileInPut = openFileInput("‪D:\\Android Studio\\file.txt");
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
}