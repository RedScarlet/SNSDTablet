package com.soshified.snsdinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Fragment containing ListView which lists the members
 */
public class ListFragment extends Fragment {

    ListView listview;
    ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();

    public ListFragment() {}

    //I almost feel ashamed at this method...
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        if (view != null) {
            listview = (ListView) view.findViewById(R.id.soshi_list_view);
        }

        //Never do this...
        //Well you can, but it's really messy.
        //I was going to do something with the real names, but decided not. Left them in though, do with them what you wish

        if(data.size() == 0){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("name", "Jessica");
            ///map.put("real_name", "Jung SooYeon");
            data.add(map);
            map = new HashMap<String, String>();
            map.put("name", "Taeyeon");
            ///map.put("real_name", "Kim TaeYeon");
            data.add(map);
            map = new HashMap<String, String>();
            map.put("name", "Tiffany");
            ///map.put("real_name", "Hwang Miyoung");
            data.add(map);
            map = new HashMap<String, String>();
            map.put("name", "Hyoyeon");
            ///map.put("real_name", "Kim Hyoyeon");
            data.add(map);
            map = new HashMap<String, String>();
            map.put("name", "Sunny");
            ///map.put("real_name", "Lee Soonkyu");
            data.add(map);map = new HashMap<String, String>();
            map.put("name", "Yuri");
            ///map.put("real_name", "Kwon Yuri");
            data.add(map);map = new HashMap<String, String>();
            map.put("name", "Yoona");
            ///map.put("real_name", "Im Yoonah");
            data.add(map);
            map = new HashMap<String, String>();
            map.put("name", "Sooyoung");
            ///map.put("real_name", "Choi Sooyoung");
            data.add(map);
            map = new HashMap<String, String>();
            map.put("name", "Seohyun");
            ///map.put("real_name", "Seo Joo Hyun");
            data.add(map);
        }

        //If using real names, just add "real_names" to this array
        String[] from = new String[]{"name"};

        //*shrugs* don't ask. This is just a reference to a text view in a generic default android view
        int[] to = new int[]{android.R.id.text1};

        //The text view above is located in the android.R.layout.simple_list_item_1, which is a default/generic layout
        //https://github.com/android/platform_frameworks_base/blob/master/core/res/res/layout/activity_list_item_2.xml
        if(listview.getCount() == 0)
            listview.setAdapter(new SimpleAdapter(getActivity(), data, android.R.layout.simple_list_item_1, from, to));

        //Handles touches to the ListView items. In this case it replaces the fragment
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContentFragment contentFragment = new ContentFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", data.get(i).get("name"));
                contentFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, contentFragment)
                        .addToBackStack(null).commit();

            }
        });

        //Yep, I'm ashamed

        return view;
    }

}
