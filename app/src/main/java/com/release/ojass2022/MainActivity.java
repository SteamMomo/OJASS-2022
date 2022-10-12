package com.release.ojass2022;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;
import com.release.ojass2022.sidemenuFragments.AboutUsFragment;
import com.release.ojass2022.sidemenuFragments.DevelopersFragment;
import com.release.ojass2022.sidemenuFragments.EventsFragment;
import com.release.ojass2022.sidemenuFragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new HomeFragment())
                .commit();
        initialisations();
        configureToolbar();
        frameLayoutController();
    }

    /**
     * handle the framelayout
     */
    private void frameLayoutController() {
        navigationView.setNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HomeFragment())
                        .commit();
                toolbar.setTitle("Home");
            }
            if(item.getItemId() == R.id.events) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new EventsFragment())
                        .commit();
                toolbar.setTitle("Events");
            }
            if(item.getItemId() == R.id.developers) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new DevelopersFragment())
                        .commit();
                toolbar.setTitle("Developers");
            }
            if(item.getItemId() == R.id.about_us) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new AboutUsFragment())
                        .commit();
                toolbar.setTitle("About Us");
            }
            if(drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });
    }

    /**
     * handle the toolbar
     */
    private void configureToolbar() {

        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Initialization block
     */
    void initialisations(){
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.main_drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frame);
    }

    @Override
    public void onBackPressed() {
        if(toolbar.getTitle()!="Home"){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HomeFragment())
                    .commit();
            toolbar.setTitle("Home");
        }
        else
            super.onBackPressed();

    }
}