package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.Data.UserDao;
import com.example.quizapp.Data.UserDataBase;
import com.example.quizapp.Model.User;

public class RegisterActivity extends AppCompatActivity  {
    Button reg;
    TextView tvLogin;
    EditText etName, etEmail, etPass;
    //private DbHelper db;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //db = new DbHelper(this);

        reg = (Button) findViewById(R.id.btnReg);
        tvLogin = (TextView) findViewById(R.id.tvLogin);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);

        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPass.getText().toString().trim();


                if (!(etName.equals("") && etEmail.equals("") && etPass.equals(""))) {
                    User user = new User(userName, password, email);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(RegisterActivity.this, "Is empty", Toast.LENGTH_SHORT).show();

                }
            }
        });
       /* reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
            default:

        }
    }

    private void register(){
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if(name.isEmpty() && email.isEmpty() && pass.isEmpty()){
            displayToast("Name/email/password field empty");
        }else{
            db.addUser(name,email,pass);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }*/
    }
}