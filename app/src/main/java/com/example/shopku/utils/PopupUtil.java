package com.example.shopku.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopku.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class PopupUtil {

    // Metode statis untuk menampilkan popup
    public static void showPopup(Context context, String message) {
        // Buat BottomSheetDialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);

        // Inflate layout pop-up
        View view = LayoutInflater.from(context).inflate(R.layout.popup_success, null);

        // Hubungkan komponen dalam layout
        ImageView ivCheck = view.findViewById(R.id.ivCheck);
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        Button btnClose = view.findViewById(R.id.btnClose);

        // Atur data atau listener
        tvMessage.setText(message);
        btnClose.setOnClickListener(v -> bottomSheetDialog.dismiss());

        // Set layout ke BottomSheetDialog
        bottomSheetDialog.setContentView(view);

        // Atur tinggi menjadi 50% layar
        bottomSheetDialog.getBehavior().setPeekHeight((int) (context.getResources().getDisplayMetrics().heightPixels * 0.5));

        // Tampilkan pop-up
        bottomSheetDialog.show();
    }
}
