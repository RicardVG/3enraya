package com.androidpprog2.a3enraya_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    TextView textVictory;
    TextView textPlayer1;
    TextView textPlayer2;
    Integer[] buttons;
    int player = 1;
    int[] table = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVictory = findViewById(R.id.textVictory);
        textVictory.setVisibility(View.VISIBLE);

        buttons = new Integer[]{
                R.id.button1, R.id.button2, R.id.button3,
                R.id.b4, R.id.b5, R.id.b6,
                R.id.button7, R.id.button8, R.id.button9
        };
    }

    public void addToken(View v){
        boolean shoot = false;
        int numButton = Arrays.asList(buttons).indexOf(v.getId());
        int flag = 0;

        textPlayer1 = findViewById(R.id.t1);
        textPlayer2 = findViewById(R.id.t2);
        textPlayer1.setVisibility(View.INVISIBLE);
        textPlayer2.setVisibility(View.VISIBLE);
        textVictory.setVisibility(View. INVISIBLE);

        if(table[numButton] == 0 && player == 1){
            v.setBackgroundResource(R.drawable.circulo_verde);
            table[numButton] = 1;
            shoot = true;
            flag = 2;
        }

        if(table[numButton] == 0 && player == 2){
            v.setBackgroundResource(R.drawable.cruz_verde);
            textPlayer1.setVisibility(View.VISIBLE);
            textPlayer2.setVisibility(View.INVISIBLE);
            table[numButton] = 2;
            shoot = true;
            flag = 2;
        }

        if (shoot){
            if(player==1){
                player=2;
            }else{
                player=1;
            }
        }

        if ((table[numButton] == 1 || table[numButton] == 2) && flag < 1){
            Toast.makeText(MainActivity.this,"No se puede seleccionar esta casilla ocupada!",Toast.LENGTH_SHORT).show();
        }

    }

}