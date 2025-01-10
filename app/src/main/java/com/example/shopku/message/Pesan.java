package com.example.shopku.message;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;

import java.util.ArrayList;
import java.util.List;

public class Pesan extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_screen);

        RecyclerView rvPesan = findViewById(R.id.recyclerPesan);
        rvPesan.setLayoutManager(new LinearLayoutManager(this));
        List<MessageInbox> messageList = new ArrayList<>();

        messageList.add(new MessageInbox(R.drawable.picgoto,"gotoliving", "Terimakasih ya kak sudah...","22/09/2024"));
        messageList.add(new MessageInbox(R.drawable.picisku,"isku.tangerang", "Terimakasih ya kak sudah...","22/09/2024"));

        MessageAdapter messageAdapter = new MessageAdapter(messageList);
        rvPesan.setAdapter(messageAdapter);

    }
}
