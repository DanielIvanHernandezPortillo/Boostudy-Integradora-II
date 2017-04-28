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
public class VocalUActivity extends Activity {

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
        setContentView(R.layout.activity_vocal_u);

        ivA = (ImageView)findViewById(R.id.iv_agua);
        ivE = (ImageView)findViewById(R.id.iv_espejo);
        ivI = (ImageView)findViewById(R.id.iv_isla);
        ivO = (ImageView)findViewById(R.id.iv_oveja);
        ivU = (ImageView)findViewById(R.id.iv_uña);

        correcto = MediaPlayer.create(this, R.raw.correcto);

        incorrecto = MediaPlayer.create(this, R.raw.resorte);

        ivE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });

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

        ivA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });
    }

    public void level2u(View v){
        Intent u = new Intent(this, VocalUActivity.class);
        startActivity(u);
        correcto.start();
        finish();
    }

    public void ToGoBack(View v){
        Intent i = new Intent(this, LevelsVlowes.class);
        startActivity(i);
        correcto.start();
        finish();
    }

}