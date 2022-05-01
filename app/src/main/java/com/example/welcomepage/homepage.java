package com.example.welcomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class homepage extends AppCompatActivity {

    Button search;
    Button view;
    DBHelper DB;
    DB1Helper DB1;
    EditText nametext;
    EditText localitytext;
    EditText jobtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        search = (Button) findViewById(R.id.search);
        view = (Button) findViewById(R.id.showprofile);
        nametext = (EditText) findViewById(R.id.name);
        localitytext = (EditText) findViewById(R.id.locality);
        jobtext = (EditText) findViewById(R.id.jobdesc);
        DB = new DBHelper(this);
        DB1 = new DB1Helper(this);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nametext.getText().toString();
                Cursor res = DB.OwnerData(name);
                if(res.getCount()==0){
                    Toast.makeText(homepage.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Contact No. :"+res.getString(2)+"\n");
                    buffer.append("Age :"+res.getString(3)+"\n");
                    buffer.append("Address :"+res.getString(4)+"\n");
                    buffer.append("Email Id :"+res.getString(5)+"\n");
                    buffer.append("Gender :"+res.getString(6)+"\n");
                    buffer.append("Aadhar No. :"+res.getString(7)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(homepage.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nametext.getText().toString();
                String local = localitytext.getText().toString();
                String jobd = jobtext.getText().toString();
                Cursor res = DB1.OwnerData(local,jobd);
                if(res.getCount()==0){
                    Toast.makeText(homepage.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Contact No. :"+res.getString(2)+"\n");
                    buffer.append("Age :"+res.getString(4)+"\n");
                    buffer.append("Address :"+res.getString(5)+"\n");
                    buffer.append("Experience :"+res.getString(3)+"\n");
                    buffer.append("Minimum Wages :"+res.getString(6)+"\n");
                    buffer.append("Gender :"+res.getString(7)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(homepage.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }
}