package com.boostudy.danielarguello.boostudy.registro;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Karla on 20/03/2017.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }
    public void setLoggedin (boolean loggedin){
        editor.putBoolean("loggedInmode",loggedin);
        editor.commit();
    }
    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode",false);
    }
}
