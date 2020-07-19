package com.example.hospitalinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CtgActivity extends MainActivity {
    TextView textView5;
    TextView textView6;
    Button button9;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctg_activity);
        textView5 = (TextView)findViewById(R.id.textView5);
        textView6 = (TextView)findViewById(R.id.textView6);
        button9 = (Button)findViewById(R.id.button9);
        button12 = (Button)findViewById(R.id.button12);
        button13 = (Button)findViewById(R.id.button13);
        button14 = (Button)findViewById(R.id.button14);
        button15 = (Button)findViewById(R.id.button15);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),jsonjava.class);
                startActivityForResult(intent, 0);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),jsonjava2.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
