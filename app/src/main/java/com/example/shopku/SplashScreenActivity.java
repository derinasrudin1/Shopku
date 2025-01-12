package com.example.shopku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopku.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Atur layout splash screen
        setContentView(R.layout.splash_screen);
        // Timer untuk splash screen
        new Handler().postDelayed(() -> {
            // Pindah ke MainActivity setelah 3 detik
            Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 1000); // Durasi 3 detik
    }




    }
