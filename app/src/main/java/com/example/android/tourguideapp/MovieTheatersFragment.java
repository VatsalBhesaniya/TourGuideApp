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

public class MovieTheatersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        //Getting arrays of images and strings
        ImagesArray imagesArray = new ImagesArray();
        String[] movieTheaterssWebsiteUrlArray = getContext().getResources().getStringArray(R.array.movie_theaters_websites);
        String[] movieTheatersLocationUrlArray = getContext().getResources().getStringArray(R.array.movie_theaters_location);
        String[] movieTheatersNameArray = getContext().getResources().getStringArray(R.array.movie_theaters_name);
        String[] movieTheatersAdressArray = getContext().getResources().getStringArray(R.array.movie_theaters_adress);

        //Create an array of Movie Theaters
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(imagesArray.getMovieTheatersImageArray(0), movieTheaterssWebsiteUrlArray[0], movieTheatersLocationUrlArray[0], movieTheatersNameArray[0], movieTheatersAdressArray[0], 4.6));
        places.add(new Place(imagesArray.getMovieTheatersImageArray(1), movieTheaterssWebsiteUrlArray[1], movieTheatersLocationUrlArray[1], movieTheatersNameArray[1], movieTheatersAdressArray[1], 4.4));
        places.add(new Place(imagesArray.getMovieTheatersImageArray(2), movieTheaterssWebsiteUrlArray[2], movieTheatersLocationUrlArray[2], movieTheatersNameArray[2], movieTheatersAdressArray[2], 4.0));
        places.add(new Place(imagesArray.getMovieTheatersImageArray(3), movieTheaterssWebsiteUrlArray[3], movieTheatersLocationUrlArray[3], movieTheatersNameArray[3], movieTheatersAdressArray[3], 4.2));
        places.add(new Place(imagesArray.getMovieTheatersImageArray(4), movieTheaterssWebsiteUrlArray[4], movieTheatersLocationUrlArray[4], movieTheatersNameArray[4], movieTheatersAdressArray[4], 3.9));

        //Create instance of PlaceAdapter and set it to RecyclerView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
