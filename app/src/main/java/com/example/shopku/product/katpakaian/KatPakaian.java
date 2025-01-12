package com.example.shopku.product.katpakaian;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;
import com.example.shopku.product.Product;

import java.util.ArrayList;
import java.util.List;

public class KatPakaian extends AppCompatActivity {
    private RecyclerView recyclerKatPakaian;
    private KatPakaianAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kat_pakaian);

        // Inisialisasi RecyclerView
        recyclerKatPakaian = findViewById(R.id.recyclerKatPakaian);
        recyclerKatPakaian.setLayoutManager(new LinearLayoutManager(this));
        // Gunakan GridLayoutManager dengan 2 kolom
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerKatPakaian.setLayoutManager(layoutManager);

        // Load data produk
        productList = new ArrayList<>();
        loadProducts();

        // Set adapter
        adapter = new KatPakaianAdapter(productList, this);
        recyclerKatPakaian.setAdapter(adapter);
    }

    private void loadProducts() {
        // Tambahkan daftar produk ke dalam productList
        productList.add(new Product(
                R.drawable.yogadress,
                "Yoga Dress Pants untuk Wanita",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Celana yoga wanita yang menggabungkan kenyamanan olahraga dengan gaya profesional. Dirancang untuk memberikan fleksibilitas maksimal, celana ini cocok digunakan di studio yoga maupun di tempat kerja. Dengan bahan elastis dan potongan ramping, Anda akan merasa nyaman sepanjang hari."
        ));
        productList.add(new Product(
                R.drawable.bajucokelat,
                "Dress Cokelat",
                "Rp 71.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Terlihat elegan dan gaya dengan baju wanita terbaru kami. Dirancang dengan penuh perhatian untuk memberikan kenyamanan maksimal sekaligus penampilan yang memukau. Terbuat dari bahan katun premium yang lembut di kulit, sehingga nyaman untuk dipakai sepanjang hari. Jahitan yang rapi dan kualitas bahan yang tahan lama memastikan baju ini tetap awet meski sering dicuci. Tersedia dalam berbagai ukuran, mulai dari S hingga XXL, untuk memastikan setiap wanita bisa menemukan ukuran yang pas dan nyaman."
        ));
        productList.add(new Product(
                R.drawable.gaunlm,
                "Yoga Dress Pants untuk Wanita",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Terlihat elegan dan gaya dengan baju wanita terbaru kami. Dirancang dengan penuh perhatian untuk memberikan kenyamanan maksimal sekaligus penampilan yang memukau. Terbuat dari bahan katun premium yang lembut di kulit, sehingga nyaman untuk dipakai sepanjang hari. Jahitan yang rapi dan kualitas bahan yang tahan lama memastikan baju ini tetap awet meski sering dicuci. Tersedia dalam berbagai ukuran, mulai dari S hingga XXL, untuk memastikan setiap wanita bisa menemukan ukuran yang pas dan nyaman."
        ));
        productList.add(new Product(
                R.drawable.gaunpinky,
                "Yoga Dress Pants untuk Wanita",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Terlihat elegan dan gaya dengan baju wanita terbaru kami. Dirancang dengan penuh perhatian untuk memberikan kenyamanan maksimal sekaligus penampilan yang memukau. Terbuat dari bahan katun premium yang lembut di kulit, sehingga nyaman untuk dipakai sepanjang hari. Jahitan yang rapi dan kualitas bahan yang tahan lama memastikan baju ini tetap awet meski sering dicuci. Tersedia dalam berbagai ukuran, mulai dari S hingga XXL, untuk memastikan setiap wanita bisa menemukan ukuran yang pas dan nyaman."
        ));
        productList.add(new Product(
                R.drawable.gauntoska,
                "Yoga Dress Pants untuk Wanita",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Terlihat elegan dan gaya dengan baju wanita terbaru kami. Dirancang dengan penuh perhatian untuk memberikan kenyamanan maksimal sekaligus penampilan yang memukau. Terbuat dari bahan katun premium yang lembut di kulit, sehingga nyaman untuk dipakai sepanjang hari. Jahitan yang rapi dan kualitas bahan yang tahan lama memastikan baju ini tetap awet meski sering dicuci. Tersedia dalam berbagai ukuran, mulai dari S hingga XXL, untuk memastikan setiap wanita bisa menemukan ukuran yang pas dan nyaman."
        ));
        productList.add(new Product(
                R.drawable.pinkgaun,
                "Yoga Dress Pants untuk Wanita",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Terlihat elegan dan gaya dengan baju wanita terbaru kami. Dirancang dengan penuh perhatian untuk memberikan kenyamanan maksimal sekaligus penampilan yang memukau. Terbuat dari bahan katun premium yang lembut di kulit, sehingga nyaman untuk dipakai sepanjang hari. Jahitan yang rapi dan kualitas bahan yang tahan lama memastikan baju ini tetap awet meski sering dicuci. Tersedia dalam berbagai ukuran, mulai dari S hingga XXL, untuk memastikan setiap wanita bisa menemukan ukuran yang pas dan nyaman."
        ));
    }
}