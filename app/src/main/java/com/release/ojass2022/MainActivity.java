package com.release.ojass2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisations();
        configureToolbar();
        frameLayoutController();
    }

    private void frameLayoutController() {
        navigationView.setNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home)
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HomeFragment())
                        .commit();
            if(item.getItemId() == R.id.events)
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new EventsFragment())
                        .commit();
            if(drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });
    }
    private void configureToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    void initialisations(){
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.main_drawer_layout);
        toolbar = findViewById(R.id.toolbar);
    }
}