package com.honeybeeapp.mapboxplay.mapboxplay;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {

    private MapboxMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initMapbox(this);

        setContentView(R.layout.activity_main);

        final SupportMapFragment mapFragment1 = new SupportMapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map_frame_layout, mapFragment1).commit();

        final LatLng latLng = new LatLng(32, -18);

        mapFragment1.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                mMap = mapboxMap;

                MarkerOptions customerMarker = new MarkerOptions();
                customerMarker.position(latLng);
                customerMarker.title("Hi!");
                mMap.addMarker(customerMarker);
            }
        });

        View button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMap != null) {

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15), new MapboxMap.CancelableCallback() {
                        @Override
                        public void onCancel() {

                        }

                        @Override
                        public void onFinish() {
                            mMap.clear();
                        }
                    });

                }
            }
        });


    }

    private void initMapbox(Context context) {
        Mapbox.getInstance(this, context.getString(R.string.mapbox_access_token));
    }

}
