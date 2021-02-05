package com.example.uselesstrivia20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registrazione extends AppCompatActivity {

    private EditText edtEmail, edtPassword, edtPassword2, edtNome;
    private Button btnRegister;
    private TextView txtSwitchPage;
    private FirebaseAuth fAuth;
    private ProgressBar progRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword1);
        edtPassword2 = findViewById(R.id.edtPassword2);
        btnRegister = findViewById(R.id.btnRegister);
        txtSwitchPage = findViewById(R.id.txtSwitchPage);
        progRegister = findViewById(R.id.progRegister);
        edtNome = findViewById(R.id.edtNome);
        fAuth = FirebaseAuth.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progRegister.setVisibility(View.INVISIBLE);
                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String password2 = edtPassword2.getText().toString();
                if(TextUtils.isEmpty(email)){
                    edtEmail.setError("Campo necessario");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    edtPassword.setError("Campo necessario");
                    return;
                }
                if(TextUtils.isEmpty(password2)){
                    edtPassword2.setError("Campo necessario");
                    return;
                }
                if(password.length() < 2){
                    edtPassword.setError("Password di minimo 8 caratteri");
                    return;
                }
                if(!TextUtils.equals(password,password2)){
                    edtPassword.setError("Le password devono corrispondere");
                    return;
                }

                progRegister.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            SessionManager myUser = new SessionManager(Registrazione.this);
                            myUser.createUserSession(nome, email,"0", fAuth.getCurrentUser().getUid());
                            myUser.update();
                            progRegister.setVisibility(View.INVISIBLE);
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                            finish();
                        }else
                            Toast.makeText(Registrazione.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        txtSwitchPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });

    }
}