package com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adapter.MyListAdapter;
import com.example.zh_demo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mycomputer on 2017/6/30.
 * 热门推荐
 */
public class recommend_fragment extends Fragment {
    private static final String TAG = "TAG";
    @BindView(R.id.recyclerView)
    RecyclerView rc;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            Log.i(TAG, "onCreateView:热门推荐 ");
            view = inflater.inflate(R.layout.recommend_fragment, null);
            ButterKnife.bind(this, view);
            ArrayList<String> list = new ArrayList<>();
            for (int i = 'A'; i <= 'Z'; i++) {
                list.add("" + (char) i);
            }
            MyListAdapter adapter = new MyListAdapter(list);
            rc.setAdapter(adapter);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rc.setLayoutManager(manager);
        }
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 热门推荐");
    }
}
