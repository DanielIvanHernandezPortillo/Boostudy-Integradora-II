package com.boostudy.danielarguello.boostudy.num;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.boostudy.danielarguello.boostudy.R;
import com.boostudy.danielarguello.boostudy.group.AgroupOne;
import com.boostudy.danielarguello.boostudy.group.AgroupThree;
import com.boostudy.danielarguello.boostudy.group.AgroupTwo;
import com.boostudy.danielarguello.boostudy.group.AgroupZero;

import java.util.Random;

/**
 * Created by DANIEL ARGUELLO on 22/03/2017.
 */

public class MainNum  extends Activity {

    private Button btOption1;
    private Button btOption2;
    private Button btOption3;
    private Button btOption4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_num);

        btOption1 = (Button) findViewById(R.id.bt_1);
        btOption2 = (Button) findViewById(R.id.bt_3);
        btOption3 = (Button) findViewById(R.id.bt_4);
        btOption4 = (Button) findViewById(R.id.bt_conjunto);


        btOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),NumberOneOne.class);
                startActivity(intent);
                finish();

            }
        });

        btOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),TenAndTen.class);
                startActivity(intent);
                finish();

            }
        });
        btOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),NumberTwo.class);
                startActivity(intent);
                finish();

            }
        });
        btOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Class[] classes = new Class[4];
                classes[0] = AgroupZero.class;
                classes[1] = AgroupOne.class;
                classes[2] = AgroupTwo.class;
                classes[3] = AgroupThree.class;

                Random r = new Random();


                startActivity(new Intent(MainNum.this, classes[r.nextInt(classes.length)]));
                finish();


            }
        });


    }






}
