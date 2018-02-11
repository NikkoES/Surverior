package uinbdg.developer.surveriorapps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uinbdg.developer.surveriorapps.R;
import uinbdg.developer.surveriorapps.utils.DbHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button reg;
    private TextView loginForm;
    private EditText username, password, namaLengkap, noHp, alamat;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        reg = (Button)findViewById(R.id.btnReg);
        loginForm = (TextView)findViewById(R.id.loginForm);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        namaLengkap = (EditText)findViewById(R.id.namaLengkap);
        noHp = (EditText)findViewById(R.id.noHp);
        alamat = (EditText)findViewById(R.id.alamat);
        reg.setOnClickListener(this);
        loginForm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnReg:
                register();
                break;
            case R.id.loginForm:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    public void register(){
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String nama = namaLengkap.getText().toString();
        String hp = noHp.getText().toString();
        String almt = alamat.getText().toString();
        if(user.isEmpty() && pass.isEmpty() && nama.isEmpty() && hp.isEmpty() && almt.isEmpty()){
            displayToast("Username/Password/Name/Phone Number/Address field can't be empty");
        }
        else{
            db.addUser(user,pass,nama,hp,almt);
            displayToast("User Registered");
            finish();
        }
    }
    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
}
