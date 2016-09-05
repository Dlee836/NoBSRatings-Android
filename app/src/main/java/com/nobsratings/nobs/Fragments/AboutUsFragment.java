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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.nobsratings.nobs.BuildConfig;
import com.nobsratings.nobs.Member;
import com.nobsratings.nobs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AboutUsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AboutUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutUsFragment extends Fragment {
    public static final String FRAGMENT_TAG = BuildConfig.APPLICATION_ID + ".HomeActivity Fragment Tag";
    protected View mView;

    private OnFragmentInteractionListener mListener;

    public AboutUsFragment() {
        // Required empty public constructor
    }

    public static AboutUsFragment newInstance(String param1, String param2) {
        AboutUsFragment fragment = new AboutUsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        this.mView = view;

        final LinearLayout ll = (LinearLayout)view.findViewById(R.id.memberLinearLayout);
        final LayoutInflater tempInflater = LayoutInflater.from(getContext());

        Firebase myFirebaseRef = new Firebase("https://nobs-ratings.firebaseio.com/");
        myFirebaseRef.child("Members").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dsp : dataSnapshot.getChildren()) {
                    View tempView = tempInflater.inflate(R.layout.member_item, ll, false);
                    TextView mName = (TextView) tempView.findViewById(R.id.memberName);
                    TextView mDesc = (TextView) tempView.findViewById(R.id.memberDescription);
                    ImageView mPhoto = (ImageView) tempView.findViewById(R.id.memberPhoto);

                    String name = (String) dsp.child("name").getValue();
                    String imageUrl = (String) dsp.child("imageUrl").getValue();
                    String desc = (String) dsp.child("aboutText").getValue();

                    mName.setText(name);
                    Picasso.with(getContext()).load(imageUrl).into(mPhoto);
                    mDesc.setText(desc);

                    ll.addView(tempView);

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());

            }
        });

        return this.mView;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
