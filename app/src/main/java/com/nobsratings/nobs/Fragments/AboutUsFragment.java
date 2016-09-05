package com.nobsratings.nobs.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        ArrayList<Member> memberArray = new ArrayList<>();

        String m1Name = "SAM YOON – CHIEF STORYTELLER";
        String m2Name = "MILDRED WONG – OPERATIONS BRAIN";
        String m3Name = "MAX ROGERS – PARTNERS MANAGER";

        String m1Desc = "I'm a good boy";
        String m2Desc = "I'm a good girl";
        String m3Desc = "I'm a good boy";

        String m1Photo ="http://www.nobsratings.org/wp-content/uploads/2016/02/Sam-1-e1456625951940.png";
        String m2Photo ="http://www.nobsratings.org/wp-content/uploads/2016/02/Mildred-e1456625902825.png";
        String m3Photo ="http://www.nobsratings.org/wp-content/uploads/2016/02/Max-e1456627381198.png";

        Member m1 = new Member(m1Name, m1Desc, m1Photo);
        Member m2 = new Member(m2Name, m2Desc, m3Photo);
        Member m3 = new Member(m3Name, m2Desc, m3Photo);

        memberArray.add(m1);
        memberArray.add(m2);
        memberArray.add(m3);


        LinearLayout ll = (LinearLayout)view.findViewById(R.id.memberLinearLayout);
        LayoutInflater tempInflater = LayoutInflater.from(getContext());
        for (int i=0; i<5; i++) {

            View tempView = tempInflater.inflate(R.layout.member_item, ll, false);
            TextView mName = (TextView) tempView.findViewById(R.id.memberName);
            TextView mDesc = (TextView) tempView.findViewById(R.id.memberDescription);
            ImageView mPhoto = (ImageView) tempView.findViewById(R.id.memberPhoto);

            mName.setText("SAM YOON – CHIEF STORYTELLER");
            mDesc.setText("Sam has always been passionate about how to make the world a better place. As a Law and Economics student at the University of Auckland his favourite hobby is to sleep.");
            Picasso.with(getContext()).load("http://www.nobsratings.org/wp-content/uploads/2016/02/Sam-1-e1456625951940.png").into(mPhoto);

            ll.addView(tempView);

        }

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
