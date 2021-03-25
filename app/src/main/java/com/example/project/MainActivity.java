package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private  EditText weight;
    private TextView show_bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.edtxHeight);
        weight = findViewById(R.id.edtxWeight);
        show_bmi = findViewById(R.id.txBMI);

    }

    public void calBMI(View view) {
        double bmi = Double.parseDouble(bmiValue());

        String txt = "";
            if(bmi < 18.5){
//                show_bmi.setText("BMI : " + String.valueOf(bmi) + "\n \t 您太輕了!");
                txt = "\n \t 您太輕了!";
            }
            else if (bmi < 25){
//                show_bmi.setText("BMI : " + String.valueOf(bmi) + "\n \t 標準體重,繼續保持!");
                txt = "\n \t 標準體重,繼續保持!";
            }
            else{
//                show_bmi.setText("BMI : " + String.valueOf(bmi) + "\n \t 您過重了喔");
                txt = "\n \t 您過重了喔";
            }

            show_bmi.setText("BMI : " + String.valueOf(bmi) + txt);

    }

    private String bmiValue() {
        if(height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()){
            show_bmi.setText("請輸入正確的身高或體重");
            return "0.0";
        }
        else {
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            double bmi = w / ((h / 100.0) * (h / 100.0));

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return decimalFormat.format(bmi);
        }
    }

    public void showToast(View view) {
        String bmi = bmiValue();
        Toast.makeText(this, bmi, Toast.LENGTH_SHORT).show();
    }
}