package com.yousefh.rezone.activities.main;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.location.LocationCallback;
import com.yousefh.rezone.fragments.ListFragment;
import com.yousefh.rezone.R;
import com.yousefh.rezone.databinding.ActivityMainBinding;
import com.yousefh.rezone.fragments.MapFragment;
import com.yousefh.rezone.utils.LocationUtils;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isMapView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        searchView();
        setupLocation();
        setupBottomNavigation();
        setupHeaderActions();
        loadInitialFragment();
    }

    private void searchView() {
        EditText searchEditText = binding.searchBar.findViewById(androidx.appcompat.R.id.search_src_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            searchEditText.setTextCursorDrawable(R.drawable.cursor_color);
        } else {
            try {
                @SuppressLint("DiscouragedPrivateApi") Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
                f.setAccessible(true);
                f.set(searchEditText, R.drawable.cursor_color);
            } catch (Exception ignored) {
            }

        }
        searchEditText.setTextColor(getColor(R.color.textPrimary));
        searchEditText.setHintTextColor(getColor(R.color.textFieldIcon));
    }

    private void setupLocation() {
        if (LocationUtils.checkLocationPermission(this)) {
            LocationUtils.requestLocationUpdates(this, location -> {
                // Update map/list with nearby properties
                // TODO: Fetch properties based on location
            });
        } else {
            LocationUtils.requestLocationPermission(this);
        }
    }

    private void loadInitialFragment() {
        loadFragment(new MapFragment());
    }

    private void setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                toggleViewMode();
                return true;
            } else if (itemId == R.id.nav_chat) {
                // TODO: Implement chat navigation
                return true;
            } else if (itemId == R.id.nav_upload) {
                // TODO: Implement upload navigation
                return true;
            } else if (itemId == R.id.nav_ads) {
                // TODO: Implement my ads navigation
                return true;
            } else if (itemId == R.id.nav_profile) {
                // TODO: Implement profile navigation
                return true;
            }
            return false;
        });
    }

    private void setupHeaderActions() {
        binding.btnToggleView.setOnClickListener(v -> toggleViewMode());
        binding.btnNotification.setOnClickListener(v -> {
            // TODO: Open notifications
        });
        binding.searchBar.setOnClickListener(v -> {
            // TODO: Open search
        });
    }

    private void toggleViewMode() {
        isMapView = !isMapView;
        binding.btnToggleView.setImageResource(
                isMapView ? R.drawable.ic_list : R.drawable.ic_map);

        Fragment fragment = isMapView ? new MapFragment() : new ListFragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocationUtils.requestLocationUpdates(this, location -> {
            // TODO: Update UI with new location
            // updateMapOrListWithLocation(location);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocationUtils.removeLocationUpdates(this, locationCallback);
    }
}
