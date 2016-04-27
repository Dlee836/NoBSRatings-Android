package com.nobsratings.nobs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dan on 18/04/2016.
 */
public class BusinessInformationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_information_layout);
        Bundle bundle = getIntent().getExtras();

        Integer businessId = bundle.getInt("businessId");
        String businessNames = bundle.getString("businessName");
        setTitle(businessNames);
        String r1s = bundle.getString("r1");
        String r2s = bundle.getString("r2");
        String r3s = bundle.getString("r3");
        String r4s = bundle.getString("r4");
        String r5s = bundle.getString("r5");
        String rfs = bundle.getString("rf");

        ImageView i1 = (ImageView) findViewById(R.id.companyImage);
        TextView r1 = (TextView) findViewById(R.id.r1);
        TextView r2 = (TextView) findViewById(R.id.r2);
        TextView r3 = (TextView) findViewById(R.id.r3);
        TextView r4 = (TextView) findViewById(R.id.r4);
        TextView r5 = (TextView) findViewById(R.id.r5);
        TextView rf = (TextView) findViewById(R.id.rf);

        //i1.setImageResource(R.drawable.example_company);
        r1.setText(r1s+"");
        r2.setText(r2s+"");
        r3.setText(r3s+"");
        r4.setText(r4s+"");
        r5.setText(r5s+"");
        rf.setText(rfs+"");

    }
};
