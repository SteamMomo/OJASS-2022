package com.release.ojass2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineListener;
import com.mapbox.mapboxsdk.MapmyIndia;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mmi.services.account.MapmyIndiaAccountManager;

public class MapActivity extends AppCompatActivity{

    MapView mapView;
    MapboxMap mapmyIndiaMap;
    LocationEngine locationEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        addingApiKey();
        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    private void addingApiKey() {
        MapmyIndiaAccountManager.getInstance().setRestAPIKey("463fc3ea75402e8f179b5d9985f9e89b");
        MapmyIndiaAccountManager.getInstance().setMapSDKKey("463fc3ea75402e8f179b5d9985f9e89b");
        MapmyIndiaAccountManager.getInstance().setAtlasGrantType("client_credentials");
        MapmyIndiaAccountManager.getInstance().setAtlasClientId("33OkryzDZsJKiTu9nZhzx0ZxGxLrkXbsIzIaOuphLezgdarKxI-ELSr9pwDE5HEjmcTEQI6swGl912HKSaebMIUg_vtroY6M");
        MapmyIndiaAccountManager.getInstance().setAtlasClientSecret("lrFxI-iSEg8iId_BW8R_ZoOi5wzGol8wEJX5R2-1GMbAfVxUZZraRAU0cYqC3_x1lr9SuTVDzK-UAbJaJrV6cNcC6-pcFM-P5RZNruv5hkI=");
        MapmyIndia.getInstance(getApplicationContext());
        mapView = findViewById(R.id.map_view);
    }

}