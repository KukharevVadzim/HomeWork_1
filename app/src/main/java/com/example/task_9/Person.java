package com.example.task_9;

import androidx.annotation.NonNull;

class Person implements Cloneable {
    double weight;
    double height;
    double age;

    public Person(double weight, double height, double age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }
    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
