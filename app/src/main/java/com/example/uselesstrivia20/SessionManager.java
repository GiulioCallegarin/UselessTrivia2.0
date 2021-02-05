package com.example.uselesstrivia20;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    SharedPreferences userSession;
    SharedPreferences.Editor editor;
    Context context;
    FirebaseFirestore fStore;


    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_SCORE = "score";
    public static final String KEY_USERID = "userId";
    public static final String KEY_USERCOLLECTION = "users";


    public SessionManager(Context context) {
        this.context = context;
        userSession = context.getSharedPreferences("userLoggedSessoin", Context.MODE_PRIVATE);
        editor = userSession.edit();
    }

    public void createUserSession(String username, String email, String score, String userId){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_SCORE, score);
        editor.putString(KEY_USERID, userId);
        editor.commit();
    }

    public void getUserSession(String userId){
        fStore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fStore.collection(KEY_USERCOLLECTION).document(userId);

        Map<String, Object> userData = new HashMap<>();
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                userData.putAll(documentSnapshot.getData());
                String username = userData.get(KEY_USERNAME).toString();
                String email = userData.get(KEY_EMAIL).toString();
                String score = userData.get(KEY_SCORE).toString();

                editor.putBoolean(IS_LOGIN, true);
                editor.putString(KEY_USERNAME, username);
                editor.putString(KEY_EMAIL, email);
                editor.putString(KEY_SCORE, score);
                editor.putString(KEY_USERID, userId);
                editor.commit();
            }
        });


    }

    public void edit(String key, String newValue){
        switch (key) {
            case KEY_USERNAME:
                editor.remove(KEY_USERNAME);
                editor.putString(KEY_USERNAME, newValue);
                break;
            case KEY_EMAIL:
                editor.remove(KEY_EMAIL);
                editor.putString(KEY_EMAIL, newValue);
                break;
            case KEY_USERID:
                editor.remove(KEY_USERID);
                editor.putString(KEY_USERID, newValue);
                break;
            case KEY_SCORE:
                editor.remove(KEY_SCORE);
                editor.putString(KEY_SCORE, newValue);
                break;
            default:
                break;
        }
        editor.commit();
    }

    public void update(){
        fStore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fStore.collection(KEY_USERCOLLECTION).document(userSession.getString(KEY_USERID, null));
        documentReference.set(getUserData()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context, "Progress Updated: SCORE -> " + userSession.getString(KEY_SCORE, null), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public String getField(String key){
        switch (key) {
            case KEY_USERNAME:
                return userSession.getString(KEY_USERNAME, null);
            case KEY_EMAIL:
                return userSession.getString(KEY_EMAIL, null);
            case KEY_USERID:
                return userSession.getString(KEY_USERID, null);
            case KEY_SCORE:
                return userSession.getString(KEY_SCORE, null);
            default:
                break;
        }
        return null;
    }


    public HashMap<String, String> getUserData(){
        HashMap<String, String> userData = new HashMap<>();
        userData.put(KEY_USERNAME, userSession.getString(KEY_USERNAME, null));
        userData.put(KEY_EMAIL, userSession.getString(KEY_EMAIL, null));
        userData.put(KEY_SCORE, userSession.getString(KEY_SCORE, null));
        userData.put(KEY_USERID, userSession.getString(KEY_USERID, null));

        return userData;
    }

    public boolean isLogged(){
        if(userSession.getBoolean(IS_LOGIN, false))
            return true;
        return false;
    }
}
