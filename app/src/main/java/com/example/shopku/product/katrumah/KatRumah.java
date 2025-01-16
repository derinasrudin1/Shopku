package com.example.shopku.product.katrumah;

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

public class KatRumah extends AppCompatActivity {
    private RecyclerView recyclerKatOlahraga;
    private KatMainanAdapter adapter;
    private List<Product> productList;
    private TextView menuName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kat_rumah);

        // Inisialisasi RecyclerView
        recyclerKatOlahraga = findViewById(R.id.recyclerKatRumah);
        menuName = findViewById(R.id.menu_name);
        recyclerKatOlahraga.setLayoutManager(new LinearLayoutManager(this));
        // Gunakan GridLayoutManager dengan 2 kolom
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerKatOlahraga.setLayoutManager(layoutManager);

        menuName.setText("Peralatan Rumah");
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
                R.drawable.vacum_cleaner,
                "Alat Penyedot Debu dan Air Sekaligus Dosa",
                "Rp 50.000",
                "⭐4.8/5.0",
                R.drawable.picgoto,
                "goto.official",
                "Kami menjual alat penyedot Debu dan Air Sekaligus dengan Dosa apabila Dosa nya" +
                        "masih kecil akan tersedot dengan mudah, namun jika dosa nya besar maka akan " +
                        "menyebabkan MAGOL (macet)"));
        productList.add(new Product(
                R.drawable.kompor_listrik_kanahome,
                "Kompor Gaib Tidak Pakai Api ",
                "Rp 271.400",
                "⭐4.1/5.0",
                R.drawable.picgoto,
                "goto.official",
                "Kompor Listrik Karya Anak Bangsa (Jepang). Ga usah pusing mikirin Gas Habis " +
                        "pake kompor ini cuma tinggal colok aja colok ke listrik bukan hidung" +
                        "Bapak Ibu cuma tinggal pencet saja maka tagihan listrik nya anak naik :D" ));
        productList.add(new Product(
                R.drawable.kompor_listrik_mini,
                "Anak Kompor Gaib ",
                "Rp 100.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Kompor Listrik kecil ini adalah anak dari Kompor Listrik. Karena kecil maka disebut mini" +
                        "Kompor Listrik ini punya daya yang lebih rendah dari bapak nya jadi bisa bikin hemat tagihan listrik nya" +
                        "tapi ketahanan, fitur, kenyamanan, efisiensi harus dikorbankan"        ));
        productList.add(new Product(
                R.drawable.alat_pel_putar_otomatis,
                "Pel Anti Tangan Kasar",
                "Rp 72.400",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Pelan yang lahir dari inovasi seorang yang malas meres pel pel an . maka diciptakan lah ini" +
                        "untuk mempermudah kita dalam dunia pel pel an"));

    }
}
