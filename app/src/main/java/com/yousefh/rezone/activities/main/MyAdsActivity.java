package com.yousefh.rezone.activities.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityMyAdsBinding;

public class MyAdsActivity extends AppCompatActivity {
    private ActivityMyAdsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMyAdsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
