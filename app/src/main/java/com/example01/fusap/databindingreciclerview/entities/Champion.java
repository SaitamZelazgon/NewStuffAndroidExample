package com.example01.fusap.databindingreciclerview.entities;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
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
    private Boolean read;

    @ToOne(joinProperty = "id")
    private ChampionStats atributes;

    @Generated(hash = 1101598407)
    private transient Long atributes__resolvedKey;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1051364770)
    private transient ChampionDao myDao;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

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

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1874034863)
    public void setAtributes(ChampionStats atributes) {
        synchronized (this) {
            this.atributes = atributes;
            id = atributes == null ? null : atributes.getId();
            atributes__resolvedKey = id;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1177783924)
    public ChampionStats getAtributes() {
        Long __key = this.id;
        if (atributes__resolvedKey == null || !atributes__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChampionStatsDao targetDao = daoSession.getChampionStatsDao();
            ChampionStats atributesNew = targetDao.load(__key);
            synchronized (this) {
                atributes = atributesNew;
                atributes__resolvedKey = __key;
            }
        }
        return atributes;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1683649848)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getChampionDao() : null;
    }

    public Champion() {

    }

    @Generated(hash = 1720051751)
    public Champion(Long id, String name, String imageUrl, String lore, Long riotApiId,
            Boolean read) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.lore = lore;
        this.riotApiId = riotApiId;
        this.read = read;
    }

}
