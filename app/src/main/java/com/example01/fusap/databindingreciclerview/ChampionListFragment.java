package com.example01.fusap.databindingreciclerview;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChampionListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChampionListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChampionListFragment extends Fragment {
    public static final String TAG = "Main";
    private CampionsListAdapter mAdapter;
    private RecyclerView rcw;
    private FrameLayout fl;
    private FragmentActivity faActivity;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ChampionListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChampionListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChampionListFragment newInstance(String param1, String param2) {
        ChampionListFragment fragment = new ChampionListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        ConnectionSingleton.setContext(getContext());
        ImageLoaderSingleton.setContext(getContext());
        NetworkCacheSingleton.setContext(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fl = (FrameLayout) inflater.inflate(R.layout.fragment_champion_list, container, false);

        rcw = (RecyclerView) fl.findViewById(R.id.campions_list);

        rcw.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rcw.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CampionsListAdapter();

        rcw.setItemAnimator(new DefaultItemAnimator());

        rcw.setAdapter(mAdapter);

        return fl;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(getContext(), event.message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        EventBus.getDefault().register(mAdapter);

        // Request a string response from the provided URL.
        if (ConnectionSingleton.getSession().getChampionDao().count() == 0) {
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
                                            champion.setRead(false);

                                            ChampionStats stats = new ChampionStats();
                                            stats.setArmor(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("armor"));
                                            stats.setArmorperlevel(response.getJSONObject("data").getJSONObject(championName).getJSONObject("stats").getDouble("armorperlevel"));
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

                                            ConnectionSingleton.getSession().getChampionStatsDao().insertOrReplace(stats);

                                            champion.setAtributes(stats);

                                            ConnectionSingleton.getSession().getChampionDao().insertOrReplace(champion);
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
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().unregister(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        NetworkCacheSingleton.getQueue().cancelAll(TAG);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
