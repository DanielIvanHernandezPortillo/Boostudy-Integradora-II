package com.boostudy.danielarguello.boostudy.registro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boostudy.danielarguello.boostudy.R;

public class MainActivity extends Activity implements View.OnClickListener{
private EditText etName;
private EditText etContra;
private Button btLogin;
private Button btRegister;
private DBHelper db;
private Session session;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);




        db= new DBHelper(this);
        session = new Session(this);
        etName = (EditText)findViewById(R.id.edtNombreU);
        etContra = (EditText)findViewById(R.id.edtContra);
        btLogin= (Button)findViewById(R.id.btIngresar);
        btRegister = (Button)findViewById(R.id.btRegistro);

        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);

        if (session.loggedin()){
        startActivity(new Intent(MainActivity.this, com.boostudy.danielarguello.boostudy.MainActivity.class));
        finish();
        }
        }


@Override
public void onClick(View v) {
        switch (v.getId()){
        case R.id.btIngresar:
        login();
        break;
        case  R.id.btRegistro:
        startActivity(new Intent(MainActivity.this, Registro.class));
        break;

default:

        break;

        }
        }

public void login(){
        String email = etName.getText().toString();
        String pass = etContra.getText().toString();

        if(db.getUser(email,pass)){
        session.setLoggedin(true);
        startActivity(new Intent(MainActivity.this, com.boostudy.danielarguello.boostudy.MainActivity.class));
        finish();
        }else{
        Toast.makeText(getApplicationContext(), "Nombre o contraseña invalido",Toast.LENGTH_SHORT).show();
        }

        }
        }