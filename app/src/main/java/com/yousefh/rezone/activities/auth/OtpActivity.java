package com.yousefh.rezone.activities.auth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.yousefh.rezone.R;
import com.yousefh.rezone.databinding.ActivityOtpBinding;
import com.yousefh.rezone.view.ResendCodeTextView;
import com.yousefh.rezone.view.ShowToast;

import java.util.Objects;

public class OtpActivity extends AppCompatActivity {
    private ActivityOtpBinding binding;
    private CountDownTimer resendTimer;
    private static final long RESEND_DELAY = 60000; // 60 seconds

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String phone = getIntent().getStringExtra("phone");
        String purpose = getIntent().getStringExtra("purpose");

        binding.title.setText(getString(R.string.enter_otp_we_sent_to, phone));

        setupOtpInput();
        setupButtonListeners();
        startResendTimer();
    }

    private void setupOtpInput() {
        binding.pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 4) {
                    binding.submitBtn.setEnabled(true);
                    binding.submitBtn.setBackground(
                            ContextCompat.getDrawable(binding.submitBtn.getContext(), R.drawable.rounded_button
                            )
                    );
                    binding.submitBtn.setTextColor(getResources().getColor(R.color.white));
                } else {
                    binding.submitBtn.setEnabled(false);
                    binding.submitBtn.setBackground(
                            ContextCompat.getDrawable(binding.submitBtn.getContext(), R.drawable.rounded_disable_button
                            )
                    );
                    binding.submitBtn.setTextColor(getResources().getColor(R.color.textFieldIcon));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void setupButtonListeners() {
        binding.submitBtn.setOnClickListener(v -> verifyOtp());
        binding.resendText.setOnResendClickListener(() -> {
            // هنا تحط الكود لإعادة إرسال الكود
            Toast.makeText(getApplicationContext(), "Resend clicked", Toast.LENGTH_SHORT).show();
        });
        binding.resendText.setOnResendClickListener(() -> resendOtp());

    }

    private void verifyOtp() {
        String otp = Objects.requireNonNull(binding.pinView.getText()).toString();

        if (otp.length() != 6) {
            ShowToast.success(this, "Please enter a valid 6-digit code");
            return;
        }

        // TODO: Implement OTP verification
        ShowToast.success(this, "Verifying OTP: " + otp);

        if ("reset_password".equals(getIntent().getStringExtra("purpose"))) {
            startActivity(new Intent(this, ResetPasswordActivity.class));
        } else {
            // Handle other purposes (e.g., signup verification)
        }
    }

    private void resendOtp() {
        // TODO: Implement OTP resend logic
        ShowToast.success(this, "New verification code sent");
        startResendTimer();
    }

    private void startResendTimer() {
        binding.resendText.setEnabled(false);

        if (resendTimer != null) {
            resendTimer.cancel();
        }

        resendTimer = new CountDownTimer(RESEND_DELAY, 1000) {
            @SuppressLint("StringFormatInvalid")
            public void onTick(long millisUntilFinished) {
                binding.resendText.setText(getString(R.string.resend_in,
                        millisUntilFinished / 1000));
            }

            public void onFinish() {
                binding.resendText.setText(ResendCodeTextView.NO_ID);
                binding.resendText.setEnabled(true);
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (resendTimer != null) {
            resendTimer.cancel();
        }
    }
}
