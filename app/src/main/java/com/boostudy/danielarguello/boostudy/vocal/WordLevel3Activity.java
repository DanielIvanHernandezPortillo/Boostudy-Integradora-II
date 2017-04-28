package com.boostudy.danielarguello.boostudy.vocal;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.boostudy.danielarguello.boostudy.R;

/**
 * Created by Kast on 03/04/2017.
 */
public class WordLevel3Activity extends Activity {

    private Button btT;
    private Button btU;
    private Button btV;
    private Button btW;
    private Button btX;
    private Button btY;
    private Button btZ;

    private Button btGoToBack;
    private Button btInfo;
    MediaPlayer mpt;
    MediaPlayer mpu;
    MediaPlayer mpv;
    MediaPlayer mpw;
    MediaPlayer mpx;
    MediaPlayer mpy;
    MediaPlayer mpz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_words_level_3);


        btT = (Button) findViewById(R.id.bt_t);
        btU = (Button)findViewById(R.id.bt_u);
        btV = (Button)findViewById(R.id.bt_v);
        btW = (Button)findViewById(R.id.bt_w);
        btX = (Button)findViewById(R.id.bt_x);
        btY = (Button)findViewById(R.id.bt_y);
        btZ = (Button)findViewById(R.id.bt_z);
        btGoToBack = (Button)findViewById(R.id.bt_go_to_back);
        btInfo = (Button)findViewById(R.id.bt_info);

        mpt = MediaPlayer.create(this, R.raw.t);
        btT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpt.start();
            }
        });

        mpu = MediaPlayer.create(this, R.raw.u);
        btU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpu.start();
            }
        });

        mpv = MediaPlayer.create(this, R.raw.v);
        btV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpv.start();
            }
        });

        mpw = MediaPlayer.create(this, R.raw.w);
        btW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpw.start();
            }
        });

        mpx = MediaPlayer.create(this, R.raw.x);
        btX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpx.start();
            }
        });

        mpy = MediaPlayer.create(this, R.raw.y);
        btY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpy.start();
            }
        });

        mpz = MediaPlayer.create(this, R.raw.z);
        btZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpz.start();
            }
        });

        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer info = MediaPlayer.create(WordLevel3Activity.this, R.raw.ayuda_letras);
                info.start();
            }
        });

    }

    public void ToGoBack(View v){
        Intent i = new Intent(this, WordLevel2Activity.class);
        startActivity(i);
        finish();
    }
}