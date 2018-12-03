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

public class PublicTransitFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        //Getting arrays of images and strings
        ImagesArray imagesArray = new ImagesArray();
        String[] publicTransitWebsiteUrlArray = getContext().getResources().getStringArray(R.array.public_transit_websites);
        String[] publicTransitNameArray = getContext().getResources().getStringArray(R.array.public_transit_name);

        //Create an array of Public Transit
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(imagesArray.getPublicTransitImageArray(0), publicTransitWebsiteUrlArray[0], publicTransitNameArray[0]));
        places.add(new Place(imagesArray.getPublicTransitImageArray(1), publicTransitWebsiteUrlArray[1], publicTransitNameArray[1]));
        places.add(new Place(imagesArray.getPublicTransitImageArray(2), publicTransitWebsiteUrlArray[2], publicTransitNameArray[2]));
        places.add(new Place(imagesArray.getPublicTransitImageArray(3), publicTransitWebsiteUrlArray[3], publicTransitNameArray[3]));

        //Create instance of PlaceAdapter and set it to RecyclerView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
