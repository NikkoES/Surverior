package uinbdg.developer.surveriorapps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uinbdg.developer.surveriorapps.DashboardActivity;
import uinbdg.developer.surveriorapps.R;
import uinbdg.developer.surveriorapps.utils.DbHelper;
import uinbdg.developer.surveriorapps.utils.Session;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login, register;
    private EditText username, password;
    private TextView regForm;
    private DbHelper db;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        regForm = (TextView)findViewById(R.id.regForm);
        login.setOnClickListener(this);
        regForm.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnLogin:
                login();
                break;
            case R.id.regForm:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:
                break;
        }
    }

    private void login(){
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(db.getUser(user,pass)){
            session.setLoggedin(true, user, pass);
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong username/password",Toast.LENGTH_SHORT).show();
        }
    }
}
