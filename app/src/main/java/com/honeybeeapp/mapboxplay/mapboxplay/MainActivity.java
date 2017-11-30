package com.honeybeeapp.mapboxplay.mapboxplay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initMapbox(this);

        setContentView(R.layout.activity_main);

        /*MapView map = (MapView) findViewById(R.id.mapView);
        map.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                Toast.makeText(MainActivity.this, R.string.map_ready, Toast.LENGTH_LONG).show();
            }
        });*/

        final SupportMapFragment mapFragment = new SupportMapFragment();
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                Toast.makeText(MainActivity.this, R.string.map_ready, Toast.LENGTH_LONG).show();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.map_frame_layout, mapFragment).commit();

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NavActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BottomActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

    }

    private void initMapbox(Context context) {
        Mapbox.getInstance(this, context.getString(R.string.mapbox_access_token));
    }

}
