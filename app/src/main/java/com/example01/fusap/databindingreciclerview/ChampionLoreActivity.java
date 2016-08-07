package com.example01.fusap.databindingreciclerview;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example01.fusap.databindingreciclerview.Utils.ImageLoaderSingleton;

public class ChampionLoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NetworkImageView imgChampion = (NetworkImageView) findViewById(R.id.img_champion);
        CollapsingToolbarLayout cpv = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        TextView lore = (TextView) findViewById(R.id.text_lore);
        cpv.setTitle(getIntent().getExtras().getString("nameChampion"));
        String urlImg = getIntent().getExtras().getString("imageUrl");
        imgChampion.setImageUrl(urlImg, ImageLoaderSingleton.getInstance().getImageLoader());
        lore.setText(Html.fromHtml(getIntent().getExtras().getString("lore")));



    }
}
