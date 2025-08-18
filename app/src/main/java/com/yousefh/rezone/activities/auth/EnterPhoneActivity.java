package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.yousefh.rezone.R;
import com.yousefh.rezone.databinding.ActivityEnterPhoneBinding;
import com.yousefh.rezone.fragments.CountryPickerFragment;
import com.yousefh.rezone.interfaces.OnCountrySelectedListener;
import com.yousefh.rezone.models.Country;
import com.yousefh.rezone.utils.Constants;
import com.yousefh.rezone.utils.Validator;
import com.yousefh.rezone.view.ClickableTextView;
import com.yousefh.rezone.view.ShowToast;

import java.util.HashMap;
import java.util.Map;

public class EnterPhoneActivity extends AppCompatActivity {
    private ActivityEnterPhoneBinding binding;
    private Country selectedCountry = Constants.DEFAULT_COUNTRY;

    private ClickableTextView newUserText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityEnterPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        newUserText = findViewById(R.id.loginText);

        setupCountrySelector();
        setupPhoneValidation();
        setupButtonListeners();
        updateCountryDisplay();
    }

    private void setupCountrySelector() {
        binding.countryFlag.setOnClickListener(v -> {
            CountryPickerFragment fragment = new CountryPickerFragment();
            fragment.setCountrySelectedListener(country -> {
                selectedCountry = country;
                updateCountryDisplay();
            });
            fragment.show(getSupportFragmentManager(), "CountryPicker");
        });
    }

    private void updateCountryDisplay() {
        binding.countryCode.setText(String.format("+%s", selectedCountry.getDialCode()));
        binding.countryFlag.setImageResource(selectedCountry.getFlagResId());
    }

    private void setupPhoneValidation() {
        binding.TFPhone.addTextChangedListener(new TextWatcher() {
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
        String phone = binding.TFPhone.getText().toString();
        boolean isValid = Validator.isValidPhone(phone);
        binding.createAccountBtn.setEnabled(isValid);
    }

    private void setupButtonListeners() {
        binding.createAccountBtn.setOnClickListener(v -> sendVerificationCode());
        Map<String, View.OnClickListener> map = new HashMap<>();
        map.put("Login", v -> startActivity(new Intent(this, LoginPhoneActivity.class)));

        String fullText = "Already have an account? Login";
        newUserText.setClickableParts(map, fullText, R.color.textPrimary);
    }

    private void sendVerificationCode() {
        String phone = selectedCountry.getCode() + binding.TFPhone.getText().toString();

        // TODO: Implement actual OTP sending via WhatsApp API
        ShowToast.success(this, "Verification code sent to: " + phone);

        startActivity(new Intent(this, OtpActivity.class)
                .putExtra("phone", phone)
                .putExtra("purpose", "signup"));
    }
}