package com.example.myapplication;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText user_name_login, password_login;
    Button login, register;
    RadioGroup radioGroup;
    CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name_login = findViewById(R.id.user_name_login);
        password_login = findViewById(R.id.password_login);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        radioGroup = findViewById(R.id.radio_group);
        remember = findViewById(R.id.remember);

        SharedPreferences sharedPreferences = getSharedPreferences("Save",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        boolean rem = sharedPreferences.getBoolean("rem", false);
        String user = sharedPreferences.getString("user","");
        String password_this = sharedPreferences.getString("password","");
        myEdit.putBoolean("login",rem);
        myEdit.commit();

        user_name_login = findViewById(R.id.user_name_login);
        password_login = findViewById(R.id.password_login);
        if (user!=null) {
            user_name_login.setText(user);
            password_login.setText(password_this);
        }

        boolean s1 = sharedPreferences.getBoolean("login", false);
        if (s1){
            Intent intent = new Intent(getApplicationContext(), Game_Activity.class);
            startActivity(intent);
            finish();
        }

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userName = user_name_login.getText().toString().trim();
                    String password = password_login.getText().toString().trim();
                    if (userName.isEmpty()) {
                        Toast.makeText(Login_Activity.this, R.string.enterName, Toast.LENGTH_SHORT).show();
                    } else if (password.isEmpty()) {
                        Toast.makeText(Login_Activity.this, R.string.userpasseord, Toast.LENGTH_SHORT).show();
                    }

                    if (!password.isEmpty() && !userName.isEmpty()) {
                        Intent intent = new Intent(getApplicationContext(), Game_Activity.class);
                        SharedPreferences.Editor myEdit = sharedPreferences.edit();
                        myEdit.putBoolean("rem",remember.isChecked());
                        myEdit.commit();
                        startActivity(intent);
                        finish();
                    }

                }
            });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), register_Activity.class);
startActivity(intent);
            }
        });


        }

}
