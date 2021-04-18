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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Thread thread1;
    static String MAIN_ACTIVITY_DATA = "MAIN_ACTIVITY_DATA";
    private EditText editText;
    public Button buttonCreateFile;
    public Button buttonResult;
    public TextView textViewResult;
    public Button buttonGoToPalindrome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        initThreadClick();
        Button click = findViewById(R.id.btnActTwo);
        buttonCreateFile = findViewById(R.id.buttonCreateText);
        buttonGoToPalindrome = findViewById(R.id.buttonGoToPalindrome);
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

        buttonGoToPalindrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPalindrome = new Intent(v.getContext(), PalindromeActivity.class);
                startActivity(intentPalindrome);
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

    public void WorkWithArray() {
        int[] arrayStart = new int[]{1, 4, 16, 4, 23, 4, 28, 8, 4};
        int[] arrayAfter = remove(arrayStart, 4);
        System.out.println("ArrayStart: " + Arrays.toString(arrayStart));
        System.out.println("ArrayAfter: " + Arrays.toString(arrayAfter));
    }

    private int[] remove(int[] start, int remove) {
        int a = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] != remove) {
                a = a + 1;
            }
        }
        int[] after = new int[a];
        for (int i = 0, j = 0; i < start.length; i++) {
            if (start[i] != remove) {
                after[j++] = start[i];
            }
        }
        return after;
    }

    public <A> Collection<A> removeDuplicates(Collection<A> collection) {
        return new HashSet<>(collection);
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

    public void workWtithMap(HashMap<Integer, String> mapa) {
        mapa.put(1, "First string");
        mapa.put(2, "Second string");
        mapa.put(3, "Third string");
        for (Map.Entry<Integer, String> describe : mapa.entrySet()) {
            System.out.println("Key: " + describe.getKey() + "Value: " + describe.getValue());
        }
        Iterator iterator = mapa.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry exampleWhile = (Map.Entry) iterator.next();
            System.out.println("Ключ: " + exampleWhile.getKey() + "Значение: " + exampleWhile.getValue());
        }
    }
}