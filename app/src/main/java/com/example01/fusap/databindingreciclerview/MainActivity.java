package com.example01.fusap.databindingreciclerview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example01.fusap.databindingreciclerview.Events.DataArrivedEvent;
import com.example01.fusap.databindingreciclerview.Events.MessageEvent;
import com.example01.fusap.databindingreciclerview.Utils.ConnectionSingleton;
import com.example01.fusap.databindingreciclerview.Utils.ImageLoaderSingleton;
import com.example01.fusap.databindingreciclerview.Utils.NetworkCacheSingleton;
import com.example01.fusap.databindingreciclerview.entities.Champion;
import com.example01.fusap.databindingreciclerview.entities.ChampionStats;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Main";
    private CampionsListAdapter mAdapter;
    private RecyclerView rcw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConnectionSingleton.setContext(getApplicationContext());
        ImageLoaderSingleton.setContext(getApplicationContext());
        NetworkCacheSingleton.setContext(getApplicationContext());

        setContentView(R.layout.activity_main);

        rcw = (RecyclerView) findViewById(R.id.campions_list);

        rcw.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rcw.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CampionsListAdapter();

        rcw.setItemAnimator(new DefaultItemAnimator());
        rcw.setAdapter(mAdapter);
    }

    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, event.message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        EventBus.getDefault().register(mAdapter);

        // Request a string response from the provided URL.

            JSONObject response = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                    "https://global.api.pvp.net/api/lol/static-data/las/v1.2/champion?locale=en_US&champData=image,lore,stats&api_key=bdab9731-453d-400b-9b78-1ed18b613db5",
                    response,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            new AsyncTask<JSONObject, Void, Void>() {
                                @Override
                                protected Void doInBackground(JSONObject... params) {
                                    JSONObject response = params[0];
                                    try {
                                        Iterator<String> it = response.getJSONObject("data").keys();

                                        for (; it.hasNext(); ) {
                                            String championName = it.next();
                                            String imageUrl = "http://ddragon.leagueoflegends.com/cdn/5.14.1/img/champion/" + response.getJSONObject("data").getJSONObject(championName).getJSONObject("image").getString("full");
                                            String lore = response.getJSONObject("data").getJSONObject(championName).getString("lore");
                                            Long id = response.getJSONObject("data").getJSONObject(championName).getLong("id");

                                            Champion champion = new Champion();
                                            champion.setLore(lore);
                                            champion.setImageUrl(imageUrl);
                                            champion.setName(championName);
                                            champion.setRiotApiId(id);

                                            ChampionStats stats = new ChampionStats();
                                            stats.setArmor(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("armor"));
                                            stats.setArmorperlevel( response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("armorperlevel"));
                                            stats.setAttackdamage(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackdamage"));
                                            stats.setAttackdamageperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackdamageperlevel"));
                                            stats.setAttackrange(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackrange"));
                                            stats.setAttackspeedoffset(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackspeedoffset"));
                                            stats.setAttackspeedperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("attackspeedperlevel"));
                                            stats.setCrit(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("crit"));
                                            stats.setCritperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("critperlevel"));
                                            stats.setHp(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hp"));
                                            stats.setHpperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hpperlevel"));
                                            stats.setHpregen(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hpregen"));
                                            stats.setHpregenperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("hpregenperlevel"));
                                            stats.setMovespeed(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("movespeed"));
                                            stats.setMp(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mp"));
                                            stats.setMpperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mpperlevel"));
                                            stats.setMpregen(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mpregen"));
                                            stats.setMpregenperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("mpregenperlevel"));
                                            stats.setSpellblock(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("spellblock"));
                                            stats.setSpellblockperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("spellblockperlevel"));

                                            champion.setAtributes(stats);

                                            ConnectionSingleton.getSession().getChampionDao().insert(champion);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(Void v) {
                                    EventBus.getDefault().postSticky(new DataArrivedEvent());
                                }
                            }.execute(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            EventBus.getDefault().postSticky(new MessageEvent("Connection Error."));
                        }
                    }) {
            };

            // Add the request to the RequestQueue.
            jsonObjectRequest.setTag(TAG);
            jsonObjectRequest.setShouldCache(true);
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                    15,
                    2f));
            NetworkCacheSingleton.getQueue().add(jsonObjectRequest);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().unregister(mAdapter);
    }

}

