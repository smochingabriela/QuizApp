package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.quizapp.Model.User;

public class MainActivity extends AppCompatActivity {
    /*private Button btnLogout;
    private Session session;
    private TextView tvUser;
    //private DbHelper db;
    private User user;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*//db = new DbHelper(this);
        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        user = (User) getIntent().getSerializableExtra("User");

        tvUser = findViewById(R.id.tvUser);

        if (user != null) {
            tvUser.setText("WELCOME " + user.getUserName());
        }
    }

    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }*/

    }
}