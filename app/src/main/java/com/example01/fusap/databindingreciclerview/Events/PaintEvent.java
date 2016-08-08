package com.example01.fusap.databindingreciclerview.Events;

/**
 * Created by fusap on 8/8/16.
 */
public class PaintEvent {
    Integer itemPosition = 0;

    public PaintEvent(Integer itemPosition) {
        this.itemPosition = itemPosition;
    }

    public Integer getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(Integer itemPosition) {
        this.itemPosition = itemPosition;
    }
}
