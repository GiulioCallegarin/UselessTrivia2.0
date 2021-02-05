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

public class Level5 extends AppCompatActivity {


    private Button btnMenu, btnReset, btnCheck;
    private TextView txtLivello, txtPunteggio;
    private int punteggio = 0;
    private ExplosionField explosionField;
    private ImageView imgTop, imgMid, imgBottom, imgTopLeft, imgTopRight, imgBottomLeft, imgBottomRight;
    private int[] clickCount = new int[]{0,0,0,0,0,0,0};
    private boolean vinto = false, aux = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);


        btnMenu = findViewById(R.id.btnMenu);
        btnCheck = findViewById(R.id.btnCheck);
        btnReset= findViewById(R.id.btnReset);
        txtPunteggio = findViewById(R.id.txtPunteggio);
        txtLivello = findViewById(R.id.txtLivello);

        imgTop = findViewById(R.id.imgTop);
        imgBottom = findViewById(R.id.imgBottom);
        imgMid = findViewById(R.id.imgMid);
        imgTopLeft = findViewById(R.id.imgTopLeft);
        imgTopRight = findViewById(R.id.imgTopRight);
        imgBottomLeft = findViewById(R.id.imgBottomLeft);
        imgBottomRight = findViewById(R.id.imgBottomRight);



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
                startActivity(new Intent(getApplicationContext(), Level5.class));
                finish();
            }
        });


        //--------------------------------------------------------------------------//
        //--------------------Aggiornamento Punteggio-------------------------------//


        imgTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount[0] == 0){
                    clickCount[0]++;
                    imgTop.setImageResource(R.drawable.ic_orr_disp_red);
                } else if(clickCount[0] == 4){
                    clickCount[0]++;
                    imgTop.setImageResource(R.drawable.ic_orr_disp_watergreen);
                } else if (clickCount[0] == 5){
                    clickCount[0] = 0;
                    imgTop.setImageResource(R.drawable.ic_orr_disp_black);
                } else
                    clickCount[0]++;
                update();
            }
        });
        imgMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount[1] == 0){
                    clickCount[1]++;
                    imgMid.setImageResource(R.drawable.ic_orr_disp_red);
                } else if(clickCount[1] == 4){
                    clickCount[1]++;
                    imgMid.setImageResource(R.drawable.ic_orr_disp_watergreen);
                } else if (clickCount[1] == 5){
                    clickCount[1] = 0;
                    imgMid.setImageResource(R.drawable.ic_orr_disp_black);
                } else
                    clickCount[1]++;
                update();
            }
        });
        imgBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount[2] == 0){
                    clickCount[2]++;
                    imgBottom.setImageResource(R.drawable.ic_orr_disp_red);
                } else if(clickCount[2] == 4){
                    clickCount[2]++;
                    imgBottom.setImageResource(R.drawable.ic_orr_disp_watergreen);
                } else if (clickCount[2] == 5){
                    clickCount[2] = 0;
                    imgBottom.setImageResource(R.drawable.ic_orr_disp_black);
                } else
                    clickCount[2]++;
                update();
            }
        });
        imgTopLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount[3] == 0){
                    clickCount[3]++;
                    imgTopLeft.setImageResource(R.drawable.ic_ver_disp_red);
                } else if(clickCount[3] == 4){
                    clickCount[3]++;
                    imgTopLeft.setImageResource(R.drawable.ic_ver_disp_watergreen);
                } else if (clickCount[3] == 5){
                    clickCount[3] = 0;
                    imgTopLeft.setImageResource(R.drawable.ic_ver_disp_black);
                } else
                    clickCount[3]++;
                update();
            }
        });
        imgTopRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount[4] == 0){
                    clickCount[4]++;
                    imgTopRight.setImageResource(R.drawable.ic_ver_disp_red);
                } else if(clickCount[4] == 4){
                    clickCount[4]++;
                    imgTopRight.setImageResource(R.drawable.ic_ver_disp_watergreen);
                } else if (clickCount[4] == 5){
                    clickCount[4] = 0;
                    imgTopRight.setImageResource(R.drawable.ic_ver_disp_black);
                } else
                    clickCount[4]++;
                update();
            }
        });
        imgBottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount[5] == 0){
                    clickCount[5]++;
                    imgBottomLeft.setImageResource(R.drawable.ic_ver_disp_red);
                } else if(clickCount[5] == 4){
                    clickCount[5]++;
                    imgBottomLeft.setImageResource(R.drawable.ic_ver_disp_watergreen);
                } else if (clickCount[5] == 5){
                    clickCount[5] = 0;
                    imgBottomLeft.setImageResource(R.drawable.ic_ver_disp_black);
                } else
                    clickCount[5]++;
                update();
            }
        });
        imgBottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount[6] == 0){
                    clickCount[6]++;
                    imgBottomRight.setImageResource(R.drawable.ic_ver_disp_red);
                } else if(clickCount[6] == 4){
                    clickCount[6]++;
                    imgBottomRight.setImageResource(R.drawable.ic_ver_disp_watergreen);
                } else if (clickCount[6] == 5){
                    clickCount[6] = 0;
                    imgBottomRight.setImageResource(R.drawable.ic_ver_disp_black);
                } else
                    clickCount[6]++;
                update();
            }
        });


    }


    public void update(){
        if((clickCount[0]==5 && clickCount[1]==5 && clickCount[2]==5 && clickCount[3]==5 && clickCount[6]==5) && clickCount[4]==0 && clickCount[5]==0){
            punteggio = 100;
            txtPunteggio.setText(String.valueOf(punteggio));
            explosionField = ExplosionField.attach2Window(Level5.this);
            explosionField.explode(txtLivello);
            vinto = true;
            btnCheck.setVisibility(View.VISIBLE);
            btnCheck.setEnabled(true);
            btnCheck.setText("Prossimo Livello");

            SessionManager userSession = new SessionManager(Level5.this);
            if(userSession.getField(SessionManager.KEY_SCORE).equals("4")) {
                userSession.edit(SessionManager.KEY_SCORE, "5");
                userSession.update();
            }
        }
    }




    //------------------------------------------------------------------------------//
    //--------------------------Controllo vittoria----------------------------------//

    public void check(View v){
        if(vinto){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }else if(punteggio == 100){
            explosionField = ExplosionField.attach2Window(Level5.this);
            explosionField.explode(txtLivello);
            vinto = true;
            btnCheck.setText("Prossimo Livello");
        }else
            Toast.makeText(this, "Il punteggio deve raggiungere 100", Toast.LENGTH_SHORT).show();
    }

}