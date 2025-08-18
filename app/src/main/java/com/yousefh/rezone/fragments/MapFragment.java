package com.yousefh.rezone.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.yousefh.rezone.R;
import com.yousefh.rezone.databinding.FragmentMapBinding;
import com.yousefh.rezone.utils.MapboxManager;

public class MapFragment extends Fragment {

    private FragmentMapBinding binding;
    private MapView mapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = binding.mapView;

        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS, style -> {
            // Style loaded, setup map
            MapboxManager.setupMap(mapView, requireContext());

            // TODO: Add property markers
            // MapboxManager.addPropertyMarkers(mapView, properties);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }
}