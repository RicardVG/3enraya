package com.androidpprog2.a3enraya_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textVictory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVictory = (TextView) findViewById(R.id.textVictory);
        textVictory.setVisibility(View.INVISIBLE);
    }
}