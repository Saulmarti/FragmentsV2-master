package com.example.paco.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class BlankFragment1 extends Fragment {

    private RelativeLayout layoutF1;
    private FragmentManager fm;
    private FragmentTransaction ft;


    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_blank_fragment1, container , false);

        layoutF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Has fet click en Fragment1", Toast.LENGTH_SHORT).show();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.contenedor,BlankFragment2.newInstance("",""));
                ft.commit();
            }
        });
        return v;
    }
    }

