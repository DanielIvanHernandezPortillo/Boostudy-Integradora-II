package com.boostudy.danielarguello.boostudy.vocal;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.boostudy.danielarguello.boostudy.R;

/**
 * Created by Kast on 27/01/2017.
 */
public class VocalEActivity extends Activity {

    private ImageView ivA;
    private ImageView ivE;
    private ImageView ivI;
    private ImageView ivO;
    private ImageView ivU;
    MediaPlayer correcto;
    MediaPlayer incorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_vocal_e);

        ivA = (ImageView)findViewById(R.id.iv_anillo);
        ivE = (ImageView)findViewById(R.id.iv_empanada);
        ivI = (ImageView)findViewById(R.id.iv_iglu);
        ivO = (ImageView)findViewById(R.id.iv_olla);
        ivU = (ImageView)findViewById(R.id.iv_unicornio);

        correcto = MediaPlayer.create(this, R.raw.correcto);

        ivA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });

        incorrecto = MediaPlayer.create(this, R.raw.resorte);


        ivI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });

        ivO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });

        ivU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });

    }

    public void level2i(View v){
        Intent i = new Intent(this, VocalIActivity.class);
        startActivity(i);
        correcto.start();
        finish();
    }

}