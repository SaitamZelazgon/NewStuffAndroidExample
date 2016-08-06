package com.example01.fusap.databindingreciclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.PopupWindow;
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
        stats.setText("armor:\t" + event.c.getAtributes().getArmor()+ "\n" +
                      "armorperlevel:\t" + event.c.getAtributes().getArmorperlevel() + "\n" +
                        "attackdamage:\t" + event.c.getAtributes().getAttackdamage() + "\n" +
                        "attackdamageperlevel:\t" + event.c.getAtributes().getAttackdamageperlevel() + "\n" +
                        "attackrange:\t" + event.c.getAtributes().getAttackrange() + "\n" +
                        "attackspeedoffset:\t" + event.c.getAtributes().getAttackspeedoffset() + "\n" +
                        "attackspeedperlevel:\t" + event.c.getAtributes().getAttackspeedperlevel() + "\n" +
                        "crit:\t" + event.c.getAtributes().getCrit() + "\n" +
                        "critperlevel:\t" + event.c.getAtributes().getCritperlevel() + "\n" +
                        "hp:\t" + event.c.getAtributes().getHp() + "\n" +
                        "hpperlevel:\t" + event.c.getAtributes().getHpperlevel() + "\n" +
                        "hpregen:\t" + event.c.getAtributes().getHpregen() + "\n" +
                        "hpregenperlevel:\t" + event.c.getAtributes().getHpregenperlevel() + "\n" +
                        "movespeed:\t" + event.c.getAtributes().getMovespeed() + "\n" +
                        "mp:\t" + event.c.getAtributes().getMp() + "\n" +
                        "mpperlevel:\t" + event.c.getAtributes().getMpperlevel() + "\n" +
                        "mpregen:\t" + event.c.getAtributes().getMpregen() + "\n" +
                        "mpregenperlevel:\t" + event.c.getAtributes().getMpregenperlevel() + "\n" +
                        "spellblock:\t" + event.c.getAtributes().getSpellblock() + "\n" +
                        "spellblockperlevel:\t" + event.c.getAtributes().getSpellblockperlevel());

    }





    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }
}
