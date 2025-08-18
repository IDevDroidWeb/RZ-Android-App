package com.yousefh.rezone.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.yousefh.rezone.R;

public class LocationUtils {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private static final long LOCATION_UPDATE_INTERVAL = 10000; // 10 seconds
    private static final long FASTEST_LOCATION_UPDATE_INTERVAL = 5000; // 5 seconds

    public interface LocationCallbackListener {
        void onLocationReceived(Location location);
    }

    public static boolean checkLocationPermission(Context context) {
        return ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(context,
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestLocationPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity,
                new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                },
                LOCATION_PERMISSION_REQUEST_CODE);
    }

    public static void requestLocationUpdates(Context context, LocationCallbackListener listener) {
        if (!checkLocationPermission(context)) {
            return;
        }

        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, LOCATION_UPDATE_INTERVAL)
                .setWaitForAccurateLocation(false)
                .setMinUpdateIntervalMillis(FASTEST_LOCATION_UPDATE_INTERVAL)
                .build();

        LocationCallback locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        listener.onLocationReceived(location);
                    }
                }
            }
        };

        fusedLocationClient.requestLocationUpdates(locationRequest,
                locationCallback,
                null);
    }

    public static void removeLocationUpdates(Context context, LocationCallback locationCallback) {
        if (locationCallback != null) {
            LocationServices.getFusedLocationProviderClient(context)
                    .removeLocationUpdates(locationCallback);
        }
    }

    @SuppressLint("StringFormatInvalid")
    public static String formatLocationAddress(Context context, double latitude, double longitude) {
        // TODO: Implement reverse geocoding to get address
        // For now return coordinates
        return context.getString(R.string.location_coordinates_format, latitude, longitude);
    }

    public static float calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        float[] results = new float[1];
        Location.distanceBetween(lat1, lon1, lat2, lon2, results);
        return results[0]; // distance in meters
    }
}