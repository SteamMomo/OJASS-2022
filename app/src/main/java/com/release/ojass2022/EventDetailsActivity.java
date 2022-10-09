package com.release.ojass2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class EventDetailsActivity extends AppCompatActivity {

    private TabLayout tabLayoutDetailsOption;
    private ViewPager2 viewPager2DetailsContainer;

    private int [] iconList ={R.drawable.about,R.drawable.details,R.drawable.rules,R.drawable.event_head,R.drawable.prize};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        initialisations();

        ViewPagerAdapterEventDetails adapterEventDetails=new ViewPagerAdapterEventDetails(getSupportFragmentManager(),getLifecycle());
        viewPager2DetailsContainer.setAdapter(adapterEventDetails);

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayoutDetailsOption,viewPager2DetailsContainer, (tab, position) -> {
            tab.setText(adapterEventDetails.getHeader(position));
            tab.setIcon(getResources().getDrawable(iconList[position]));
        });
        tabLayoutMediator.attach();
    }

    private void initialisations(){
        tabLayoutDetailsOption=findViewById(R.id.tlDetailsOptions);
        viewPager2DetailsContainer=findViewById(R.id.vpDetailsContainer);
    }
}