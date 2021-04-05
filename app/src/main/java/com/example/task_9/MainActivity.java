package com.example.task_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task_9.R;
import com.example.task_9.SecondActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    Thread thread1;
    static String MAIN_ACTIVITY_DATA = "MAIN_ACTIVITY_DATA";
    public Button buttonCreateFile;
    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initThreadClick();
        initToastClicK();
        Button click = findViewById(R.id.btnActTwo);
        buttonCreateFile = findViewById(R.id.buttonCreateText);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra(MAIN_ACTIVITY_DATA, editText.getText().toString());
                FileAdd fileManager = new FileAdd();
                fileManager.setDataToFile(editText.getText());
                startActivity(intent);
            }
        };
        buttonCreateFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outPut = openFileOutput("‪D:\\Android\\file.txt", MODE_PRIVATE);
                    outPut.write(editText.getText().toString().getBytes());
                    outPut.close();
                    editText.setText("");
                    Toast.makeText(MainActivity.this, "Текст сохранен", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent4 = new Intent(v.getContext(), SecondActivity.class);
                intent4.putExtra("Vadim", editText.getText().toString());
                startActivity(intent4);
            }
        });
        click.setOnClickListener(listener);
    }
    private void initThreadClick () {
        Button click = findViewById(R.id.clickTest);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread1 = new Thread(new RunnebleTask());
                Log.d("RunnebleLoop", String.valueOf(thread1.getState()));
                thread1.start();
                Log.d("RunnebleLoop", String.valueOf(thread1.getState()));
            }
        };
    }

    private void initToastClicK() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Messeg" + thread1.getState(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Methods() {
        Person Vadim = new Person(65, 176, 26);
        Person Kolia = new Person(76, 177, 24);
        Person Lesha = new Person(89, 198, 27);
        Person Dima = new Person(65, 176, 26);
        System.out.println("Equals1 " + Vadim.equals(Dima));
        System.out.println("Equals2 " + Kolia.equals(Lesha));
        System.out.println("ToString1: " + Vadim.toString());
        System.out.println("ToString1: " + Lesha.toString());
        int hashCode;
        hashCode = Kolia.hashCode();
        System.out.println("Hashcode1 Vadim: " + hashCode);
        System.out.println("Hashcode2 Kolia: " + hashCode);
    }

    public void methodClone() throws CloneNotSupportedException {
        Person Alina = new Person(70, 175, 24);
        Person copyBox = (Person) Alina.clone();
        System.out.println("Copy Person" + copyBox);
    }

    public void Strings() {
        String str = "Android Developer";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println("Строка в обратном порядке, после реверса: " + reverse);
    }
}

