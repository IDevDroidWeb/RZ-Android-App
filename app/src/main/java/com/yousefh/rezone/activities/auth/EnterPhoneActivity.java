package com.yousefh.rezone.activities.auth;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityEnterPhoneBinding;

public class EnterPhoneActivity extends AppCompatActivity {
    private ActivityEnterPhoneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityEnterPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
