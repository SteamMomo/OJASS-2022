package com.release.ojass2022.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.release.ojass2022.R;

public class ShowImageActivity extends AppCompatActivity {

    private ImageView img;
    private ScaleGestureDetector scaleGestureDetector;
    private float ScaleFactor = 1.0f;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        initializations();

        Intent intent = getIntent();
        String imageName = intent.getSerializableExtra("imageName").toString();

        img.setImageResource(this.getResources().
                getIdentifier(imageName,"drawable",this.getPackageName()));

        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());

    }

    private void initializations(){
        img=findViewById(R.id.img);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override
        public boolean onScale(@NonNull ScaleGestureDetector detector) {
            ScaleFactor *= detector.getScaleFactor();
            ScaleFactor = Math.max(0.1f, Math.min(ScaleFactor, 10.0f));
            img.setScaleX(ScaleFactor);
            img.setScaleY(ScaleFactor);
            return true;
        }
    }
}