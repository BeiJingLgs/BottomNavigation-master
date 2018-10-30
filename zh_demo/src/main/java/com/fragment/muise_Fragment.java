package com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zh_demo.R;

/**
 * Created by mycomputer on 2017/6/29.
 */

public class muise_Fragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.muisc_fragment, container, false);
        return  view;
    }

    public Fragment newInstance(String args) {
        muise_Fragment fragment = new muise_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("args",args);
        fragment.setArguments(bundle);
        return  fragment;
    }
}
