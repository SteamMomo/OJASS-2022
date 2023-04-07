package com.release.ojass2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.VideoView;

import com.release.ojass2022.R;

public class SplashScreen extends AppCompatActivity {

    private int splashtimeout = 3500;
    private VideoView video;
    private ImageView  ojass_text, realm, the, reconvening, year_2_1, year_0, year_2_2, year_2_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initialisation();
        animations();
        playVideo();
        afterAnimation();



    }

    private void playVideo()
    {
        video = (VideoView) findViewById(R.id.videoView);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.landing);
        video.setVideoURI(videoUri);


        video.start();
    }
    private void animations(){
        Animation enterFromTop = AnimationUtils.loadAnimation(this, R.anim.enter_from_top);
        Animation enterFromBottom = AnimationUtils.loadAnimation(this, R.anim.enter_from_bottom);
//        Animation rotateAnticlock = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlockwise);
//        Animation rotateClock = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        Animation enterFromLeft = AnimationUtils.loadAnimation(this, R.anim.enter_from_left);
        Animation enterFromRight = AnimationUtils.loadAnimation(this, R.anim.enter_from_right);

        ojass_text.startAnimation(enterFromTop);

        realm.startAnimation(enterFromLeft);
        the.startAnimation(fadeOut);
        reconvening.startAnimation(enterFromRight);

        year_2_1.startAnimation(enterFromBottom);
        year_0.startAnimation(enterFromBottom);
        year_2_2.startAnimation(enterFromBottom);
        year_2_3.startAnimation(enterFromBottom);

    }


    /**
     * After animation time over then switch to main activity
     */
    private void afterAnimation()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashtimeout);
    }

    /**
     * Initialisation block
     */
    void initialisation()
    {

        ojass_text = findViewById(R.id.ojass_text);

        realm = findViewById(R.id.realm);
        the = findViewById(R.id.thethe);
        reconvening = findViewById(R.id.reconvening);

        year_0 = findViewById(R.id.year_0);
        year_2_1 = findViewById(R.id.year_2_1);
        year_2_2 = findViewById(R.id.year_2_2);
        year_2_3 = findViewById(R.id.year_2_3);
        video = findViewById(R.id.videoView);

    }


}