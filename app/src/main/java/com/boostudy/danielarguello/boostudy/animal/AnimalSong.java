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

public class AnimalSong extends Activity {

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
    MediaPlayer mono;
    MediaPlayer elefante;
    MediaPlayer leon;
    MediaPlayer caballo;
    MediaPlayer info;


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
        setContentView(R.layout.animal_song);

        targetOne = (LinearLayout) findViewById(R.id.target_one);
        targetTwo = (LinearLayout) findViewById(R.id.target_two);
        targetThree = (LinearLayout) findViewById(R.id.target_three);
        targetFour = (LinearLayout) findViewById(R.id.target_four);

        ivOne = (ImageView) findViewById(R.id.iv_one);
        ivTwo = (ImageView) findViewById(R.id.iv_two);
        ivThree = (ImageView) findViewById(R.id.iv_three);
        ivFour = (ImageView) findViewById(R.id.iv_four);

        btOne = (Button) findViewById(R.id.bt_one);
        btTwo = (Button) findViewById(R.id.bt_two);
        btThree = (Button) findViewById(R.id.bt_three);
        btFour = (Button) findViewById(R.id.bt_four);
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

        correct = MediaPlayer.create(AnimalSong.this, R.raw.correcto);

        mono = MediaPlayer.create(AnimalSong.this, R.raw.mono);
        leon = MediaPlayer.create(AnimalSong.this, R.raw.leon);
        caballo = MediaPlayer.create(AnimalSong.this, R.raw.caballo);
        elefante = MediaPlayer.create(AnimalSong.this, R.raw.elefante);


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


                    startActivity(new Intent(AnimalSong.this, classes[r.nextInt(classes.length)]));
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
                mono.start();
            }
        });

        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caballo.start();
            }
        });

        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leon.start();
            }
        });

        btFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elefante.start();
            }
        });


    }

    View.OnLongClickListener longclickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            if (v.getId() == R.id.bt_one) {

            } else if (v.getId() == R.id.bt_two) {

            } else if (v.getId() == R.id.bt_3) {

            } else if (v.getId() == R.id.bt_four) {

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

                    if (view.getId() == R.id.bt_one && v.getId() == R.id.target_three) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivThree.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btOne.setFocusable(false);


                    } else if (view.getId() == R.id.bt_two && v.getId() == R.id.target_four) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivFour.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btTwo.setFocusable(false);
                    } else if (view.getId() == R.id.bt_three && v.getId() == R.id.target_one) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivOne.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btThree.setFocusable(false);
                    } else if (view.getId() == R.id.bt_four && v.getId() == R.id.target_two) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivTwo.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btFour.setFocusable(false);




                    } else {
                        MediaPlayer media = MediaPlayer.create(AnimalSong.this, R.raw.resorte);
                        media.start();

                    }


                    break;

            }

            return true;
        }
    };


}