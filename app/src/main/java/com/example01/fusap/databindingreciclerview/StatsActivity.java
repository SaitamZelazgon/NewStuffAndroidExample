package com.example01.fusap.databindingreciclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.volley.toolbox.NetworkImageView;
import com.example01.fusap.databindingreciclerview.Utils.ImageLoaderSingleton;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NetworkImageView imgChampion = (NetworkImageView) findViewById(R.id.img_champion);
        String urlImg = getIntent().getExtras().getString("imageUrl");
        imgChampion.setImageUrl(urlImg, ImageLoaderSingleton.getInstance().getImageLoader());

    }
}
