package com.yousefh.rezone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yousefh.rezone.R;
import com.yousefh.rezone.interfaces.OnCountrySelectedListener;
import com.yousefh.rezone.models.Country;
import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countries;
    private List<Country> filteredCountries;
    private final OnCountrySelectedListener listener;

    public CountryAdapter(List<Country> countries, OnCountrySelectedListener listener) {
        this.countries = new ArrayList<>(countries);
        this.filteredCountries = new ArrayList<>(countries);
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = filteredCountries.get(position);
        holder.bind(country, listener);
    }

    @Override
    public int getItemCount() {
        return filteredCountries.size();
    }

    public void filter(String query) {
        filteredCountries.clear();
        if (query.isEmpty()) {
            filteredCountries.addAll(countries);
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (Country country : countries) {
                if (country.getName().toLowerCase().contains(lowerCaseQuery) ||
                        String.valueOf(country.getCode()).contains(query)) {
                    filteredCountries.add(country);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView flag;
        private final TextView name;
        private final TextView code;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.countryFlag);
            name = itemView.findViewById(R.id.countryName);
            code = itemView.findViewById(R.id.countryCode);
        }

        public void bind(Country country, OnCountrySelectedListener listener) {
            flag.setImageResource(country.getFlagResId());
            name.setText(country.getName());
            code.setText(String.format("+%s", country.getCode()));

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onCountrySelected(country);
                }
            });
        }
    }
}