package com.nobsratings.nobs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class CompaniesFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public static final String FRAGMENT_TAG = BuildConfig.APPLICATION_ID + ".HomeActivity Fragment Tag";
    public String categoryId;

    public CompaniesFragment() {
    }

    public static CompaniesFragment newInstance(String param1, String param2) {
        CompaniesFragment fragment = new CompaniesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int temp = getArguments().getInt("categoryId");
            Log.d("^^^", temp + "SUCCESS");
            if (temp == 0) {
                this.categoryId = "0";
            } else {
                this.categoryId = "1";
            }
        } else {
            Log.d("^^^", "NO BUNDLE");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_companies, container, false);

        String[] s1;
        final ArrayList<String> list = new ArrayList<String>();

        if (this.categoryId == "0") {
            s1 = new String[] {"Niesh", "Gravity", "Langham"};
        } else {
            s1 = new String[] {"Other 1", "Other 2", "Other 3"};
        }

        for (int i=0; i<s1.length; i++) {
            list.add(s1[i]);
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_selectable_list_item, list);
        ListView lv = (ListView) view.findViewById(R.id.companyList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //REPLACE FRAGMENT

                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                CompanyFragment fragment2 = new CompanyFragment();

                Bundle bundle = new Bundle();
                bundle.putInt("companyId", position);
                fragment2.setArguments(bundle);

                fragmentTransaction2.replace(R.id.FrameLayout, fragment2, fragment2.FRAGMENT_TAG)
                        .addToBackStack("xyz")
                        .commit();



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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
