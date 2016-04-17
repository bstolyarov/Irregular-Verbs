package com.bogdan.stolyarov.irregularverbs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bogdan.stolyarov.irregularverbs.adapter.VerbsPagerAdapter;
import com.bogdan.stolyarov.irregularverbs.model.Verb;
import com.sembozdemir.viewpagerarrowindicator.library.ViewPagerArrowIndicator;
import com.support.android.designlibdemo.R;

import java.util.ArrayList;

/**
 * Created by bogdan on 14.02.2016.
 */
public class LearnFragment extends Fragment {

    public static final String LEARN_KEY = "LearnFragment";

    private ViewPager viewPager;
    private ViewPagerArrowIndicator viewPagerArrowIndicator;
    private ArrayList<Verb> verbs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        checkArgs();
        initViewpager(view);

        return view;
    }

    private void checkArgs() {
        if (getArguments() != null && getArguments().getParcelableArrayList(LEARN_KEY) != null) {
            verbs = getArguments().getParcelableArrayList(LEARN_KEY);
        }
    }

    private void initViewpager(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPagerArrowIndicator = (ViewPagerArrowIndicator) view.findViewById(R.id.view_pager_arrow_andicator);
        viewPager.setAdapter(new VerbsPagerAdapter(getActivity().getSupportFragmentManager(), verbs));

        viewPagerArrowIndicator.bind(viewPager);
    }
}
