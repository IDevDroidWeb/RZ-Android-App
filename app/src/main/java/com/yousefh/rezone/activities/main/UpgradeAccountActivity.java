package com.yousefh.rezone.activities.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityUpgradeAccountBinding;

public class UpgradeAccountActivity extends AppCompatActivity {
    private ActivityUpgradeAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityUpgradeAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
