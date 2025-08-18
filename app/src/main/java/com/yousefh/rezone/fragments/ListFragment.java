package com.yousefh.rezone.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.yousefh.rezone.R;
import com.yousefh.rezone.activities.main.PropertyDetailsActivity;
import com.yousefh.rezone.adapters.PropertyAdapter;
import com.yousefh.rezone.databinding.FragmentListBinding;
import com.yousefh.rezone.models.Property;
import com.yousefh.rezone.utils.AcNav;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private PropertyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupRecyclerView();
        loadProperties();
    }

    private void setupRecyclerView() {
        adapter = new PropertyAdapter(new ArrayList<>(), property -> {
            // TODO: Open property details
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    private void loadProperties() {
        // TODO: Replace with actual data from ViewModel
        List<Property> dummyProperties = createDummyProperties();
        adapter.updateProperties(dummyProperties);
    }

    private List<Property> createDummyProperties() {
        List<Property> properties = new ArrayList<>();
        // Add dummy properties
        return properties;
    }
}