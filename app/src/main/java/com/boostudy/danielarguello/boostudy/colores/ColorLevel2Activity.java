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
 * Created by Kast on 03/04/2017.
 */
public class ColorLevel2Activity extends Activity {

    private ImageView ivPurple;
    private ImageView ivViolet;
    private ImageView ivOrange;private ImageView ivInfo;
    private Button btGoToBack;
    private Button btInfo;
    MediaPlayer mpPurple;
    MediaPlayer mpViolet;
    MediaPlayer mpOrange;
    MediaPlayer color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_colors_level_2);


        ivPurple = (ImageView)findViewById(R.id.iv_purple);
        ivViolet = (ImageView)findViewById(R.id.iv_violet);
        ivOrange = (ImageView)findViewById(R.id.iv_orange);
        btGoToBack = (Button)findViewById(R.id.bt_go_to_back);
        btGoToBack = (Button)findViewById(R.id.bt_go_to_back);
        btInfo = (Button)findViewById(R.id.bt_info);

        mpPurple = MediaPlayer.create(this, R.raw.morado);
        ivPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpPurple.start();
            }
        });

        mpViolet = MediaPlayer.create(this, R.raw.violeta);
        ivViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpViolet.start();
            }
        });

        mpOrange = MediaPlayer.create(this, R.raw.naranja);
        ivOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpOrange.start();
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

    public void ToGoBack(View v){
        Intent i = new Intent(this, LevelsColors.class);
        startActivity(i);
        finish();
    }

}