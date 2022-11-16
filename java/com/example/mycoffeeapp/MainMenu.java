package com.example.mycoffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    EditText username,password;
    Button login;
    TextView signup;

    DBHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        username = (EditText) findViewById(R.id.PersonName);
        password = (EditText) findViewById(R.id.pswrd);
        login = (Button) findViewById(R.id.login);
        MyDb = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(MainMenu.this,"Please Enter the credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                   Boolean result = MyDb.checkusernamePassword(user, pass);
                    if(result == true){
                        Intent intent = new Intent(getApplicationContext(),Menu.class);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(MainMenu.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup = (TextView)findViewById(R.id.SignUP);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);


            }
        });
    }
}