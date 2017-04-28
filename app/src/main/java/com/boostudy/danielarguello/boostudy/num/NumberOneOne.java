package com.boostudy.danielarguello.boostudy.num;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.boostudy.danielarguello.boostudy.R;

/**
 * Created by DANIEL on 21/03/2017.
 */

public class NumberOneOne extends Activity {

    MediaPlayer zero;
    MediaPlayer one;
    MediaPlayer two;
    MediaPlayer three;
    MediaPlayer four;
    MediaPlayer five;
    MediaPlayer six;
    MediaPlayer seven;
    MediaPlayer eight;
    MediaPlayer nine;

    private Button bt_zero;
    private Button bt_one;
    private Button bt_two;
    private Button bt_three;
    private Button bt_four;
    private Button bt_five;
    private Button bt_six;
    private Button bt_seven;
    private Button bt_eight;
    private Button bt_nine;
    private Button bt_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_number_one_and_nine);

        bt_zero = (Button) findViewById(R.id.bt_zero);
        bt_one = (Button)findViewById(R.id.bt_one);
        bt_two = (Button)findViewById(R.id.bt_two);
        bt_three = (Button)findViewById(R.id.bt_three);
        bt_four = (Button)findViewById(R.id.bt_four);
        bt_five = (Button)findViewById(R.id.bt_five);
        bt_six = (Button)findViewById(R.id.bt_six);
        bt_seven = (Button)findViewById(R.id.bt_seven);
        bt_eight = (Button)findViewById(R.id.bt_eight);
        bt_nine = (Button)findViewById(R.id.bt_nine);
        bt_main = (Button) findViewById(R.id.bt_main) ;


        zero = MediaPlayer.create(NumberOneOne.this, R.raw.cero);
        one = MediaPlayer.create(NumberOneOne.this, R.raw.uno);
        two = MediaPlayer.create(NumberOneOne.this, R.raw.dos);
        three = MediaPlayer.create(NumberOneOne.this, R.raw.tres);
        four = MediaPlayer.create(NumberOneOne.this, R.raw.cuatro);
        five = MediaPlayer.create(NumberOneOne.this, R.raw.cinco);
        six = MediaPlayer.create(NumberOneOne.this, R.raw.seis);
        seven = MediaPlayer.create(NumberOneOne.this, R.raw.siete);
        eight = MediaPlayer.create(NumberOneOne.this, R.raw.ocho);
        nine = MediaPlayer.create(NumberOneOne.this, R.raw.nueve);

        bt_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zero.start();
            }
        });

        bt_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one.start();
            }
        });

        bt_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                two.start();
            }
        });

        bt_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three.start();
            }
        });

        bt_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four.start();
            }
        });

        bt_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                five.start();
            }
        });

        bt_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                six.start();
            }
        });

        bt_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seven.start();
            }
        });

        bt_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eight.start();
            }
        });

        bt_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nine.start();
            }
        });


        bt_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),MainNum.class);
                startActivity(intent);
                finish();

            }
        });
    }





}
