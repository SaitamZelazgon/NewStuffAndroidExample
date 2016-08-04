package com.example01.fusap.databindingreciclerview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example01.fusap.databindingreciclerview.Events.DataArrivedEvent;
import com.example01.fusap.databindingreciclerview.Utils.ConnectionSingleton;
import com.example01.fusap.databindingreciclerview.Utils.ImageLoaderSingleton;
import com.example01.fusap.databindingreciclerview.entities.Champion;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        final Champion c = ConnectionSingleton.getSession().getChampionDao().load(new Long(position + 1));

        holder.textView.setText(Html.fromHtml(c.getName()));
        holder.image.setImageUrl(c.getImageUrl(), ImageLoaderSingleton.getInstance().getImageLoader());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),StatsActivity.class);
                intent.putExtra("imageUrl",c.getImageUrl());

                v.getContext().startActivity(intent);
            }
        });
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
