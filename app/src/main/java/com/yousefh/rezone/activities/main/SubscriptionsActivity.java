package com.yousefh.rezone.activities.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivitySubscriptionsBinding;

public class SubscriptionsActivity extends AppCompatActivity {
    private ActivitySubscriptionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySubscriptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
