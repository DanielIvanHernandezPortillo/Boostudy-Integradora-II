package com.boostudy.danielarguello.boostudy.figure;

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

import com.boostudy.danielarguello.boostudy.MainActivity;
import com.boostudy.danielarguello.boostudy.R;

import java.util.Random;


/**
 * Created by DANIEL  on 16/02/2017.
 */

public class FigureNameSix extends Activity {

    LinearLayout targetOne;
    LinearLayout targetTwo;
    LinearLayout targetThree;
    LinearLayout targetFour;

    Button btOne;
    Button btMain;
    Button btInfo;

    Button btSiguiente;
    MediaPlayer correct;
    MediaPlayer figure;

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
        setContentView(R.layout.figure_six);

        targetOne = (LinearLayout) findViewById(R.id.target_one);
        targetTwo = (LinearLayout) findViewById(R.id.target_two);
        targetThree = (LinearLayout) findViewById(R.id.target_three);
        targetFour = (LinearLayout) findViewById(R.id.target_four);

        ivOne = (ImageView) findViewById(R.id.iv_one);
        ivTwo = (ImageView) findViewById(R.id.iv_two);
        ivThree = (ImageView) findViewById(R.id.iv_three);
        ivFour = (ImageView) findViewById(R.id.iv_four);


        btOne = (Button) findViewById(R.id.bt_one);
        btMain = (Button) findViewById(R.id.bt_main);
        btInfo = (Button) findViewById(R.id.bt_info);
        btSiguiente = (Button) findViewById(R.id.bt_siguiente);

        targetOne.setOnDragListener(dragListener);
        targetTwo.setOnDragListener(dragListener);
        targetThree.setOnDragListener(dragListener);
        targetFour.setOnDragListener(dragListener);


        btOne.setOnLongClickListener(longclickListener);

        correct = MediaPlayer.create(FigureNameSix.this, R.raw.correcto);


        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btOne.isFocusable()) {


                    Class[] classF = new Class[8];
                    classF[0] = FigureNameOne.class;
                    classF[1] = FigureNameTwo.class;
                    classF[2] = FigureNameThree.class;
                    classF[3] = FigureNameFour.class;
                    classF[4] = FigureNameFive.class;
                    classF[5] = FigureNameSix.class;
                    classF[6] = FigureNameSeven.class;
                    classF[7] = FigureNameEight.class;


                    Random rF = new Random();

                    startActivity(new Intent(FigureNameSix.this, classF[rF.nextInt(classF.length)]));
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
                MediaPlayer figure = MediaPlayer.create(FigureNameSix.this, R.raw.trapecio);
                figure.start();
            }
        });

        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer info = MediaPlayer.create(FigureNameSix.this, R.raw.ayuda_figuras);
                info.start();
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

            } else {
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

                case DragEvent.ACTION_DROP:

                    if (view.getId() == R.id.bt_one && v.getId() == R.id.target_four) {
                        LinearLayout oldparent = (LinearLayout) view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;




                        newParent.addView(view);
                        correct.start();
                        btOne.setFocusable(false);



                    } else {
                        MediaPlayer media = MediaPlayer.create(FigureNameSix.this, R.raw.resorte);
                        media.start();

                    }


                    break;

            }

            return true;
        }
    };






}