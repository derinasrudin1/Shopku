package com.example.shopku.product.katmainan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;
import com.example.shopku.product.Product;

import java.util.ArrayList;
import java.util.List;

public class KatMainan extends AppCompatActivity {
    private RecyclerView recyclerKatMainan;
    private KatMainanAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kat_mainan);

        // Inisialisasi RecyclerView
        recyclerKatMainan = findViewById(R.id.recyclerKatMainan);
        recyclerKatMainan.setLayoutManager(new LinearLayoutManager(this));
        // Gunakan GridLayoutManager dengan 2 kolom
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerKatMainan.setLayoutManager(layoutManager);

        // Load data produk
        productList = new ArrayList<>();
        loadProducts();

        // Set adapter
        adapter = new KatMainanAdapter(productList, this);
        recyclerKatMainan.setAdapter(adapter);
    }

    private void loadProducts() {
        // Tambahkan daftar produk ke dalam productList
        productList.add(new Product(
                R.drawable.lego1,
                "Mainan Lego Anak Cerdas Bangun Kota",
                "Rp 50.000",
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
                R.drawable.mobil1,
                "Mobilan Anak Keliling Kampung",
                "Rp 171.400",
                "⭐4.1/5.0",
                R.drawable.picgoto,
                "goto.official",
"Ajak anak Anda merasakan kemewahan berkendara dengan mobil limusin mini ini! Interior yang mewah dan desain yang elegan akan membuat anak Anda merasa seperti selebriti. Mobil ini dilengkapi dengan fitur-fitur menarik seperti lampu LED dan sound system."        ));
        productList.add(new Product(
                R.drawable.mobil2,
                "Mainan Mobil Truk Keren",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
"Kenalkan si kecil pada dunia petualangan off-road dengan truk tanah monster ini! Dengan roda besar yang kokoh dan suspensi yang tangguh, truk ini siap menaklukkan segala jenis medan, baik itu pasir, lumpur, atau batu. Dilengkapi dengan detail yang realistis seperti lampu depan yang menyala dan suara mesin yang menggelegar, truk ini akan membawa imajinasi si kecil menjelajah ke tempat-tempat yang paling ekstrem."        ));
        productList.add(new Product(
                R.drawable.mobil3,
                "Mobil Pik up mainan bagus",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
"Kenalkan si kecil pada dunia petualangan off-road dengan truk tanah monster ini! Dengan roda besar yang kokoh dan suspensi yang tangguh, truk ini siap menaklukkan segala jenis medan, baik itu pasir, lumpur, atau batu. Dilengkapi dengan detail yang realistis seperti lampu depan yang menyala dan suara mesin yang menggelegar, truk ini akan membawa imajinasi si kecil menjelajah ke tempat-tempat yang paling ekstrem."        ));
        productList.add(new Product(
                R.drawable.masakan,
                "Set Masakan Anak",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
"Hadirkan keseruan bermain masak-masakan dengan Dapur Impian Si Kecil! Dapur ini didesain menyerupai dapur sungguhan, lengkap dengan lemari penyimpanan, wastafel, dan kulkas mini. Si kecil bisa berkreasi membuat berbagai macam hidangan dan menyajikannya untuk teman-temannya.\n" +
        "\n" +
        "Fitur:\n" +
        "Lemari penyimpanan dengan pintu yang bisa dibuka-tutup\n" +
        "Wastafel dengan kran air yang bisa diputar\n" +
        "Kulkas mini dengan rak penyimpanan\n" +
        "Aksesoris lengkap: panci, wajan, peralatan makan, dan makanan mainan\n" +
        "Kelebihan:\n" +
        "Bahan berkualitas tinggi dan aman untuk anak-anak\n" +
        "Desain yang menarik dan berwarna-warni\n" +
        "Stimulasi perkembangan kognitif dan sosial anak"        ));
        productList.add(new Product(
                R.drawable.masakan2,
                "Mainan Masak Masakan Kitchen Set",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
"Hadirkan keseruan bermain masak-masakan dengan Dapur Impian Si Kecil! Dapur ini didesain menyerupai dapur sungguhan, lengkap dengan lemari penyimpanan, wastafel, dan kulkas mini. Si kecil bisa berkreasi membuat berbagai macam hidangan dan menyajikannya untuk teman-temannya.\n" +
        "\n" +
        "Fitur:\n" +
        "Lemari penyimpanan dengan pintu yang bisa dibuka-tutup\n" +
        "Wastafel dengan kran air yang bisa diputar\n" +
        "Kulkas mini dengan rak penyimpanan\n" +
        "Aksesoris lengkap: panci, wajan, peralatan makan, dan makanan mainan\n" +
        "Kelebihan:\n" +
        "Bahan berkualitas tinggi dan aman untuk anak-anak\n" +
        "Desain yang menarik dan berwarna-warni\n" +
        "Stimulasi perkembangan kognitif dan sosial anak"        ));
        productList.add(new Product(
                R.drawable.doll,
                "Boneka Kuromi imut lucu",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Perkenalkan, boneka Kuromi yang super imut dan lembut! Dengan desain klasiknya yang ikonik, boneka ini siap menemanimu setiap saat. Peluk tubuhnya yang empuk dan rasakan kenyamanan yang luar biasa. Cocok untuk dijadikan teman tidur atau sekadar pajangan di kamarmu.\n" +
                        "\n" +
                        "Detail Produk:\n" +
                        "Bahan: Velvet lembut, isi dakron berkualitas\n" +
                        "Ukuran: [ukuran, misal: 30 cm]\n" +
                        "Warna: Hitam dan merah muda khas Kuromi\n" +
                        "Ekspresi wajah: [jelaskan ekspresi, misal: tersenyum manis]\n" +
                        "Keunggulan:\n" +
                        "Desain autentik dari karakter Kuromi\n" +
                        "Bahan berkualitas tinggi, aman untuk anak-anak\n" +
                        "Cocok untuk dikoleksi dan dijadikan hadiah"));
        productList.add(new Product(
                R.drawable.doll1,
                "Jual Boneka Beruang Murah",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
        "Temukan sahabat terbaikmu dalam bentuk boneka beruang yang super lembut ini! Dengan bulu yang halus dan isian yang empuk, boneka beruang ini akan membuatmu merasa nyaman dan aman setiap saat. Cocok untuk dipeluk saat tidur, dijadikan teman bermain, atau sebagai hadiah istimewa untuk orang tersayang.\n" +
        "\n" +
        "Bahan: Bulu halus dan lembut, isian dakron berkualitas\n" +
        "Ukuran: 40cm\n" +
        "Warna: coklat\n" +
        "Fitur: Mata yang berkilau, hidung yang lucu, jahitan yang rapi"        ));
        productList.add(new Product(
                R.drawable.capit1,
                "Mesin Capit Mini Mainan",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Ingin merasakan sensasi menang hadiah seperti di arkade? Sekarang kamu bisa memilikinya sendiri di rumah dengan Mesin Capit Mini! Desainnya yang kompak dan lucu membuatnya cocok untuk menghiasi kamar anak-anak atau dijadikan hadiah yang unik.\n" +
                        "\n" +
                        "Fitur Menarik:\n" +
                        "Desain Mini: Mudah dibawa ke mana saja.\n" +
                        "Operasi Sederhana: Cukup masukkan koin (atau benda lain sebagai pengganti) dan gerakkan capitnya untuk mendapatkan hadiah.\n" +
                        "Hadiah Menarik: Isi mesin dengan berbagai macam mainan kecil, permen, atau hadiah lainnya untuk menambah keseruan.\n" +
                        "Lampu dan Suara: Efek suara dan lampu yang menarik membuat permainan semakin seru."        ));
    }
}
