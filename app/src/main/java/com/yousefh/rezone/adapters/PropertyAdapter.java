package com.yousefh.rezone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.yousefh.rezone.R;
import com.yousefh.rezone.interfaces.OnPropertyClickListener;
import com.yousefh.rezone.models.Property;
import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private List<Property> properties;
    private final OnPropertyClickListener listener;

    public PropertyAdapter(List<Property> properties, OnPropertyClickListener listener) {
        this.properties = properties;
        this.listener = listener;
    }

    public void updateProperties(List<Property> newProperties) {
        this.properties = newProperties;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_property, parent, false);
        return new PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {
        Property property = properties.get(position);
        holder.bind(property, listener);
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }

    static class PropertyViewHolder extends RecyclerView.ViewHolder {
        private final ImageSlider propertyImages;
        private final ImageButton favoriteBtn;
        private final TextView propertyTitle;
        private final TextView propertyLocation;
        private final TextView propertyPrice, propertyPriceCurrency;

        public PropertyViewHolder(@NonNull View itemView) {
            super(itemView);
            propertyImages = itemView.findViewById(R.id.imageSlider);
            favoriteBtn = itemView.findViewById(R.id.favoriteBtn);
            propertyTitle = itemView.findViewById(R.id.propertyTitle);
            propertyLocation = itemView.findViewById(R.id.propertyLocation);
            propertyPrice = itemView.findViewById(R.id.propertyPrice);
            propertyPriceCurrency = itemView.findViewById(R.id.propertyPriceCurrency);
        }

        public void bind(Property property, OnPropertyClickListener listener) {
            // TODO: Load image with Glide
            propertyTitle.setText(property.getTitle());
            propertyLocation.setText(property.getLocation());
            propertyPrice.setText(property.getFormattedPrice());

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onPropertyClick(property);
                }
            });
        }
    }
}