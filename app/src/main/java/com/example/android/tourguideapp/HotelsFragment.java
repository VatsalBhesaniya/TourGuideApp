package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        //Getting arrays of images and strings
        ImagesArray imagesArray = new ImagesArray();
        String[] hotelsWebsiteUrlArray = getContext().getResources().getStringArray(R.array.hotels_websites);
        String[] hotelsLocationUrlArray = getContext().getResources().getStringArray(R.array.hotels_location);
        String[] hotelsNameArray = getContext().getResources().getStringArray(R.array.hotels_name);
        String[] hotelsAdressArray = getContext().getResources().getStringArray(R.array.hotels_adress);

        //Create an array of Hotels
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(imagesArray.getHotelsImageArray(0), hotelsWebsiteUrlArray[0], hotelsLocationUrlArray[0], hotelsNameArray[0], hotelsAdressArray[0], 4.4));
        places.add(new Place(imagesArray.getHotelsImageArray(1), hotelsWebsiteUrlArray[1], hotelsLocationUrlArray[1], hotelsNameArray[1], hotelsAdressArray[1], 4.4));
        places.add(new Place(imagesArray.getHotelsImageArray(2), hotelsWebsiteUrlArray[2], hotelsLocationUrlArray[2], hotelsNameArray[2], hotelsAdressArray[2], 4.1));
        places.add(new Place(imagesArray.getHotelsImageArray(3), hotelsWebsiteUrlArray[3], hotelsLocationUrlArray[3], hotelsNameArray[3], hotelsAdressArray[3], 4.3));
        places.add(new Place(imagesArray.getHotelsImageArray(4), hotelsWebsiteUrlArray[4], hotelsLocationUrlArray[4], hotelsNameArray[4], hotelsAdressArray[4], 3.8));

        //Create instance of PlaceAdapter and set it to RecyclerView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
