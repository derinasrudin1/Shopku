package com.example.shopku.product;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopku.R;
import com.example.shopku.payment.PaymentActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductDetail extends AppCompatActivity {

    private ImageView imgProduct;
    private TextView tvProductName, tvProductPrice, tvProductRate, tvProductDescription;
    private Button btnAddToCart, btnBuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Inisialisasi Views
        imgProduct = findViewById(R.id.productImageView);
        tvProductName = findViewById(R.id.productNameTextView);
        tvProductPrice = findViewById(R.id.productPriceTextView);
        tvProductRate = findViewById(R.id.productRateTextView);
        tvProductDescription = findViewById(R.id.productDescriptionTextView);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        // Tangkap data dari Intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("PRODUCT_NAME");
        String productPrice = intent.getStringExtra("PRODUCT_PRICE");
        String productRate = intent.getStringExtra("PRODUCT_RATE");
        int productImage = intent.getIntExtra("PRODUCT_IMAGE", R.drawable.kamera);
        String productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION");

        // Set data ke Views
        tvProductName.setText(productName);
        tvProductPrice.setText(productPrice);
        tvProductRate.setText(productRate);
        imgProduct.setImageResource(productImage);

        if (productDescription != null) {
            tvProductDescription.setText(productDescription);
        } else {
            tvProductDescription.setText("Deskripsi produk belum tersedia.");
        }

        // Listener tombol Tambah ke Keranjang
        btnAddToCart.setOnClickListener(v -> {
            // Tambahkan ke keranjang (implementasi sederhana)
            addToCart(productName,productImage,productPrice);
        });

    }

//    private void addToCart(String productName) {
//        // Logika penambahan produk ke keranjang (simulasi)
//        Toast.makeText(this, productName + " berhasil ditambahkan ke keranjang!", Toast.LENGTH_SHORT).show();
//        // Bisa tambahkan logika untuk menyimpan data ke database atau shared preferences
//    }

    private void addToCart(String productName, int productImage, String productPrice) {
    // Simulasi penambahan produk ke keranjang
    Toast.makeText(this, productName + " berhasil ditambahkan ke keranjang!", Toast.LENGTH_SHORT).show();

    // Ambil SharedPreferences
    SharedPreferences sharedPreferences = getSharedPreferences("CartPreferences", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    // Ambil produk yang sudah ada di keranjang (jika ada)
    String existingCart = sharedPreferences.getString("cart_items", "[]");

    try {
        // Parse existing cart items ke JSONArray
        JSONArray cartArray = new JSONArray(existingCart);

        // Buat objek JSON untuk produk baru
        JSONObject newProduct = new JSONObject();
        newProduct.put("name", productName);
        newProduct.put("image", productImage);
        newProduct.put("price", productPrice);

        // Tambahkan produk baru ke array
        cartArray.put(newProduct);

        // Simpan array ke SharedPreferences
        editor.putString("cart_items", cartArray.toString());
        editor.apply();
    } catch (JSONException e) {
        e.printStackTrace();
    }
}


    private void goToCheckout(String productName, String productPrice) {
        // Navigasi ke halaman pembayaran
        Intent intent = new Intent(ProductDetail.this, PaymentActivity.class);
        intent.putExtra("PRODUCT_NAME", productName);
        intent.putExtra("PRODUCT_PRICE", productPrice);
        startActivity(intent);
    }
}
