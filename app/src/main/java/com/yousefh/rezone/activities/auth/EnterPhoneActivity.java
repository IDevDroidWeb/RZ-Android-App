package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.databinding.ActivityEnterPhoneBinding;
import com.yousefh.rezone.fragments.CountryPickerFragment;
import com.yousefh.rezone.models.Country;
import com.yousefh.rezone.utils.Constants;
import com.yousefh.rezone.utils.Validator;
import com.yousefh.rezone.view.ShowToast;

public class EnterPhoneActivity extends AppCompatActivity {
    private ActivityEnterPhoneBinding binding;
    private Country selectedCountry = Constants.DEFAULT_COUNTRY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityEnterPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupCountrySelector();
        setupPhoneValidation();
        setupButtonListeners();
        updateCountryDisplay();
    }

    private void setupCountrySelector() {
        binding.countrySelector.setOnClickListener(v -> {
            // Launch country picker fragment
            CountryPickerFragment fragment = new CountryPickerFragment();
            fragment.setCountrySelectedListener(country -> {
                selectedCountry = country;
                updateCountryDisplay();
            });
            fragment.show(getSupportFragmentManager(), "CountryPicker");
        });
    }

    private void updateCountryDisplay() {
        binding.countryCode.setText(String.format("+%s", selectedCountry.getCode()));
        binding.countryFlag.setImageResource(selectedCountry.getFlagResId());
    }

    private void setupPhoneValidation() {
        binding.etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validatePhone();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void validatePhone() {
        String phone = binding.etPhone.getText().toString();
        boolean isValid = Validator.isValidPhone(phone);
        binding.btnCreateAccount.setEnabled(isValid);
    }

    private void setupButtonListeners() {
        binding.btnCreateAccount.setOnClickListener(v -> sendVerificationCode());
        binding.btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginPhoneActivity.class));
            finish();
        });
    }

    private void sendVerificationCode() {
        String phone = selectedCountry.getCode() + binding.etPhone.getText().toString();

        // TODO: Implement actual OTP sending via WhatsApp API
        ShowToast.success(this, "Verification code sent to: " + phone);

        startActivity(new Intent(this, VerificationCodeActivity.class)
                .putExtra("phone", phone)
                .putExtra("purpose", "signup"));
    }
}