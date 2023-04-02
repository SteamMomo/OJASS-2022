package com.release.ojass2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;

import com.mmi.services.account.MapmyIndiaAccountManager;
import com.release.ojass2022.R;

import com.mmi.MapView;
import com.mmi.MapmyIndiaMapView;
import com.mmi.layers.UserLocationOverlay;
import com.mmi.layers.location.GpsLocationProvider;
import com.mmi.util.constants.MapViewConstants;

public class MapActivity extends AppCompatActivity implements MapViewConstants {

    UserLocationOverlay mLocationOverlay;
    MapView mMapView;
    @SuppressLint("HandlerLeak")
    Handler locationFoundHandler = new Handler() {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mMapView.setCenter(mLocationOverlay.getMyLocation());
                mMapView.setZoom(mMapView.getMaxZoomLevel());
            }
        }
    };

    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        apiKey();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mMapView = ((MapmyIndiaMapView) findViewById(R.id.map)).getMapView();
        mPrefs = getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.mLocationOverlay = new UserLocationOverlay(new GpsLocationProvider(getApplicationContext()), mMapView);
        mLocationOverlay.enableMyLocation();
        mMapView.getOverlays().add(this.mLocationOverlay);
        mLocationOverlay.runOnFirstFix(new Runnable() {
            @Override
            public void run() {
                locationFoundHandler.sendEmptyMessage(1);
            }
        });
        mMapView.invalidate();
    }

    @Override
    public void onPause() {
        final SharedPreferences.Editor edit = mPrefs.edit();

        edit.putInt(PREFS_SCROLL_X, mMapView.getScrollX());
        edit.putInt(PREFS_SCROLL_Y, mMapView.getScrollY());
        edit.putInt(PREFS_ZOOM_LEVEL, mMapView.getZoomLevel());
        edit.apply();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.setZoom(mPrefs.getInt(PREFS_ZOOM_LEVEL, 5));
        mMapView.scrollTo(mPrefs.getInt(PREFS_SCROLL_X, 0), mPrefs.getInt(PREFS_SCROLL_Y, 0));
    }

    private void apiKey() {
        MapmyIndiaAccountManager.getInstance().setRestAPIKey("463fc3ea75402e8f179b5d9985f9e89b");
        MapmyIndiaAccountManager.getInstance().setMapSDKKey("463fc3ea75402e8f179b5d9985f9e89b");
//        MapmyIndiaAccountManager.getInstance().setAtlasGrantType(getAtlasGrantType());
        MapmyIndiaAccountManager.getInstance().setAtlasClientId("33OkryzDZsJKiTu9nZhzx0ZxGxLrkXbsIzIaOuphLezgdarKxI-ELSr9pwDE5HEjmcTEQI6swGl912HKSaebMIUg_vtroY6M");
        MapmyIndiaAccountManager.getInstance().setAtlasClientSecret("lrFxI-iSEg8iId_BW8R_ZoOi5wzGol8wEJX5R2-1GMbAfVxUZZraRAU0cYqC3_x1lr9SuTVDzK-UAbJaJrV6cNcC6-pcFM-P5RZNruv5hkI=");
    }
}