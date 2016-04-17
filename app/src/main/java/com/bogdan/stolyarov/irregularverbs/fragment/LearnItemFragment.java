package com.bogdan.stolyarov.irregularverbs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bogdan.stolyarov.irregularverbs.model.Verb;
import com.support.android.designlibdemo.R;

/**
 * Created by bogdan on 16.04.2016.
 */
public class LearnItemFragment extends Fragment {

    public static final String LEARN_ITEM_KEY = "LearnItemFragment";

    private Verb verb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_item, container, false);
        checkArgs();
        ((TextView) view.findViewById(R.id.learn_item_card_view_infinitive)).setText(verb.getInfinitive());
        ((TextView) view.findViewById(R.id.learn_item_card_view_second_form)).setText(verb.getSecondForm());
        ((TextView) view.findViewById(R.id.learn_item_card_view_third_form)).setText(verb.getThirdForm());
        ((TextView) view.findViewById(R.id.learn_item_card_view_translate)).setText(verb.getTranslate());
        return view;
    }

    private void checkArgs() {
        if (getArguments() != null && getArguments().getParcelable(LEARN_ITEM_KEY) != null) {
            verb = getArguments().getParcelable(LEARN_ITEM_KEY);
        }
    }
}
