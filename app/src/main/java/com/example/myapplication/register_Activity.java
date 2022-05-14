package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.provider.MediaStore;
import android.net.Uri;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class register_Activity extends AppCompatActivity {

    ImageView edit_img;
    EditText full_name, email_address, user_name, password, password_re;
    RadioGroup radio_group;
    RadioButton male, female;
    Button save;
    DBHelper DB;
    DatePickerDialog datePickerDialog;
    TextView dateBaker;

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
        dateBaker = findViewById(R.id.date_baker_register);
        DB = new DBHelper(this);


        dateBaker.setText(getTodaysDate());
        initDatePicker();
        edit_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 111);

            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("Save", Context.MODE_PRIVATE);
        boolean s1 = sharedPreferences.getBoolean("login", false);
        if (s1) {
            Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
            startActivity(intent);
            finish();
        }


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = user_name.getText().toString().trim();
                String password_now = password.getText().toString().trim();
                String emailAddress = email_address.getText().toString().trim();
                String fullName = full_name.getText().toString().trim();
                String password_re = password.getText().toString().trim();

                if (userName.isEmpty()) {
                    Toast.makeText(register_Activity.this, R.string.enterName, Toast.LENGTH_SHORT).show();
                } else if (fullName.isEmpty()) {
                    Toast.makeText(register_Activity.this, R.string.enterName, Toast.LENGTH_SHORT).show();
                } else if (emailAddress.isEmpty()) {
                    Toast.makeText(register_Activity.this, R.string.emailAddress, Toast.LENGTH_SHORT).show();
                } else if (password_now.isEmpty()) {
                    Toast.makeText(register_Activity.this, R.string.userpasseord, Toast.LENGTH_SHORT).show();
                } else if (password_re.isEmpty()) {
                    Toast.makeText(register_Activity.this, R.string.userpasseordre, Toast.LENGTH_SHORT).show();
                }
                if (male.isChecked() || female.isChecked()) {
                    Toast.makeText(register_Activity.this, R.string.gender, Toast.LENGTH_SHORT).show();
                }
                if (!userName.isEmpty() && !fullName.isEmpty() && !emailAddress.isEmpty() && !password_now.isEmpty() && !password_re.isEmpty()) {
                    Boolean checkuser = DB.checkusername(userName);
                    if (!checkuser) {
                        Boolean insert = DB.insertData(userName, password_now);
                        if (insert) {
                            Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                            SharedPreferences.Editor myEdit = sharedPreferences.edit();
                            myEdit.putBoolean("rem", radio_group.isClickable());
                            myEdit.putString("user", userName);
                            myEdit.putString("password", password_now);
                            myEdit.commit();
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }

        });

        dateBaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });


    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateBaker.setText(date);
            }
        };
        Calendar calendar = Calendar.getInstance();

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.BUTTON_POSITIVE;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {

        return getMonthFormat(month) + " " + day + " " + year;

    }

//هين حطينا لما يضغط على الشهر يظهر في Textview اسم الشهر


    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

//default شهر JAN
        return "JAN";

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111) {
            if (resultCode == MainActivity.RESULT_OK) {
                final Uri uri = data.getData();
                InputStream in;
                try {
                    in = getContentResolver().openInputStream(uri);
                    final Bitmap selected_img = BitmapFactory.decodeStream(in);
                    edit_img.setImageBitmap(selected_img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "An error occured!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "You didn't pick an image!", Toast.LENGTH_LONG).show();
            }
        }
    }
}




