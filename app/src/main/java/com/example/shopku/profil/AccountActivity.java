package com.example.shopku.profil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;
import com.example.shopku.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewAccountOptions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<AccountOption> options = new ArrayList<>();
        options.add(new AccountOption(R.drawable.ic_profil, "Profil"));
        options.add(new AccountOption(R.drawable.ic_cart, "Pesanan Saya"));
        options.add(new AccountOption(R.drawable.ic_payment, "Metode Pembayaran"));
        options.add(new AccountOption(R.drawable.ic_notifications, "Pemberitahuan"));
        options.add(new AccountOption(R.drawable.ic_help, "Pusat Bantuan"));
        options.add(new AccountOption(R.drawable.ic_add, "Undang Teman"));
        options.add(new AccountOption(R.drawable.ic_logout, "Keluar"));

        AccountOptionsAdapter adapter = new AccountOptionsAdapter(options, this, position -> {
            switch (position) {
                case 0: // Profil
                    Intent intent = new Intent(AccountActivity.this, Profil.class);
                    startActivity(intent);
                    break;
                case 1: // Pesanan Saya
                    Toast.makeText(this, "Pesanan Saya clicked", Toast.LENGTH_SHORT).show();
                    break;
                case 2: // Metode Pembayaran
                    Toast.makeText(this, "Metode Pembayaran clicked", Toast.LENGTH_SHORT).show();
                    break;
                case 3: // Pemberitahuan
                    Toast.makeText(this, "Pemberitahuan clicked", Toast.LENGTH_SHORT).show();
                    break;
                case 4: // Pusat Bantuan
                    Toast.makeText(this, "Pusat Bantuan clicked", Toast.LENGTH_SHORT).show();
                    break;
                case 5: // Undang Teman
                    Toast.makeText(this, "Undang Teman clicked", Toast.LENGTH_SHORT).show();
                    break;
                case 6: // Keluar
                    Toast.makeText(this, "Anda telah Logout", Toast.LENGTH_SHORT).show();
                    // Handle logout logic here
                    logout();

                    break;
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void logout() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // Hapus semua data login
        editor.apply();

        // Arahkan ke layar login
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}

