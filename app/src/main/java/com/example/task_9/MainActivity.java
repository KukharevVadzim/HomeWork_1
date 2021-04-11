package com.example.task_9;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    Thread thread1;
    static String MAIN_ACTIVITY_DATA = "MAIN_ACTIVITY_DATA";
    private EditText editText;
    public Button buttonCreateFile;
    public Button buttonResult;
    public TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        initThreadClick();
        Button click = findViewById(R.id.btnActTwo);
        buttonCreateFile = findViewById(R.id.buttonCreateText);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra(MAIN_ACTIVITY_DATA, editText.getText().toString());
                FileManager fileManager = new FileManager();
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
                startActivity(intent4);
                Intent intent5 = new Intent(v.getContext(), ThirdActivity.class);
                startActivity(intent5);
            }
        });

        buttonResult = findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult = findViewById(R.id.textViewResult);
                Callable callable = getDataFromCallable();
                FutureTask futureTask = new FutureTask(callable);
                new Thread(futureTask).start();
                try {
                    textViewResult.setText(futureTask.get().toString());
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public Callable<Integer> getDataFromCallable() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int summa = 0;
                for (int i = 2; i <= Integer.parseInt(editText.getText().toString()); i++) {
                    summa += i;
                }
                return summa;
            }
        };
        return callable;
    }

    public void ArrayWithLinkedList() {
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        int a = 1000000;
        int b = 1000;
        long time = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            arrayList.add(Math.random());
            linkedList.add(Math.random());
        }
        for (int i = 0; i < b; i++) {
            arrayList.get((int) (Math.random() * a - 1));
        }
        System.out.println(System.currentTimeMillis() - time);
        for (int i = 0; i < b; i++) {
            linkedList.get((int) (Math.random() * a - 1));
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    public void initThreadClick() {
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

    public void initToastClicK() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Messeg" + thread1.getState(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Strings() {
        String str = "Android Developer";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println("Строка в обратном порядке, после реверса: " + reverse);
    }
}
//    public void Methods() {
//        Person Vadim = new Person(65, 176, 26);
//        Person Kolia = new Person(76, 177, 24);
//        Person Lesha = new Person(89, 198, 27);
//        Person Dima = new Person(65, 176, 26);
//        System.out.println("Equals1 " + Vadim.equals(Dima));
//        System.out.println("Equals2 " + Kolia.equals(Lesha));
//        System.out.println("ToString1: " + Vadim.toString());
//        System.out.println("ToString1: " + Lesha.toString());
//        int hashCode;
//        hashCode = Kolia.hashCode();
//        System.out.println("Hashcode1 Vadim: " + hashCode);
//        System.out.println("Hashcode2 Kolia: " + hashCode);
//    }
//
//    public void methodClone() throws CloneNotSupportedException {
//        Person Alina = new Person(70, 175, 24);
//        Person copyBox = (Person) Alina.clone();
//        System.out.println("Copy Person" + copyBox);
//    }
//}
