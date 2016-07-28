package com.example01.fusap.databindingreciclerview.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by fusap on 7/10/16.
 */
@Entity
public class Champion {
    @Id
    private Long id;

    @Unique
    private String name;
    private String imageUrl;
    private String lore;
    private Long riotApiId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public Long getRiotApiId() {
        return riotApiId;
    }

    public void setRiotApiId(Long riotApiId) {
        this.riotApiId = riotApiId;
    }

    @Generated(hash = 1872717816)
    public Champion(Long id, String name, String imageUrl, String lore,
            Long riotApiId) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.lore = lore;
        this.riotApiId = riotApiId;
    }

    public Champion(){

    }

}
