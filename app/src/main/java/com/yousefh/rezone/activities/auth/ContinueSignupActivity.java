package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.yousefh.rezone.R;
import com.yousefh.rezone.activities.webviews.PrivacyActivity;
import com.yousefh.rezone.activities.webviews.TermsActivity;
import com.yousefh.rezone.databinding.ActivityContinueSignupBinding;
import com.yousefh.rezone.utils.AcNav;
import com.yousefh.rezone.utils.Validator;
import com.yousefh.rezone.view.ClickableTextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ContinueSignupActivity extends AppCompatActivity {

    private ActivityContinueSignupBinding binding;
    ClickableTextView termsText, loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContinueSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        termsText = findViewById(R.id.termsText);
        loginText = findViewById(R.id.loginText);

        String phone = getIntent().getStringExtra("phone");
        binding.TFPhone.setText(phone);

        setupFormValidation();
        setupButtonListeners();
    }

    private void setupFormValidation() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateForm();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        Objects.requireNonNull(binding.TFName.getEditText()).addTextChangedListener(textWatcher);
        Objects.requireNonNull(binding.TFEmail.getEditText()).addTextChangedListener(textWatcher);
        Objects.requireNonNull(binding.TFPassword.getEditText()).addTextChangedListener(textWatcher);
        Objects.requireNonNull(binding.TFConfirmPassword.getEditText()).addTextChangedListener(textWatcher);
    }

    private void validateForm() {
        boolean isValid = Validator.isValidName(binding.TFName.getEditText().getText().toString()) &&
                Validator.isValidEmail(binding.TFEmail.getEditText().getText().toString()) &&
                Validator.isValidPassword(binding.TFPassword.getEditText().getText().toString()) &&
                binding.TFPassword.getEditText().getText().toString().equals(binding.TFConfirmPassword.getEditText().getText().toString()) &&
                binding.checkboxTerms.isChecked();

        binding.createAccountBtn.setEnabled(isValid);
    }

    private void setupButtonListeners() {
        binding.createAccountBtn.setOnClickListener(v -> createAccount());

        Map<String, View.OnClickListener> map1 = new HashMap<>();
        map1.put("Login", v -> {
            AcNav.openFinish(this, LoginPhoneActivity.class);
        });

        String fullText1 = "Already have an account? Login";
        loginText.setClickableParts(map1, fullText1, R.color.backgroundLight);

        Map<String, View.OnClickListener> map3 = new HashMap<>();
        map3.put("Terms & Conditions", v -> startActivity(new Intent(this, TermsActivity.class)));
        map3.put("Privacy Policy.", v -> startActivity(new Intent(this, PrivacyActivity.class)));

        String fullText3 = "Agree to Terms & Conditions and Privacy Policy.";
        termsText.setClickableParts(map3, fullText3, R.color.backgroundLight);
    }

    private void createAccount() {
        // TODO: Implement account creation API call
        showToast("Account created successfully");

        AcNav.openFinish(this, UploadProfileActivity.class);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}