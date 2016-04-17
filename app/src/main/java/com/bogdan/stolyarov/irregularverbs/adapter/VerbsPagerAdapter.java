package com.bogdan.stolyarov.irregularverbs.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bogdan.stolyarov.irregularverbs.fragment.LearnItemFragment;
import com.bogdan.stolyarov.irregularverbs.model.Verb;

import java.util.ArrayList;

/**
 * Created by bogdan on 16.04.2016.
 */
public class VerbsPagerAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fragmentManager;
    private ArrayList<Verb> verbs;

    public VerbsPagerAdapter(FragmentManager fm, ArrayList<Verb> verbs) {
        super(fm);
        this.verbs = verbs;
    }


    @Override
    public Fragment getItem(int position) {
        //TODO
        LearnItemFragment learnItemFragment = new LearnItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(LearnItemFragment.LEARN_ITEM_KEY, verbs.get(position));
        learnItemFragment.setArguments(bundle);
        return learnItemFragment;
    }

    @Override
    public int getCount() {
        return verbs.size();
    }
}
