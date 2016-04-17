package com.bogdan.stolyarov.irregularverbs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

    public static final String LIST_OF_VERBS_KEY = "ListOfVerbsFragment";

    private ArrayList<Verb> verbs;
    private ListView verbsList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkArgs();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_verbs, container, false);
        verbsList = (ListView) view.findViewById(R.id.list_of_verbs_list);

        ListOfVerbsAdapter adapter = new ListOfVerbsAdapter(getActivity(), verbs);

        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(adapter);
        alphaInAnimationAdapter.setAbsListView(verbsList);
        verbsList.setAdapter(alphaInAnimationAdapter);
        verbsList.setDividerHeight(0);

        return view;
    }

    private void checkArgs() {
        if (getArguments() != null && getArguments().getParcelableArrayList(LIST_OF_VERBS_KEY) != null) {
            verbs = getArguments().getParcelableArrayList(LIST_OF_VERBS_KEY);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    public void setVerbs(ArrayList<Verb> verbs) {
        this.verbs = verbs;
    }
}
