package com.example.shopku.profil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopku.R;

import java.util.List;

public class AccountOptionsAdapter extends RecyclerView.Adapter<AccountOptionsAdapter.ViewHolder> {
    private List<AccountOption> options;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public AccountOptionsAdapter(List<AccountOption> options, Context context, OnItemClickListener onItemClickListener) {
        this.options = options;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_account_option, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AccountOption option = options.get(position);
        holder.icon.setImageResource(option.getIcon());
        holder.title.setText(option.getTitle());
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

