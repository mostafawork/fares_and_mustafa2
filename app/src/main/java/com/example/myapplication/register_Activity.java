package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = user_name.getText().toString().trim();
                String password_now= password.getText().toString().trim();
                String emailAddress = email_address.getText().toString().trim();
                String fullName = full_name.getText().toString().trim();
                String password_re = password.getText().toString().trim();

                if (userName.isEmpty()){
                    Toast.makeText(register_Activity.this, R.string.enterName, Toast.LENGTH_SHORT).show();
                }else if (fullName.isEmpty()){
                    Toast.makeText(register_Activity.this, R.string.enterName, Toast.LENGTH_SHORT).show();
                }else if (emailAddress.isEmpty()){
                    Toast.makeText(register_Activity.this, R.string.emailAddress, Toast.LENGTH_SHORT).show();
                }else if (password_now.isEmpty()){
                    Toast.makeText(register_Activity.this, R.string.userpasseord, Toast.LENGTH_SHORT).show();
                }else if (password_re.isEmpty()){
                    Toast.makeText(register_Activity.this, R.string.userpasseordre, Toast.LENGTH_SHORT).show();
                }
                if (male.isChecked()||female.isChecked()){
                    Toast.makeText(register_Activity.this, R.string.gender, Toast.LENGTH_SHORT).show();

                }
            }
        });




    }
}