package com.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by mycomputer on 2017/6/30.
 */

public class Find_tab_adapter extends FragmentPagerAdapter {
    private List<Fragment> fragment_list;
    private List<String> tab_list;

    public Find_tab_adapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabList) {
        super(fm);
        this.fragment_list = fragmentList;
        this.tab_list = tabList;
    }

    @Override
    public Fragment getItem(int position) {
        return   fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {
        return tab_list.get(position);
    }
}
