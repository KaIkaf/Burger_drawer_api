package com.example.burgerloginapi.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerloginapi.R;
import com.example.burgerloginapi.burgerdrawer.MainActivityBurger;

public class Splashscrenn extends AppCompatActivity {
    private static  final String prefname = "MyPrefFile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screnn);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences settings = getSharedPreferences(prefname, MODE_PRIVATE);

                String username = settings.getString("username", "No Username Found");

                if (username.equalsIgnoreCase("No Username Found")) {
                    // intent to login
                    Intent intent = new Intent(Splashscrenn.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // intent to home
                    Intent intent = new Intent(Splashscrenn.this, MainActivityBurger.class);
                    startActivity(intent);
                    finish();
                }


            }

        },2000);
            }
        }
