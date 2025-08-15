package com.yousefh.rezone.activities.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.yousefh.rezone.databinding.ActivityEditAdBinding;


public class EditAdActivity extends AppCompatActivity {
    private ActivityEditAdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityEditAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
