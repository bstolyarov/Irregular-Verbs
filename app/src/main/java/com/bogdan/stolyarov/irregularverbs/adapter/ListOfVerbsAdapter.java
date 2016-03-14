package com.bogdan.stolyarov.irregularverbs.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bogdan.stolyarov.irregularverbs.model.Verb;
import com.support.android.designlibdemo.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bogdan on 14.03.2016.
 */
public class ListOfVerbsAdapter extends BaseAdapter {

    private final Activity context;
    private static ArrayList<Verb> verbs;

    static class ViewHolder {
        public TextView infinitive;
        public TextView secondForm;
        public TextView thirdForm;
    }

    public ListOfVerbsAdapter(Activity context, ArrayList<Verb> verbs) {
        this.verbs = verbs;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        View cardView = view;

        if (cardView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            cardView = inflater.inflate(R.layout.card_in_list_of_verbs,null,true);
            viewHolder = new ViewHolder();
            viewHolder.infinitive = (TextView) cardView.findViewById(R.id.card_infinitive_text_view);
            viewHolder.secondForm = (TextView) cardView.findViewById(R.id.card_second_form_text_view);
            viewHolder.thirdForm = (TextView) cardView.findViewById(R.id.card_third_text_view);
            cardView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) cardView.getTag();
        }
        if (verbs != null) {
            Verb verb = verbs.get(i);
            viewHolder.infinitive.setText(verb.getInfinitive());
            viewHolder.secondForm.setText(verb.getSecondForm());
            viewHolder.thirdForm.setText(verb.getThirdForm());
        }
        return cardView;
    }

    @Override
    public int getCount() {
        int count  = 0;
        if(verbs != null) {
            count = verbs.size();
        }
        return count;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
