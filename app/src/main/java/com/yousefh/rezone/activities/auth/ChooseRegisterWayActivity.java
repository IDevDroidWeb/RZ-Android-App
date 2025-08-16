package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.activities.main.MainActivity;
import com.yousefh.rezone.activities.webviews.PrivacyActivity;
import com.yousefh.rezone.activities.webviews.TermsActivity;
import com.yousefh.rezone.databinding.ActivityChooseRegisterBinding;
import com.yousefh.rezone.view.TermsPrivacyTextView;

public class ChooseRegisterWayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        com.yousefh.rezone.databinding.ActivityChooseRegisterBinding binding = ActivityChooseRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Button click listeners
        binding.btnPhone.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginPhoneActivity.class);
            intent.putExtra("is_signup", false);
            startActivity(intent);
        });

        binding.btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginEmailActivity.class);
            intent.putExtra("is_signup", false);
            startActivity(intent);
        });

        binding.btnGuest.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        binding.signupText.setOnClickListener(v -> {
            Intent intent = new Intent(this, EnterPhoneActivity.class);
            intent.putExtra("is_signup", true);
            startActivity(intent);
        });

        binding.termsAndPrivacy.setOnLinkClickListener(new TermsPrivacyTextView.OnLinkClickListener() {
            @Override
            public void onTermsClick() {
                startActivity(new Intent(getApplicationContext(), TermsActivity.class));
            }

            @Override
            public void onPrivacyClick() {
                startActivity(new Intent(getApplicationContext(), PrivacyActivity.class));
            }
        });
    }
}

