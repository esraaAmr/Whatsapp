package com.example.whatsapp2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.whatsapp2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreenActivity extends AppCompatActivity {
    Handler handler = new Handler();
    public static final long TIME = 3000;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        signInAnnonamously();
        setContentView(R.layout.activity_splash_screen);
    }
    private void signInAnnonamously() {
        firebaseAuth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    handler.postDelayed(runnable,TIME);
                    Toast.makeText(SplashScreenActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SplashScreenActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private final Runnable runnable = () -> {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    };
}