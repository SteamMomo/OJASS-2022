package com.release.ojass2022;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.release.ojass2022.eventFragments.AboutFragment;
import com.release.ojass2022.eventFragments.DetailsFragment;
import com.release.ojass2022.eventFragments.EventHeadFragment;
import com.release.ojass2022.eventFragments.PrizeFragment;
import com.release.ojass2022.eventFragments.RulesFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterEventDetails extends FragmentStateAdapter {


    private List<Fragment> fragments=new ArrayList<>();
    private List<String> headers=new ArrayList<>();

    public ViewPagerAdapterEventDetails(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        initData();
    }

    private void initData(){
        addData(new AboutFragment(),"ABOUT");
        addData(new DetailsFragment(),"DETAILS");
        addData(new RulesFragment(),"RULES");
        addData(new EventHeadFragment(),"EVENT HEAD");
        addData(new PrizeFragment(),"PRIZE");
    }

    private void addData(Fragment fragment,String header){
        fragments.add(fragment);
        headers.add(header);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public String getHeader(int position){
        return headers.get(position);
    }
}
