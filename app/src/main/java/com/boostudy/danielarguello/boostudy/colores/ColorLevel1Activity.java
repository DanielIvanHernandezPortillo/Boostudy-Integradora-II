package com.boostudy.danielarguello.boostudy.colores;

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
public class ColorLevel1Activity extends Activity {

    private ImageView ivRed;
    private ImageView ivBlue;
    private ImageView ivYelow;
    private ImageView ivGreen;
    private ImageView ivInfo;
    private Button btGoToBack;
    private Button btNextLevel;
    private Button btInfo;
    MediaPlayer mpRed;
    MediaPlayer mpBlue;
    MediaPlayer mpYelow;
    MediaPlayer mpGreen;
    MediaPlayer color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_colors_level_1);


        ivRed = (ImageView)findViewById(R.id.iv_red);
        ivBlue = (ImageView)findViewById(R.id.iv_blue);
        ivYelow = (ImageView)findViewById(R.id.iv_yellow);
        ivGreen = (ImageView)findViewById(R.id.iv_green);
        btGoToBack = (Button)findViewById(R.id.bt_go_to_back);
        btNextLevel = (Button)findViewById(R.id.bt_next_level);
        btInfo = (Button) findViewById(R.id.bt_info);

        /*ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DialogoVocal();
                dialogFragment.show(getSupportFragmentManager(), "undialogo");
            }
        });
        */
        mpRed = MediaPlayer.create(this, R.raw.rojo);

        ivRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpRed.start();
            }
        });

        mpBlue = MediaPlayer.create(this, R.raw.azul);

        ivBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpBlue.start();
            }
        });

        mpYelow = MediaPlayer.create(this, R.raw.amarillo);

        ivYelow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpYelow.start();
            }
        });

        mpGreen = MediaPlayer.create(this, R.raw.verde);

        ivGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpGreen.start();
            }
        });

        color = MediaPlayer.create(this, R.raw.ayuda_colores);


        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color.start();
            }
        });


    }

    public void Level2Color(View v){
        Intent a = new Intent(this, ColorLevel2Activity.class);
        startActivity(a);
        finish();
    }

    public void ToGoBack(View v){
        Intent i = new Intent(this, LevelsColors.class);
        startActivity(i);
        finish();
    }

}