package com.boostudy.danielarguello.boostudy.group;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.boostudy.danielarguello.boostudy.R;
import com.boostudy.danielarguello.boostudy.num.MainNum;

import java.util.Random;

/**
 * Created by DANIEL ARGUELLO on 21/04/2017.
 */

public class AgroupTwo extends Activity {

    LinearLayout targetOne;
    LinearLayout targetTwo;
    LinearLayout targetThree;
    LinearLayout targetFour;
    LinearLayout targetContent;

    Button btOne;
    Button btTwo;
    Button btThree;
    Button btFour;
    Button btSiguiente;
    Button btMain;

    MediaPlayer correct;
    MediaPlayer diez;
    MediaPlayer seis;
    MediaPlayer cero;
    MediaPlayer dos;


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
        setContentView(R.layout.activity_agrup_two);

        targetOne = (LinearLayout) findViewById(R.id.target_on);
        targetTwo = (LinearLayout) findViewById(R.id.target_two);
        targetThree = (LinearLayout) findViewById(R.id.target_three);
        targetFour = (LinearLayout) findViewById(R.id.target_four);
        targetContent = (LinearLayout) findViewById(R.id.target_content);

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

        correct = MediaPlayer.create(AgroupTwo.this, R.raw.correcto);

        diez = MediaPlayer.create(AgroupTwo.this, R.raw.diez);
        seis = MediaPlayer.create(AgroupTwo.this, R.raw.seis);
        cero = MediaPlayer.create(AgroupTwo.this, R.raw.cero);
        dos = MediaPlayer.create(AgroupTwo.this, R.raw.dos);


        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!btOne.isFocusable() && !btTwo.isFocusable() && !btThree.isFocusable() && !btFour.isFocusable()) {


                    Class[] classes = new Class[4];
                    classes[0] = AgroupZero.class;
                    classes[1] = AgroupOne.class;
                    classes[2] = AgroupTwo.class;
                    classes[3] = AgroupThree.class;

                    Random r = new Random();


                    startActivity(new Intent(AgroupTwo.this, classes[r.nextInt(classes.length)]));
                    finish();
                }
            }
        });
        btMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), MainNum.class);
                intent.putExtra("cancion", false);
                startActivity(intent);
                finish();
            }
        });

        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diez.start();
            }
        });

        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seis.start();
            }
        });

        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cero.start();
            }
        });

        btFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dos.start();
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

            } else if (v.getId() == R.id.bt_three) {

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


                    } else if (view.getId() == R.id.bt_two && v.getId() == R.id.target_on) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivOne.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btTwo.setFocusable(false);
                    } else if (view.getId() == R.id.bt_three && v.getId() == R.id.target_two) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivTwo.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btThree.setFocusable(false);
                    } else if (view.getId() == R.id.bt_four && v.getId() == R.id.target_four) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivFour.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btFour.setFocusable(false);


                    } else {
                        MediaPlayer media = MediaPlayer.create(AgroupTwo.this, R.raw.resorte);
                        media.start();

                    }


                    break;

            }

            return true;
        }
    };

}
