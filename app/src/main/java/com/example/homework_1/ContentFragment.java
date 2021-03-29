package com.example.fragmentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.homework_1.R;

public class ContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_content, container, false);
        TextView textViewF = v.findViewById(R.id.btnActThree);
        for (int a = 15; a < 20; a++) {
            textViewF.setText("a is = " + a);
        }
        return v;
    }
}