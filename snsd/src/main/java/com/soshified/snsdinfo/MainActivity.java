package com.soshified.snsdinfo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
* Main activity. Generally you shouldn't have everything in the one file/class but for simplicity it is done this way.
*
* */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //The default fragment/first fragment that will go in the right side of the screen. Otherwise it'll look strange...
            ContentFragment contentFragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", "SNSD");
            contentFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, contentFragment)
                    .commit();
        }
    }

}
