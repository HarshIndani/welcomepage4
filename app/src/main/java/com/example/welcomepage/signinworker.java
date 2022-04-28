package com.example.welcomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signinworker extends AppCompatActivity {
    Button button1;
    Button signin;
    EditText wname_text;
    EditText wage_text;
    EditText locality_text;
    EditText waddress_text;
    EditText waadhar_text;
    EditText wphone_text;
    EditText experience_text;
    EditText worker_wage_text;
    EditText jobpref_text;
    EditText gender_text;
    EditText password_text;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinworker);
        wname_text = (EditText) findViewById(R.id.wnametext);
        wage_text = (EditText) findViewById(R.id.wagetext);
        wphone_text = (EditText) findViewById(R.id.wphonetext);
        experience_text = (EditText) findViewById(R.id.experiencetext);
        waddress_text = (EditText) findViewById(R.id.waddresstext);
        waadhar_text = (EditText) findViewById(R.id.widprooftext);
        worker_wage_text = (EditText) findViewById(R.id.worker_wagetext);
        jobpref_text = (EditText) findViewById(R.id.jobpref);
        gender_text = (EditText) findViewById(R.id.gender);
        locality_text = (EditText) findViewById(R.id.localitytext);
        password_text = (EditText) findViewById(R.id.password);
        DB = new DBHelper(this);

        button1 = (Button) findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = wname_text.getText().toString();
                String age = wage_text.getText().toString();
                String phone = wphone_text.getText().toString();
                String experience = experience_text.getText().toString();
                String address = waddress_text.getText().toString();
                String aadhar = waadhar_text.getText().toString();
                String email = worker_wage_text.getText().toString();
                String jobpref = jobpref_text.getText().toString();
                String locality = locality_text.getText().toString();
                String password = password_text.getText().toString();
                String gender = gender_text.getText().toString();

                if(name.equals("")||password.equals("")||age.equals("")||email.equals("")||phone.equals("")||gender.equals("")||address.equals("")||aadhar.equals(""))
                    Toast.makeText(signinworker.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = DB.checkusername(name);
                    if(checkuser==false){
                        Boolean insert = DB.insertData(name, password, phone, age, address, email, gender, aadhar);
                        if(insert==true){
                            Toast.makeText(signinworker.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),login.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(signinworker.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signinworker.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin = (Button) findViewById(R.id.wsignin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    public void login() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
