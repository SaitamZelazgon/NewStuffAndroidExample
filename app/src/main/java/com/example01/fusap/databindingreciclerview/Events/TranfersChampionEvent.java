package com.example01.fusap.databindingreciclerview.Events;

import com.example01.fusap.databindingreciclerview.entities.Champion;

/**
 * Created by fusap on 8/5/16.
 */
public class TranfersChampionEvent {

    public final Champion c;
    public final Long key;

    public TranfersChampionEvent(Champion c, Long key) {
        this.c = c;
        this.key = key;
    }
}
