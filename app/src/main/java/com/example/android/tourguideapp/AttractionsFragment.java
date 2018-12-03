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

public class AttractionsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        //Getting arrays of images and strings
        ImagesArray imagesArray = new ImagesArray();
        String[] attractionsLocationUrlArray = getContext().getResources().getStringArray(R.array.attractions_location);
        String[] attractionsNameArray = getContext().getResources().getStringArray(R.array.attractions_name);
        String[] attractionsAdressArray = getContext().getResources().getStringArray(R.array.attractions_adress);

        //Create an array of Attractions
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(imagesArray.getAttractionsImageArray(0), attractionsLocationUrlArray[0], attractionsNameArray[0], attractionsAdressArray[0], 4.3));
        places.add(new Place(imagesArray.getAttractionsImageArray(1), attractionsLocationUrlArray[1], attractionsNameArray[1], attractionsAdressArray[1], 4.2));
        places.add(new Place(imagesArray.getAttractionsImageArray(2), attractionsLocationUrlArray[2], attractionsNameArray[2], attractionsAdressArray[2], 4.2));
        places.add(new Place(imagesArray.getAttractionsImageArray(3), attractionsLocationUrlArray[3], attractionsNameArray[3], attractionsAdressArray[3], 3.9));
        places.add(new Place(imagesArray.getAttractionsImageArray(4), attractionsLocationUrlArray[4], attractionsNameArray[4], attractionsAdressArray[4], 4.2));
        places.add(new Place(imagesArray.getAttractionsImageArray(5), attractionsLocationUrlArray[5], attractionsNameArray[5], attractionsAdressArray[5], 3.9));
        places.add(new Place(imagesArray.getAttractionsImageArray(6), attractionsLocationUrlArray[6], attractionsNameArray[6], attractionsAdressArray[6], 4.3));

        //Create instance of PlaceAdapter and set it to RecyclerView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
