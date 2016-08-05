package com.example01.fusap.databindingreciclerview.entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHAMPION_STATS".
*/
public class ChampionStatsDao extends AbstractDao<ChampionStats, Long> {

    public static final String TABLENAME = "CHAMPION_STATS";

    /**
     * Properties of entity ChampionStats.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Armor = new Property(1, Double.class, "armor", false, "ARMOR");
        public final static Property Armorperlevel = new Property(2, Double.class, "armorperlevel", false, "ARMORPERLEVEL");
        public final static Property Attackdamage = new Property(3, Double.class, "attackdamage", false, "ATTACKDAMAGE");
        public final static Property Attackdamageperlevel = new Property(4, Double.class, "attackdamageperlevel", false, "ATTACKDAMAGEPERLEVEL");
        public final static Property Attackrange = new Property(5, Double.class, "attackrange", false, "ATTACKRANGE");
        public final static Property Attackspeedoffset = new Property(6, Double.class, "attackspeedoffset", false, "ATTACKSPEEDOFFSET");
        public final static Property Attackspeedperlevel = new Property(7, Double.class, "attackspeedperlevel", false, "ATTACKSPEEDPERLEVEL");
        public final static Property Crit = new Property(8, Double.class, "crit", false, "CRIT");
        public final static Property Critperlevel = new Property(9, Double.class, "critperlevel", false, "CRITPERLEVEL");
        public final static Property Hp = new Property(10, Double.class, "hp", false, "HP");
        public final static Property Hpperlevel = new Property(11, Double.class, "hpperlevel", false, "HPPERLEVEL");
        public final static Property Hpregen = new Property(12, Double.class, "hpregen", false, "HPREGEN");
        public final static Property Hpregenperlevel = new Property(13, Double.class, "hpregenperlevel", false, "HPREGENPERLEVEL");
        public final static Property Movespeed = new Property(14, Double.class, "movespeed", false, "MOVESPEED");
        public final static Property Mp = new Property(15, Double.class, "mp", false, "MP");
        public final static Property Mpperlevel = new Property(16, Double.class, "mpperlevel", false, "MPPERLEVEL");
        public final static Property Mpregen = new Property(17, Double.class, "mpregen", false, "MPREGEN");
        public final static Property Mpregenperlevel = new Property(18, Double.class, "mpregenperlevel", false, "MPREGENPERLEVEL");
        public final static Property Spellblock = new Property(19, Double.class, "spellblock", false, "SPELLBLOCK");
        public final static Property Spellblockperlevel = new Property(20, Double.class, "spellblockperlevel", false, "SPELLBLOCKPERLEVEL");
    };


    public ChampionStatsDao(DaoConfig config) {
        super(config);
    }
    
    public ChampionStatsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHAMPION_STATS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ARMOR\" REAL," + // 1: armor
                "\"ARMORPERLEVEL\" REAL," + // 2: armorperlevel
                "\"ATTACKDAMAGE\" REAL," + // 3: attackdamage
                "\"ATTACKDAMAGEPERLEVEL\" REAL," + // 4: attackdamageperlevel
                "\"ATTACKRANGE\" REAL," + // 5: attackrange
                "\"ATTACKSPEEDOFFSET\" REAL," + // 6: attackspeedoffset
                "\"ATTACKSPEEDPERLEVEL\" REAL," + // 7: attackspeedperlevel
                "\"CRIT\" REAL," + // 8: crit
                "\"CRITPERLEVEL\" REAL," + // 9: critperlevel
                "\"HP\" REAL," + // 10: hp
                "\"HPPERLEVEL\" REAL," + // 11: hpperlevel
                "\"HPREGEN\" REAL," + // 12: hpregen
                "\"HPREGENPERLEVEL\" REAL," + // 13: hpregenperlevel
                "\"MOVESPEED\" REAL," + // 14: movespeed
                "\"MP\" REAL," + // 15: mp
                "\"MPPERLEVEL\" REAL," + // 16: mpperlevel
                "\"MPREGEN\" REAL," + // 17: mpregen
                "\"MPREGENPERLEVEL\" REAL," + // 18: mpregenperlevel
                "\"SPELLBLOCK\" REAL," + // 19: spellblock
                "\"SPELLBLOCKPERLEVEL\" REAL);"); // 20: spellblockperlevel
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHAMPION_STATS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ChampionStats entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Double armor = entity.getArmor();
        if (armor != null) {
            stmt.bindDouble(2, armor);
        }
 
        Double armorperlevel = entity.getArmorperlevel();
        if (armorperlevel != null) {
            stmt.bindDouble(3, armorperlevel);
        }
 
        Double attackdamage = entity.getAttackdamage();
        if (attackdamage != null) {
            stmt.bindDouble(4, attackdamage);
        }
 
        Double attackdamageperlevel = entity.getAttackdamageperlevel();
        if (attackdamageperlevel != null) {
            stmt.bindDouble(5, attackdamageperlevel);
        }
 
        Double attackrange = entity.getAttackrange();
        if (attackrange != null) {
            stmt.bindDouble(6, attackrange);
        }
 
        Double attackspeedoffset = entity.getAttackspeedoffset();
        if (attackspeedoffset != null) {
            stmt.bindDouble(7, attackspeedoffset);
        }
 
        Double attackspeedperlevel = entity.getAttackspeedperlevel();
        if (attackspeedperlevel != null) {
            stmt.bindDouble(8, attackspeedperlevel);
        }
 
        Double crit = entity.getCrit();
        if (crit != null) {
            stmt.bindDouble(9, crit);
        }
 
        Double critperlevel = entity.getCritperlevel();
        if (critperlevel != null) {
            stmt.bindDouble(10, critperlevel);
        }
 
        Double hp = entity.getHp();
        if (hp != null) {
            stmt.bindDouble(11, hp);
        }
 
        Double hpperlevel = entity.getHpperlevel();
        if (hpperlevel != null) {
            stmt.bindDouble(12, hpperlevel);
        }
 
        Double hpregen = entity.getHpregen();
        if (hpregen != null) {
            stmt.bindDouble(13, hpregen);
        }
 
        Double hpregenperlevel = entity.getHpregenperlevel();
        if (hpregenperlevel != null) {
            stmt.bindDouble(14, hpregenperlevel);
        }
 
        Double movespeed = entity.getMovespeed();
        if (movespeed != null) {
            stmt.bindDouble(15, movespeed);
        }
 
        Double mp = entity.getMp();
        if (mp != null) {
            stmt.bindDouble(16, mp);
        }
 
        Double mpperlevel = entity.getMpperlevel();
        if (mpperlevel != null) {
            stmt.bindDouble(17, mpperlevel);
        }
 
        Double mpregen = entity.getMpregen();
        if (mpregen != null) {
            stmt.bindDouble(18, mpregen);
        }
 
        Double mpregenperlevel = entity.getMpregenperlevel();
        if (mpregenperlevel != null) {
            stmt.bindDouble(19, mpregenperlevel);
        }
 
        Double spellblock = entity.getSpellblock();
        if (spellblock != null) {
            stmt.bindDouble(20, spellblock);
        }
 
        Double spellblockperlevel = entity.getSpellblockperlevel();
        if (spellblockperlevel != null) {
            stmt.bindDouble(21, spellblockperlevel);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ChampionStats entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Double armor = entity.getArmor();
        if (armor != null) {
            stmt.bindDouble(2, armor);
        }
 
        Double armorperlevel = entity.getArmorperlevel();
        if (armorperlevel != null) {
            stmt.bindDouble(3, armorperlevel);
        }
 
        Double attackdamage = entity.getAttackdamage();
        if (attackdamage != null) {
            stmt.bindDouble(4, attackdamage);
        }
 
        Double attackdamageperlevel = entity.getAttackdamageperlevel();
        if (attackdamageperlevel != null) {
            stmt.bindDouble(5, attackdamageperlevel);
        }
 
        Double attackrange = entity.getAttackrange();
        if (attackrange != null) {
            stmt.bindDouble(6, attackrange);
        }
 
        Double attackspeedoffset = entity.getAttackspeedoffset();
        if (attackspeedoffset != null) {
            stmt.bindDouble(7, attackspeedoffset);
        }
 
        Double attackspeedperlevel = entity.getAttackspeedperlevel();
        if (attackspeedperlevel != null) {
            stmt.bindDouble(8, attackspeedperlevel);
        }
 
        Double crit = entity.getCrit();
        if (crit != null) {
            stmt.bindDouble(9, crit);
        }
 
        Double critperlevel = entity.getCritperlevel();
        if (critperlevel != null) {
            stmt.bindDouble(10, critperlevel);
        }
 
        Double hp = entity.getHp();
        if (hp != null) {
            stmt.bindDouble(11, hp);
        }
 
        Double hpperlevel = entity.getHpperlevel();
        if (hpperlevel != null) {
            stmt.bindDouble(12, hpperlevel);
        }
 
        Double hpregen = entity.getHpregen();
        if (hpregen != null) {
            stmt.bindDouble(13, hpregen);
        }
 
        Double hpregenperlevel = entity.getHpregenperlevel();
        if (hpregenperlevel != null) {
            stmt.bindDouble(14, hpregenperlevel);
        }
 
        Double movespeed = entity.getMovespeed();
        if (movespeed != null) {
            stmt.bindDouble(15, movespeed);
        }
 
        Double mp = entity.getMp();
        if (mp != null) {
            stmt.bindDouble(16, mp);
        }
 
        Double mpperlevel = entity.getMpperlevel();
        if (mpperlevel != null) {
            stmt.bindDouble(17, mpperlevel);
        }
 
        Double mpregen = entity.getMpregen();
        if (mpregen != null) {
            stmt.bindDouble(18, mpregen);
        }
 
        Double mpregenperlevel = entity.getMpregenperlevel();
        if (mpregenperlevel != null) {
            stmt.bindDouble(19, mpregenperlevel);
        }
 
        Double spellblock = entity.getSpellblock();
        if (spellblock != null) {
            stmt.bindDouble(20, spellblock);
        }
 
        Double spellblockperlevel = entity.getSpellblockperlevel();
        if (spellblockperlevel != null) {
            stmt.bindDouble(21, spellblockperlevel);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ChampionStats readEntity(Cursor cursor, int offset) {
        ChampionStats entity = new ChampionStats( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getDouble(offset + 1), // armor
            cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2), // armorperlevel
            cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3), // attackdamage
            cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4), // attackdamageperlevel
            cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5), // attackrange
            cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6), // attackspeedoffset
            cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7), // attackspeedperlevel
            cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8), // crit
            cursor.isNull(offset + 9) ? null : cursor.getDouble(offset + 9), // critperlevel
            cursor.isNull(offset + 10) ? null : cursor.getDouble(offset + 10), // hp
            cursor.isNull(offset + 11) ? null : cursor.getDouble(offset + 11), // hpperlevel
            cursor.isNull(offset + 12) ? null : cursor.getDouble(offset + 12), // hpregen
            cursor.isNull(offset + 13) ? null : cursor.getDouble(offset + 13), // hpregenperlevel
            cursor.isNull(offset + 14) ? null : cursor.getDouble(offset + 14), // movespeed
            cursor.isNull(offset + 15) ? null : cursor.getDouble(offset + 15), // mp
            cursor.isNull(offset + 16) ? null : cursor.getDouble(offset + 16), // mpperlevel
            cursor.isNull(offset + 17) ? null : cursor.getDouble(offset + 17), // mpregen
            cursor.isNull(offset + 18) ? null : cursor.getDouble(offset + 18), // mpregenperlevel
            cursor.isNull(offset + 19) ? null : cursor.getDouble(offset + 19), // spellblock
            cursor.isNull(offset + 20) ? null : cursor.getDouble(offset + 20) // spellblockperlevel
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ChampionStats entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setArmor(cursor.isNull(offset + 1) ? null : cursor.getDouble(offset + 1));
        entity.setArmorperlevel(cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2));
        entity.setAttackdamage(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setAttackdamageperlevel(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        entity.setAttackrange(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setAttackspeedoffset(cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6));
        entity.setAttackspeedperlevel(cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7));
        entity.setCrit(cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8));
        entity.setCritperlevel(cursor.isNull(offset + 9) ? null : cursor.getDouble(offset + 9));
        entity.setHp(cursor.isNull(offset + 10) ? null : cursor.getDouble(offset + 10));
        entity.setHpperlevel(cursor.isNull(offset + 11) ? null : cursor.getDouble(offset + 11));
        entity.setHpregen(cursor.isNull(offset + 12) ? null : cursor.getDouble(offset + 12));
        entity.setHpregenperlevel(cursor.isNull(offset + 13) ? null : cursor.getDouble(offset + 13));
        entity.setMovespeed(cursor.isNull(offset + 14) ? null : cursor.getDouble(offset + 14));
        entity.setMp(cursor.isNull(offset + 15) ? null : cursor.getDouble(offset + 15));
        entity.setMpperlevel(cursor.isNull(offset + 16) ? null : cursor.getDouble(offset + 16));
        entity.setMpregen(cursor.isNull(offset + 17) ? null : cursor.getDouble(offset + 17));
        entity.setMpregenperlevel(cursor.isNull(offset + 18) ? null : cursor.getDouble(offset + 18));
        entity.setSpellblock(cursor.isNull(offset + 19) ? null : cursor.getDouble(offset + 19));
        entity.setSpellblockperlevel(cursor.isNull(offset + 20) ? null : cursor.getDouble(offset + 20));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ChampionStats entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ChampionStats entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
