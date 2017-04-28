package com.boostudy.danielarguello.boostudy.colorear;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.boostudy.danielarguello.boostudy.R;

import java.util.UUID;

public class MainActivity extends Activity implements View.OnClickListener {

    //Colours
    private ImageButton ibRed;
    private ImageButton ibBlack;
    private ImageButton ibPink;
    private ImageButton ibYellow;
    private ImageButton ibBlue;
    private ImageButton ibOrange;
    private ImageButton ibBrown;
    private ImageButton ibPurple;
    private ImageButton ibGreen;


    //Action Buttons
    private ImageButton ibClean;
    private ImageButton ibNew;
    private ImageButton ibSave;
    private ImageButton ibSmall;
    private ImageButton ibMedium;
    private ImageButton ibBig;


    //paint
    private static Lienzo lienzo;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_lienzo);


        //colours
        ibYellow = (ImageButton) findViewById(R.id.ib_yellow);
        ibBlack = (ImageButton) findViewById(R.id.ib_black);
        ibBlue = (ImageButton) findViewById(R.id.ib_blue);
        ibPink = (ImageButton) findViewById(R.id.ib_pink);
        ibRed = (ImageButton) findViewById(R.id.ib_red);
        ibOrange = (ImageButton) findViewById(R.id.ib_orange);
        ibBrown = (ImageButton) findViewById(R.id.ib_brown);
        ibPurple = (ImageButton) findViewById(R.id.ib_purple);
        ibGreen = (ImageButton) findViewById(R.id.ib_green);

        //actions
        ibClean = (ImageButton) findViewById(R.id.ib_clean);
        // ibSize = (ImageButton) findViewById(R.id.ib_size);
        ibSave = (ImageButton) findViewById(R.id.ib_save);
        ibNew = (ImageButton) findViewById(R.id.ib_new);
        ibSmall = (ImageButton) findViewById(R.id.ib_small);
        ibMedium = (ImageButton) findViewById(R.id.ib_medium);
        ibBig = (ImageButton) findViewById(R.id.ib_big);
        //lienzo
        lienzo = (Lienzo) findViewById(R.id.lienzo);

        //colors
        ibRed.setOnClickListener(this);
        ibPink.setOnClickListener(this);
        ibBlue.setOnClickListener(this);
        ibBlack.setOnClickListener(this);
        ibYellow.setOnClickListener(this);
        ibGreen.setOnClickListener(this);
        ibOrange.setOnClickListener(this);
        ibBrown.setOnClickListener(this);
        ibBlack.setOnClickListener(this);
        ibPurple.setOnClickListener(this);


        ibClean.setOnClickListener(this);
        ibNew.setOnClickListener(this);
        // ibSize.setOnClickListener(this);
        ibSave.setOnClickListener(this);
        ibSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lienzo.setPencilSize(10);
            }
        });
        ibMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lienzo.setPencilSize(30);
            }
        });
        ibBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lienzo.setPencilSize(50);
            }
        });


    }

    @Override
    public void onClick(View v) {
        String color = null;
        switch (v.getId()) {
            case R.id.ib_yellow:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.ib_red:
                color = v.getTag().toString();
                lienzo.setColor(color);

                break;
            case R.id.ib_pink:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.ib_blue:
                color = v.getTag().toString();
                lienzo.setColor(color);

                break;
            case R.id.ib_black:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.ib_brown:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.ib_green:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.ib_purple:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.ib_orange:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.ib_clean:
                color = v.getTag().toString();
                lienzo.setColor(color);


//                Paint paint = new Paint();
//                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//                lienzo.getDrawCanvas().drawRect(0,0, lienzo.getWidth(), lienzo.getHeight(), paint);
//                lienzo.invalidate();
                break;
            case R.id.ib_new:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Nuevo Dibujo");
                builder.setMessage("¿Comenzar nuevo dibujo(se perderá el dibujo actual)?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        lienzo.newDraw();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.show();
                break;
            case R.id.ib_save:
                AlertDialog.Builder saveDraw = new AlertDialog.Builder(this);
                saveDraw.setTitle("Guardar Dibujo");
                saveDraw.setMessage("¿Guardar dibujo en galería?");
                saveDraw.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        lienzo.setDrawingCacheEnabled(true);
                        String imgSaved = MediaStore.Images.Media.insertImage(getContentResolver(), lienzo.getDrawingCache(),
                                UUID.randomUUID().toString() + ".png", "drawing");
                        //Correct Message
                        if (imgSaved != null) {
                            Toast savedToast = Toast.makeText(getApplicationContext(),
                                    "¡Dibujo guardado en la galería!", Toast.LENGTH_SHORT);
                            savedToast.show();
                        } else {
                            Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                    "¡Error, la imagen no pudo ser guardada!", Toast.LENGTH_SHORT);
                            unsavedToast.show();
                        }
                        lienzo.destroyDrawingCache();
                    }
                });
                saveDraw.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                saveDraw.show();

                break;


        }

    }



}