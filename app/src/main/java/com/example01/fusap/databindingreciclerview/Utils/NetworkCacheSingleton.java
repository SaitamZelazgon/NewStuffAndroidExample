package com.example01.fusap.databindingreciclerview.Utils;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by fusap on 7/10/16.
 */
public class NetworkCacheSingleton {
    private RequestQueue mRequestQueue;
    private static Context mContext;
    private Cache mCache;
    private static NetworkCacheSingleton instance;

    // Set up the network to use HttpURLConnection as the HTTP client.
    Network network = new BasicNetwork(new HurlStack());

    private NetworkCacheSingleton() {
        // Instantiate the RequestQueue with the cache and network.
        // Instantiate the cache
        mCache = new DiskBasedCache(mContext.getCacheDir(), 1024 * 1024 * 4); // 4MB cap
        mRequestQueue = new RequestQueue(mCache, network);
        // Start the queue
        mRequestQueue.start();
    }

    public static void setContext(Context c) {
        mContext = c;
    }

    public synchronized static RequestQueue getQueue() {
        if (instance == null)
            instance = new NetworkCacheSingleton();

        return instance.mRequestQueue;
    }
}
