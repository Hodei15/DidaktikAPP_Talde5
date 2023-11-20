package com.example.didaktikapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Gune_1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gune_1);

        Button btn_atzera =findViewById(R.id.btn_atzera);
        Button btn_aurrera = findViewById(R.id.btn_aurrera);

        FragmentManager fm = getSupportFragmentManager();

        btn_atzera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Entra frag 1");
                FragmentTransaction fragmentTransaction = Gune_1_Activity.this.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frag_container, new Bideo_Fragment_Gune_1());
                fragmentTransaction.commit();
            }
        });

        btn_aurrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Entra frag 2");
                fm.beginTransaction().replace(R.id.frag_container, Audio_Fragment_Gune_1.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
    }


}