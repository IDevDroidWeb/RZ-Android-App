package com.yousefh.rezone.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.yousefh.rezone.adapters.CountryAdapter;
import com.yousefh.rezone.databinding.FragmentCountryPickerBinding;
import com.yousefh.rezone.interfaces.OnCountrySelectedListener;
import com.yousefh.rezone.models.Country;
import com.yousefh.rezone.utils.Constants;
import java.util.ArrayList;
import java.util.List;

public class CountryPickerFragment extends DialogFragment {

    private FragmentCountryPickerBinding binding;
    private OnCountrySelectedListener listener;
    private CountryAdapter adapter;

    public void setCountrySelectedListener(OnCountrySelectedListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCountryPickerBinding.inflate(inflater, container, false);
        setupRecyclerView();
        setupSearch();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        List<Country> countries = new ArrayList<>(Constants.COUNTRIES);
        adapter = new CountryAdapter(countries, country -> {
            if (listener != null) {
                listener.onCountrySelected(country);
            }
            dismiss();
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    private void setupSearch() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}