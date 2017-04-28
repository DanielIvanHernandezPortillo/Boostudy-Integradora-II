package com.boostudy.danielarguello.boostudy.num;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.boostudy.danielarguello.boostudy.R;
import android.media.MediaPlayer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by DANIEL on 21/03/2017.
 */

public class TenAndTen extends Activity {

    MediaPlayer diez;
    MediaPlayer veinte;
    MediaPlayer treinta;
    MediaPlayer cuarenta;
    MediaPlayer cincuenta;
    MediaPlayer sesenta;
    MediaPlayer setenta;
    MediaPlayer ochenta;
    MediaPlayer noventa;
    MediaPlayer cien;

    private Button btDiez;
    private Button btVeinte;
    private Button btTrienta;
    private Button btCuarenta;
    private Button btCincuenta;
    private Button btSesenta;
    private Button btSetenta;
    private Button btOchenta;
    private Button btNoventa;
    private Button btCien;
    private Button btMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_diez);

        btDiez = (Button)findViewById(R.id.bt_diez);
        btVeinte = (Button)findViewById(R.id.bt_veinte);
        btTrienta = (Button)findViewById(R.id.bt_treinta);
        btCuarenta = (Button)findViewById(R.id.bt_cuarenta);
        btCincuenta = (Button)findViewById(R.id.bt_cincuenta);
        btSesenta = (Button)findViewById(R.id.bt_sesenta);
        btSetenta = (Button)findViewById(R.id.bt_setenta);
        btOchenta = (Button)findViewById(R.id.bt_ochenta);
        btNoventa = (Button)findViewById(R.id.bt_noventa);
        btCien = (Button)findViewById(R.id.bt_cien);
        btMain = (Button) findViewById(R.id.bt_main);



        diez = MediaPlayer.create(TenAndTen.this, R.raw.diez);
        veinte = MediaPlayer.create(TenAndTen.this, R.raw.veinte);
        treinta = MediaPlayer.create(TenAndTen.this, R.raw.treinta);
        cuarenta = MediaPlayer.create(TenAndTen.this, R.raw.cuarenta);
        cincuenta = MediaPlayer.create(TenAndTen.this, R.raw.cincuenta);
        sesenta = MediaPlayer.create(TenAndTen.this, R.raw.sesentaa);
        setenta = MediaPlayer.create(TenAndTen.this, R.raw.setenta);
        ochenta = MediaPlayer.create(TenAndTen.this, R.raw.ochenta);
        noventa = MediaPlayer.create(TenAndTen.this, R.raw.noventa);
        cien = MediaPlayer.create(TenAndTen.this, R.raw.cien);

        btDiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diez.start();
            }
        });

        btVeinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veinte.start();
            }
        });

        btTrienta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                treinta.start();
            }
        });

        btCuarenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cuarenta.start();
            }
        });

        btCincuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cincuenta.start();
            }
        });

        btSesenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sesenta.start();
            }
        });

        btSetenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setenta.start();
            }
        });

        btOchenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ochenta.start();
            }
        });

        btNoventa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noventa.start();
            }
        });

        btCien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cien.start();
            }
        });

        btMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),MainNum.class);
                startActivity(intent);
                finish();

            }
        });

    }
}