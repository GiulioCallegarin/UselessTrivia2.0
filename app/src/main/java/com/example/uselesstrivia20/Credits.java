package com.example.uselesstrivia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Credits extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    public void ig(View v){
        Uri uri = Uri.parse("https://www.instagram.com/giulio_callegarin");
        Intent instagram = new Intent(Intent.ACTION_VIEW, uri);
        instagram.setPackage("com.instagram.android");
        try{
            startActivity(instagram);
        } catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }

    public void sito(View v){
        Uri uri = Uri.parse("http://bananeblu.zapto.org/");
        Intent instagram = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(instagram);
    }
}