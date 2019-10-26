package com.android1.shoplarity.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.models.WomenDetailFragment;

import java.util.List;

public class clothespagerAdapter extends FragmentPagerAdapter {

    List<Business>cloth;

    public clothespagerAdapter(@NonNull FragmentManager fm, List<Business> cloth) {
        super(fm);
        this.cloth = cloth;
    }

    @Override
    public Fragment getItem(int position) {
        return WomenDetailFragment.newInstance(cloth.get(position));
    }

    @Override
    public int getCount() {
        return cloth.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return cloth.get(position).getName();
    }
}
