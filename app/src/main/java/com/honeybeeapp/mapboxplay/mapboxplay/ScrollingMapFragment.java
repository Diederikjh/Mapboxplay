package com.honeybeeapp.mapboxplay.mapboxplay;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScrollingMapFragment extends Fragment {


    public ScrollingMapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scrolling_map, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View fragmentRootView = getView();
        MapView mapView = fragmentRootView.findViewById(R.id.map_view);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

            }
        });

    }
}
