package com.boostudy.danielarguello.boostudy.vocal;
import com.boostudy.danielarguello.boostudy.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Kast on 27/01/2017.
 */
public class VocalAActivity extends Activity {

    private ImageView ivA;
    private ImageView ivE;
    private ImageView ivI;
    private ImageView ivO;
    private ImageView ivU;
    private ImageView ivInfo;
    private Button btGoToBack;
    private Button btNextLevel;
    MediaPlayer correcto;
    MediaPlayer incorrecto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_vocal_a);

        ivA = (ImageView)findViewById(R.id.iv_angel);
        ivE = (ImageView)findViewById(R.id.iv_estrella);
        ivI = (ImageView)findViewById(R.id.iv_iglesia);
        ivO = (ImageView)findViewById(R.id.iv_oso);
        ivU = (ImageView)findViewById(R.id.iv_uno);

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

        ivU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrecto.start();
            }
        });

    }



    public void level2e(View v){
        Intent e = new Intent(this, VocalEActivity.class);
        startActivity(e);
        correcto.start();
        finish();
    }

}