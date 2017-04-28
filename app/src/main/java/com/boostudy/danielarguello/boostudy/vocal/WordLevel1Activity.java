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
public class WordLevel1Activity extends Activity {

    private Button btA;
    private Button btB;
    private Button btC;
    private Button btD;
    private Button btE;
    private Button btF;
    private Button btG;
    private Button btH;
    private Button btI;
    private Button btJ;

    private Button btGoToBack;
    private Button btNextLevel;
    private Button btInfo;
    MediaPlayer mpa;
    MediaPlayer mpb;
    MediaPlayer mpc;
    MediaPlayer mpd;
    MediaPlayer mpe;
    MediaPlayer mpf;
    MediaPlayer mpg;
    MediaPlayer mph;
    MediaPlayer mpi;
    MediaPlayer mpj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_words_level_1);


        btA = (Button) findViewById(R.id.bt_a);
        btB = (Button)findViewById(R.id.bt_b);
        btC = (Button)findViewById(R.id.bt_c);
        btD = (Button)findViewById(R.id.bt_d);
        btE = (Button)findViewById(R.id.bt_e);
        btF = (Button)findViewById(R.id.bt_f);
        btG = (Button)findViewById(R.id.bt_g);
        btH = (Button)findViewById(R.id.bt_h);
        btI = (Button)findViewById(R.id.bt_i);
        btJ = (Button)findViewById(R.id.bt_j);
        btGoToBack = (Button)findViewById(R.id.bt_go_to_back);
        btNextLevel = (Button)findViewById(R.id.bt_next_level);
        btInfo = (Button)findViewById(R.id.bt_info);

        mpa = MediaPlayer.create(this, R.raw.a);
        btA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpa.start();
            }
        });

        mpb = MediaPlayer.create(this, R.raw.b);
        btB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpb.start();
            }
        });

        mpc = MediaPlayer.create(this, R.raw.c);
        btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpc.start();
            }
        });

        mpd = MediaPlayer.create(this, R.raw.d);
        btD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpd.start();
            }
        });

        mpe = MediaPlayer.create(this, R.raw.e);
        btE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpe.start();
            }
        });

        mpf = MediaPlayer.create(this, R.raw.f);
        btF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpf.start();
            }
        });

        mpg = MediaPlayer.create(this, R.raw.g);
        btG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpg.start();
            }
        });

        mph = MediaPlayer.create(this, R.raw.h);
        btH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mph.start();
            }
        });

        mpi = MediaPlayer.create(this, R.raw.i);
        btI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpi.start();
            }
        });

        mpj = MediaPlayer.create(this, R.raw.j);
        btJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpj.start();
            }
        });


        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer info = MediaPlayer.create(WordLevel1Activity.this, R.raw.ayuda_letras);
                info.start();
            }
        });


    }

    public void Level2Word(View v){
        Intent a = new Intent(this, WordLevel2Activity.class);
        startActivity(a);
        finish();
    }

    public void ToGoBack(View v){
        Intent i = new Intent(this, LevelsVlowes.class);
        startActivity(i);
        finish();
    }



}
