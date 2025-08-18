package com.yousefh.rezone.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;
import com.yousefh.rezone.R;
import com.yousefh.rezone.adapters.OnboardingAdapter;
import com.yousefh.rezone.databinding.ActivityOnboardingBinding;
import com.yousefh.rezone.models.OnboardingItem;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {
    private ActivityOnboardingBinding binding;
    private ViewPager2 viewPager;
    private Button btnNext;
    private TextView btnSkip;
    private OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize views
        viewPager = findViewById(R.id.viewPager);
        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);

        // Setup onboarding items
        List<OnboardingItem> onboardingItems = new ArrayList<>();
        onboardingItems.add(new OnboardingItem(
                R.drawable.onboarding_1,
                getString(R.string.onboarding_title_1),
                getString(R.string.onboarding_desc_1)
        ));
        onboardingItems.add(new OnboardingItem(
                R.drawable.onboarding_2,
                getString(R.string.onboarding_title_2),
                getString(R.string.onboarding_desc_2)
        ));
        onboardingItems.add(new OnboardingItem(
                R.drawable.onboarding_3,
                getString(R.string.onboarding_title_3),
                getString(R.string.onboarding_desc_3)
        ));

        // Setup adapter
        onboardingAdapter = new OnboardingAdapter(onboardingItems);
        viewPager.setAdapter(onboardingAdapter);

        // Setup dots indicator
        // TODO: You'll implement this in your XML with a custom view or use a library

        // Button listeners
        btnNext.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() < onboardingItems.size() - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            } else {
                startChooseRegisterActivity();
            }
        });

        btnSkip.setOnClickListener(v -> startChooseRegisterActivity());

        // Update button text when page changes
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == onboardingItems.size() - 1) {
                    btnNext.setText(R.string.get_started);
                } else {
                    btnNext.setText(R.string.next);
                }
            }
        });
    }

    private void startChooseRegisterActivity() {
        startActivity(new Intent(this, ChooseRegisterWayActivity.class));
        finish();
    }
}
