package com.example.navdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.navdrawer.databasehelper.DatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText title_receta, prep, ingrediente, ingrediente2, ingrediente3, ingrediente4, ingrediente5 ;
    Button add_button;


    public AgregarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarFragment newInstance(String param1, String param2) {
        AgregarFragment fragment = new AgregarFragment();
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
        View view = inflater.inflate(R.layout.fragment_agregar, container, false);

        title_receta = view.findViewById(R.id.etTitulo);
        prep = view.findViewById(R.id.etPrep);
        ingrediente = view.findViewById(R.id.etIngredente);
        ingrediente2 = view.findViewById(R.id.etIngredente2);
        ingrediente3 = view.findViewById(R.id.etIngredente3);
        ingrediente4 = view.findViewById(R.id.etIngredente4);
        ingrediente5 = view.findViewById(R.id.etIngredente5);
        add_button = view.findViewById(R.id.bnAdd);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper myDB = new DatabaseHelper(AgregarFragment.this.getContext());
                myDB.addReceta(title_receta.getText().toString().trim(),
                        prep.getText().toString().trim(),
                        ingrediente.getText().toString().trim(),
                        ingrediente2.getText().toString().trim(),
                        ingrediente3.getText().toString().trim(),
                        ingrediente4.getText().toString().trim(),
                        ingrediente5.getText().toString().trim());
            }
        });
        return view;
    }
}