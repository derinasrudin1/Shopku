package com.example.shopku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.cart.CartActivity;
import com.example.shopku.message.Pesan;
import com.example.shopku.product.Product;
import com.example.shopku.product.ProductAdapter;
import com.example.shopku.product.ProductDetail;
import com.example.shopku.product.katmainan.KatMainan;
import com.example.shopku.product.katpakaian.KatPakaian;
import com.example.shopku.profil.AccountActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView ivPesan,katPakaian,katMainan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi menu
        LinearLayout menuHome = findViewById(R.id.menuHome);
        LinearLayout menuCart = findViewById(R.id.menuCart);
        LinearLayout menuProfile = findViewById(R.id.menuProfile);
        // Set listener untuk menu Home
        menuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class)); // Tetap di MainActivity
            }
        });

        // Set listener untuk menu Keranjang
        menuCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        // Set listener untuk menu Profil
        menuProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AccountActivity.class));
            }
        });
        //Intent ke Kategori Pakaian
        katPakaian = findViewById(R.id.imageView8);
        katPakaian.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, KatPakaian.class);
            startActivity(intent);
        });

        //Intent ke Kategori Permainan
        katMainan = findViewById(R.id.imageView7);
        katMainan.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, KatMainan.class);
            startActivity(intent);
        });


        // Intent untuk berpindah ke Pesan
        ivPesan = findViewById(R.id.ivPesan);
        ivPesan.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Pesan.class);
            startActivity(intent);
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // Gunakan GridLayoutManager dengan 2 kolom
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        // Dummy Data
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(
                R.drawable.gambarkipas,
                "Kipas Leher Portabel",
                "Rp 42.120",
                "⭐4.8/5.0",
                R.drawable.picisku,
                "isku.official",
                "Kipas leher portabel yang ringan dan mudah digunakan, dirancang khusus untuk memberikan kesegaran saat Anda bepergian. Dengan desain yang stylish, kipas ini dilengkapi dengan tiga mode kecepatan yang dapat disesuaikan. Cocok untuk aktivitas luar ruangan, olahraga, atau bahkan bersantai di rumah."
        ));

        productList.add(new Product(
                R.drawable.gambarrefurbish,
                "Refurbished Echo Dot",
                "Rp 37.400",
                "⭐4.8/5.0",
                R.drawable.picgoto,
                "goto.official",
                "Echo Dot Refurbished ini merupakan perangkat cerdas dengan fitur Alexa, memberikan Anda kemudahan untuk mengontrol musik, perangkat pintar, dan mendapatkan informasi hanya dengan suara. Perangkat ini telah melalui uji kualitas ketat dan hadir seperti baru, namun dengan harga yang jauh lebih terjangkau."
        ));

        productList.add(new Product(
                R.drawable.ringstick,
                "Ring Stick Up Cam Battery HD",
                "Rp 131.012",
                "⭐4.1/5.0",
                R.drawable.picgoto,
                "goto.official",
                "Kamera keamanan serbaguna yang dapat ditempatkan di mana saja, baik di dalam maupun luar ruangan. Dengan kualitas video HD dan deteksi gerakan canggih, Anda dapat memantau rumah Anda secara real-time melalui aplikasi. Dilengkapi baterai tahan lama dan mudah diisi ulang untuk kenyamanan ekstra."
        ));

        productList.add(new Product(
                R.drawable.womenswing,
                "Women's Swing Tunic Notch Collar",
                "Rp 46.000",
                "⭐4.1/5.0",
                R.drawable.picgoto,
                "goto.official",
                "Tunik wanita elegan dengan desain kerah notch yang memberikan sentuhan klasik namun modern. Terbuat dari bahan berkualitas tinggi yang lembut di kulit, pakaian ini sangat cocok untuk acara santai maupun semi-formal. Warna merah yang mencolok akan menambah kepercayaan diri Anda."
        ));

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
                R.drawable.productadidas,
                "Adidas Women's Grand Court",
                "Rp 264.600",
                "⭐4.1/5.0",
                R.drawable.picisku,
                "isku.official",
                "Sepatu Adidas Grand Court untuk wanita ini menggabungkan kenyamanan, gaya, dan daya tahan. Dengan desain klasik yang terinspirasi dari sepatu tenis, sepatu ini cocok untuk aktivitas sehari-hari maupun acara kasual. Sol yang empuk memberikan dukungan optimal untuk kaki Anda sepanjang hari."
        ));


        ProductAdapter adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
//        ProductAdapter adapter = new ProductAdapter(productList, product -> {
//            Intent intent = new Intent(MainActivity.this, ProductDetail.class);
//            intent.putExtra("PRODUCT_NAME", product.getName());
//            intent.putExtra("PRODUCT_PRICE", product.getPrice());
//            intent.putExtra("PRODUCT_RATE", product.getRate());
//            intent.putExtra("PRODUCT_IMAGE", product.getImageResId());
//            startActivity(intent);
//        });


    }

}