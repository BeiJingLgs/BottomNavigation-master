package com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adapter.Find_tab_adapter;
import com.example.zh_demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by mycomputer on 2017/6/29.
 */

public class FristFragment extends Fragment {
    private static final String TAG ="TAG" ;
    //    supportRequestWindowFeature(Window.FEATURE_NO_TITLE) 去掉了默认的导航栏（注意，我的BaseActivity是继承了AppCompatActivity的，如果是继承Activity就应该调用requestWindowFeature(Window.FEATURE_NO_TITLE)）；
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    private List<String> titleList;
    private ArrayList<Fragment> fragments1;
    private View view;

    public static Fragment newInstance(String args) {
        FristFragment fragment = new FristFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", args);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view ==null){
            Log.i(TAG, "onCreateView:FristFragment ");
            view = inflater.inflate(R.layout.frist_fragment,null);
            ButterKnife.bind(this, view);
            //设置Toolbar
            setToolbar();
            //设置Tablayouts，并返回title的集合
            titleList = tablayouts();
            //获取fagment的集合
            List<Fragment> fragmentList = getFragments();
            Find_tab_adapter adapter = new Find_tab_adapter(getActivity().getSupportFragmentManager(), fragmentList, titleList);
            //这适配的Fragment不显示
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }
        return view;
    }


    private List<Fragment> getFragments() {
        List<Fragment> list = new ArrayList<>();
        list.add(new recommend_fragment());
        list.add(new collection_fragment());
        list.add(new hotList_fragment());
        return list;
    }

    private void setToolbar() {
        //        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setTitle("Title");//设置主标题
        toolbar.setSubtitle("Subtitle");//设置子标题
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "aa", Toast.LENGTH_LONG).show();
            }
        });
    }
     //返回title结合
    private  List<String> tablayouts() {
        titleList = new ArrayList<>();
        titleList.add("热门推荐");
        titleList.add("热门收藏");
        titleList.add("今日热榜");
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));
        return titleList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: FristFragment");
    }
}
