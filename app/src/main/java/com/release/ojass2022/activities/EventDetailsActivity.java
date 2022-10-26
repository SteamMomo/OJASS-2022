package com.release.ojass2022.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.release.ojass2022.R;
import com.release.ojass2022.ViewPagerAdapterEventDetails;

public class EventDetailsActivity extends AppCompatActivity {

    private TabLayout tabLayoutDetailsOption;
    private ViewPager2 viewPager2DetailsContainer;
    private Toolbar toolbar;

    private int [] iconList ={R.drawable.about,R.drawable.details,R.drawable.rules,R.drawable.event_head,R.drawable.prize};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        initialisations();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });

        ViewPagerAdapterEventDetails adapterEventDetails=new ViewPagerAdapterEventDetails(getSupportFragmentManager(),getLifecycle());
        viewPager2DetailsContainer.setAdapter(adapterEventDetails);

        viewPager2DetailsContainer.setClipToPadding(false);
        viewPager2DetailsContainer.setClipChildren(false);
        viewPager2DetailsContainer.setOffscreenPageLimit(3);
        viewPager2DetailsContainer.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });
        viewPager2DetailsContainer.setPageTransformer(compositePageTransformer);
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayoutDetailsOption,viewPager2DetailsContainer, (tab, position) -> {
            tab.setText(adapterEventDetails.getHeader(position));
            tab.setIcon(getResources().getDrawable(iconList[position]));
        });
        tabLayoutMediator.attach();
    }

    private void initialisations(){
        toolbar=findViewById(R.id.tb);
        tabLayoutDetailsOption=findViewById(R.id.tlDetailsOptions);
        viewPager2DetailsContainer=findViewById(R.id.vpDetailsContainer);
    }
}