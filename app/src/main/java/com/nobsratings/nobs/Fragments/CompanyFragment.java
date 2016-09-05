package com.nobsratings.nobs.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.nobsratings.nobs.BuildConfig;
import com.nobsratings.nobs.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


public class CompanyFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public static final String FRAGMENT_TAG = BuildConfig.APPLICATION_ID + ".HomeActivity Fragment Tag";
    public String compId;
    public String categoryId;

    public CompanyFragment() {
        // Required empty public constructor
    }

    public static CompanyFragment newInstance(String param1, String param2) {
        CompanyFragment fragment = new CompanyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int temp = getArguments().getInt("companyId");
        categoryId = getArguments().getString("categoryId");
        this.compId = temp +"";
        Log.d("^^^", compId);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_company, container, false);

        //FireBase Stuff
        Firebase myFirebaseRef = new Firebase("https://nobs-ratings.firebaseio.com/");

        final TextView companyTitleText = (TextView) view.findViewById(R.id.companyTitleText);
        final TextView aboutTextView = (TextView) view.findViewById(R.id.aboutTextDetail);
        final ImageView companyImage = (ImageView) view.findViewById(R.id.companyImage);
        final TextView c1 = (TextView) view.findViewById(R.id.rating1);
        final TextView c2 = (TextView) view.findViewById(R.id.rating2);
        final TextView c3 = (TextView) view.findViewById(R.id.rating3);
        final TextView c4 = (TextView) view.findViewById(R.id.rating4);
        final TextView c5 = (TextView) view.findViewById(R.id.rating5);
        final TextView cf = (TextView) view.findViewById(R.id.ratingf);

        Picasso.with(this.getContext()).load("https://scontent-syd1-1.xx.fbcdn.net/v/t1.0-9/13164488_988097974578510_4063345207487792109_n.jpg?oh=e79c5950a32f4643e25633c2e505367a&oe=5853E328").into(companyImage);

        //Add listener to get information from firebase
        myFirebaseRef.child("categories").child(categoryId).child(compId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String companyTitle = (String) dataSnapshot.child("title").getValue();
                String aboutText = (String) dataSnapshot.child("aboutText").getValue();
                String imageUrl = (String) dataSnapshot.child("imageUrl").getValue();
                String r1 = (String) dataSnapshot.child("category1").getValue();
                String r2 = (String) dataSnapshot.child("category2").getValue();
                String r3 = (String) dataSnapshot.child("category3").getValue();
                String r4 = (String) dataSnapshot.child("category4").getValue();
                String r5 = (String) dataSnapshot.child("category5").getValue();
                String rf = (String) dataSnapshot.child("categoryf").getValue();

                companyTitleText.setText(companyTitle);
                Picasso.with(getContext()).load(imageUrl).into(companyImage);
                aboutTextView.setText(aboutText);
                c1.setText(r1);
                c2.setText(r2);
                c3.setText(r3);
                c4.setText(r4);
                c5.setText(r5);
                cf.setText(rf);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
