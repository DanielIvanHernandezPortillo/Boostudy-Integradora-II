package com.boostudy.danielarguello.boostudy.colores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.boostudy.danielarguello.boostudy.R;
import com.boostudy.danielarguello.boostudy.colorear.MainActivity;
import com.boostudy.danielarguello.boostudy.letras.LetrasColoresActivity;

/**
 * Created by Kast on 17/03/2017.
 */
public class LevelsColors extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_colors_levels);
    }

    public void Facil(View v){
        Intent f = new Intent(this, ColorLevel1Activity.class);
        startActivity(f);
        finish();
    }



    public void Colorear(View v){
        Intent m = new Intent(this, MainActivity.class);
        startActivity(m);
        finish();
    }

    public void Identificar(View v){
        Intent m = new Intent(this, LetrasColoresActivity.class);
        startActivity(m);
        finish();
    }
}