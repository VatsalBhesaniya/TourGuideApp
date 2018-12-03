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

public class ShoppingMallsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        //Getting arrays of images and strings
        ImagesArray imagesArray = new ImagesArray();
        String[] shoppingmallsLocationUrlArray = getContext().getResources().getStringArray(R.array.shoppingmalls_location);
        String[] shoppingmallsNameArray = getContext().getResources().getStringArray(R.array.shoppingmalls_name);
        String[] shoppingmallsAdressArray = getContext().getResources().getStringArray(R.array.shoppingmalls_adress);

        //Create an array of Shopping Malls
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(imagesArray.getShoppingMallsImageArray(0), shoppingmallsLocationUrlArray[0], shoppingmallsNameArray[0], shoppingmallsAdressArray[0], 4.6));
        places.add(new Place(imagesArray.getShoppingMallsImageArray(1), shoppingmallsLocationUrlArray[1], shoppingmallsNameArray[1], shoppingmallsAdressArray[1], 4.4));
        places.add(new Place(imagesArray.getShoppingMallsImageArray(2), shoppingmallsLocationUrlArray[2], shoppingmallsNameArray[2], shoppingmallsAdressArray[2], 3.9));
        places.add(new Place(imagesArray.getShoppingMallsImageArray(3), shoppingmallsLocationUrlArray[3], shoppingmallsNameArray[3], shoppingmallsAdressArray[3], 4.0));
        places.add(new Place(imagesArray.getShoppingMallsImageArray(4), shoppingmallsLocationUrlArray[4], shoppingmallsNameArray[4], shoppingmallsAdressArray[4], 4.1));

        //Create instance of PlaceAdapter and set it to RecyclerView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}