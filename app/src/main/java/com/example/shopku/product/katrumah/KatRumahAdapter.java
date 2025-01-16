package com.example.shopku.product.katrumah;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;
import com.example.shopku.product.Product;
import com.example.shopku.product.ProductDetail;
import com.example.shopku.product.katpakaian.KatPakaianAdapter;

import java.util.List;

public class KatRumahAdapter extends RecyclerView.Adapter<KatRumahAdapter.ViewHolder> {
    private List<Product> productList;
    private Context context;

    public KatRumahAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }
    @NonNull
    @Override
    public KatRumahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new KatRumahAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KatRumahAdapter.ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice());
        holder.imgProduct.setImageResource(product.getImageResId());
        holder.tvProductRate.setText(product.getRate());
        // Tambahkan klik listener untuk item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetail.class);
            intent.putExtra("PRODUCT_NAME", product.getName());
            intent.putExtra("PRODUCT_PRICE", product.getPrice());
            intent.putExtra("PRODUCT_RATE", product.getRate());
            intent.putExtra("PRODUCT_IMAGE", product.getImageResId());
            intent.putExtra("PRODUCT_DESCRIPTION", product.getDescription());
            intent.putExtra("IMAGE_TOKO", product.getImageToko());
            intent.putExtra("NAMA_TOKO", product.getNamaToko());

            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvProductName, tvProductPrice, tvProductRate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvProductRate = itemView.findViewById(R.id.tvProductRate);
        }
    }

}
