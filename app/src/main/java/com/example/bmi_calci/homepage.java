package com.example.bmi_calci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class homepage extends AppCompatActivity {
   EditText name;
   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        name=(EditText) findViewById(R.id.name);
        btn=(Button) findViewById(R.id.start);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = name.getText().toString().trim();
                if (text.isEmpty() || text.length() == 0 || text.equals("") || text == null) {
                    Toast.makeText(homepage.this, "Enter your name to start!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent bmi = new Intent(getApplicationContext(), MainActivity.class);
                    bmi.putExtra("myname", text);
                    startActivity(bmi);
                }
            }});
    }
}