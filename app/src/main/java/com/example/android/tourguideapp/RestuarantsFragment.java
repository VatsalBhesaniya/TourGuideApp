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

public class RestuarantsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        //Getting arrays of images and strings
        ImagesArray imagesArray = new ImagesArray();
        String[] restaurantsWebsiteUrlArray = getContext().getResources().getStringArray(R.array.restaurant_websites);
        String[] restaurantsLocationUrlArray = getContext().getResources().getStringArray(R.array.restaurant_location);
        String[] restaurantsNameArray = getContext().getResources().getStringArray(R.array.restaurant_name);
        String[] restaurantsAdressArray = getContext().getResources().getStringArray(R.array.restaurant_adress);

        //Create an array of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(imagesArray.getRestaurantsImageArray(0), restaurantsWebsiteUrlArray[0], restaurantsLocationUrlArray[0], restaurantsNameArray[0], restaurantsAdressArray[0], 4.6));
        places.add(new Place(imagesArray.getRestaurantsImageArray(1), restaurantsWebsiteUrlArray[1], restaurantsLocationUrlArray[1], restaurantsNameArray[1], restaurantsAdressArray[1], 4.4));
        places.add(new Place(imagesArray.getRestaurantsImageArray(2), restaurantsWebsiteUrlArray[2], restaurantsLocationUrlArray[2], restaurantsNameArray[2], restaurantsAdressArray[2], 4.0));
        places.add(new Place(imagesArray.getRestaurantsImageArray(3), restaurantsWebsiteUrlArray[3], restaurantsLocationUrlArray[3], restaurantsNameArray[3], restaurantsAdressArray[3], 4.2));
        places.add(new Place(imagesArray.getRestaurantsImageArray(4), restaurantsWebsiteUrlArray[4], restaurantsLocationUrlArray[4], restaurantsNameArray[4], restaurantsAdressArray[4], 3.9));
        places.add(new Place(imagesArray.getRestaurantsImageArray(5), restaurantsWebsiteUrlArray[5], restaurantsLocationUrlArray[5], restaurantsNameArray[5], restaurantsAdressArray[5], 4.1));
        places.add(new Place(imagesArray.getRestaurantsImageArray(6), restaurantsWebsiteUrlArray[6], restaurantsLocationUrlArray[6], restaurantsNameArray[6], restaurantsAdressArray[6], 3.8));
        places.add(new Place(imagesArray.getRestaurantsImageArray(7), restaurantsWebsiteUrlArray[7], restaurantsLocationUrlArray[7], restaurantsNameArray[7], restaurantsAdressArray[7], 4.0));
        places.add(new Place(imagesArray.getRestaurantsImageArray(8), restaurantsWebsiteUrlArray[8], restaurantsLocationUrlArray[8], restaurantsNameArray[8], restaurantsAdressArray[8], 4.2));
        places.add(new Place(imagesArray.getRestaurantsImageArray(9), restaurantsWebsiteUrlArray[9], restaurantsLocationUrlArray[9], restaurantsNameArray[9], restaurantsAdressArray[9], 4.1));

        //Create instance of PlaceAdapter and set it to RecyclerView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
