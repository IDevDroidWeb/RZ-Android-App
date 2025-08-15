package com.yousefh.rezone.activities.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityUploadAdBinding;

public class UploadAdActivity extends AppCompatActivity {
    private ActivityUploadAdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityUploadAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
