package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.yousefh.rezone.R;
import com.yousefh.rezone.databinding.ActivityResetPasswordBinding;
import com.yousefh.rezone.utils.Validator;
import com.yousefh.rezone.view.ShowToast;

import java.util.Objects;

public class ResetPasswordActivity extends AppCompatActivity {
    private ActivityResetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupFormValidation();
        setupButtonListeners();
    }

    private void setupFormValidation() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateForm();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        Objects.requireNonNull(binding.TFPassword.getEditText()).addTextChangedListener(textWatcher);
        Objects.requireNonNull(binding.TFConfirmPassword.getEditText()).addTextChangedListener(textWatcher);
    }

    private void validateForm() {
        String password = Objects.requireNonNull(binding.TFPassword.getEditText()).getText().toString();
        String confirmPassword = Objects.requireNonNull(binding.TFConfirmPassword.getEditText()).getText().toString();

        boolean isValid = Validator.isValidPassword(password) &&
                password.equals(confirmPassword);

        binding.submitBtn.setEnabled(isValid);
        binding.submitBtn.setBackground(
                ContextCompat.getDrawable(
                        binding.submitBtn.getContext(),
                        isValid ? R.drawable.rounded_button : R.drawable.bg_disabled_button
                )
        );
        binding.submitBtn.setTextColor(getResources().getColor(
                isValid ? R.color.white : R.color.textFieldIcon));
    }

    private void setupButtonListeners() {
        binding.submitBtn.setOnClickListener(v -> resetPassword());
    }

    private void resetPassword() {
        String password = Objects.requireNonNull(binding.TFPassword.getEditText()).getText().toString();

        // TODO: Implement password reset API call
        ShowToast.success(this, "Password reset successful");

        startActivity(new Intent(this, PasswordChangedActivity.class));
        finish();
    }
}