package com.example.project;

public class personData {
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public personData(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    double height;
    double weight;

}
