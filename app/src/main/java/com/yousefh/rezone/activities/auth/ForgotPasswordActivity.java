package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.yousefh.rezone.R;
import com.yousefh.rezone.databinding.ActivityForgotPasswordBinding;
import com.yousefh.rezone.utils.Validator;
import com.yousefh.rezone.view.ShowToast;

import java.util.Objects;

public class ForgotPasswordActivity extends AppCompatActivity {
    private ActivityForgotPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupFormValidation();
        setupButtonListeners();
    }

    private void setupFormValidation() {
        Objects.requireNonNull(binding.TFPhone.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateForm();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void validateForm() {
        boolean isValid = Validator.isValidPhone(Objects.requireNonNull(binding.TFPhone.getEditText()).getText().toString());
        binding.sendCodeBtn.setEnabled(isValid);
        binding.sendCodeBtn.setBackground(
                ContextCompat.getDrawable(
                        binding.sendCodeBtn.getContext(),
                        isValid ? R.drawable.rounded_button : R.drawable.bg_disabled_button
                )
        );
        binding.sendCodeBtn.setTextColor(getResources().getColor(
                isValid ? R.color.white : R.color.textFieldIcon));
    }

    private void setupButtonListeners() {
        binding.sendCodeBtn.setOnClickListener(v -> sendVerificationCode());
    }

    private void sendVerificationCode() {
        String phone = Objects.requireNonNull(binding.TFPhone.getEditText()).getText().toString();

        // TODO: Implement actual OTP sending logic
        ShowToast.success(this, "Verification code sent to: " + phone);

        // Proceed to OTP screen
        startActivity(new Intent(this, OtpActivity.class)
                .putExtra("phone", phone)
                .putExtra("purpose", "reset_password"));
    }

}
