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
 * Created by mycomputer on 2017/6/29.
 */

public class locationFragment  extends Fragment {

    private static final String TAG ="TAG" ;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.location_fragment, container, false);
        Log.i(TAG, "onCreateView:locationFragment ");
        return  view;
    }

    public Fragment newInstance(String args) {
        locationFragment fragment = new locationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args",args);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: locationFragment");
        super.onDestroy();
    }
}
