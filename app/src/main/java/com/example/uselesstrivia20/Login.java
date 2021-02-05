package com.example.uselesstrivia20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class Login extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private TextView txtSwitchPage;
    private FirebaseAuth fAuth;
    private ProgressBar progLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword1);
        btnLogin = findViewById(R.id.btnLogin);
        txtSwitchPage = findViewById(R.id.txtSwitchPage);
        progLogin = findViewById(R.id.progLogin);
        fAuth = FirebaseAuth.getInstance();


        if (fAuth.getCurrentUser() != null){
            SessionManager userSession = new SessionManager(Login.this);
            userSession.getUserSession(fAuth.getCurrentUser().getUid());
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progLogin.setVisibility(View.INVISIBLE);
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if(TextUtils.isEmpty(email)){
                    edtEmail.setError("Campo necessario");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    edtPassword.setError("Campo necessario");
                    return;
                }

                progLogin.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progLogin.setVisibility(View.INVISIBLE);
                            SessionManager userSession = new SessionManager(Login.this);
                            userSession.getUserSession(fAuth.getCurrentUser().getUid());
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }else {
                            progLogin.setVisibility(View.INVISIBLE);
                            Toast.makeText(Login.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        txtSwitchPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registrazione.class));
            }
        });

    }
}