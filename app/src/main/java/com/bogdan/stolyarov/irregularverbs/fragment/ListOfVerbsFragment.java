package com.bogdan.stolyarov.irregularverbs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bogdan.stolyarov.irregularverbs.adapter.ListOfVerbsAdapter;
import com.bogdan.stolyarov.irregularverbs.model.Verb;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.support.android.designlibdemo.R;

import java.util.ArrayList;


/**
 * Created by bogdan on 14.02.2016.
 */
public class ListOfVerbsFragment extends Fragment {

    private ArrayList<Verb> verbs;
    private ListView verbsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_verbs, container, false);
        verbsList = (ListView) view.findViewById(R.id.list_of_verbs_list);


        ListOfVerbsAdapter adapter = new ListOfVerbsAdapter(getActivity(), verbs);

        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(adapter);
        alphaInAnimationAdapter.setAbsListView(verbsList);
        verbsList.setAdapter(alphaInAnimationAdapter);

        return view;
    }

    public void setVerbs(ArrayList<Verb> verbs) {
        this.verbs = verbs;
    }
}
