package com.example.raghu.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button b;
    Button search;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        b=(Button)findViewById(R.id.button);
        search=(Button)findViewById(R.id.button2);

        sharedpreferences=getSharedPreferences("mycontacts", Context.MODE_PRIVATE);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String RName=sharedpreferences.getString("Name",null);
                String RPhone=sharedpreferences.getString("Phone",null);

                et1.setText(RName);
                et2.setText(RPhone);



            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name=et1.getText().toString();
                String Phone=et2.getText().toString();

                SharedPreferences.Editor contacts=sharedpreferences.edit();
                contacts.putString("Name", Name);
                contacts.putString("Phone", Phone);
                contacts.commit();
                Toast.makeText(MainActivity.this,"CONTACT STORED",Toast.LENGTH_SHORT).show();


            }
        });




    }
}
