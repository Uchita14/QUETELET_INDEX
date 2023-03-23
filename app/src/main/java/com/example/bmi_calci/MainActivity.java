package com.example.bmi_calci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText wei , hei;
    Button calc;
    RadioGroup rd;
    RadioButton rb1,rb2;
    TextView result,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wei=(EditText) findViewById(R.id.weight);
        hei=(EditText) findViewById(R.id.height);
        calc=(Button) findViewById(R.id.btn);
        rd=(RadioGroup) findViewById(R.id.radiogrp);
        rb1=(RadioButton) findViewById(R.id.rb1);
        rb2=(RadioButton) findViewById(R.id.rb2);
        result=(TextView) findViewById(R.id.result);
        msg=(TextView) findViewById(R.id.msg) ;

        msg = (TextView) findViewById(R.id.msg);
        Intent receive = getIntent();
        String str = receive.getStringExtra( "myname");
        msg.setText("Hello " + str + "!" + " Let's get started! ");


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             double wt=   Double.parseDouble(wei.getText().toString());
                double ht = Double.parseDouble(hei.getText().toString());
                double bmi= (wt/(ht*ht));
                if (bmi<18.5){
                    result.setText("Result: " + "You come under Underweight category!");
                }
                else if(bmi>=18.5 && bmi<=24.9){
                    result.setText("Result: " + "You come under Healthy Weight category!");
                }
                else if(bmi>=25.0 && bmi<=29.9){
                    result.setText("Result: " + "You come under Overweight category!");
                }
                else{
                    result.setText("Result: " + "You come under Obese category");
                }
            }
        });
    }
}