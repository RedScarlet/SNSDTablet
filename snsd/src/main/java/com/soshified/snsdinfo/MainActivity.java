package com.soshified.snsdinfo;

import android.content.Intent;
import android.content.res.Configuration;
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

        if (savedInstanceState == null && getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //The default fragment/first fragment that will go in the right side of the screen. Otherwise it'll look strange...
            ContentFragment contentFragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", "SNSD");
            contentFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, contentFragment)
                    .commit();
        }else if(savedInstanceState == null && getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //For some reason, the list wasn't loading by just providing the fragment in activity_main (portrait). So I just loaded it
            //in java and changed activity_main
            ListFragment listFragment = new ListFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, listFragment)
                    .commit();
        }else{
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(intent);

        }
    }

}
