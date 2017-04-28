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
 * Created by Kast on 09/02/2017.
 */
public class VocalLevel1Activity extends Activity {

    private ImageView ivA;
    private ImageView ivE;
    private ImageView ivI;
    private ImageView ivO;
    private ImageView ivU;

    private Button btGoToBack;
    private Button btNextLevel;
    private Button btInfo;

    MediaPlayer mpa;
    MediaPlayer mpe;
    MediaPlayer mpi;
    MediaPlayer mpo;
    MediaPlayer mpu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_vlowes_level_1);


        ivA = (ImageView)findViewById(R.id.iv_a);
        ivE = (ImageView)findViewById(R.id.iv_e);
        ivI = (ImageView)findViewById(R.id.iv_i);
        ivO = (ImageView)findViewById(R.id.iv_o);
        ivU = (ImageView)findViewById(R.id.iv_u);
        btGoToBack = (Button)findViewById(R.id.bt_go_to_back);
        btNextLevel = (Button)findViewById(R.id.bt_next_level);
        btInfo = (Button)findViewById(R.id.bt_info);

       /* ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DialogoVocal();
                dialogFragment.show(getSupportFragmentManager(), "undialogo");
            }
        });
        */

        mpa = MediaPlayer.create(this, R.raw.a);

        ivA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpa.start();
            }
        });

        mpe = MediaPlayer.create(this, R.raw.e);

        ivE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpe.start();
            }
        });

        mpi = MediaPlayer.create(this, R.raw.i);

        ivI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpi.start();
            }
        });

        mpo = MediaPlayer.create(this, R.raw.o);

        ivO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpo.start();
            }
        });

        mpu = MediaPlayer.create(this, R.raw.u);

        ivU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpu.start();
            }
        });

        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer info = MediaPlayer.create(VocalLevel1Activity.this, R.raw.ayuda_letras);
                info.start();
            }
        });
    }

    public void Level2A(View v){
        Intent a = new Intent(this, VocalAActivity.class);
        startActivity(a);
        finish();
    }

    public void ToGoBack(View v){
        Intent i = new Intent(this, LevelsVlowes.class);
        startActivity(i);
        finish();
    }

}