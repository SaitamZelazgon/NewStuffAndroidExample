package com.example01.fusap.databindingreciclerview.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by fusap on 8/3/16.
 */
@Entity
public class ChampionStats {
    @Id
    private Long id;

    @Unique
    private Double armor;
    private Double armorperlevel;
    private Double attackdamage;
    private Double attackdamageperlevel;
    private Double attackrange;
    private Double attackspeedoffset;
    private Double attackspeedperlevel;
    private Double crit;
    private Double critperlevel;
    private Double hp;
    private Double hpperlevel;
    private Double hpregen;
    private Double hpregenperlevel;
    private Double movespeed;
    private Double mp;
    private Double mpperlevel;
    private Double mpregen;
    private Double mpregenperlevel;
    private Double spellblock;
    private Double spellblockperlevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getArmor() {
        return armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getArmorperlevel() {
        return armorperlevel;
    }

    public void setArmorperlevel(Double armorperlevel) {
        this.armorperlevel = armorperlevel;
    }

    public Double getAttackdamage() {
        return attackdamage;
    }

    public void setAttackdamage(Double attackdamage) {
        this.attackdamage = attackdamage;
    }

    public Double getAttackdamageperlevel() {
        return attackdamageperlevel;
    }

    public void setAttackdamageperlevel(Double attackdamageperlevel) {
        this.attackdamageperlevel = attackdamageperlevel;
    }

    public Double getAttackrange() {
        return attackrange;
    }

    public void setAttackrange(Double attackrange) {
        this.attackrange = attackrange;
    }

    public Double getAttackspeedoffset() {
        return attackspeedoffset;
    }

    public void setAttackspeedoffset(Double attackspeedoffset) {
        this.attackspeedoffset = attackspeedoffset;
    }

    public Double getAttackspeedperlevel() {
        return attackspeedperlevel;
    }

    public void setAttackspeedperlevel(Double attackspeedperlevel) {
        this.attackspeedperlevel = attackspeedperlevel;
    }

    public Double getCrit() {
        return crit;
    }

    public void setCrit(Double crit) {
        this.crit = crit;
    }

    public Double getCritperlevel() {
        return critperlevel;
    }

    public void setCritperlevel(Double critperlevel) {
        this.critperlevel = critperlevel;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public Double getHpperlevel() {
        return hpperlevel;
    }

    public void setHpperlevel(Double hpperlevel) {
        this.hpperlevel = hpperlevel;
    }

    public Double getHpregen() {
        return hpregen;
    }

    public void setHpregen(Double hpregen) {
        this.hpregen = hpregen;
    }

    public Double getHpregenperlevel() {
        return hpregenperlevel;
    }

    public void setHpregenperlevel(Double hpregenperlevel) {
        this.hpregenperlevel = hpregenperlevel;
    }

    public Double getMovespeed() {
        return movespeed;
    }

    public void setMovespeed(Double movespeed) {
        this.movespeed = movespeed;
    }

    public Double getMp() {
        return mp;
    }

    public void setMp(Double mp) {
        this.mp = mp;
    }

    public Double getMpperlevel() {
        return mpperlevel;
    }

    public void setMpperlevel(Double mpperlevel) {
        this.mpperlevel = mpperlevel;
    }

    public Double getMpregen() {
        return mpregen;
    }

    public void setMpregen(Double mpregen) {
        this.mpregen = mpregen;
    }

    public Double getMpregenperlevel() {
        return mpregenperlevel;
    }

    public void setMpregenperlevel(Double mpregenperlevel) {
        this.mpregenperlevel = mpregenperlevel;
    }

    public Double getSpellblock() {
        return spellblock;
    }

    public void setSpellblock(Double spellblock) {
        this.spellblock = spellblock;
    }

    public Double getSpellblockperlevel() {
        return spellblockperlevel;
    }

    public void setSpellblockperlevel(Double spellblockperlevel) {
        this.spellblockperlevel = spellblockperlevel;
    }

    public ChampionStats() {

    }

    @Generated(hash = 841192864)
    public ChampionStats(Long id, Double armor, Double armorperlevel,
            Double attackdamage, Double attackdamageperlevel, Double attackrange,
            Double attackspeedoffset, Double attackspeedperlevel, Double crit,
            Double critperlevel, Double hp, Double hpperlevel, Double hpregen,
            Double hpregenperlevel, Double movespeed, Double mp, Double mpperlevel,
            Double mpregen, Double mpregenperlevel, Double spellblock,
            Double spellblockperlevel) {
        this.id = id;
        this.armor = armor;
        this.armorperlevel = armorperlevel;
        this.attackdamage = attackdamage;
        this.attackdamageperlevel = attackdamageperlevel;
        this.attackrange = attackrange;
        this.attackspeedoffset = attackspeedoffset;
        this.attackspeedperlevel = attackspeedperlevel;
        this.crit = crit;
        this.critperlevel = critperlevel;
        this.hp = hp;
        this.hpperlevel = hpperlevel;
        this.hpregen = hpregen;
        this.hpregenperlevel = hpregenperlevel;
        this.movespeed = movespeed;
        this.mp = mp;
        this.mpperlevel = mpperlevel;
        this.mpregen = mpregen;
        this.mpregenperlevel = mpregenperlevel;
        this.spellblock = spellblock;
        this.spellblockperlevel = spellblockperlevel;
    }
    

}
