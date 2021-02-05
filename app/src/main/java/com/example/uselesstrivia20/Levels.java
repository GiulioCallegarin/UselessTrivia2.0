package com.example.uselesstrivia20;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.example.uselesstrivia20.adapter.Adapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Levels extends AppCompatActivity {

    private RecyclerView levelList;
    private List<String> livelli;
    private Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        levelList = findViewById(R.id.levelList);

        livelli = new ArrayList<>();

        SessionManager userSession = new SessionManager(Levels.this);
        HashMap<String, String> userData = userSession.getUserData();

        int score = Integer.parseInt(userData.get(SessionManager.KEY_SCORE));

        for(int i=0; i<score+1; i++)
            livelli.add(String.valueOf(i+1));


        adapter = new Adapter(this,livelli);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        levelList.setLayoutManager(gridLayoutManager);
        levelList.setAdapter(adapter);
    }

}