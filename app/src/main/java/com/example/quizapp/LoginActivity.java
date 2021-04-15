package com.example.quizapp;

import android.content.Intent;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.Data.UserDao;
import com.example.quizapp.Data.UserDataBase;
import com.example.quizapp.Model.User;

public class LoginActivity extends AppCompatActivity {
    Button login, register;
    EditText etEmail, etPass;
    //private DbHelper db;
    UserDao db;
    UserDataBase dataBase;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //db = new DbHelper(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnReg);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);


        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();
        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this,StartActivity.class));
            finish();
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPass.getText().toString().trim();
                session.setLoggedin(true);

                User user = db.getUser(email, password);
                if (user != null) {
                    Intent i = new Intent(LoginActivity.this, StartActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

        /*login.setOnClickListener(this);
        register.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnReg:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:

        }
    }

    private void login(){

        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if(db.getUser(email,pass)){
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }*/
}