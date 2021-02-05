package com.example.uselesstrivia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uselesstrivia20.levels.Level1;
import com.example.uselesstrivia20.levels.Level2;
import com.example.uselesstrivia20.levels.Level3;
import com.example.uselesstrivia20.levels.Level4;
import com.example.uselesstrivia20.levels.Level5;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

import tyrantgit.explosionfield.ExplosionField;

public class MainActivity extends AppCompatActivity {

    private ExplosionField explosionField;
    private Button btnGioca, btnLivelli, btnCredits;
    private ImageView imgPanik;
    private FirebaseAuth fAuth;
    private TextView txtUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fAuth = FirebaseAuth.getInstance();
        imgPanik = findViewById(R.id.imgPanik);
        btnGioca = findViewById(R.id.btnGioca);
        btnCredits = findViewById(R.id.btnCredits);
        btnLivelli = findViewById(R.id.btnLivelli);
        txtUsername = findViewById(R.id.txtUsername);

        SessionManager userSession = new SessionManager(MainActivity.this);
        HashMap<String, String> userData = userSession.getUserData();

        txtUsername.setText("Ciao " + userData.get(SessionManager.KEY_USERNAME));




        btnCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Credits.class));
            }
        });

        btnGioca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Integer.parseInt(userData.get(SessionManager.KEY_SCORE))){
                    case 0: startActivity(new Intent(getApplicationContext(), Level1.class)); break;
                    case 1: startActivity(new Intent(getApplicationContext(), Level2.class)); break;
                    case 2: startActivity(new Intent(getApplicationContext(), Level3.class)); break;
                    case 3: startActivity(new Intent(getApplicationContext(), Level4.class)); break;
                    case 4: startActivity(new Intent(getApplicationContext(), Level5.class)); break;
                    default:break;
                }
            }
        });

        btnLivelli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Levels.class);
                startActivity(i);
            }
        });

    }

    public void logout(View v){
        fAuth.signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void panik(View v){
        explosionField = ExplosionField.attach2Window(MainActivity.this);
        explosionField.explode(imgPanik);
    }
}