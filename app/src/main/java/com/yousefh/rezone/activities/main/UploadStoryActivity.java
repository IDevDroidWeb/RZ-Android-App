package com.yousefh.rezone.activities.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityUploadStoryBinding;

public class UploadStoryActivity extends AppCompatActivity {
    private ActivityUploadStoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityUploadStoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
