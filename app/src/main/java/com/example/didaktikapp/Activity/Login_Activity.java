package com.example.didaktikapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.didaktikapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText erabiltzaileEditText;
    private EditText pasahitzaEditText;
    private Button loginBtnSartu;
    private Button loginBtnErregistratu;
    private Button loginBtnAnonimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //firebase
            mAuth = FirebaseAuth.getInstance();

        //edit text
            //erabiltzailea
            erabiltzaileEditText = findViewById(R.id.loginEditErbiltzaile);
            erabiltzaileEditText.setHint(getResources().getString(R.string.Login_editxt_email_hint));
                //BORRAR ANTES DE ENTREGAR
                erabiltzaileEditText.setText("admin@gmail.com");

            //pasahitza
            pasahitzaEditText = findViewById(R.id.loginEditPasahitza);
            pasahitzaEditText.setHint(getResources().getString(R.string.Login_editxt_pasahitza_hint));
                //BORRAR ANTES DE ENTREGAR
                pasahitzaEditText.setText("admin123");

        //botoiak
            loginBtnSartu = findViewById(R.id.loginBtnSartu);
            loginBtnErregistratu = findViewById(R.id.loginBtnErregistratu);



      //BOTONES (eventos)
        //login
            loginBtnSartu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String erabiltzaile = erabiltzaileEditText.getText().toString().trim(); //trim es para no espacios y tal
                    String pasahitza = pasahitzaEditText.getText().toString().trim();//trim es para no espacios y tal

                    if (TextUtils.isEmpty(erabiltzaile)) {
                        String sartuEposta = getResources().getString(R.string.Login_editxt_email_hint);
                        erabiltzaileEditText.setError(sartuEposta);
                    } else if (TextUtils.isEmpty(pasahitza)) {
                        String sartuPasahitza = getResources().getString(R.string.Login_editxt_pasahitza_hint);
                        pasahitzaEditText.setError(sartuPasahitza);
                    } else {
                        saioaHasi(erabiltzaile, pasahitza);
                    }

                }
            });//fin botones eventos LOGIN


        //erregistratu
        loginBtnErregistratu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String erabiltzaile = erabiltzaileEditText.getText().toString().trim(); //trim es para no espacios y tal
                String pasahitza = pasahitzaEditText.getText().toString().trim();//trim es para no espacios y tal

                erregistratu(erabiltzaile,pasahitza);

            }
        });//fin botones eventos LOGIN


    }//fin oncreate



    //METODOS
    private void saioaHasi(String erabiltzaile, String pasahitza) {
        mAuth.signInWithEmailAndPassword(erabiltzaile, pasahitza)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Saioa ondo hasi da
                            FirebaseUser user = mAuth.getCurrentUser();

                            // Hurrengo lehiora pasatzen da
                            Intent intent = new Intent(Login_Activity.this, Gune_1_Activity.class);

                            String email_pasatzeko = erabiltzaile.toString();
                            String pasahitza_pasatzeko = pasahitza.toString();


                            // Pertsonaren informazioa pasatzeko hurrengo aktibitatera
                            intent.putExtra("USER_email", email_pasatzeko);
                            intent.putExtra("USER_password", pasahitza_pasatzeko);


                            startActivity(intent);
                            finish();

                        //Saioko erroreak(email okerra, pasahitza okerra, no conection...)
                        } else {
                            Exception exception = task.getException();

                            if (exception instanceof FirebaseNetworkException) {
                                String erKonexioa = "konexio errorea";
                                Toast.makeText(Login_Activity.this, erKonexioa, Toast.LENGTH_SHORT).show();
                            } else if (exception instanceof FirebaseAuthInvalidUserException) {
                                String erEposta = "Ez da aurkitu emaila";
                                // Correo electrónico no encontrado en Firebase Authentication
                                Toast.makeText(Login_Activity.this, erEposta, Toast.LENGTH_SHORT).show();
                            } else if (exception instanceof FirebaseAuthInvalidCredentialsException) {
                                String erPasahitza = "Pasahitza ez du emailarekin bat";
                                // Credenciales de inicio de sesión inválidas (correo o contraseña incorrectos)
                                Toast.makeText(Login_Activity.this, erPasahitza, Toast.LENGTH_SHORT).show();
                            } else {
                                String erLogin = "Email edo Pasahitza okerrak";
                                // Otro error no manejado específicamente
                                Toast.makeText(Login_Activity.this, erLogin, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }//fin metodo saioahasi

    private void erregistratu(String erabiltzaile, String pasahitza) {


        // Hurrengo lehiora pasatzen da
        Intent intent = new Intent(Login_Activity.this, Erregistratu_Activity.class);

        //pasatuko diogu errregistratzeko ez jartzeko berriro guztia
        String email_pasatzeko = erabiltzaile.toString();
        String pasahitza_pasatzeko = pasahitza.toString();

        // Pertsonaren informazioa pasatzeko hurrengo aktibitatera
        intent.putExtra("USER_email", email_pasatzeko);
        intent.putExtra("USER_password", pasahitza_pasatzeko);


        startActivity(intent);
        finish();



    }//fin metodo erregistratu
}