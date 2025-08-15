package com.yousefh.rezone.activities.auth;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityUploadProfileBinding;

public class UploadProfileActivity extends AppCompatActivity {
    private ActivityUploadProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityUploadProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
