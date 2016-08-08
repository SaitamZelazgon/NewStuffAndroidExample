package com.example01.fusap.databindingreciclerview.Events;

/**
 * Created by fusap on 8/5/16.
 */
public class TranfersChampionEvent {

    public final Long idChampion;
    public final Long key;

    public TranfersChampionEvent(Long idChampion, Long key) {
        this.idChampion = idChampion;
        this.key = key;
    }
}
