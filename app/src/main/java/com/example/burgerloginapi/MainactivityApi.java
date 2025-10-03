package com.example.burgerloginapi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.burgerloginapi.burgerdrawer.liga1fragment;
import com.example.burgerloginapi.burgerdrawer.ligaspanyolfragment;

public class MainactivityApi extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.drawer_layout, new liga1fragment());
            transaction.commit();
        } else if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.drawer_layout, new ligaspanyolfragment());
            transaction.commit();

        }

    }
}
