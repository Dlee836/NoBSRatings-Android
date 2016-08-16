package com.nobsratings.nobs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        String m3Name = "MAX ROGERS – PARTNERS MANAGER\n";
        String m4Name = "";
        String m5Name = "";
        String m6Name = "";

        String m1Desc = "From his experience being on the Mayor’s Youth Advisory Panel for Auckland and being a Office of Ethnic Affairs Young Leader, Sam has always been passionate about how to make the world a better place. As a Law and Economics student at the University of Auckland his favourite hobby is to sleep.";
        String m2Desc = "Mildred thinks that the world must move forward in a new direction, the Nobs direction! As a Mechatronic Engineering and Commerce student, Previous Head Girl at Mt Roskill Grammar and a University of Auckland Scholar, she has the brains to make this vision into reality.\n";
        String m3Desc = "As a current Commerce and Science student at the University of Auckland and having experience at World Vision and the Management Consulting Club, Max believes that consumers have the power to influence businesses to change their practices for the better.\n";
        String m4Desc = "";
        String m5Desc = "";

        String m1Photo ="http://www.nobsratings.org/wp-content/uploads/2016/02/Sam-1-e1456625951940.png";
        String m2Photo ="http://www.nobsratings.org/wp-content/uploads/2016/02/Mildred-e1456625902825.png";
        String m3Photo ="http://www.nobsratings.org/wp-content/uploads/2016/02/Max-e1456627381198.png";
        String m4Photo ="";
        String m5Photo ="";

        Member m1 = new Member(m1Name, m1Desc, m1Photo);
        Member m2 = new Member(m2Name, m2Desc, m2Photo);
        Member m3 = new Member(m3Name, m3Desc, m3Photo);
        //Member m4 = new Member(m4Name, m4Desc, m4Photo);
        //Member m5 = new Member(m5Name, m5Desc, m5Photo);

        memberArray.add(m1);
        memberArray.add(m2);
        memberArray.add(m3);
        //memberArray.add(m4);
        //memberArray.add(m5);

        TextView tm1Text = (TextView) view.findViewById(R.id.memberName1);
        TextView tm2Text = (TextView) view.findViewById(R.id.memberName2);
        TextView tm3Text = (TextView) view.findViewById(R.id.memberName3);
        TextView tm4Text = (TextView) view.findViewById(R.id.memberName4);
        TextView tm5Text = (TextView) view.findViewById(R.id.memberName5);
        //TextView tm6Text = (TextView) view.findViewById(R.id.memberName6);

        TextView tm1Desc = (TextView) view.findViewById(R.id.memberDescription1);
        TextView tm2Desc = (TextView) view.findViewById(R.id.memberDescription2);
        TextView tm3Desc = (TextView) view.findViewById(R.id.memberDescription3);
        TextView tm4Desc = (TextView) view.findViewById(R.id.memberDescription4);
        TextView tm5Desc = (TextView) view.findViewById(R.id.memberDescription5);
        //TextView tm6Desc = (TextView) view.findViewById(R.id.memberDescription6);

        ImageView tm1Photo = (ImageView) view.findViewById(R.id.memberPhoto1);
        ImageView tm2Photo = (ImageView) view.findViewById(R.id.memberPhoto2);
        ImageView tm3Photo = (ImageView) view.findViewById(R.id.memberPhoto3);
        ImageView tm4Photo = (ImageView) view.findViewById(R.id.memberPhoto4);
        ImageView tm5Photo = (ImageView) view.findViewById(R.id.memberPhoto5);
        //ImageView tm6Photo = (ImageView) view.findViewById(R.id.memberPhoto6);

        tm1Text.setText(m1.getName());
        tm2Text.setText(m2.getName());
        tm3Text.setText(m3.getName());

        //tm1Desc.setText(m1.getDescription());
        //tm2Desc.setText(m2.getDescription());
        //tm3Desc.setText(m3.getDescription());

        //Picasso.with(getContext()).load(m1.getPhotoUrl()).into(tm1Photo);
        //Picasso.with(getContext()).load(m2.getPhotoUrl()).into(tm2Photo);
        //Picasso.with(getContext()).load(m3.getPhotoUrl()).into(tm3Photo);

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
