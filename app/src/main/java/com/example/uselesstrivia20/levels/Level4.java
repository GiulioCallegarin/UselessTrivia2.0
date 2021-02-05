package com.example.uselesstrivia20.levels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uselesstrivia20.MainActivity;
import com.example.uselesstrivia20.R;
import com.example.uselesstrivia20.SessionManager;

import tyrantgit.explosionfield.ExplosionField;

public class Level4 extends AppCompatActivity{


    private Button btnMenu, btnReset, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnCheck;
    private TextView txtLivello, txtPunteggio;
    private int punteggio = 0;
    private ExplosionField explosionField;
    private ImageView imgDoggo,imgDialog;
    private boolean vinto = false, aux = false;
    private char[] vettCharAB;
    private char[] vettCharAU;
    private char[] vettCharBU;
    int index[] = new int[]{0,0,0,0,0,0};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        btnMenu = findViewById(R.id.btnMenu);
        btnCheck = findViewById(R.id.btnCheck);
        btnOne= findViewById(R.id.btnOne);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix= findViewById(R.id.btnSix);
        btnThree= findViewById(R.id.btnThree);
        btnTwo= findViewById(R.id.btnTwo);
        btnReset= findViewById(R.id.btnReset);
        txtPunteggio = findViewById(R.id.txtPunteggio);
        txtLivello = findViewById(R.id.txtLivello);
        imgDoggo = findViewById(R.id.imgDoggo);
        imgDialog = findViewById(R.id.imgDialog);


        vettCharAB = new char[]{'E','C','A','B','N','T'};
        vettCharAU = new char[]{'V','I','D','A','U','C'};
        vettCharBU = new char[]{'L','B','F','U','G','T'};


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Level4.class));
                finish();
            }
        });


        //--------------------------------------------------------------------------//
        //--------------------Aggiornamento Punteggio-------------------------------//


        imgDoggo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(imgDialog.getVisibility() == View.INVISIBLE){
                    imgDialog.setVisibility(View.VISIBLE);
                    punteggio+=20;
                    txtPunteggio.setText(String.valueOf(punteggio));
                }
                return false;
            }
        });


        //--------------------------------------------------------------------------//

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[0] = (index[0]+1)%6;
                btnOne.setText(String.valueOf(vettCharAB[index[0]]));
                update();
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[1] = (index[1]+1)%6;
                btnTwo.setText(String.valueOf(vettCharAU[index[1]]));
                update();
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[2] = (index[2]+1)%6;
                btnThree.setText(String.valueOf(vettCharBU[index[2]]));
                update();
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[3] = (index[3]+1)%6;
                btnFour.setText(String.valueOf(vettCharBU[index[3]]));
                update();
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[4] = (index[4]+1)%6;
                btnFive.setText(String.valueOf(vettCharAB[index[4]]));
                update();
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index[5] = (index[5]+1)%6;
                btnSix.setText(String.valueOf(vettCharAU[index[5]]));
                update();
            }
        });


    }


    public void update(){
        if(index[0] == 3 && index[1] == 3 && index[2] == 3 && index[3] == 1 && index[4] == 2 && index[5] == 4){
            imgDialog.setVisibility(View.VISIBLE);
            punteggio = 100;
            txtPunteggio.setText(String.valueOf(punteggio));
            explosionField = ExplosionField.attach2Window(Level4.this);
            explosionField.explode(txtLivello);
            vinto = true;
            btnCheck.setVisibility(View.VISIBLE);
            btnCheck.setEnabled(true);
            btnCheck.setText("Prossimo Livello");

            SessionManager userSession = new SessionManager(Level4.this);
            if(userSession.getField(SessionManager.KEY_SCORE).equals("3")) {
                userSession.edit(SessionManager.KEY_SCORE, "4");
                userSession.update();
            }
        }
    }


    //------------------------------------------------------------------------------//
    //--------------------------Controllo vittoria----------------------------------//

    public void check(View v){
        if(vinto){
            startActivity(new Intent(getApplicationContext(), Level5.class));
            finish();
        }else if(punteggio == 100){
            explosionField = ExplosionField.attach2Window(Level4.this);
            explosionField.explode(txtLivello);
            vinto = true;
            btnCheck.setText("Prossimo Livello");

            SessionManager userSession = new SessionManager(Level4.this);
            if(userSession.getField(SessionManager.KEY_SCORE).equals("3")) {
                userSession.edit(SessionManager.KEY_SCORE, "4");
                userSession.update();
            }
        }else
            Toast.makeText(this, "Il punteggio deve raggiungere 100", Toast.LENGTH_SHORT).show();
    }
}