package com.nobsratings.nobs;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dan on 20/04/2016.
 */
public class OnItemClickListenerListViewItem implements OnItemClickListener {


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        TextView businessViewItem = ((TextView) view.findViewById(R.id.businessName));

        // get the clicked item name
        String businessItemText = businessViewItem.getText().toString();

        // get the clicked item ID
        String businessItemId = businessViewItem.getTag().toString();

        // SEND TO NEW ACTIVITY

    }
}
