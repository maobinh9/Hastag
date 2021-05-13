package com.example.hastag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hastag.ItemClickListener;
import com.example.hastag.Model.Hashtag;
import com.example.hastag.R;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.List;

public class HashtagDetailAdapter extends RecyclerView.Adapter<HashtagDetailAdapter.HasTagDetailViewHolder> {

    private String nameHashTag;
    private List<String> hashtagList;
    private Context mContext;
    private ItemClickListener itemClickListener;

    public HashtagDetailAdapter(String nameHashTag, List<String> hashtagList, Context mContext, ItemClickListener itemClickListener) {
        this.nameHashTag = nameHashTag;
        this.hashtagList = hashtagList;
        this.mContext = mContext;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HasTagDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HasTagDetailViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_detail_hashtag, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HasTagDetailViewHolder holder, int position) {
        String[] list = hashtagList.get(position).split(" ");
        holder.textCategoryDetail.setText(nameHashTag + " | Top " + (position + 1));

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(mContext);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        holder.listHastagDetail.setLayoutManager(layoutManager);
        holder.listHastagDetail.setAdapter(new ListHashtagAdapter(mContext, list));
    }

    @Override
    public int getItemCount() {
        return hashtagList.size();
    }

    public class HasTagDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textCategoryDetail;
        RecyclerView listHastagDetail;
        Button buttonSave;
        Button buttonAnalyze;
        Button buttonCoppy;

        public HasTagDetailViewHolder(@NonNull View view) {
            super(view);
            textCategoryDetail = view.findViewById(R.id.text_category_detail);
            listHastagDetail = view.findViewById(R.id.list_hastag_detail);
            buttonSave = view.findViewById(R.id.button_save);
            buttonAnalyze = view.findViewById(R.id.button_analyze);
            buttonCoppy = view.findViewById(R.id.button_coppy);
            buttonCoppy.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }
}
