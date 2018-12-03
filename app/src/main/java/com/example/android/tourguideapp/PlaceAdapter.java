package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private Context mContext;
    private List<Place> mPlaceList;

    public PlaceAdapter(Context mContext, List<Place> mPlaceList) {
        this.mContext = mContext;
        this.mPlaceList = mPlaceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterViewFlipper adapterViewFlipper;
        private FlipperAdapter adapter;
        private TextView placeName;
        private TextView address;
        private TextView placeAddress;
        private TextView placerating;
        private RatingBar ratingBar;
        private Button btnWebsite;
        private Button btnLocation;

        public ViewHolder(View view) {
            super(view);
            adapterViewFlipper = view.findViewById(R.id.adapterViewFlipper);
            placeName = view.findViewById(R.id.place_name);
            address = view.findViewById(R.id.address);
            placeAddress = view.findViewById(R.id.place_address);
            placerating = view.findViewById(R.id.place_rating);
            ratingBar = view.findViewById(R.id.place_rating_bar);
            btnWebsite = view.findViewById(R.id.btn_website);
            btnLocation = view.findViewById(R.id.btn_location);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Place currentPlace = mPlaceList.get(position);
        //Creating adapter object
        holder.adapter = new FlipperAdapter(mContext, currentPlace.getImage());
        holder.adapterViewFlipper.setAdapter(holder.adapter);
        holder.adapterViewFlipper.setAutoStart(true);
        holder.placeName.setText(currentPlace.getPlaceName());
        holder.placeName.setSelected(true);

        if (currentPlace.hasAdress()) {
            holder.placeAddress.setText(currentPlace.getPlaceAddress());
        } else {
            holder.address.setVisibility(View.GONE);
            holder.placeAddress.setVisibility(View.GONE);
        }

        if (currentPlace.hasRating()) {
            String rating = "Rating: " + Double.toString(currentPlace.getRating());
            holder.placerating.setText(rating);
            holder.ratingBar.setRating((float) currentPlace.getRating());
        } else {
            holder.placerating.setVisibility(View.GONE);
            holder.ratingBar.setVisibility(View.GONE);
        }

        if (currentPlace.hasWebsite()) {
            final View finalView1 = holder.itemView;
            holder.btnWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = currentPlace.getWebsite();
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                    websiteIntent.setData(Uri.parse(url));
                    //Start the new activity
                    finalView1.getContext().startActivity(websiteIntent);
                }
            });
        } else {
            holder.btnWebsite.setVisibility(View.GONE);
        }

        if (currentPlace.hasLocation()) {
            final View finalView2 = holder.itemView;
            holder.btnLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = currentPlace.getLocation();
                    Intent locationIntent = new Intent(Intent.ACTION_VIEW);
                    locationIntent.setData(Uri.parse(url));
                    finalView2.getContext().startActivity(locationIntent);
                }
            });
        } else {
            holder.btnLocation.setVisibility(View.GONE);
        }
    }

    private class FlipperAdapter extends BaseAdapter {
        Context ctx;
        int[] images;
        LayoutInflater inflater;

        FlipperAdapter(Context context, int[] placeImages) {
            this.ctx = context;
            this.images = placeImages;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.flipper, null);
            ImageView image = view.findViewById(R.id.cover_image);
            image.setImageResource(images[i]);
            return view;
        }
    }
}

