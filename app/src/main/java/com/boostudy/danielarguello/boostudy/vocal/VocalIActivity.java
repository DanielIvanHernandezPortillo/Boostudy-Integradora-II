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
public class VocalIActivity extends Activity {

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
        setContentView(R.layout.activity_vocal_i);

        ivA = (ImageView)findViewById(R.id.iv_abeja);
        ivE = (ImageView)findViewById(R.id.iv_espejo);
        ivI = (ImageView)findViewById(R.id.iv_incendio);
        ivO = (ImageView)findViewById(R.id.iv_ostra);
        ivU = (ImageView)findViewById(R.id.iv_urraca);

        correcto = MediaPlayer.create(this, R.raw.correcto);

        incorrecto = MediaPlayer.create(this, R.raw.resorte);

        ivE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });

        ivA.setOnClickListener(new View.OnClickListener() {
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

    public void level2o(View v){
        Intent o = new Intent(this, VocalOActivity.class);
        correcto.start();
        startActivity(o);
        finish();
    }

}