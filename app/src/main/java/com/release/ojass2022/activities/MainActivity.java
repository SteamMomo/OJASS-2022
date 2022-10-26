package com.release.ojass2022.activities;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.release.ojass2022.R;
import com.release.ojass2022.sidemenuFragments.DevelopersFragment;
import com.release.ojass2022.sidemenuFragments.EventsFragment;
import com.release.ojass2022.sidemenuFragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;
    GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        getSupportFragmentManager()
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
            if (item.getItemId() == R.id.sign_out) {
                signOut();
            }
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });
    }

    private void signOut() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
            mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(MainActivity.this, "User signed out", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * handle the toolbar
     */
    private void configureToolbar() {

        toolbar.setTitle("Home");
        toolbar.setNavigationIcon(R.drawable.menu_light);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
    }

    /**
     * Initialization block
     */
    void initialisations() {
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.main_drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frame);
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