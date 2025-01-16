package com.example.shopku.product.katolahraga;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;
import com.example.shopku.product.Product;
import com.example.shopku.product.katmainan.KatMainanAdapter;

import java.util.ArrayList;
import java.util.List;

public class KatOlahraga extends AppCompatActivity {
    private RecyclerView recyclerKatOlahraga;
    private KatMainanAdapter adapter;
    private List<Product> productList;
    private TextView menuName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kat_olahraga);

        // Inisialisasi RecyclerView
        recyclerKatOlahraga = findViewById(R.id.recyclerKatOlahraga);
        menuName = findViewById(R.id.menu_name);
        recyclerKatOlahraga.setLayoutManager(new LinearLayoutManager(this));
        // Gunakan GridLayoutManager dengan 2 kolom
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerKatOlahraga.setLayoutManager(layoutManager);

        menuName.setText("Alat Olahraga");


        // Load data produk
        productList = new ArrayList<>();
        loadProducts();

        // Set adapter
        adapter = new KatMainanAdapter(productList, this);
        recyclerKatOlahraga.setAdapter(adapter);
    }
    private void loadProducts() {
        // Tambahkan daftar produk ke dalam productList
        productList.add(new Product(
                R.drawable.bola,
                "Jual Bola bonus Pompa",
                "Rp 80.000",
                "⭐4.8/5.0",
                R.drawable.picgoto,
                "goto.official",
                "Rasakan sensasi nostalgia dengan set LEGO Creator Expert - Kota Tua! Dengan detail bangunan yang menakjubkan, seperti toko roti, jam besar, dan balkon klasik, set ini akan membawa Anda kembali ke masa lalu. Nikmati pengalaman membangun yang menantang dan hasil akhir yang mengagumkan. Sempurna untuk dipajang di rumah atau kantor Anda.\n" +
                        "\n" +
                        "Fitur:\n" +
                        "Lebih dari [jumlah] buah bata LEGO\n" +
                        "Mini figur: tukang roti, penjual bunga, dan anak kecil\n" +
                        "Fungsi interaktif: jam yang bergerak, pintu yang bisa dibuka-tutup\n" +
                        "Panduan pembangunan yang jelas dan terperinci\n" +
                        "Cocok untuk: Penggemar LEGO dewasa, kolektor, dan mereka yang menyukai arsitektur klasik."));
        productList.add(new Product(
                R.drawable.jual_jersey_bola,
                "Jual Jersey Bola Bisa Custom Bebasss",
                "Rp 101.400",
                "⭐4.1/5.0",
                R.drawable.picgoto,
                "goto.official",
                "Ajak anak Anda merasakan kemewahan berkendara dengan mobil limusin mini ini! Interior yang mewah dan desain yang elegan akan membuat anak Anda merasa seperti selebriti. Mobil ini dilengkapi dengan fitur-fitur menarik seperti lampu LED dan sound system."        ));
        productList.add(new Product(
                R.drawable.raket_bulu_tangkis,
                "Raket Gacorrr Speeds",
                "Rp 372.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Kenalkan si kecil pada dunia petualangan off-road dengan truk tanah monster ini! Dengan roda besar yang kokoh dan suspensi yang tangguh, truk ini siap menaklukkan segala jenis medan, baik itu pasir, lumpur, atau batu. Dilengkapi dengan detail yang realistis seperti lampu depan yang menyala dan suara mesin yang menggelegar, truk ini akan membawa imajinasi si kecil menjelajah ke tempat-tempat yang paling ekstrem."        ));
        productList.add(new Product(
                R.drawable.treadmil,
                "Jual Alat Gym Treadmill Murah",
                "Rp 1.172.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Kenalkan si kecil pada dunia petualangan off-road dengan truk tanah monster ini! Dengan roda besar yang kokoh dan suspensi yang tangguh, truk ini siap menaklukkan segala jenis medan, baik itu pasir, lumpur, atau batu. Dilengkapi dengan detail yang realistis seperti lampu depan yang menyala dan suara mesin yang menggelegar, truk ini akan membawa imajinasi si kecil menjelajah ke tempat-tempat yang paling ekstrem."        ));
        }

}
