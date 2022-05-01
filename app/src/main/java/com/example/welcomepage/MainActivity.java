package com.example.welcomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button button;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.signinbtn);

        button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Signin_worker();
                }

        });
        button2 = (Button) findViewById(R.id.signin_owner);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signin_owner();
            }
        });
    }

    public void Login(){

        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void Signin_worker(){
        Intent intent = new Intent(this,signinworker.class);
        startActivity(intent);
    }
    public void Signin_owner() {
        Intent intent = new Intent(this, signinowner.class);
        startActivity(intent);
    }
}
