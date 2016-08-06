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
        stats.setText("Armor:" + event.c.getAtributes().getArmor()+ "\n" +
                      "armorperlevel:" + event.c.getAtributes().getArmorperlevel() + "\n" +
                        "attackdamage:" + event.c.getAtributes().getAttackdamage() + "\n" +
                        "attackdamageperlevel:" + event.c.getAtributes().getAttackdamageperlevel() + "\n" +
                        "attackrange:" + event.c.getAtributes().getAttackrange() + "\n" +
                        "attackspeedoffset:" + event.c.getAtributes().getAttackspeedoffset() + "\n" +
                        "attackspeedperlevel:" + event.c.getAtributes().getAttackspeedperlevel() + "\n" +
                        "crit:" + event.c.getAtributes().getCrit() + "\n" +
                        "critperlevel:" + event.c.getAtributes().getCritperlevel() + "\n" +
                        "hp:" + event.c.getAtributes().getHp() + "\n" +
                        "hpperlevel:" + event.c.getAtributes().getHpperlevel() + "\n" +
                        "hpregen:" + event.c.getAtributes().getHpregen() + "\n" +
                        "hpregenperlevel:" + event.c.getAtributes().getHpregenperlevel() + "\n" +
                        "movespeed:" + event.c.getAtributes().getMovespeed() + "\n" +
                        "mp:" + event.c.getAtributes().getMp() + "\n" +
                        "mpperlevel:" + event.c.getAtributes().getMpperlevel() + "\n" +
                        "mpregen:" + event.c.getAtributes().getMpregen() + "\n" +
                        "mpregenperlevel:" + event.c.getAtributes().getMpregenperlevel() + "\n" +
                        "spellblock:" + event.c.getAtributes().getSpellblock() + "\n" +
                        "spellblockperlevel:" + event.c.getAtributes().getSpellblockperlevel());

    }





    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }
}
