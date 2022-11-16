package com.example.navdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navdrawer.recycleradapter.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageURLs = new ArrayList<>();

    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        Log.d(TAG, "onCreate: Started.");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home, container, false);
        initImageBitmaps();
        initRecyclerView();
        return view;
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitMaps: preparing bitmaps.");

        mNames.add("Paella");
        mImageURLs.add("https://www.thespruceeats.com/thmb/rWeSaLTQeF1NJePa_HP5Tabf3jo=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/fresh-paella-in-pan-on-wooden-table-556668991-5843564b5f9b5851e5745d5a.jpg");
        mNames.add("Pasta");
        mImageURLs.add("https://images.immediate.co.uk/production/volatile/sites/30/2013/05/Puttanesca-fd5810c.jpg");
        mNames.add("Hamburguesa");
        mImageURLs.add("https://www.tentacionesdemujer.com/wp-content/uploads/2017/05/King-bacon-Burguer-King-600x400.jpg");
        mNames.add("Pizza");
        mImageURLs.add("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F19%2F2014%2F07%2F10%2Fpepperoni-pizza-ck-x.jpg");
        mNames.add("Sushi");
        mImageURLs.add("https://www.justonecookbook.com/wp-content/uploads/2020/01/Sushi-Rolls-Maki-Sushi-–-Hosomaki-1106-II.jpg");
        mNames.add("Burrito");
        mImageURLs.add("https://www.thespruceeats.com/thmb/vequ4du_9ahBCvjuNErPtixsHsY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/vegetarian-bean-and-rice-burrito-recipe-3378550-hero-01-40ecbc08fcc84e80b8be853c1b779a13.jpg");
        mNames.add("Pad Thai");
        mImageURLs.add("https://www.lemonblossoms.com/wp-content/uploads/2020/01/Pad-Thai-S1-500x500.jpg");
        mNames.add("Tacos");
        mImageURLs.add("https://www.jocooks.com/wp-content/uploads/2020/08/ground-beef-tacos-1-11.jpg");
        mNames.add("Lasagna");
        mImageURLs.add("https://thecozycook.com/wp-content/uploads/2022/04/Lasagna-Recipe-f.jpg");
        mNames.add("Sopa");
        mImageURLs.add("https://www.cookingclassy.com/wp-content/uploads/2022/03/sopa-de-fideo-1.jpg");

       // initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");


        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        //ESTO HACE EL RECYCLERVIEW HORIZONTAL!!!!
        //recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL, false));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getContext(), mNames, mImageURLs);
        recyclerView.setAdapter(adapter);
        //ESTO HACE EL RECYCLERVIEW VERTICAL!!!!
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.setAdapter(adapter);
    }
}