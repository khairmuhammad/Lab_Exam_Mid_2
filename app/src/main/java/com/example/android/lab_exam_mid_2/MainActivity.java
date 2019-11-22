package com.example.android.lab_exam_mid_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Login_Info", MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        editor.putString("username","admin");
//        editor.putString("password","1234");
//        editor.putBoolean("isLogin",false);
//        editor.commit();

        if (sharedPreferences.getBoolean("isLogin", false) == true) {
            intent = new Intent(this, Activity2.class);
            startActivity(intent);
        } else {
            return;
        }
    }

    public void onClick(View v)
    {
        user = (EditText) findViewById(R.id.edit_user);
        pass = (EditText) findViewById(R.id.edit_pass);
        sharedPreferences = getSharedPreferences("Login_Info",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (user.getText().toString().contentEquals(sharedPreferences.getString("username", ""))
                        && pass.getText().toString().contentEquals(sharedPreferences.getString("password", ""))) {

                    editor.putBoolean("isLogin", true).apply();
                    editor.commit();
                    Intent intent = new Intent(this, Activity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid password or username", Toast.LENGTH_SHORT).show();
                }
    }
}
