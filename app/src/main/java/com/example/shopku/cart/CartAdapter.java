package com.example.shopku.cart;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItemList;
    private Context context;

    public CartAdapter(List<CartItem> cartItemList, Context context) {
        this.cartItemList = cartItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItemList.get(position);

        // Set item data
        holder.productName.setText(item.getName());
        holder.productDetails.setText(item.getDetails());
        holder.productPrice.setText(formatCurrency(item.getPrice()));
        holder.productQuantity.setText(String.valueOf(item.getQuantity()));
        holder.checkbox.setChecked(item.isSelected());
        holder.productImage.setImageResource(item.getImageResource());

        // Checkbox listener
        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setSelected(isChecked);
            if (onItemCheckedChangeListener != null) {
                onItemCheckedChangeListener.onCheckedChange(item);
            }
        });

        // Increase button listener
        holder.btnIncrease.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            notifyItemChanged(position);
            notifyTotalPriceUpdate(item);
            saveCartItems(); // Simpan perubahan ke SharedPreferences
        });

        // Decrease button listener
        holder.btnDecrease.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                // Reduce quantity
                item.setQuantity(item.getQuantity() - 1);
                notifyItemChanged(position);
            } else {
                // Remove item if quantity reaches 0
                cartItemList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cartItemList.size());
            }
            notifyTotalPriceUpdate(item);
            saveCartItems();
        });

    }

    // Fungsi untuk menyimpan perubahan ke SharedPreferences
    private void saveCartItems() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("CartPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        JSONArray cartArray = new JSONArray();
        for (CartItem item : cartItemList) {
            JSONObject product = new JSONObject();
            try {
                product.put("name", item.getName());
                product.put("image", item.getImageResource());
                product.put("price", formatCurrency(item.getPrice()));
                product.put("quantity", item.getQuantity());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            cartArray.put(product);
        }
        editor.putString("cart_items", cartArray.toString());
        editor.apply();
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    // Format currency
    private String formatCurrency(int amount) {
        return String.format("Rp %,d", amount).replace(',', '.');
    }

    // Notify total price update to activity
    private void notifyTotalPriceUpdate(CartItem item) {
        if (onItemCheckedChangeListener != null) {
            onItemCheckedChangeListener.onCheckedChange(item);
        }
    }

    // Interface for notifying activity about checkbox changes
    public interface OnItemCheckedChangeListener {
        void onCheckedChange(CartItem item);
    }

    private OnItemCheckedChangeListener onItemCheckedChangeListener;

    public void setOnItemCheckedChangeListener(OnItemCheckedChangeListener listener) {
        this.onItemCheckedChangeListener = listener;
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productDetails, productPrice, productQuantity;
        CheckBox checkbox;
        ImageView btnIncrease, btnDecrease, productImage;

        CartViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productDetails = itemView.findViewById(R.id.productDetails);
            productPrice = itemView.findViewById(R.id.productPrice);
            productQuantity = itemView.findViewById(R.id.productQuantity);
            checkbox = itemView.findViewById(R.id.checkbox);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
