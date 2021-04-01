package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        String bmi = bundle.getString("BMI");
        int height = bundle.getInt("Height");
        TextView showbmi = findViewById(R.id.tvShowBmi);

        showbmi.setText("BMI:" + bmi + "\n Height:" + String.valueOf(height));
    }
}