package com.example.welcomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.Toast;
import android.widget.Toast;

public class signinowner extends AppCompatActivity {

    Button button1;
    Button savebtn;
    Button signinbtn;
    EditText name_text;
    EditText age_text;
    EditText email_text;
    EditText address_text;
    EditText aadhar_text;
    EditText phone_text;
    EditText gender_text;
    EditText job_req;
    EditText password_text;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinowner);
        name_text = (EditText) findViewById(R.id.nametext);
        age_text = (EditText) findViewById(R.id.agetext);
        phone_text = (EditText) findViewById(R.id.phonetext);
        email_text = (EditText) findViewById(R.id.emailtext);
        address_text = (EditText) findViewById(R.id.addresstext);
        aadhar_text = (EditText) findViewById(R.id.aadhartext);
        gender_text = (EditText) findViewById(R.id.gendertext);
        job_req = (EditText) findViewById(R.id.jobreqtext);
        password_text = (EditText) findViewById(R.id.passwordtext);
        DB = new DBHelper(this);


        savebtn = (Button) findViewById(R.id.button2);

        savebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                String name = name_text.getText().toString();
                String age = age_text.getText().toString();
                String phone = phone_text.getText().toString();
                String email = email_text.getText().toString();
                String gender = gender_text.getText().toString();
                String address = address_text.getText().toString();
                String aadhar = aadhar_text.getText().toString();
                String jobreq = job_req.getText().toString();
                String password = password_text.getText().toString();

                if(name.equals("")||password.equals("")||age.equals("")||email.equals("")||phone.equals("")||gender.equals("")||address.equals("")||aadhar.equals(""))
                    Toast.makeText(signinowner.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                        Boolean checkuser = DB.checkusername(name);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(name, password, phone, age, address, email, gender, aadhar);
                            if(insert==true){
                                Toast.makeText(signinowner.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(signinowner.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(signinowner.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }





            }
        });


        signinbtn = (Button) findViewById(R.id.signin);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                login();
            }
            });

    }
    public void login(){
        Intent intent = new Intent(this,homepage.class);
        startActivity(intent);
    }

        






}