package com.example.uselesstrivia20.levels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uselesstrivia20.MainActivity;
import com.example.uselesstrivia20.R;
import com.example.uselesstrivia20.SessionManager;
import com.google.android.material.chip.Chip;

import tyrantgit.explosionfield.ExplosionField;

public class Level3 extends AppCompatActivity {

    private Button btnMenu, btnReset, btnOne, btnTwo, btnThree, btnCheck;
    private SeekBar seekIncrement, seekIncrement2, seekIncrement3;
    private Chip chipActivate;
    private TextView txtLivello, txtPunteggio;
    private ExplosionField explosionField;
    private int punteggio = 0;
    private int vettSet[] = new int[3];
    private boolean vinto = false, aux = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);


        btnMenu = findViewById(R.id.btnMenu);
        btnCheck = findViewById(R.id.btnCheck);
        btnOne= findViewById(R.id.btnOne);
        btnThree= findViewById(R.id.btnThree);
        btnTwo= findViewById(R.id.btnTwo);
        btnReset= findViewById(R.id.btnReset);
        seekIncrement = findViewById(R.id.seekIncrement);
        seekIncrement2 = findViewById(R.id.seekIncrement2);
        seekIncrement3 = findViewById(R.id.seekIncrement3);
        chipActivate = findViewById(R.id.chipActivate);
        txtPunteggio = findViewById(R.id.txtPunteggio);
        txtLivello = findViewById(R.id.txtLivello);



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
                startActivity(new Intent(getApplicationContext(), Level3.class));
                finish();
            }
        });


        //--------------------------------------------------------------------------//
        //--------------------Aggiornamento Punteggio-------------------------------//


        chipActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!aux){
                    if(seekIncrement.getProgress()==20 && seekIncrement2.getProgress()==20 && seekIncrement3.getProgress()==20 ){
                        punteggio+=10;
                        txtPunteggio.setText(String.valueOf(punteggio));
                        chipActivate.setText("ON");
                        btnOne.setTextColor(Color.WHITE);
                        btnTwo.setTextColor(Color.WHITE);
                        btnThree.setTextColor(Color.WHITE);
                        aux = true;
                    }
                } else if(aux) {
                    punteggio -= 10;
                    chipActivate.setText("OFF");
                    txtPunteggio.setText(String.valueOf(punteggio));
                    btnOne.setTextColor(Color.BLACK);
                    btnTwo.setTextColor(Color.BLACK);
                    btnThree.setTextColor(Color.BLACK);
                    aux = false;
                }
            }
        });

        //--------------------------------------------------------------------------//

        seekIncrement.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int difference = 0, start = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                difference = progress - start;
                punteggio += difference;
                txtPunteggio.setText(String.valueOf(punteggio));
                start = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekIncrement2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int difference = 0, start = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                difference = progress - start;
                punteggio += difference;
                txtPunteggio.setText(String.valueOf(punteggio));
                start = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekIncrement3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int difference = 0, start = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                difference = progress - start;
                punteggio += difference;
                txtPunteggio.setText(String.valueOf(punteggio));
                start = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //--------------------------------------------------------------------------//

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aux){
                    if(vettSet[0] < 2) {
                        vettSet[0]++;
                        btnOne.setText(String.valueOf(vettSet[0]));
                    }else if(vettSet[0] == 2){
                        vettSet[0]++;
                        btnOne.setText(String.valueOf(vettSet[0]));
                        punteggio += 10;
                        txtPunteggio.setText(String.valueOf(punteggio));
                    }
                }
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aux){
                    if(vettSet[1] < 2) {
                        vettSet[1]++;
                        btnTwo.setText(String.valueOf(vettSet[1]));
                    }else if(vettSet[1] == 2){
                        vettSet[1]++;
                        btnTwo.setText(String.valueOf(vettSet[1]));
                        punteggio += 10;
                        txtPunteggio.setText(String.valueOf(punteggio));
                    }
                }
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aux){
                    if(vettSet[2] < 2) {
                        vettSet[2]++;
                        btnThree.setText(String.valueOf(vettSet[2]));
                    }else if(vettSet[2] == 2){
                        vettSet[2]++;
                        btnThree.setText(String.valueOf(vettSet[2]));
                        punteggio += 10;
                        txtPunteggio.setText(String.valueOf(punteggio));
                    }
                }
            }
        });

    }

    //------------------------------------------------------------------------------//
    //--------------------------Controllo vittoria----------------------------------//

    public void check(View v){
        if(vinto){
            startActivity(new Intent(getApplicationContext(), Level4.class));
            finish();
        }else if(punteggio == 100){
            explosionField = ExplosionField.attach2Window(Level3.this);
            explosionField.explode(txtLivello);
            vinto = true;
            btnCheck.setText("Prossimo Livello");

            SessionManager userSession = new SessionManager(Level3.this);
            if(userSession.getField(SessionManager.KEY_SCORE).equals("2")) {
                userSession.edit(SessionManager.KEY_SCORE, "3");
                userSession.update();
            }
        }else
            Toast.makeText(this, "Il punteggio deve raggiungere 100", Toast.LENGTH_SHORT).show();
    }

}