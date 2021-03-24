package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity<b> extends AppCompatActivity {

    int a = 10;
    byte b = 125;
    short c = 3000;
    long d = 300000000;
    float f = 30.467f;
    double g = 3.14567;
    char h = 'f';
    boolean u = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

