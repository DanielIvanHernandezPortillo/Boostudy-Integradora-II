package com.boostudy.danielarguello.boostudy.num;

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

import java.util.Random;


/**
 * Created by karla on 04/04/2017.
 */

public class NumberZero extends Activity {

    LinearLayout targetOne;
    LinearLayout targetTwo;
    LinearLayout targetThree;
    LinearLayout targetFour;


    Button btThree;
    Button btSiguiente;
    Button btMain;

    MediaPlayer correct;
    MediaPlayer ocho;
    MediaPlayer tres;
    MediaPlayer cero;
    MediaPlayer cinco;


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
        setContentView(R.layout.activity_number_zero);

        targetOne = (LinearLayout) findViewById(R.id.target_one);
        targetTwo = (LinearLayout) findViewById(R.id.target_two);
        targetThree = (LinearLayout) findViewById(R.id.target_three);
        targetFour = (LinearLayout) findViewById(R.id.target_four);

        ivOne = (ImageView) findViewById(R.id.iv_one);
        ivTwo = (ImageView) findViewById(R.id.iv_two);
        ivThree = (ImageView) findViewById(R.id.iv_three);
        ivFour = (ImageView) findViewById(R.id.iv_four);


        btThree = (Button) findViewById(R.id.bt_three);
        btSiguiente = (Button) findViewById(R.id.bt_siguiente);
        btMain = (Button) findViewById(R.id.bt_main);

        targetOne.setOnDragListener(dragListener);
        targetTwo.setOnDragListener(dragListener);
        targetThree.setOnDragListener(dragListener);
        targetFour.setOnDragListener(dragListener);


        btThree.setOnLongClickListener(longclickListener);


        correct = MediaPlayer.create(NumberZero.this, R.raw.correcto);

        ocho = MediaPlayer.create(NumberZero.this, R.raw.ocho);
        tres = MediaPlayer.create(NumberZero.this, R.raw.tres);
        cero = MediaPlayer.create(NumberZero.this, R.raw.cero);
        cinco = MediaPlayer.create(NumberZero.this, R.raw.cinco);


        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!btThree.isFocusable()) {


                    Class[] classeN = new Class[11];
                    classeN[0] = NumberZero.class;
                    classeN[1] = NumberOne.class;
                    classeN[2] = NumberTwo.class;
                    classeN[3] = NumberThree.class;
                    classeN[4] = NumberFour.class;
                    classeN[5] = NumberFive.class;
                    classeN[6] = NumberSix.class;
                    classeN[7] = NumberSeven.class;
                    classeN[8] = NumberEight.class;
                    classeN[9] = NumberNine.class;
                    classeN[10] = NumberTen.class;
                    Random rN = new Random();

                    startActivity(new Intent(NumberZero.this, classeN[rN.nextInt(classeN.length)]));
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

        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cero.start();
            }
        });



    }

    View.OnLongClickListener longclickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            if (v.getId() == R.id.bt_three) {

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

                    if (view.getId() == R.id.bt_three && v.getId() == R.id.target_three) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivThree.setVisibility(View.GONE);
                        newParent.addView(view);
                        correct.start();
                        btThree.setFocusable(false);

                    } else {
                        MediaPlayer media = MediaPlayer.create(NumberZero.this, R.raw.resorte);
                        media.start();

                    }


                    break;

            }

            return true;
        }
    };

    public void iniciarNumberZero(View v){
        Intent i = new Intent(this, NumberZero.class);
        startActivity(i);
    }

}
