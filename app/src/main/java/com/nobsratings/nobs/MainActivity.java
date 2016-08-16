package com.nobsratings.nobs;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //setFragment(new HomeFragment());
        addFragment(R.id.FrameLayout, new HomeFragment(), HomeFragment.FRAGMENT_TAG);

        //Initialize Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("NoBS");
        setSupportActionBar(toolbar);

        //Initialize Navigation Drawer
        new DrawerBuilder().withActivity(this).build();

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Main Menu");
        SecondaryDrawerItem item2 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(2).withName("Our Mission!");
        SecondaryDrawerItem item3 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(3).withName("Categories!");
        SecondaryDrawerItem item4 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(4).withName("Map!");
        SecondaryDrawerItem item5 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(5).withName("About Us!");


        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
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
                        Log.d("^^^", drawerItem.getIdentifier()+ " " + position);
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

                            }


                        }
                        return false;
                    }
                })
                .withFireOnInitialOnClick(true)
                .build();



    }//
    protected void addFragment(@IdRes int containerViewId, @NonNull Fragment fragment, @NonNull String fragmentTag)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();
    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    protected void replaceFragment (@IdRes int containerViewId,
    @NonNull Fragment fragment,
    @NonNull String fragmentTag,
    @Nullable String backStackStateName) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .addToBackStack(backStackStateName)
                .commit();
    }

    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
    }

}//end
