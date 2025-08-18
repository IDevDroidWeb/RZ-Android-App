package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.activities.main.MainActivity;
import com.yousefh.rezone.databinding.ActivityUploadProfileBinding;
import com.yousefh.rezone.utils.AcNav;
import com.yousefh.rezone.utils.ImageUtils;
import com.yousefh.rezone.view.ShowToast;

public class UploadProfileActivity extends AppCompatActivity {
    private ActivityUploadProfileBinding binding;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityUploadProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupImagePicker();
        setupButtonListeners();
    }

    private void setupImagePicker() {
        binding.profileImage.setOnClickListener(v -> {
            // Launch image picker
            ImageUtils.showImagePicker(this);
        });
    }

    private void setupButtonListeners() {
        binding.uploadBtn.setOnClickListener(v -> {
            if (selectedImageUri != null) {
                uploadProfile();
            } else {
                Toast.makeText(this, "Please select a profile picture", Toast.LENGTH_SHORT).show();
            }
        });

        binding.skipBtn.setOnClickListener(v -> proceedToMainScreen());
    }

    private void uploadProfile() {
        // TODO: Implement profile picture upload
        ShowToast.success(this, "Profile picture uploaded");
        proceedToMainScreen();
    }

    private void proceedToMainScreen() {
        AcNav.openClearAll(this, MainActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ImageUtils.isImagePickerResult(requestCode, resultCode, data)) {
            selectedImageUri = data.getData();
            binding.profileImage.setImageURI(selectedImageUri);
        }
    }

}
