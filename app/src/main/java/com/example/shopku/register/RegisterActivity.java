package com.example.shopku.register;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopku.DatabaseHelper;
import com.example.shopku.R;
import com.example.shopku.login.LoginActivity;
import com.example.shopku.utils.PopupUtil;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPassword, etConfirmPassword;
    private CheckBox cbTerms;
    private Button btnRegister;
    private DatabaseHelper databaseHelper;

    //    private boolean isPasswordVisible = false;
//    private boolean isConfirmPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi view
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
//        ivTogglePassword = findViewById(R.id.ivTogglePassword);
//        ivToggleConfirmPassword = findViewById(R.id.ivToggleConfirmPassword);
        cbTerms = findViewById(R.id.cbTerms);
        btnRegister = findViewById(R.id.btnRegister);
        databaseHelper = new DatabaseHelper(this);

//        // Toggle visibility password
//        ivTogglePassword.setOnClickListener(v -> togglePasswordVisibility(etPassword, ivTogglePassword));
//        ivToggleConfirmPassword.setOnClickListener(v -> togglePasswordVisibility(etConfirmPassword, ivToggleConfirmPassword));

        // Klik tombol daftar
        btnRegister.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(RegisterActivity.this, "Password tidak cocok", Toast.LENGTH_SHORT).show();
            } else if (!cbTerms.isChecked()) {
                Toast.makeText(RegisterActivity.this, "Anda harus menyetujui syarat dan ketentuan", Toast.LENGTH_SHORT).show();
            } else {
                boolean isInserted = databaseHelper.addUser(email, password);
                if (isInserted) {
                    PopupUtil.showPopup(RegisterActivity.this, "Login Berhasil!"); // Memanggil popup utilitas
                    new Handler().postDelayed(() -> {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    }, 2000); // Durasi 2 detik

                } else {
                    Toast.makeText(RegisterActivity.this, "Registrasi gagal. Email mungkin sudah terdaftar.", Toast.LENGTH_SHORT).show();
                }
            }
    });
    }}

//    private void togglePasswordVisibility(EditText editText, ImageView toggleView) {
//        if (editText.getInputType() == 129) { // 129 adalah inputType password
//            editText.setInputType(1); // 1 adalah inputType text
//            toggleView.setImageResource(R.drawable.ic_eye_closed);
//        } else {
//            editText.setInputType(129);
//            toggleView.setImageResource(R.drawable.ic_eye);
//        }
//        editText.setSelection(editText.length());
//    }


