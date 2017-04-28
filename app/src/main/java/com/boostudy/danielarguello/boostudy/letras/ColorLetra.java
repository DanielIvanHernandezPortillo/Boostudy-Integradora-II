package com.boostudy.danielarguello.boostudy.letras;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.boostudy.danielarguello.boostudy.MainActivity;
import com.boostudy.danielarguello.boostudy.R;

public class ColorLetra extends AppCompatActivity {


    LinearLayout targetOne;
    LinearLayout targetTwo;
    LinearLayout targetThree;



    ImageButton ibPlay;
    Button btSiguiente;

    MediaPlayer correct;
    MediaPlayer aamarilla;



    ImageButton ibOne;
    ImageButton ibTwo;
    ImageButton ibThree;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_letra_color);

        targetOne = (LinearLayout) findViewById(R.id.target_one);
        targetTwo = (LinearLayout) findViewById(R.id.target_two);
        targetThree = (LinearLayout) findViewById(R.id.target_three);


        ibOne = (ImageButton) findViewById(R.id.ib_one);
        ibTwo = (ImageButton) findViewById(R.id.ib_two);
        ibThree = (ImageButton) findViewById(R.id.ib_three);


        ibPlay = (ImageButton) findViewById(R.id.ib_play);
        btSiguiente = (Button) findViewById(R.id.bt_siguiente);

        btSiguiente.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(!ibTwo.isFocusable()){
                    Intent intent = new Intent(
                            getApplicationContext(), MainActivity.class);
                    intent.putExtra("cancion", false);
                    startActivity(intent);
                    finish();
                }
            }
        });

        ibTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }

    public void presionePlay(View v){
    correct = MediaPlayer.create(this, R.raw.correcto);
       ;
    }


}
