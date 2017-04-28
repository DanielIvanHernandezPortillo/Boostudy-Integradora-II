package com.boostudy.danielarguello.boostudy.vocal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.boostudy.danielarguello.boostudy.R;

/**
 * Created by Kast on 17/03/2017.
 */
public class LevelsVlowes extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_vlowes_levels);
    }

    public void Facil(View v){
        Intent f = new Intent(this, VocalLevel1Activity.class);
        startActivity(f);
        finish();
    }

    public void Medio(View v){
        Intent m = new Intent(this, WordLevel1Activity.class);
        startActivity(m);
        finish();
    }

}