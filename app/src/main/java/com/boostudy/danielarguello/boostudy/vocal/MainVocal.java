package com.boostudy.danielarguello.boostudy.vocal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.boostudy.danielarguello.boostudy.R;
import com.boostudy.danielarguello.boostudy.num.TenAndTen;

/**
 * Created by DANIEL ARGUELLO on 16/04/2017.
 */

public class MainVocal extends Activity {

    private Button btOptionOne;
    private Button btOptionTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main_vocal);

        btOptionOne = (Button) findViewById(R.id.bt_1);
        btOptionTwo = (Button) findViewById(R.id.bt_4);


        btOptionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(), WordLevel1Activity.class);
                startActivity(intent);
                finish();

            }
        });

        btOptionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(), TenAndTen.class);
                startActivity(intent);
                finish();

            }
        });


    }
}