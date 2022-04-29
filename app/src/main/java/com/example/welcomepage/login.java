package com.example.welcomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    Button loginbtn_1;
    EditText username_text;
    EditText password_text;
    EditText savedmsg_text;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbtn_1 = (Button) findViewById(R.id.loginbtn1);

        loginbtn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                username_text = (EditText) findViewById(R.id.usernametext);
                password_text = (EditText) findViewById(R.id.passwordtext);
                savedmsg_text = (EditText) findViewById(R.id.savedmsgtext);
                savedmsg_text.setText("Welcome "+username_text.getText().toString()+" !");
            }
        });

        TextView create = (TextView) findViewById(R.id.create) ;
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });
        button = (Button) findViewById(R.id.loginbtn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homepage();
            }
        });

    }

    public void homepage(){
        Intent intent = new Intent(this,homepage.class);
        startActivity(intent);
    }

    public void create ()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

