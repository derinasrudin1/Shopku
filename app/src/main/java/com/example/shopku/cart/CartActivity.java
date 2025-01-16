package com.example.shopku.cart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.MainActivity;
import com.example.shopku.ProfileActivity;
import com.example.shopku.R;
import com.example.shopku.payment.PaymentActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerCart;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItemList;
    private CheckBox checkboxAll;
    private TextView totalPrice, totalSavings;
    private Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize views
        recyclerCart = findViewById(R.id.recyclerCart);
        checkboxAll = findViewById(R.id.checkboxAll);
        totalPrice = findViewById(R.id.totalPrice);
        totalSavings = findViewById(R.id.totalSavings);
        btnPay = findViewById(R.id.btnPay);

        // Initialize RecyclerView
        cartItemList = new ArrayList<>();
        loadCartItems(); // Load data to cart
        cartAdapter = new CartAdapter(cartItemList, this);
        cartAdapter.setOnItemCheckedChangeListener(this::updateTotalPrice); // Set listener
        recyclerCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerCart.setAdapter(cartAdapter);

        // Checkbox "Select All"
        checkboxAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            for (CartItem item : cartItemList) {
                item.setSelected(isChecked);
            }
            cartAdapter.notifyDataSetChanged();
            updateTotalPrice(null); // Recalculate total price
        });

        // Button Pay
        btnPay.setOnClickListener(v -> {
            // Ambil nilai total harga dari TextView
            String totalPriceValue = totalPrice.getText().toString();

            // Intent dan data extra
            Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
            intent.putExtra("TOTAL_PRICE", totalPriceValue);

            // Pindah ke PaymentActivity
            startActivity(intent);
        });


        // Initial calculation of total price
        updateTotalPrice(null);
    }

    // Load items from SharedPreferences
    private void loadCartItems() {
        SharedPreferences sharedPreferences = getSharedPreferences("CartPreferences", MODE_PRIVATE);
        String cartData = sharedPreferences.getString("cart_items", "[]");

        try {
            JSONArray cartArray = new JSONArray(cartData);
            for (int i = 0; i < cartArray.length(); i++) {
                JSONObject product = cartArray.getJSONObject(i);

                String name = product.getString("name");
                int image = product.getInt("image");
                String priceString = product.getString("price");
                int price = Integer.parseInt(priceString.replaceAll("[^\\d]", "")); // Remove non-numeric characters
                int quantity = 1; // Default quantity

                cartItemList.add(new CartItem(name, "", price, quantity, false, image));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Method to calculate total price
    private void updateTotalPrice(CartItem item) {
        int total = 0;
        for (CartItem cartItem : cartItemList) {
            if (cartItem.isSelected()) {
                total += cartItem.getPrice() * cartItem.getQuantity();
            }
        }
        totalPrice.setText(formatCurrency(total));
        checkSelectAllStatus(); // Update "Select All" checkbox
    }

    // Check if "Select All" checkbox should be updated
    private void checkSelectAllStatus() {
        boolean allSelected = true;
        for (CartItem item : cartItemList) {
            if (!item.isSelected()) {
                allSelected = false;
                break;
            }
        }
        checkboxAll.setChecked(allSelected);
    }

    // Format currency to "Rp xxx.xxx" lah ya
    private String formatCurrency(int amount) {
        return String.format("Rp %,d", amount).replace(',', '.');
    }
}
