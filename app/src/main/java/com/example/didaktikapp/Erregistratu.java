package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Erregistratu extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText erabiltzaileEditText;
    private EditText pasahitzaEditText1;
    private EditText pasahitzaEditText2;
    private Button erregistratuErregistratu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erregistratu);



        //firebase
        mAuth = FirebaseAuth.getInstance();

        //edit text
            //erabiltzailea
            String gmail_from_intent = getIntent().getStringExtra("USER_email");
            erabiltzaileEditText = findViewById(R.id.errgstrtuEdtTxtEmail);
            erabiltzaileEditText.setHint(getResources().getString(R.string.Login_editxt_email_hint));

            erabiltzaileEditText.setText(gmail_from_intent);

            //pasahitzak
            String pasahitza_from_intent = getIntent().getStringExtra("USER_password");

            pasahitzaEditText1 = findViewById(R.id.errgstrtuEdtTxtPasahitza1);
            pasahitzaEditText1.setHint(getResources().getString(R.string.Login_editxt_pasahitza_hint));
            pasahitzaEditText1.setText(pasahitza_from_intent);

            pasahitzaEditText2 = findViewById(R.id.errgstrtuEdtTxtPasahitza2);
            pasahitzaEditText2.setHint(getResources().getString(R.string.Login_editxt_pasahitza_hint));
            pasahitzaEditText2.setText(pasahitza_from_intent);



        //botoiak

        erregistratuErregistratu = findViewById(R.id.errgstrtuBtnErregistratu);
    }
}