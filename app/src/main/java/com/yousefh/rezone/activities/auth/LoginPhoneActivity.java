package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.yousefh.rezone.R;
import com.yousefh.rezone.databinding.ActivityLoginPhoneBinding;
import com.yousefh.rezone.utils.Validator;
import com.yousefh.rezone.view.ShowToast;

import java.util.Objects;

public class LoginPhoneActivity extends AppCompatActivity {
    private ActivityLoginPhoneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginPhoneBinding.inflate(getLayoutInflater());
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

        Objects.requireNonNull(binding.TFPhone.getEditText()).addTextChangedListener(textWatcher);
        Objects.requireNonNull(binding.TFPassword.getEditText()).addTextChangedListener(textWatcher);
    }

    private void validateForm() {
        boolean isValid = Validator.isValidPhone(Objects.requireNonNull(binding.TFPhone.getEditText()).getText().toString()) &&
                Validator.isValidPassword(Objects.requireNonNull(binding.TFPassword.getEditText()).getText().toString());

        binding.loginBtn.setEnabled(isValid);
        binding.loginBtn.setBackground(
                ContextCompat.getDrawable(
                        binding.loginBtn.getContext(),
                        isValid ? R.drawable.rounded_button : R.drawable.bg_disabled_button
                )
        );
        binding.loginBtn.setTextColor(getResources().getColor(
                isValid ? R.color.white : R.color.textFieldIcon));

    }

    private void setupButtonListeners() {
        binding.loginBtn.setOnClickListener(v -> attemptLogin());
        binding.forgetPasswordTxt.setOnClickListener(v -> startActivity(new Intent(this, ForgotPasswordActivity.class)));

        binding.signupText.setOnSignupClickListener(() ->
                startActivity(new Intent(LoginPhoneActivity.this, EnterPhoneActivity.class)
                        .putExtra("is_signup", true)));
    }

    private void attemptLogin() {
        String phone = Objects.requireNonNull(binding.TFPhone.getEditText()).getText().toString();
        String password = Objects.requireNonNull(binding.TFPassword.getEditText()).getText().toString();

        // TODO: Implement actual login logic with API call
        ShowToast.success(this, "Login attempt with phone: " + phone);
    }
}
