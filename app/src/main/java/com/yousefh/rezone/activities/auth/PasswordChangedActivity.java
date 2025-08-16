package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityPasswordChangedBinding;

public class PasswordChangedActivity extends AppCompatActivity {
    private ActivityPasswordChangedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityPasswordChangedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginPhoneActivity.class));
            finishAffinity(); // Clear all previous activities
        });

    }
}
