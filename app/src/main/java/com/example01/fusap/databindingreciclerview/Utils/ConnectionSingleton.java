package com.example01.fusap.databindingreciclerview.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example01.fusap.databindingreciclerview.entities.DaoMaster;
import com.example01.fusap.databindingreciclerview.entities.DaoSession;

/**
 * Created by fusap on 7/10/16.
 */
public class ConnectionSingleton {
    private static ConnectionSingleton instance;
    private DaoSession daoSession;
    private static Context context;

    private ConnectionSingleton() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "champion-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public synchronized static DaoSession getSession() {
        if (instance == null)
            instance = new ConnectionSingleton();

        return instance.daoSession;
    }

    public static void setContext(Context c) {
        context = c;
    }
}
