package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Game_Activity extends AppCompatActivity {

    TextView score, tv_name , tv_age;
    Button enter , check , new_game;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = findViewById(R.id.score);
        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);
        enter = findViewById(R.id.enter);
        check = findViewById(R.id.check);
        new_game = findViewById(R.id.new_game);


    }
}