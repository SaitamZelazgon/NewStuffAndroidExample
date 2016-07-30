package com.example01.fusap.databindingreciclerview;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
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

/**
 * Created by fusap on 7/9/16.
 */
public class CampionsListAdapter extends RecyclerView.Adapter<CampionsListAdapter.ViewHolder> {

    @Override
    public CampionsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.champion_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CampionsListAdapter.ViewHolder holder, int position) {
        Champion c = ConnectionSingleton.getSession().getChampionDao().load(new Long(position + 1));

        holder.textView.setText(Html.fromHtml(c.getLore()));
        holder.image.setImageUrl(c.getImageUrl(), ImageLoaderSingleton.getInstance().getImageLoader());
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDataArrived(DataArrivedEvent d) {
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return new Float(ConnectionSingleton.getSession().getChampionDao().count()).intValue();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout ll;
        public NetworkImageView image;
        public TextView textView;

        public ViewHolder(LinearLayout itemView) {
            super(itemView);
            ll = itemView;
            image = (NetworkImageView) ll.findViewById(R.id.champ_icon);
            textView = (TextView) ll.findViewById(R.id.champ_lore);
        }
    }
}
