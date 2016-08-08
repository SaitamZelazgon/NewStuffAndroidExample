package com.example01.fusap.databindingreciclerview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example01.fusap.databindingreciclerview.Events.PaintEvent;
import com.example01.fusap.databindingreciclerview.Events.TranfersChampionEvent;
import com.example01.fusap.databindingreciclerview.Utils.ConnectionSingleton;
import com.example01.fusap.databindingreciclerview.Utils.ImageLoaderSingleton;
import com.example01.fusap.databindingreciclerview.entities.Champion;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ChampionLoreActivity extends AppCompatActivity {
    private Champion c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChampionEvent(TranfersChampionEvent event) {
        c = ConnectionSingleton.getSession().getChampionDao().load(event.idChampion);
        NetworkImageView imgChampion = (NetworkImageView) findViewById(R.id.img_champion);
        CollapsingToolbarLayout cpv = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        TextView lore = (TextView) findViewById(R.id.text_lore);
        cpv.setTitle(c.getName());
        String urlImg = c.getImageUrl();
        imgChampion.setImageUrl(urlImg, ImageLoaderSingleton.getInstance().getImageLoader());
        lore.setText(Html.fromHtml(c.getLore()));

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                c.setRead(true);
                ConnectionSingleton.getSession().getChampionDao().insertOrReplace(c);
                EventBus.getDefault().postSticky(new PaintEvent(new Integer(c.getId().toString()) - 1));
                return null;
            }

        }.execute();

    }
}
