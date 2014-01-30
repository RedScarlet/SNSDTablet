package com.soshified.snsdinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Simple fragment which is displayed when item is clicked in the ListView
 */
public class ContentFragment extends Fragment {

    TextView textView;

    public ContentFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        if(view != null){
            textView = (TextView) view.findViewById(R.id.textView);
        }

        textView.setText(getArguments().getString("name") + " is 대박!");

        return view;
    }
}
