package com.boostudy.danielarguello.boostudy.registro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boostudy.danielarguello.boostudy.R;



public class Registro extends Activity {
    private EditText edtName;
    private EditText edtPass;

    private Button btRegistro;
    private DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);




        db= new DBHelper(this);
        edtName = (EditText)findViewById(R.id.edtUser);
        edtPass = (EditText)findViewById(R.id.edtPass);

        btRegistro = (Button)findViewById(R.id.btRg);


    }


    public void registrar(View v){
        String user = edtName.getText().toString();
        String pass= edtPass.getText().toString();

        if (user.isEmpty()) {
            displayToast("El nombre está vacío");
            onStop();
        }
        if (pass.isEmpty()){
            displayToast("La contraseña está vacía ");
            onStop();
        }else{

            displayToast("Usuario registrado");

        }
        if (!user.isEmpty() && !pass.isEmpty()){
            db.addUser(user,pass);
            displayToast("Usuario registrado");
            finish();
        }

    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }



    public void cancelar(View v){
        finish();

    }


}
