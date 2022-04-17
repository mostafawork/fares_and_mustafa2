package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class register_Activity extends AppCompatActivity {

    View edit_img;
    EditText full_name, email_address, user_name, password, password_re;
    RadioGroup radio_group;
    RadioButton male, female;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_img = findViewById(R.id.edit_img);
        full_name = findViewById(R.id.full_name);
        email_address = findViewById(R.id.email_address);
        user_name = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        password_re = findViewById(R.id.password_re);
        radio_group = findViewById(R.id.radio_group);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        save = findViewById(R.id.save);


    }
}