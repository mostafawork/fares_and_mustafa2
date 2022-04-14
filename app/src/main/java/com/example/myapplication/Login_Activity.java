package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText user_name, user_password;
    Button login, register;
    RadioGroup rad;
    RadioButton java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = findViewById(R.id.user_name);
        user_password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        rad = findViewById(R.id.rad);
        java = findViewById(R.id.java);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = user_name.getText().toString().trim();
                String password = user_password.getText().toString().trim();
                if (userName.isEmpty()) {
                    Toast.makeText(Login_Activity.this, R.string.enterName, Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(Login_Activity.this, R.string.userpasseord, Toast.LENGTH_SHORT).show();
                }

                if (!password.isEmpty() && !userName.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), Game_Activity.class);
                    startActivity(intent);
                }

            }
        });


    }
}