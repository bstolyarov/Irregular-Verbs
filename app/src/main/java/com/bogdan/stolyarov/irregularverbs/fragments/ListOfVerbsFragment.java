package com.bogdan.stolyarov.irregularverbs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.support.android.designlibdemo.R;


/**
 * Created by bogdan on 14.02.2016.
 */
public class ListOfVerbsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_verbs, container, false);
        TextView textView = (TextView) view.findViewById(R.id.list_of_verbs_text_view);
        return view;
    }
}
