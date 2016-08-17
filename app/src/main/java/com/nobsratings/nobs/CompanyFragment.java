package com.nobsratings.nobs;

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

import com.squareup.picasso.Picasso;


public class CompanyFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public static final String FRAGMENT_TAG = BuildConfig.APPLICATION_ID + ".HomeActivity Fragment Tag";
    public String catId;

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
        this.catId = temp +"";
        Log.d("^^^", catId);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_company, container, false);

        TextView tv = (TextView) view.findViewById(R.id.companyTextView);
        String categoryId = this.catId;
        tv.setText("companyId is: " + categoryId);

        ImageView companyImage = (ImageView) view.findViewById(R.id.companyImage);
        Picasso.with(this.getContext()).load("https://scontent-syd1-1.xx.fbcdn.net/v/t1.0-9/13164488_988097974578510_4063345207487792109_n.jpg?oh=e79c5950a32f4643e25633c2e505367a&oe=5853E328").into(companyImage);
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
