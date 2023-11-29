package com.example.didaktikapp.Activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.didaktikapp.Fragments.Audio_Fragment_Gune_1;
import com.example.didaktikapp.Fragments.Bideo_Fragment_Gune_1;
import com.example.didaktikapp.Fragments.Jolasa_Fragment_Gune_1;
import com.example.didaktikapp.R;

public class Gune_1_Activity extends AppCompatActivity {
    boolean gune1 = true;

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
                if(gune1){
                    Intent intent = new Intent(Gune_1_Activity.this, Gune_2_Activity.class);

                }
                Log.d(TAG,"Entra frag 2");
                fm.beginTransaction().replace(R.id.frag_container, Jolasa_Fragment_Gune_1.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
    }


}