package com.boostudy.danielarguello.boostudy.letras;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.boostudy.danielarguello.boostudy.R;
import com.boostudy.danielarguello.boostudy.colores.LevelsColors;


public class LetrasColoresActivity extends Activity {

    MediaPlayer correcto;
    MediaPlayer incorrecto;
    MediaPlayer letraColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letras_colores);

        correcto = MediaPlayer.create(this, R.raw.correcto);
        incorrecto = MediaPlayer.create(this, R.raw.resorte);
        letraColor = MediaPlayer.create(this, R.raw.aamarilla);

    }

    public void Next(View v){
        Intent e = new Intent(this, LetrasColoresUnoActivity.class);
        startActivity(e);
        correcto.start();
        finish();
    }

    public void Error(View v){
        incorrecto.start();
    }

    public void Back(View v){
        Intent e = new Intent(this, LevelsColors.class); //aqui pones el menu de las los colores
        startActivity(e);
        finish();
    }

    public void Play(View v){
        letraColor.start();
    }

}