package com.androidpprog2.a3enraya_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textVictory;
    TextView textPlayer1;
    TextView textPlayer2;
    Integer[] buttons;
    int[] table = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVictory = (TextView) findViewById(R.id.textVictory);
        textVictory.setVisibility(View.VISIBLE);

        buttons = new Integer[]{
                R.id.button1, R.id.button2, R.id.button3,
                R.id.b4, R.id.b5, R.id.b6,
                R.id.button7, R.id.button8, R.id.button9
        };
    }

    public void addToken(View v){
        int size = 10;

        int numButton = Arrays.asList(buttons).indexOf(v.getId());
        textPlayer1 = (TextView) findViewById(R.id.t1);
        textPlayer1.setVisibility(View.VISIBLE);

        textPlayer2 = (TextView) findViewById(R.id.t2);
        textPlayer2.setVisibility(View.INVISIBLE);
        textVictory.setVisibility(View. INVISIBLE);
        table[numButton] = 1;

        for (int i = 0; i < size; i++){
            v.setBackgroundResource(R.drawable.circulo_negro);
            textPlayer1.setVisibility(View.INVISIBLE);
            textPlayer2.setVisibility(View.VISIBLE);
            Player2(numButton);

        }
    }

    public void Player2(int numButton) {
        Button b = (Button) findViewById(buttons[numButton]);
        b.setBackgroundResource(R.drawable.cruz_negra);
        table[numButton] = -1;
        textPlayer1.setVisibility(View.VISIBLE);
        textPlayer2.setVisibility(View.INVISIBLE);
    }
}