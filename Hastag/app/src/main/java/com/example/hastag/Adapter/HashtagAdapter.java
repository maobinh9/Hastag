package com.example.hastag.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hastag.ItemClickListener;
import com.example.hastag.Model.Hashtag;
import com.example.hastag.R;

import java.util.List;

public class HashtagAdapter extends RecyclerView.Adapter<HashtagAdapter.HasTagViewHolder> {
    private List<Hashtag> hashtagList;
    private Context mContext;
    private ItemClickListener itemClickListener;

    public HashtagAdapter(List<Hashtag> hashtagList, Context mContext, ItemClickListener itemClickListener) {
        this.hashtagList = hashtagList;
        this.mContext = mContext;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HasTagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View mangaHotView = inflater.inflate(R.layout.row_category_hashtag, parent, false);
        HasTagViewHolder viewHolder = new HasTagViewHolder(mangaHotView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull HasTagViewHolder holder, int position) {

        int imageResource = mContext.getResources().getIdentifier("@drawable/"+hashtagList.get(position).getUrlImage(), null, mContext.getPackageName());
        Drawable res = mContext.getResources().getDrawable(imageResource);
        holder.imageCategory.setImageDrawable(resize(res));

        holder.categoryName.setText(hashtagList.get(position).getName());
    }
    private Drawable resize(Drawable image) {
        Bitmap bitmapImage = ((BitmapDrawable)image).getBitmap();
        //Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 250, 150, false);
        int nh = (int) ( bitmapImage.getHeight() * (512.0 / bitmapImage.getWidth()) );
        Bitmap scaled = Bitmap.createScaledBitmap(bitmapImage, 512, nh, true);
        return new BitmapDrawable(mContext.getResources(), scaled);
    }

    @Override
    public int getItemCount() {
        return hashtagList.size();
    }

    public class HasTagViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView categoryName;
        ImageView imageCategory;
        CardView categoryCard;
        public HasTagViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryCard = itemView.findViewById(R.id.card_category_hashtag);
            categoryName = itemView.findViewById(R.id.text_category);
            imageCategory = itemView.findViewById(R.id.image_category);
            categoryCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
