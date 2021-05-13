package com.example.hastag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hastag.R;

import java.util.List;

public class ListHashtagAdapter extends RecyclerView.Adapter<ListHashtagAdapter.ListHashtagViewHolder> {

    private Context mContext;
    private String[] list;


    public ListHashtagAdapter(Context mContext, String[] list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ListHashtagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListHashtagViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_hashtag,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListHashtagViewHolder holder, int position) {
        holder.hashtag.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class ListHashtagViewHolder extends RecyclerView.ViewHolder{
        TextView hashtag;
        public ListHashtagViewHolder(@NonNull View itemView) {
            super(itemView);
            hashtag = itemView.findViewById(R.id.hashtag);
        }
    }
}
