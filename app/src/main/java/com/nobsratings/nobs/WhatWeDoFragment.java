package com.nobsratings.nobs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WhatWeDoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WhatWeDoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WhatWeDoFragment extends Fragment {

    public static final String FRAGMENT_TAG = BuildConfig.APPLICATION_ID + ".HomeActivity Fragment Tag";
    private ImageView mNoBS, mEnvironment, mCommunity, mHandshake, mLabour, mLike,mOne, mTwo, mThree;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WhatWeDoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WhatWeDoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WhatWeDoFragment newInstance(String param1, String param2) {
        WhatWeDoFragment fragment = new WhatWeDoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_what_we_do, container, false);
//        mNoBS = (ImageView)view.findViewById(R.id.no_bullshit);
//        mEnvironment = (ImageView)view.findViewById(R.id.environment_image);
//        mCommunity = (ImageView)view.findViewById(R.id.community_image);
//        mHandshake = (ImageView)view.findViewById(R.id.handshake_image);
//        mLabour = (ImageView)view.findViewById(R.id.labour_image);
//        mLike = (ImageView)view.findViewById(R.id.like_image);
//        mOne = (ImageView)view.findViewById(R.id.image_one);
//        mTwo = (ImageView)view.findViewById(R.id.image_two);
//        mThree = (ImageView)view.findViewById(R.id.image_three);
//
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/nobsworld-300x300.png").into(mNoBS);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/enviroicon-copy-150x150.png").into(mEnvironment);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/commicon-copy-150x150.png").into(mCommunity);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/fairtradeicon-copy-150x150.png").into(mHandshake);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/labouricon-150x150.png").into(mLabour);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/proconsicon-copy-150x150.png").into(mLike);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/collect.png").into(mOne);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/verify.png").into(mTwo);
//        Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/calculate.png").into(mThree);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) { super.onAttach(context); }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
