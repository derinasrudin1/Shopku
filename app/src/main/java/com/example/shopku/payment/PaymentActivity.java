package com.example.shopku.payment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopku.R;
import com.example.shopku.utils.PopupUtil;

public class PaymentActivity extends AppCompatActivity {
    private TextView subTotal, totalPayment , tvOngkir, tvDiskon;
    private Button btnAddOrder;
    private int ongkir = 15000; // Ongkir default (contoh)
    private int voucherDiskon = 10000; // Voucher diskon default (contoh)

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

        btnAddOrder.setOnClickListener(v ->
                PopupUtil.showPopup(PaymentActivity.this, "Pesanan Berhasil!")
        );
    }

    // Format mata uang ke "Rp xxx.xxx"
    private String formatCurrency(int amount) {
        return String.format("Rp %,d", amount).replace(',', '.');
    }
}
