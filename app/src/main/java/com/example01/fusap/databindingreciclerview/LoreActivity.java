package com.example01.fusap.databindingreciclerview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example01.fusap.databindingreciclerview.Events.TranfersChampionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoreActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lore);

    }

    @Override
    protected void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);

    }
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChampionEvent(TranfersChampionEvent event){
        TextView stats = (TextView) findViewById(R.id.text_stats);
        stats.setText("Armor:" + event.c.getAtributes().getArmor());

    }





    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }
}
