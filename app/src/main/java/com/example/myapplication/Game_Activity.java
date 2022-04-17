package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Game_Activity extends AppCompatActivity {

    TextView score, tv_name , tv_age;
    Button check , new_game;
    EditText enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        SharedPreferences sharedPreferences = getSharedPreferences("Save",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        boolean rem = sharedPreferences.getBoolean("rem", false);


        myEdit.putBoolean("login",rem);
        myEdit.commit();

        score = findViewById(R.id.score);
        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);
        enter = findViewById(R.id.enter);
        check = findViewById(R.id.check);
        new_game = findViewById(R.id.new_game);


    }
}