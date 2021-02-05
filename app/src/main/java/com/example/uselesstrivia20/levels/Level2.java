package com.example.uselesstrivia20.levels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uselesstrivia20.MainActivity;
import com.example.uselesstrivia20.R;
import com.example.uselesstrivia20.SessionManager;

import tyrantgit.explosionfield.ExplosionField;

public class Level2 extends AppCompatActivity {


    private Button btnMenu, btnReset, btnDouble, btnCheck;
    private SeekBar seekIncrement, seekIncrement2;
    private TextView txtLivello, txtPunteggio;
    private ExplosionField explosionField;
    private int punteggio = 0;
    private boolean vinto = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        btnMenu = findViewById(R.id.btnMenu);
        btnCheck = findViewById(R.id.btnCheck);
        btnDouble= findViewById(R.id.btnDouble);
        btnReset= findViewById(R.id.btnReset);
        seekIncrement = findViewById(R.id.seekIncrement);
        seekIncrement2 = findViewById(R.id.seekIncrement2);
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
                startActivity(new Intent(getApplicationContext(), Level2.class));
                finish();
            }
        });


        //--------------------------------------------------------------------------//
        //--------------------Aggiornamento Punteggio-------------------------------//

        seekIncrement.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int start = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int difference = 0;
                if(progress <= 75) {
                    difference = progress - start;
                    punteggio += difference;
                    txtPunteggio.setText(String.valueOf(punteggio));
                    start = progress;
                }else {
                    difference = progress - start;
                    punteggio -= difference;
                    txtPunteggio.setText(String.valueOf(punteggio));
                    start = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                start = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //----------------------------------------------------------------------------//

        btnDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punteggio = -punteggio;
                txtPunteggio.setText(String.valueOf(punteggio));
            }
        });


        //----------------------------------------------------------------------------//

        seekIncrement2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int difference = 0, start = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() == 100){
                    punteggio = 100;
                    txtPunteggio.setText(String.valueOf(punteggio));
                }
            }
        });


    }


    //------------------------------------------------------------------------------//
    //--------------------------Controllo vittoria----------------------------------//

    public void check(View v){
        if(vinto){
            startActivity(new Intent(getApplicationContext(), Level3.class));
            finish();
        }else if(punteggio == 100){
            explosionField = ExplosionField.attach2Window(Level2.this);
            explosionField.explode(txtLivello);
            vinto = true;
            btnCheck.setText("Prossimo Livello");

            SessionManager userSession = new SessionManager(Level2.this);
            if(userSession.getField(SessionManager.KEY_SCORE).equals("1")) {
                userSession.edit(SessionManager.KEY_SCORE, "2");
                userSession.update();
            }
        }else
            Toast.makeText(this, "Il punteggio deve raggiungere 100", Toast.LENGTH_SHORT).show();
    }
}