package com.example.task_9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.task_9.ContentFragment;

public class SecondActivity extends AppCompatActivity {
private Button buttonFor;
private Button buttonWhile;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    buttonFor = findViewById(R.id.btnActThree);
    buttonWhile = findViewById(R.id.btnActFour);

    buttonFor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            com.example.task_9.ContentFragment contentFragment = new com.example.task_9.ContentFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            ButtonFragment buttonFragment = new ButtonFragment();
            fragment.replace(R.id.frameLayout1, buttonFragment);
            fragment.commit();
        }
    });

    buttonWhile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            com.example.task_9.ButtonFragment buttonFragment = new com.example.task_9.ButtonFragment();
            FragmentTransaction fragment2 = getSupportFragmentManager().beginTransaction();
            ContentFragment contentFragment = new ContentFragment();
            fragment2.replace(R.id.frameLayout2, contentFragment);
            fragment2.commit();
        }
    });





}
}