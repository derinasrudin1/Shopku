package com.example.shopku.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<MessageInbox> messageList;

    public MessageAdapter(List<MessageInbox> messageList) {
        this.messageList = messageList;
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvSenderName, tvMessageContent,tvMessageDate;
        ImageView imageSender;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSenderName = itemView.findViewById(R.id.tvSenderName);
            tvMessageContent = itemView.findViewById(R.id.tvMessageContent);
            tvMessageDate = itemView.findViewById(R.id.tvMessageDate);
            imageSender = itemView.findViewById(R.id.imageSender);
        }
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        MessageInbox message = messageList.get(position);
        holder.tvSenderName.setText(message.getSenderName());
        holder.tvMessageContent.setText(message.getMessageContent());
        holder.imageSender.setImageResource(message.getImageSender());
        holder.tvMessageDate.setText(message.getMessageDate());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
