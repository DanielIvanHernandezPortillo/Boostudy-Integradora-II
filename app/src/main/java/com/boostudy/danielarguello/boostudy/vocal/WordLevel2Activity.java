package com.boostudy.danielarguello.boostudy.vocal;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.boostudy.danielarguello.boostudy.R;

/**
 * Created by Kast on 03/04/2017.
 */
public class WordLevel2Activity extends Activity {

    private Button btK;
    private Button btL;
    private Button btM;
    private Button btN;
    private Button btNn;
    private Button btO;
    private Button btP;
    private Button btQ;
    private Button btR;
    private Button btS;
    private ImageView ivInfo;
    private Button btGoToBack;
    private Button btNextLevel;
    private Button btInfo;
    MediaPlayer mpk;
    MediaPlayer mpl;
    MediaPlayer mpm;
    MediaPlayer mpn;
    MediaPlayer mpnie;
    MediaPlayer mpo;
    MediaPlayer mpp;
    MediaPlayer mpq;
    MediaPlayer mpr;
    MediaPlayer mps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_words_level_2);


        btK = (Button) findViewById(R.id.bt_k);
        btL = (Button)findViewById(R.id.bt_l);
        btM = (Button)findViewById(R.id.bt_m);
        btN = (Button)findViewById(R.id.bt_n);
        btNn = (Button)findViewById(R.id.bt_nn);
        btO = (Button)findViewById(R.id.bt_o);
        btP = (Button)findViewById(R.id.bt_p);
        btQ = (Button)findViewById(R.id.bt_q);
        btR = (Button)findViewById(R.id.bt_r);
        btS = (Button)findViewById(R.id.bt_s);
        btGoToBack = (Button)findViewById(R.id.bt_go_to_back);
        btNextLevel = (Button)findViewById(R.id.bt_next_level);
        btInfo = (Button)findViewById(R.id.bt_info);

        mpk = MediaPlayer.create(this, R.raw.k);
        btK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpk.start();
            }
        });

        mpl = MediaPlayer.create(this, R.raw.l);
        btL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpl.start();
            }
        });

        mpm = MediaPlayer.create(this, R.raw.m);
        btM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpm.start();
            }
        });

        mpn = MediaPlayer.create(this, R.raw.n);
        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpn.start();
            }
        });

        mpnie = MediaPlayer.create(this, R.raw.nn);
        btNn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpnie.start();
            }
        });

        mpo = MediaPlayer.create(this, R.raw.o);
        btO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpo.start();
            }
        });

        mpp = MediaPlayer.create(this, R.raw.p);
        btP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpp.start();
            }
        });

        mpq = MediaPlayer.create(this, R.raw.q);
        btQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpq.start();
            }
        });

        mpr = MediaPlayer.create(this, R.raw.r);
        btR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpr.start();
            }
        });

        mps = MediaPlayer.create(this, R.raw.s);
        btS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mps.start();
            }
        });

        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer info = MediaPlayer.create(WordLevel2Activity.this, R.raw.ayuda_letras);
                info.start();
            }
        });

    }

    public void Level3Word(View v){
        Intent a = new Intent(this, WordLevel3Activity.class);
        startActivity(a);
        finish();
    }

    public void ToGoBack(View v){
        Intent i = new Intent(this, WordLevel1Activity.class);
        startActivity(i);
        finish();
    }

}
