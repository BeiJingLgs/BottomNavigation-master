package com.example.zh_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.fragment.FristFragment;
import com.fragment.locationFragment;
import com.fragment.muise_Fragment;
import com.fragment.sc_Fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    @BindView(R.id.bottom_bar)
    BottomNavigationBar bottom_bar;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ArrayList<Fragment> fragments;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottom_bar.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //设置底下角标
        TextBadgeItem badgeItem = new TextBadgeItem().setBackgroundColor(Color.RED).setText("99");
        bottom_bar.addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "主页").setActiveColorResource(R.color.colorHome))
                .addItem(new BottomNavigationItem(R.drawable.ic_location_on_white_24dp, "导航").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, "收藏").setActiveColorResource(R.color.colorXin).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "音乐").setActiveColorResource(R.color.colorMuisc))
                .setFirstSelectedPosition(0).initialise();
        setDefaultFragment();
        fragments = getfragment();
        /**
         *选项切换监听事件
         */
        bottom_bar.setTabSelectedListener(this);
    }

    private void setDefaultFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.myfragment, new FristFragment().newInstance("主页"));
        transaction.commit();
    }

    private ArrayList<Fragment> getfragment() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new FristFragment().newInstance("主页"));
        list.add(new locationFragment().newInstance("导航"));
        list.add(new muise_Fragment().newInstance("音乐"));
        list.add(new sc_Fragment().newInstance("收藏"));
        return list;
    }
    /**
     *未选中到选中的情况
     */
    @Override
    public void onTabSelected(int position) {
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (fragments != null) {
            //todo 你这是写的什么啊？
            if (position < fragments.size()) {
                Fragment fragment = fragments.get(position);
//                if (fragment.isAdded()) {
                    fragmentTransaction.replace(R.id.myfragment, fragment);
//                } else {
//                    fragmentTransaction.add(R.id.myfragment, fragment);
//                }
                fragmentTransaction.commitAllowingStateLoss();
            }
        }
    }
    /**
     *选中到未选中的情况
     */
    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            Fragment fragment = fragments.get(position);
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commitAllowingStateLoss();
        }
    }
    /**
     * 选中到选中的情况
     */
    @Override
    public void onTabReselected(int position) {

    }
}
