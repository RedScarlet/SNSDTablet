package com.soshified.snsdinfo;

import android.os.Bundle;

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
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ListFragment())
                    .commit();
        }
    }

}
