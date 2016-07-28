package com.example01.fusap.databindingreciclerview;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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
import com.example01.fusap.databindingreciclerview.entities.ChampionDao;

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
    private ProgressDialog progressBar;

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

        progressBar = new ProgressDialog(this);
        progressBar.setMessage(getString(R.string.loading));
    }

    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, event.message, Toast.LENGTH_LONG).show();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void newItemsArrived(DataArrivedEvent event) {
        progressBar.cancel();
        rcw.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        EventBus.getDefault().register(mAdapter);

        progressBar.show();
        //Aatrox.png

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

                                        if (ConnectionSingleton.getSession().getChampionDao().queryBuilder().where(ChampionDao.Properties.RiotApiId.eq(id)).count() == 0)
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
                        EventBus.getDefault().postSticky(new DataArrivedEvent());
                    }
                }) {
        };

        // Add the request to the RequestQueue.
        jsonObjectRequest.setTag(TAG);
        NetworkCacheSingleton.getQueue().add(jsonObjectRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().unregister(mAdapter);
        progressBar.cancel();
    }

}

