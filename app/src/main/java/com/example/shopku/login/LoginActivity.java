package com.example.shopku.login;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopku.DatabaseHelper;
import com.example.shopku.MainActivity;
import com.example.shopku.R;
import com.example.shopku.register.RegisterActivity;
import com.example.shopku.utils.PopupUtil;


public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvForgotPassword, tvRegister, tvNoteEmail,tvNotePassword;
    private DatabaseHelper databaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi view
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvRegister = findViewById(R.id.tvRegister);
        tvNoteEmail = findViewById(R.id.tvNoteEmail);
        tvNotePassword = findViewById(R.id.tvNotePassword);
        databaseHelper = new DatabaseHelper(this);




        // Klik tombol login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Email atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    boolean userExists = databaseHelper.checkUser(email, password);
                    if (userExists) {
//                        // Tampilkan animasi pop-up
                        PopupUtil.showPopup(LoginActivity.this, "Login Berhasil!"); // Memanggil popup utilitas


                        // Pindah ke MainActivity setelah beberapa detik
                        new Handler().postDelayed(() -> {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }, 2000); // Durasi 2 detik
                    } else {
                        Toast.makeText(LoginActivity.this, "Login gagal. Silakan periksa email dan password Anda.", Toast.LENGTH_SHORT).show();
                        tvNoteEmail.setText("Email atau password salah");
                        tvNotePassword.setText("Email atau password salah");
                    }
                }
            }
        });

        // Klik lupa password
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman lupa password
                Toast.makeText(LoginActivity.this, "Lupa Password diklik", Toast.LENGTH_SHORT).show();
            }
        });

//         Klik daftar
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman pendaftaran
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}

//              deri@deri.com
//              deri123
