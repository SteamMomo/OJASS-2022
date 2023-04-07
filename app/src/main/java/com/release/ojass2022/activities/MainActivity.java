package com.release.ojass2022.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.release.ojass2022.R;
import com.release.ojass2022.sidemenuFragments.DevelopersFragment;
import com.release.ojass2022.sidemenuFragments.EventsFragment;
import com.release.ojass2022.sidemenuFragments.GalleryFragment;
import com.release.ojass2022.sidemenuFragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    //    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;
    GoogleSignInOptions gso;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(String.valueOf(R.string.web_client_id))
                .requestEmail()
                .build();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new HomeFragment())
                .commit();
        initialisations();
        requestPermissions();
        configureToolbar();
        frameLayoutController();
    }

    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                | ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                | ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                | ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                | ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this
                    , new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
                            , Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    /**
     * handle the framelayout
     */
    private void frameLayoutController() {

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HomeFragment())
                        .commit();
                toolbar.setTitle("Home");
            }
            if (item.getItemId() == R.id.events) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new EventsFragment())
                        .commit();
                toolbar.setTitle("Events");
            }
            if (item.getItemId() == R.id.developers) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new DevelopersFragment())
                        .commit();
                toolbar.setTitle("Developers");
            }
            if (item.getItemId() == R.id.gallery) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new GalleryFragment())
                        .commit();
                toolbar.setTitle("Gallery");
            }
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });


    }

    /**
     * handle the toolbar
     */
    private void configureToolbar() {

        toolbar.setTitle("Home");
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.location) {
                Intent intent = new Intent(this, MapActivity.class);
                startActivity(intent);
            }

            return false;
        });
    }

    /**
     * Initialization block
     */
    void initialisations() {
//        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.main_drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frame);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    @Override
    public void onBackPressed() {
        if (toolbar.getTitle() != "Home") {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HomeFragment())
                    .commit();
            toolbar.setTitle("Home");
        } else
            super.onBackPressed();

    }
}