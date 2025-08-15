package com.yousefh.rezone.activities.auth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivitySplashBinding;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        com.yousefh.rezone.databinding.ActivitySplashBinding binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, OnboardingActivity.class));
            finish();
        }, SPLASH_DURATION);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Remove callbacks to prevent memory leaks
        getWindow().getDecorView().getHandler().removeCallbacksAndMessages(null);
    }
}
