package com.example.burgerloginapi.burgerdrawer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.burgerloginapi.R;
import com.google.android.material.navigation.NavigationView;



public class MainActivityBurger extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_burger);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.clubliga1) {
                    showLiga1Page();
                } else if (itemId == R.id.clubliga2) {
                    showLigaSpanyolPage();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new Profilefragment())
                            .commit();
                    getSupportActionBar().setTitle("Profile");
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void showLiga1Page() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new liga1fragment())
                .commit();
        getSupportActionBar().setTitle("Liga1");
    }

    private void showLigaSpanyolPage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new ligaspanyolfragment())
                .commit();
        getSupportActionBar().setTitle("LigaSpanyol");
    }
}