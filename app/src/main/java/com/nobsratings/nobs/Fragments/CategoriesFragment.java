package com.nobsratings.nobs.Fragments;

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
import android.widget.Toast;

import com.nobsratings.nobs.BuildConfig;
import com.nobsratings.nobs.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CategoriesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment {

    public static final String FRAGMENT_TAG = BuildConfig.APPLICATION_ID + ".HomeActivity Fragment Tag";
    private OnFragmentInteractionListener mListener;
    View mView;

    public CategoriesFragment() {
    }


    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        this.mView = view;

        //Initialize dummy data
        final ArrayList<String> list = new ArrayList<String>();
        String[] values = new String[] {"Education","Cafes and Restaurants", "Other"};
        for (int i=0; i<values.length; i++) {
            list.add(values[i]);
        }
        Log.d("^^^", list.size() + "");

        //Initialize adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.mView.getContext(), android.R.layout.simple_selectable_list_item, list);
        ListView listview = (ListView) view.findViewById(R.id.categoriesListView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "POSITION: " + position, Toast.LENGTH_SHORT).show();
                //Replace Fragment

                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                CompaniesFragment fragment2 = new CompaniesFragment();

                Bundle bundle = new Bundle();
                bundle.putInt("categoryId", position);
                fragment2.setArguments(bundle);

                fragmentTransaction2.replace(R.id.FrameLayout, fragment2, fragment2.FRAGMENT_TAG)
                        .addToBackStack("xyz")
                        .commit();
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
        void onFragmentInteraction(Uri uri);
    }
}
