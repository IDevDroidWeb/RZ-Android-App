package com.yousefh.rezone.activities.auth;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityChooseRegisterBinding;

public class ChooseRegisterWayActivity extends AppCompatActivity {
    private ActivityChooseRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityChooseRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
