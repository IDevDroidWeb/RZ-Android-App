package com.yousefh.rezone.activities.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityChattingBinding;

public class ChattingActivity extends AppCompatActivity {
    private ActivityChattingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityChattingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
