package com.example.burgerloginapi.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.burgerloginapi.R;
import com.example.burgerloginapi.burgerdrawer.MainActivityBurger;

//mainactivitylogin langkah awal
public class MainActivity extends AppCompatActivity {
    private static final String prefname = "MyPrefFile";
    Button btnLogin ;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        btnLogin = findViewById(R.id.btnlogin);
        username = findViewById(R.id.usrnme);
        password = findViewById(R.id.pswrd);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pw = password.getText().toString();

                if (user.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Masukkan username terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pw.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Masukkan password terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (user.equals("admin") && pw.equals("admin")) {
                    editor.putString("username", username.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivityBurger.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Gagal Login", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}