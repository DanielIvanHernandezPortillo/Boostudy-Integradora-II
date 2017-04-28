package com.boostudy.danielarguello.boostudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.boostudy.danielarguello.boostudy.animal.AnimalSong;

/**
 * Created by DANIEL  on 15/02/2017.
 */

public class Dificult extends Activity {

    private Button btOptionOne;
    private Button btOptionTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.dificult);

        btOptionOne = (Button) findViewById(R.id.bt_1);
        btOptionTwo = (Button) findViewById(R.id.bt_2);
        btOptionTwo = (Button) findViewById(R.id.bt_3);

        btOptionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                      getApplicationContext(),AnimalSong.class);
               startActivity(intent);
                finish();

            }
        });

        btOptionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //  Intent intent = new Intent(
                //  getApplicationContext(),SecondActivity.class);
                //    startActivity(intent);

            }
        });
    }






}
