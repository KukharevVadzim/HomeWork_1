package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int x = 25;
        if (x > 20) {
            System.out.print("Равенстов верно");
        }
        int y = 48;
        if (y > 69) {
            System.out.print("Равенство не выполнено");
        } else {
            System.out.print("Равенство вополнено");
        }
        int p = 47;
        switch (p) {
            case 46:
                System.out.print("Неверно");
                break;
            case 45:
                System.out.print("Не выйдет");
                break;
            case 47:
                System.out.print("Верно");
                break;
        }
        System.out.print("Ваш ответ" + p);
        int a = 4;
        int b = 6;
        int c = 10;
        System.out.println("a + b =" + (a + b));
        System.out.println("b - a =" + (b - a));
        System.out.println("a * b =" + (a * b));
        System.out.println("b / a =" + (b / a));
        System.out.println("(a + b) / c =" + ((a + b) / c));
        System.out.println("c % b =" + (c % b));
        System.out.println("c == (a + b)" + (c == (a + b)));
        System.out.println("c !=a" + (c != a));
        System.out.println("c > a" + (c > a));
        System.out.println("c < a" + (c < a));
        System.out.println("c >= a" + (c >= a));
        System.out.println("c <= a" + (c <= a));
        boolean r = true;
        boolean e = false;
        boolean t = r | e;
        boolean u = r & e;
        boolean o = r ^ e;
        boolean q = !r;
        System.out.println(" r | e =" + t);
        System.out.println(" r & e =" + u);
        System.out.println(" r ^ e =" + o);
        System.out.println(" !r =" + q);
        int month = 3; //март
        String season; //Время года
        switch (month) {
            case (1):
            case (2):
            case (12):
                System.out.print("Зимушка-зима");
                break;
            case (3):
            case (4):
            case (5):
                System.out.print("Весна");
                break;
            case (6):
            case (7):
            case (8):
                System.out.print("Лето");
                break;
            case (9):
            case (10):
            case (11):
                System.out.print("Осень");
                break;
            default:
                System.out.print("Не знаю");
        }
        int n = 5;
        while (n > 0) {
            System.out.println("Number: " + n--);
        }
        int l = 10;
        do {
            System.out.println("Number: " + l--);
        } while (l > 0);
        for (int i = 0; i < 10; i++) {
            System.out.println("Number: " + i);
        }
        for (int i = 1, j = 4; i < j; i++, j--) {
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }
        for (int i = 1, j = 4; i < j; i++, j--) {
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }
        class Test {
            public void main(String[] args) {
                int[] array = {51,136,387};
                for (int i:array) {
                    System.out.println(i);
                }
            }
        }
    }
}
class MyMethod {
    static void drinkBeer(String beer){
        System.out.print("Я люблю пить" + beer);
    }

}