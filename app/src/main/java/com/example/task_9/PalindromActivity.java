package com.example.task_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

class PalindromeActivity extends AppCompatActivity {
    public TextView textViewAnswerPalindrome;
    public EditText editTextUserInput;
    public Button buttonChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);
        textViewAnswerPalindrome = findViewById(R.id.textViewAnswerPalindrome);
        editTextUserInput = findViewById(R.id.editTextUserInput);
        buttonChecked = findViewById(R.id.buttonCheckPalindrome);
        buttonChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char[] charInput = editTextUserInput.getText().toString().toCharArray();
                int intLenght = charInput.length;
                boolean isPalindrome = true;
                for (int i = 0; i < intLenght / 2; i++) {
                    if (charInput[i] != charInput[intLenght - 1 - i]) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    textViewAnswerPalindrome.setText("It's a palindrome");
                } else {
                    textViewAnswerPalindrome.setText("It's not a palindrome");
                }
            }
        });
    }
}