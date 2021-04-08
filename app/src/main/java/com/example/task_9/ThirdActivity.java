package com.example.task_9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView textViewShow;
    Button buttonShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        textViewShow = findViewById(R.id.textViewShowText);
        buttonShowText = findViewById(R.id.buttonShowText);
        buttonShowText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FileManager  fileManager = new FileManager ();
                textViewShow.setText(fileManager.getDataFromFIle().toString());
            }
        });
    }
}