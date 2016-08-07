package com.example01.fusap.databindingreciclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example01.fusap.databindingreciclerview.Events.TranfersChampionEvent;
import com.example01.fusap.databindingreciclerview.Utils.ConnectionSingleton;
import com.example01.fusap.databindingreciclerview.entities.ChampionStats;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class StatsActivityTransparent extends Activity {
    TextView statsText;
    ChampionStats stats;


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
    public void onChampionEvent(TranfersChampionEvent event){
        stats = ConnectionSingleton.getSession().getChampionStatsDao().load(event.key);
        statsText.setText("armor:\t" + stats.getArmor()+ "\n" +
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

    }





    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }
}
