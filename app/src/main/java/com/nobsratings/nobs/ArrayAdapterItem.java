package com.nobsratings.nobs;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

/**
 * Created by Dan on 20/04/2016.
 */
public class ArrayAdapterItem extends ArrayAdapter<com.nobsratings.nobs.BusinessItem>{
    //Here's our beautiful adapter

    Context mContext;
    int layoutResourceId;
    com.nobsratings.nobs.BusinessItem data[] = null;

    public ArrayAdapterItem(Context mContext, int layoutResourceId, com.nobsratings.nobs.BusinessItem[] data){
        super(mContext,layoutResourceId,data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //Inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        //Object item based on the position
        com.nobsratings.nobs.BusinessItem businessItem = data[position];
        TextView businessName = (TextView) convertView.findViewById(R.id.businessName);
        businessName.setText(businessItem.businessName);
        businessName.setTag(businessItem.businessId);

        return convertView;
    }

}
