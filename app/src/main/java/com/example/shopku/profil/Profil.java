package com.example.shopku.profil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopku.R;

public class Profil extends AppCompatActivity {

    // Deklarasi elemen UI
    private TextView tvNama, etNama, email, emailET, tglLahir, etTgl, kelamin, etKelamin, noTelp, etNoTelp;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil); // Pastikan nama file XML adalah activity_profile.xml

        // Inisialisasi elemen UI
        tvNama = findViewById(R.id.tvNama);
        etNama = findViewById(R.id.etNama);
        email = findViewById(R.id.email);
        emailET = findViewById(R.id.emailET);
        tglLahir = findViewById(R.id.tglLahir);
        etTgl = findViewById(R.id.etTgl);
        kelamin = findViewById(R.id.kelamin);
        etKelamin = findViewById(R.id.etKelamin);
        noTelp = findViewById(R.id.noTelp);
        etNoTelp = findViewById(R.id.etNoTelp);
        btnSimpan = findViewById(R.id.simpan);

        // Set data awal (opsional, hanya contoh)
        etNama.setText("Nama");
        emailET.setText("@google.com");
        etTgl.setText("01/01/1990");
        etKelamin.setText("Laki-Laki");
        etNoTelp.setText("+628123456789");

    }
}
