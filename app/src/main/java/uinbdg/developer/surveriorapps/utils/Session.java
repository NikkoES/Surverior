package uinbdg.developer.surveriorapps.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by muhammadmishlahulumam on 11/02/18.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("surveymultibahasa", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean loggedin, String user, String pass) {
        editor.putBoolean("loggedInmode", loggedin);
        if (user != null && pass != null) {
            //encrypt
            //user = md6(user);
            //pass = md5(pass);
            editor.putString("user", user);
            editor.putString("pass", pass);
        }
        editor.commit();
    }

    public boolean loggedin() {
        return prefs.getBoolean("loggedInmode", false);
    }
}
