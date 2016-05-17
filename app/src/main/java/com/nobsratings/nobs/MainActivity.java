package com.nobsratings.nobs;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private String[] mDrawerTitles = {"A","B","C","D"};
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    com.nobsratings.nobs.BusinessItem[] businessItemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mDrawerTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        //Set the list view
        businessItemData = new com.nobsratings.nobs.BusinessItem[5];
        businessItemData[0] = new com.nobsratings.nobs.BusinessItem(1, "MedAscend", "A","A","A","A","N/A","A");
        businessItemData[1] = new com.nobsratings.nobs.BusinessItem(2, "The Learning Collaborative", "B","B","A","B","NA","B");
        businessItemData[2] = new com.nobsratings.nobs.BusinessItem(3, "Momentum Tutoring","A","A","A","A","N/A","A");
        businessItemData[3] = new com.nobsratings.nobs.BusinessItem(4, "Avance", "A+","A+","A","A+","N/A","A+");
        businessItemData[4] = new com.nobsratings.nobs.BusinessItem(5, "Justin the Tutor","A","A","A","A+","N/A","A+");

        com.nobsratings.nobs.ArrayAdapterItem adapter = new com.nobsratings.nobs.ArrayAdapterItem(this, R.layout.business_item, businessItemData);

        ListView businessList = (ListView) this.findViewById(R.id.main_list);
        businessList.setAdapter(adapter);

        businessList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object listItem = list.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), com.nobsratings.nobs.BusinessInformationActivity.class);

                Bundle bundle = new Bundle();

                bundle.putInt("businessId", businessItemData[position].businessId);
                bundle.putString("businessName", businessItemData[position].businessName);
                bundle.putString("r1", businessItemData[position].r1);
                bundle.putString("r2", businessItemData[position].r2);
                bundle.putString("r3", businessItemData[position].r3);
                bundle.putString("r4", businessItemData[position].r4);
                bundle.putString("r5", businessItemData[position].r5);
                bundle.putString("rf", businessItemData[position].rf);

                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
    }



}
