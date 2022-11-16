package com.example.mycoffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username, password,repassword;
    Button signup;
    TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pswrd1);
        repassword= (EditText) findViewById(R.id.pswrd2);
        signup = (Button) findViewById(R.id.Register);
        signin = (TextView) findViewById(R.id.signIn);

        DBHelper MyDb = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText( Register.this, "fill all fields", Toast.LENGTH_SHORT ).show();
                }
                else{
                        if(pass.equals(repass)){
                            Boolean usercheckResult = MyDb.checkusername(user);
                            if(usercheckResult == false){
                                Boolean regResult = MyDb.insertData(user,pass);
                                if(regResult == true){
                                    Toast.makeText(Register.this,"Registration Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),Menu.class);
                                    startActivity(intent);

                                }
                                else{
                                    Toast.makeText(Register.this,"Registration failed",Toast.LENGTH_SHORT).show();
                                }

                            }
                            else
                            {
                                Toast.makeText(Register.this,"User Already Exists.\n Please sign In", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{

                            Toast.makeText(Register.this,"Password Not matching",Toast.LENGTH_SHORT).show();
                              }
                }
            }
        });
            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),MainMenu.class);
                    startActivity(intent);

                }
            });

    }
}