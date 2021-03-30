package com.example.task_9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ButtonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.button_fragment, container, false);
        TextView textViewW = v.findViewById(R.id.btnActFour);
        int count = 1;
        while (count <= 15) {
            textViewW.setText("Count is: " + count++);
        }
        return v;
    }
}

