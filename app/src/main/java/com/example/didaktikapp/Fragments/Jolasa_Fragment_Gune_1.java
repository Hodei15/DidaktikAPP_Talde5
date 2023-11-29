package com.example.didaktikapp.Fragments;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.example.didaktikapp.Model.Argazki;
import com.example.didaktikapp.Model.DibujoView;
import com.example.didaktikapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jolasa_Fragment_Gune_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jolasa_Fragment_Gune_1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean bukatuta;

    public Jolasa_Fragment_Gune_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Jolasa_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Jolasa_Fragment_Gune_1 newInstance(String param1, String param2) {
        Jolasa_Fragment_Gune_1 fragment =  new Jolasa_Fragment_Gune_1();
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

    private DibujoView dibujoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jolasa_gune_1, container, false);

        dibujoView = view.findViewById(R.id.dibujoView);

        //Argazkiak lortzen ditugu
        ImageView pez1 = view.findViewById(R.id.img_arrain_1);
        ImageView pez2 = view.findViewById(R.id.img_arrain_2);
        ImageView pez3 = view.findViewById(R.id.img_arrain_3);
        ImageView pez4 = view.findViewById(R.id.img_arrain_4);
        ImageView pez5 = view.findViewById(R.id.img_arrain_5);
        ImageView lata1 = view.findViewById(R.id.img_lata_1);
        ImageView lata2 = view.findViewById(R.id.img_lata_2);
        ImageView lata3 = view.findViewById(R.id.img_lata_3);
        ImageView lata4 = view.findViewById(R.id.img_lata_4);
        ImageView lata5 = view.findViewById(R.id.img_lata_5);

        //Arrain argazkiak gordetzen ditugu
        List<Argazki> arrain_argazkiak = new ArrayList<Argazki>();
        //Lata argazkiak gordetzen ditugu
        List<Argazki> lata_argazkiak = new ArrayList<Argazki>();

        //Arrainak kargatu
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,1,pez1);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,2,pez2);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,3,pez3);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,4,pez4);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,5,pez5);

        //Latak kargatu
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,1,lata1);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,2,lata2);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,3,lata3);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,4,lata4);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,5,lata5);

        dibujoView.setArrainak(arrain_argazkiak);
        dibujoView.setLatak(lata_argazkiak);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    public void setGune1Value(boolean gune1) {
        //Booleanoa
        this.bukatuta = gune1;
    }
    private List<Argazki> agazkiakKargatu(List<Argazki> argazkiak,int bikote, ImageView argazki){

        ViewTreeObserver viewTreeObserver = argazki.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] locationOnScreen = new int[2];
                argazki.getLocationOnScreen(locationOnScreen);
                Argazki argazki_obj = new Argazki(argazki,bikote,argazki.getHeight(),argazki.getWidth(),locationOnScreen[0],locationOnScreen[1]);
                argazkiak.add(argazki_obj);
            }
        });
        return argazkiak;
    }

    private void limpiarDibujo() {
        dibujoView.limpiarDibujo();
    }

}