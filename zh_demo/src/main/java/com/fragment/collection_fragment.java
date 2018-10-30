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
 * 热门收藏
 */
public class collection_fragment extends Fragment{
    private static final String TAG ="TAG" ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_fragment,null);
        Log.i(TAG, "onCreateView: 热门收藏");
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 热门收藏");
    }
}
