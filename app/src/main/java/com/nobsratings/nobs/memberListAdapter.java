package com.nobsratings.nobs;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Optional on 16/08/16.
 */

public class memberListAdapter extends ArrayAdapter<Member> {
    private Context context;
    private ArrayList<Member> members;
    private View convertView;
    private Picasso mPicasso;

    public memberListAdapter(Context context, ArrayList<Member> members) {
        super(context,R.layout.member_item, members);
        this.context = context;
        this.mPicasso = Picasso.with(context);
        this.members = members;
        Log.d("^^^", "0");

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Housekeeping
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View rowView = inflater.inflate(R.layout.member_item, parent, false);
            this.convertView = rowView;
            Log.d("^^^", "1");

        }

        Log.d("^^^", "2");

        final Member memberItem = getItem(position);
        Log.d("^^^", memberItem.getName());

        final TextView mName = (TextView) this.convertView.findViewById(R.id.memberName);
        final TextView mDescription = (TextView) this.convertView.findViewById(R.id.memberDescription);
        final ImageView mPhoto = (ImageView) this.convertView.findViewById(R.id.memberPhoto);

        mName.setText(memberItem.getName());
        mDescription.setText(memberItem.getDescription());
        //this.mPicasso.with(this.getContext()).load(memberItem.getPhotoUrl()).into(mPhoto);

        Log.d("^^", "LAST");

        return this.convertView;
    }
}
