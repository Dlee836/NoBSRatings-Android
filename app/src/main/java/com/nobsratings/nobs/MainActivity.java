package com.nobsratings.nobs;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.firebase.client.Firebase;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.nobsratings.nobs.Fragments.AboutUsFragment;
import com.nobsratings.nobs.Fragments.CategoriesFragment;
import com.nobsratings.nobs.Fragments.HomeFragment;

public class MainActivity extends BaseActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize Firebase
        Firebase.setAndroidContext(this);
        Firebase rootRef = new Firebase("https://nobs-ratings.firebaseio.com/");

        setContentView(R.layout.activity_main);

        //Initialize Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("NoBS");
        setSupportActionBar(toolbar);

        //setFragment(new HomeFragment());
        addFragment(R.id.FrameLayout, new HomeFragment(), HomeFragment.FRAGMENT_TAG);
        //Initialize Navigation Drawer

        new DrawerBuilder().withActivity(this).build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        SecondaryDrawerItem item2 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(2).withName("Rating System");
        SecondaryDrawerItem item3 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(3).withName("Categories");
        SecondaryDrawerItem item4 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(4).withName("Map");
        SecondaryDrawerItem item5 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(5).withName("About Us");
        SecondaryDrawerItem item6 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(6).withName("What We Do");

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item6,
                        item2,
                        item3,
                        item4,
                        item5
                )
                .withSelectedItem(0)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        Log.d("^^^", drawerItem.getIdentifier() + " " + position);
                        //Get Drawer ID
                        int id = (int) drawerItem.getIdentifier();

                        if (drawerItem != null) {


                            //According to id, replace appropriate fragment
                            if (id == 1) {
                                replaceFragment(R.id.FrameLayout, new HomeFragment(), HomeFragment.FRAGMENT_TAG, null);

                            } else if (id == 2) {
                                replaceFragment(R.id.FrameLayout, new OurMissionFragment(), OurMissionFragment.FRAGMENT_TAG, null);

                            } else if (id == 3) {
                                replaceFragment(R.id.FrameLayout, new CategoriesFragment(), CategoriesFragment.FRAGMENT_TAG, null);

                            } else if (id == 4) {
                                replaceFragment(R.id.FrameLayout, new MapFragment(), MapFragment.FRAGMENT_TAG, null);

                            } else if (id == 5) {
                                replaceFragment(R.id.FrameLayout, new AboutUsFragment(), AboutUsFragment.FRAGMENT_TAG, null);

                            } else if (id == 6) {
                                replaceFragment(R.id.FrameLayout, new WhatWeDoFragment(), WhatWeDoFragment.FRAGMENT_TAG, null);
                            }


                        }
                        return false;
                    }
                })
                .withFireOnInitialOnClick(true)
                .build();



    }//

}//end
