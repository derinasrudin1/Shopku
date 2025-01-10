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
        checkLoginStatus();
        // Timer untuk splash screen
        new Handler().postDelayed(() -> {
            // Pindah ke MainActivity setelah 3 detik
            Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 1000); // Durasi 3 detik
    }

        private void checkLoginStatus() {
            SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);

            boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
            long lastLoginTime = sharedPreferences.getLong("lastLoginTime", 0);

            // Hitung durasi sejak login terakhir
            long currentTime = System.currentTimeMillis();
            long duration = currentTime - lastLoginTime;

            // 2 jam dalam milidetik: 2 * 60 * 60 * 1000
            if (isLoggedIn && duration <= 2 * 60 * 60 * 1000) {
                // Pengguna masih login, lanjut ke halaman utama
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            } else {
                // Durasi login habis, minta login ulang
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false); // Reset login status
                editor.apply();

                startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
            }

            finish(); // Tutup layar splash atau activity ini
        }


    }
