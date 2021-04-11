package com.example.task_9;

import android.text.Editable;
import android.text.GetChars;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {

    String text = "Вадим-фраер блатной";

    public void setDataToFile(Editable text1) {
        try (FileOutputStream outPut = new FileOutputStream("‪D:\\Android Studio\\file.txt")) {
            byte[] buffer = text.getBytes();
            outPut.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
        }
    }

    public String getDataFromFIle() {
        try {
            FileInputStream fileInPut = new FileInputStream("‪D:\\Android\\file.txt");
            InputStreamReader reader = new InputStreamReader(fileInPut);
            BufferedReader buff = new BufferedReader(reader);
            StringBuffer strBuff = new StringBuffer();
            String lines;
            while ((lines = buff.readLine()) != null) {
                strBuff.append(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}