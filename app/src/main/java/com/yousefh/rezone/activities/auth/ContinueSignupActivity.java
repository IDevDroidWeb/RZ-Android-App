package com.yousefh.rezone.activities.auth;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityContinueSignupBinding;

public class ContinueSignupActivity extends AppCompatActivity {
    private ActivityContinueSignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityContinueSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
