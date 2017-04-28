package com.boostudy.danielarguello.boostudy.animal;

import android.view.DragEvent;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.boostudy.danielarguello.boostudy.MainActivity;
import com.boostudy.danielarguello.boostudy.R;

import java.util.Random;

/**
 * Created by DANIEL  on 14/03/2017.
 */

public class AnimalSongTwo extends Activity {

    LinearLayout targetOne;
    LinearLayout targetTwo;
    LinearLayout targetThree;
    LinearLayout targetFour;

    Button btOne;
    Button btTwo;
    Button btThree;
    Button btFour;
    Button btSiguiente;
    Button btMain;

    MediaPlayer correct;
    MediaPlayer gallina;
    MediaPlayer perro;
    MediaPlayer cat;
    MediaPlayer lobo;

    ImageView ivOne;
    ImageView ivTwo;
    ImageView ivThree;
    ImageView ivFour;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.animal_song_two);

        targetOne = (LinearLayout) findViewById(R.id.target1);
        targetTwo = (LinearLayout) findViewById(R.id.target2);
        targetThree = (LinearLayout) findViewById(R.id.target3);
        targetFour = (LinearLayout) findViewById(R.id.target4);

        ivOne = (ImageView) findViewById(R.id.test1);
        ivTwo = (ImageView) findViewById(R.id.test2);
        ivThree = (ImageView) findViewById(R.id.test3);
        ivFour = (ImageView) findViewById(R.id.test4);

        btOne = (Button) findViewById(R.id.btn1);
        btTwo = (Button) findViewById(R.id.btn2);
        btThree = (Button) findViewById(R.id.btn3);
        btFour = (Button) findViewById(R.id.btn4);
        btSiguiente = (Button) findViewById(R.id.bt_siguiente);
        btMain = (Button) findViewById(R.id.bt_main);

        targetOne.setOnDragListener(dragListener);
        targetTwo.setOnDragListener(dragListener);
        targetThree.setOnDragListener(dragListener);
        targetFour.setOnDragListener(dragListener);

        btOne.setOnLongClickListener(longclickListener);
        btTwo.setOnLongClickListener(longclickListener);
        btThree.setOnLongClickListener(longclickListener);
        btFour.setOnLongClickListener(longclickListener);

        correct = MediaPlayer.create(AnimalSongTwo.this, R.raw.correcto);

        gallina = MediaPlayer.create(AnimalSongTwo.this, R.raw.gallina);
        perro = MediaPlayer.create(AnimalSongTwo.this, R.raw.perro);
        cat = MediaPlayer.create(AnimalSongTwo.this, R.raw.gato);
        lobo = MediaPlayer.create(AnimalSongTwo.this, R.raw.lobo);


        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!btOne.isFocusable() && !btTwo.isFocusable() && !btThree.isFocusable() && !btFour.isFocusable()) {

                    Class[] classes = new Class[4];
                    classes[0] = AnimalSong.class;
                    classes[1] = AnimalSongTwo.class;
                    classes[2] = AnimalSongThree.class;
                    classes[3] = AnimalSongFour.class;

                    Random r = new Random();


                    startActivity(new Intent(AnimalSongTwo.this, classes[r.nextInt(classes.length)]));
                    finish();
                }
            }
        });
        btMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), MainActivity.class);
                intent.putExtra("cancion", false);
                startActivity(intent);
                finish();
            }
        });

        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lobo.start();
            }
        });

        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gallina.start();
            }
        });

        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cat.start();
            }
        });

        btFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perro.start();
            }
        });


    }

    View.OnLongClickListener longclickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            if (v.getId() == R.id.btn1) {

            } else if (v.getId() == R.id.btn2) {

            } else if (v.getId() == R.id.btn3) {

            } else if (v.getId() == R.id.btn4) {

            }


            return true;
        }

    };


    View.OnDragListener dragListener = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();


            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    if (view.getId() == R.id.btn1 && v.getId() == R.id.target1) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivOne.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btOne.setFocusable(false);


                    } else if (view.getId() == R.id.btn2 && v.getId() == R.id.target2) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivTwo.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btTwo.setFocusable(false);
                    } else if (view.getId() == R.id.btn3 && v.getId() == R.id.target3) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivThree.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btThree.setFocusable(false);
                    } else if (view.getId() == R.id.btn4 && v.getId() == R.id.target4) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivFour.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btFour.setFocusable(false);


                    } else {
                        MediaPlayer media = MediaPlayer.create(AnimalSongTwo.this, R.raw.resorte);
                        media.start();

                    }


                    break;

            }

            return true;
        }
    };


}