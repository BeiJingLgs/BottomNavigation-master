package com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zh_demo.R;

/**
 * Created by mycomputer on 2017/6/30.
 * 今日热榜
 */
public class hotList_fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("tag", "onCreateView: 今日热榜");
        View view = inflater.inflate(R.layout.hotlist_fragment, null);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy: 今日热榜");
    }
}
