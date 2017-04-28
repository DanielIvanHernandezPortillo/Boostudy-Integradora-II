package com.boostudy.danielarguello.boostudy;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.boostudy.danielarguello.boostudy.colores.LevelsColors;
import com.boostudy.danielarguello.boostudy.crias.CriasFour;
import com.boostudy.danielarguello.boostudy.crias.CriasOne;
import com.boostudy.danielarguello.boostudy.crias.CriasThree;
import com.boostudy.danielarguello.boostudy.crias.CriasTwo;
import com.boostudy.danielarguello.boostudy.figure.FigureNameEight;
import com.boostudy.danielarguello.boostudy.figure.FigureNameFive;
import com.boostudy.danielarguello.boostudy.figure.FigureNameFour;
import com.boostudy.danielarguello.boostudy.figure.FigureNameOne;
import com.boostudy.danielarguello.boostudy.figure.FigureNameSeven;
import com.boostudy.danielarguello.boostudy.figure.FigureNameSix;
import com.boostudy.danielarguello.boostudy.figure.FigureNameThree;
import com.boostudy.danielarguello.boostudy.figure.FigureNameTwo;
import com.boostudy.danielarguello.boostudy.animal.AnimalSong;
import com.boostudy.danielarguello.boostudy.animal.AnimalSongFour;
import com.boostudy.danielarguello.boostudy.animal.AnimalSongThree;
import com.boostudy.danielarguello.boostudy.animal.AnimalSongTwo;
import com.boostudy.danielarguello.boostudy.mayusculas.MayusFive;
import com.boostudy.danielarguello.boostudy.mayusculas.MayusFour;
import com.boostudy.danielarguello.boostudy.mayusculas.MayusOne;
import com.boostudy.danielarguello.boostudy.mayusculas.MayusSeven;
import com.boostudy.danielarguello.boostudy.mayusculas.MayusSix;
import com.boostudy.danielarguello.boostudy.mayusculas.MayusThree;
import com.boostudy.danielarguello.boostudy.mayusculas.MayusTwo;
import com.boostudy.danielarguello.boostudy.num.MainNum;
import com.boostudy.danielarguello.boostudy.registro.Session;
import com.boostudy.danielarguello.boostudy.vocal.LevelsVlowes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends Activity {

    /*
    Declarar instancias globales
     */
    private RecyclerView recycler;
    private AnimeAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private MediaPlayer song;
    private Button btLogout;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);


        //Session Start
        session = new Session(this);
        if (!session.loggedin()){
            logout();
        }
        btLogout = (Button)findViewById(R.id.bt_logout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
                finish();
            }
        });

        song = MediaPlayer.create(MainActivity.this, R.raw.songg);
        boolean play = getIntent().getBooleanExtra("cancion", true);
        if(play) {
            song.start();
        }
        // Inicializar Actividades
        List<Anime> items = new ArrayList<>();

        items.add(new Anime(R.drawable.leon, "Animales y \n Sonidos"));
        items.add(new Anime(R.drawable.cubo, "Figuras"));
        items.add(new Anime(R.drawable.pollito, "Crias"));
        items.add(new Anime(R.drawable.crayons, "Colores"));
        items.add(new Anime(R.drawable.numeros, "Numeros"));
        items.add(new Anime(R.drawable.vocales, "Vocales y \n Abecedario"));
        items.add(new Anime(R.drawable.a, "Minusculas y \n Mayusculas" ));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Crear un nuevo adaptador
        adapter = new AnimeAdapter(items);
        recycler.setAdapter(adapter);
        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recycler.getChildPosition(view);
                switch (position){
                    case 0:
                        Class[] classes = new Class[4];
                        classes[0] = AnimalSong.class;
                        classes[1] = AnimalSongTwo.class;
                        classes[2] = AnimalSongThree.class;
                        classes[3] = AnimalSongFour.class;

                        Random r = new Random();

                        //Intent i = new Intent(MainActivity.this, classes[r.nextInt(classes.length)]);
                        //startActivity(i);

                        startActivity(new Intent(MainActivity.this, classes[r.nextInt(classes.length)]));


                        break;
                    case 1:

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

                        startActivity(new Intent(MainActivity.this, classF[rF.nextInt(classF.length)]));
                        break;
                    case 2:

                        Class[] classeC = new Class[4];
                        classeC[0] = CriasOne.class;
                        classeC[1] = CriasTwo.class;
                        classeC[2] = CriasThree.class;
                        classeC[3] = CriasFour.class;

                        Random rC = new Random();

                        startActivity(new Intent(MainActivity.this, classeC[rC.nextInt(classeC.length)]));

                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, LevelsColors.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, MainNum.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, LevelsVlowes.class));

                        break;
                    case 6:

                        Class[] classeM = new Class[7];
                        classeM[0] = MayusOne.class;
                        classeM[1] = MayusTwo.class;
                        classeM[2] = MayusThree.class;
                        classeM[3] = MayusFour.class;
                        classeM[4] = MayusFive.class;
                        classeM[5] = MayusSix.class;
                        classeM[6] = MayusSeven.class;
                        Random rM = new Random();

                        startActivity(new Intent(MainActivity.this, classeM[rM.nextInt(classeM.length)]));
                        break;

                }


            }
        });

    }
    private void logout() {
        session.setLoggedin(false);
        Intent intent = new Intent(
                getApplicationContext(), com.boostudy.danielarguello.boostudy.registro.MainActivity.class);
        startActivity(intent);
        finish();

    }



}
