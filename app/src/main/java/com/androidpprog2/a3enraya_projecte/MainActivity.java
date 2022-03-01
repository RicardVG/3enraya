package com.androidpprog2.a3enraya_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    TextView startingGame;
    TextView textPlayer1;
    TextView textPlayer2;
    TextView textWinPlayer;
    Integer[] buttons;
    int player = 1;
    int[] table = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
    };
    int state = 0;
    int tokensAdded = 0;
    int turn = 1;
    int[] posWin = new int[]{-1, -1, -1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startingGame = findViewById(R.id.startingGame);
        startingGame.setVisibility(View.VISIBLE);

        textWinPlayer = findViewById(R.id.textWinPlayer);
        textWinPlayer.setVisibility(View.INVISIBLE);


        buttons = new Integer[]{
                R.id.button1, R.id.button2, R.id.button3,
                R.id.b4, R.id.b5, R.id.b6,
                R.id.button7, R.id.button8, R.id.button9
        };
    }

    public void addToken(View v){

        if(state == 0){
            boolean shoot = false;
            int numButton = Arrays.asList(buttons).indexOf(v.getId());
            int flag = 0;
            turn = 1;
            textPlayer1 = findViewById(R.id.t1);
            textPlayer2 = findViewById(R.id.t2);
            textPlayer1.setVisibility(View.INVISIBLE);
            textPlayer2.setVisibility(View.VISIBLE);
            startingGame.setVisibility(View. INVISIBLE);

            if(table[numButton] == 0 && player == 1){
                v.setBackgroundResource(R.drawable.circulo_verde);
                table[numButton] = 1;
                shoot = true;
                flag = 2;
                tokensAdded += 1;
                state = checkState();
                finishGame();
            }

            if(state == 0){
                if(table[numButton] == 0 && player == 2){
                    turn = -1;
                    v.setBackgroundResource(R.drawable.ic_baseline_close_24);
                    textPlayer1.setVisibility(View.VISIBLE);
                    textPlayer2.setVisibility(View.INVISIBLE);
                    table[numButton] = -1;
                    shoot = true;
                    flag = 2;
                    tokensAdded += 1;
                    state = checkState();
                    finishGame();
                }
            }

            if (shoot){
                if(player==1){
                    player=2;
                }else{
                    player=1;
                }
            }

            if ((table[numButton] == 1 || table[numButton] == -1) && flag < 1){
                Toast.makeText(MainActivity.this,"No se puede seleccionar esta casilla ocupada!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void finishGame(){
        if(state == 1 || state == -1){
            if (state == 1){
                textWinPlayer.setVisibility(View.VISIBLE);
                textWinPlayer.setTextColor(Color.GREEN);
            }else{
                textWinPlayer.setVisibility(View.VISIBLE);
                textWinPlayer.setText("JUGADOR 2 HA GANADO");
                textWinPlayer.setTextColor(Color.RED);
                textPlayer1.setVisibility(View.INVISIBLE);
                textPlayer2.setVisibility(View.INVISIBLE);
            }

        }else if (state == 2){
            textWinPlayer.setVisibility(View.VISIBLE);
            textWinPlayer.setText("LOS JUGADORES HAN EMPATADO");
            textPlayer1.setVisibility(View.INVISIBLE);
            textPlayer2.setVisibility(View.INVISIBLE);
        }
    }

    public int checkState(){
        int newState = 0;

        if(Math.abs(table[0]+table[1]+table[2]) == 3){
            posWin = new int[]{0,1,2};
            newState = 1*turn;
        }else if(Math.abs(table[3]+table[4]+table[5]) == 3){
            posWin = new int[]{3,4,5};
            newState = 1*turn;
        }else if(Math.abs(table[6]+table[7]+table[8]) == 3){
            posWin = new int[]{6,7,8};
            newState = 1*turn;
        }else if(Math.abs(table[0]+table[3]+table[6]) == 3){
            posWin = new int[]{0,3,6};
            newState = 1*turn;
        }else if(Math.abs(table[1]+table[4]+table[7]) == 3){
            posWin = new int[]{1,4,7};
            newState = 1*turn;
        }else if(Math.abs(table[2]+table[5]+table[8]) == 3){
            posWin = new int[]{2,5,8};
            newState = 1*turn;
        }else if(Math.abs(table[0]+table[4]+table[8]) == 3){
            posWin = new int[]{0,4,8};
            newState = 1*turn;
        }else if(Math.abs(table[2]+table[4]+table[6]) == 3){
            posWin = new int[]{2,4,6};
            newState = 1*turn;
        }else if(tokensAdded == 9){
            newState = 2;
        }
        return newState;
    }

}