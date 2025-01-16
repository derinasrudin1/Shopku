package com.example.shopku.payment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopku.R;
import com.example.shopku.utils.PopupUtil;

public class PaymentActivity extends AppCompatActivity {
    private TextView subTotal, totalPayment , tvOngkir, tvDiskon;
    private Button btnAddOrder,btnDebit, btnCod, btnApplePay;
    private int ongkir = 15000; // Ongkir default (contoh)
    private int voucherDiskon = 10000; // Voucher diskon default (contoh)
    private TextView tvSaldo; // TextView untuk saldo
    private int saldoDebit = 100000; // Contoh saldo Debit
    private int saldoApplePay = 50000; // Contoh saldo Apple Pay
    private String selectedPaymentMethod = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);

        // Inisialisasi TextView
        subTotal = findViewById(R.id.subTotal);
        totalPayment = findViewById(R.id.totalPayment);
        tvOngkir = findViewById(R.id.ongkir);
        tvDiskon = findViewById(R.id.diskon);
        btnAddOrder = findViewById(R.id.btnAddOrder);
        btnDebit = findViewById(R.id.btnDebit);
        btnCod = findViewById(R.id.btnCod);
        btnApplePay = findViewById(R.id.btnApplePay);
        tvSaldo = findViewById(R.id.SaldoTv);



        // Ambil nilai subtotal dari Intent
        String totalPriceValue = getIntent().getStringExtra("TOTAL_PRICE");
        int subtotal = 0; // Default subtotal jika null

        // Konversi subtotal ke integer
        if (totalPriceValue != null) {
            subtotal = Integer.parseInt(totalPriceValue.replaceAll("[^\\d]", "")); // Hapus format Rp dan titik
            subTotal.setText(formatCurrency(subtotal));
        }

        // Hitung total payment
        int totalPaymentValue = subtotal + ongkir - voucherDiskon;

        // Tampilkan nilai ongkir dan diskon
        tvOngkir.setText(formatCurrency(ongkir));
        tvDiskon.setText(formatCurrency(voucherDiskon));

        // Tampilkan total payment
        totalPayment.setText(formatCurrency(totalPaymentValue));

        View.OnClickListener paymentMethodListener = view -> {
            // Reset warna semua tombol
            resetButtonColors();

            // Ubah warna tombol yang diklik
            Button clickedButton = (Button) view;
            clickedButton.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
            clickedButton.setTextColor(Color.WHITE);

            // Simpan metode pembayaran yang dipilih
            selectedPaymentMethod = clickedButton.getText().toString();

            // Perbarui saldo berdasarkan metode pembayaran yang dipilih
            switch (selectedPaymentMethod) {
                case "Debit":
                    tvSaldo.setText(formatCurrency(saldoDebit));
                    break;
                case "Apple Pay":
                    tvSaldo.setText(formatCurrency(saldoApplePay));
                    break;
                case "COD":
                    tvSaldo.setText("Bayar di Tempat");

                    break;
                default:
                    tvSaldo.setText(""); // Kosongkan jika metode lain
                    break;
            }

            // Tampilkan Toast untuk metode pembayaran
            Toast.makeText(PaymentActivity.this, "Anda memilih: " + selectedPaymentMethod, Toast.LENGTH_SHORT).show();
        };



        // Pasang listener ke setiap tombol
        btnDebit.setOnClickListener(paymentMethodListener);
        btnCod.setOnClickListener(paymentMethodListener);
        btnApplePay.setOnClickListener(paymentMethodListener);


        btnAddOrder.setOnClickListener(v -> {
            switch (selectedPaymentMethod) {
                case "Debit":
                    if (saldoDebit >= totalPaymentValue) {
                        PopupUtil.showPopup(PaymentActivity.this, "Pesanan Berhasil!");
                    } else {
                        Toast.makeText(PaymentActivity.this,
                                "Gagal menambahkan pesanan. Saldo Debit tidak mencukupi!",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "Apple Pay":
                    if (saldoApplePay >= totalPaymentValue) {
                        PopupUtil.showPopup(PaymentActivity.this, "Pesanan Berhasil!");
                    } else {
                        Toast.makeText(PaymentActivity.this,
                                "Gagal menambahkan pesanan. Saldo Apple Pay tidak mencukupi!",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "COD":
                    // Untuk COD, selalu berhasil
                    PopupUtil.showPopup(PaymentActivity.this, "Pesanan Berhasil!");
                    break;
                default:
                    Toast.makeText(PaymentActivity.this,
                            "Pilih metode pembayaran terlebih dahulu!",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        });


    }

    // Reset warna tombol ke default
    private void resetButtonColors() {
        btnDebit.setBackgroundTintList(getResources().getColorStateList(R.color.white));
        btnDebit.setTextColor(getResources().getColor(R.color.black));

        btnCod.setBackgroundTintList(getResources().getColorStateList(R.color.white));
        btnCod.setTextColor(getResources().getColor(R.color.black));

        btnApplePay.setBackgroundTintList(getResources().getColorStateList(R.color.white));
        btnApplePay.setTextColor(getResources().getColor(R.color.black));
    }

    // Format mata uang ke "Rp xxx.xxx"
    private String formatCurrency(int amount) {
        return String.format("Rp %,d", amount).replace(',', '.');
    }
}
