package com.honeybeeapp.mapboxplay.mapboxplay;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initMapbox(this);

        setContentView(R.layout.activity_main);

        final SupportMapFragment mapFragment1 = new SupportMapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map_frame_layout, mapFragment1).commit();

        // Contrived example of mapFragment1 being destroyed before surface view added.

        final SupportMapFragment mapFragment2 = new SupportMapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map_frame_layout, mapFragment2).commit();

    }

    private void initMapbox(Context context) {
        Mapbox.getInstance(this, context.getString(R.string.mapbox_access_token));
    }

}
