package com.example01.fusap.databindingreciclerview;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example01.fusap.databindingreciclerview.Events.PaintEvent;
import com.example01.fusap.databindingreciclerview.Events.TranfersChampionEvent;
import com.example01.fusap.databindingreciclerview.Utils.ConnectionSingleton;
import com.example01.fusap.databindingreciclerview.entities.Champion;
import com.example01.fusap.databindingreciclerview.entities.ChampionStats;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class StatsActivityTransparent extends Activity {
    TextView statsText;
    ChampionStats stats;
    Champion c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lore);
        statsText = (TextView) findViewById(R.id.text_stats);
    }

    @Override
    protected void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChampionEvent(TranfersChampionEvent event) {
        c = ConnectionSingleton.getSession().getChampionDao().load(event.idChampion);

        stats = ConnectionSingleton.getSession().getChampionStatsDao().load(event.key);
        statsText.setText("armor:\t" + stats.getArmor() + "\n" +
                "armorperlevel:\t" + stats.getArmorperlevel() + "\n" +
                "attackdamage:\t" + stats.getAttackdamage() + "\n" +
                "attackdamageperlevel:\t" + stats.getAttackdamageperlevel() + "\n" +
                "attackrange:\t" + stats.getAttackrange() + "\n" +
                "attackspeedoffset:\t" + stats.getAttackspeedoffset() + "\n" +
                "attackspeedperlevel:\t" + stats.getAttackspeedperlevel() + "\n" +
                "crit:\t" + stats.getCrit() + "\n" +
                "critperlevel:\t" + stats.getCritperlevel() + "\n" +
                "hp:\t" + stats.getHp() + "\n" +
                "hpperlevel:\t" + stats.getHpperlevel() + "\n" +
                "hpregen:\t" + stats.getHpregen() + "\n" +
                "hpregenperlevel:\t" + stats.getHpregenperlevel() + "\n" +
                "movespeed:\t" + stats.getMovespeed() + "\n" +
                "mp:\t" + stats.getMp() + "\n" +
                "mpperlevel:\t" + stats.getMpperlevel() + "\n" +
                "mpregen:\t" + stats.getMpregen() + "\n" +
                "mpregenperlevel:\t" + stats.getMpregenperlevel() + "\n" +
                "spellblock:\t" + stats.getSpellblock() + "\n" +
                "spellblockperlevel:\t" + stats.getSpellblockperlevel());

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


    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }
}
