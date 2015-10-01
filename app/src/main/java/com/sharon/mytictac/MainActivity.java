package com.sharon.mytictac;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import static android.graphics.Color.*;

public class MainActivity extends Activity implements OnClickListener {

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3;
    Button bNewGame;
    Button[] bArray;
    boolean turn = true; // x=true , o=false
    int trun_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (Button) findViewById(R.id.A1);
        a2 = (Button) findViewById(R.id.A2);
        a3 = (Button) findViewById(R.id.A3);
        b1 = (Button) findViewById(R.id.B1);
        b2 = (Button) findViewById(R.id.B2);
        b3 = (Button) findViewById(R.id.B3);
        c1 = (Button) findViewById(R.id.C1);
        c2 = (Button) findViewById(R.id.C2);
        c3 = (Button) findViewById(R.id.C3);
        bNewGame = (Button) findViewById(R.id.bNewGame);

        bArray = new Button[] {a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for (Button b : bArray){
            b.setOnClickListener(this);
        }

        bNewGame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //this function will be called wen new game is clicked
                //whe need to reset and turn_cunt
                turn = true;
                trun_count = 0;
                enabledisableAllButton(true);



            }
        });




    }

    @Override
    public void onClick(View v) {
       Button b = (Button) v;
        buttonClicked(b);


    }

    public void buttonClicked(Button b){
        //we just want to change the tex on th butteon to X/O
        if(turn){
            // x's turn
            b.setText("X");

        }else {
            //o's turn
            b.setText("O");
        }

        trun_count ++;
        // and change the turn
       // b.setBackgroundColor(Color.LTGRAY);
        b.setClickable(false);

        turn = !turn;

        checkForWinner();

    }

    private void checkForWinner(){
        boolean there_is_a_winner = false;

        if(a1.getText() == a2.getText() && a2.getText() == a3.getText() && !a1.isClickable())
            there_is_a_winner = true;
        else if (b1.getText() == b2.getText() && b2.getText() == b3.getText()&& !b1.isClickable())
            there_is_a_winner = true;
        else if (c1.getText() == c2.getText() && c2.getText() == c3.getText()&& !c1.isClickable())
            there_is_a_winner = true;
        ////////////////////////////////

        else if(a1.getText() == b1.getText() && b1.getText() == c1.getText() && !a1.isClickable())
            there_is_a_winner = true;
        else if (a2.getText() == b2.getText() && b2.getText() == c2.getText()&& !b2.isClickable())
            there_is_a_winner = true;
        else if (a3.getText() == b3.getText() && b3.getText() == c3.getText()&& !c3.isClickable())
            there_is_a_winner = true;
        /////////////////////////

        if(a1.getText() == b2.getText() && b2.getText() == c3.getText() && !a1.isClickable())
            there_is_a_winner = true;
        else if (a3.getText() == b2.getText() && b2.getText() == c1.getText()&& !b2.isClickable())
            there_is_a_winner = true;

        if(there_is_a_winner) {
            if (!turn) {
                toast("X the wins");
            }else {
                toast("O the wins");
            }

            enabledisableAllButton(false);
        }else if(trun_count == 9){
            toast("DRAW");



        }

    }

    private void enabledisableAllButton(boolean enable) {
        //false to disable
        for(Button b: bArray){
            b.setClickable(enable);
            // this is for the color
           if(enable){
             //  b.setBackgroundColor(parseColor("#33b5e5"));
               b.setText("");

           }

           else {
               // b.setBackgroundColor(LTGRAY);

            }
        }
    }


    private void toast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }


}
