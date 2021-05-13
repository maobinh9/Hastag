package com.example.hastag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hastag.Adapter.HashtagAdapter;
import com.example.hastag.Adapter.HashtagDetailAdapter;
import com.example.hastag.Model.Hashtag;
import com.example.hastag.Model.HashtagDetail;

import java.io.Serializable;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private Hashtag hashtagDetailList;
    private Toolbar toolbar;
    private ImageView imageBack;
    private RecyclerView listHastagDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        Intent intent = getIntent();
        hashtagDetailList = (Hashtag) intent.getSerializableExtra("LIST");
        setListHashTag();
        setOnCLick();
    }

    private void setOnCLick() {
        imageBack.setOnClickListener(this);
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        imageBack = toolbar.findViewById(R.id.image_back);
        listHastagDetail = findViewById(R.id.list_hastag_detail);
    }

    private void setListHashTag() {
        listHastagDetail.setLayoutManager(new LinearLayoutManager(this));
        listHastagDetail.setAdapter(new HashtagDetailAdapter(hashtagDetailList.getName(),hashtagDetailList.getDetailList(), DetailActivity.this, itemClickListener));
    }
    ItemClickListener itemClickListener = (view, position) -> {
        switch (view.getId()){
            case R.id.button_coppy:{
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("coppy",hashtagDetailList.getDetailList().get(position));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Đã coppy", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:{
                finish();
                break;
            }
        }
    }
}