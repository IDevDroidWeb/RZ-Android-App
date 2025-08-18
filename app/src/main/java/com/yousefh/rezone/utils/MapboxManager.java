package com.yousefh.rezone.utils;

import android.content.Context;
import com.mapbox.maps.MapView;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.yousefh.rezone.models.Property;

import java.util.List;

public class MapboxManager {

    private static MapboxManager instance;
    private PointAnnotationManager pointAnnotationManager;

    private MapboxManager() {}

    public static synchronized MapboxManager getInstance() {
        if (instance == null) {
            instance = new MapboxManager();
        }
        return instance;
    }

    public static void setupMap(MapView mapView, Context context) {
        // Initialize map settings
        // TODO: Configure map style, camera position, gestures, etc.

        // Initialize annotation manager
        // pointAnnotationManager = new PointAnnotationManager(mapView, mapView.getMapboxMap());
    }

    public void addPropertyMarkers(List<Property> properties) {
        // TODO: Implement marker addition logic
        // for (Property property : properties) {
        //     PointAnnotationOptions options = new PointAnnotationOptions()
        //         .withPoint(Point.fromLngLat(property.getLongitude(), property.getLatitude()))
        //         .withIconImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.property_marker));
        //     pointAnnotationManager.create(options);
        // }
    }

    public void clearMarkers() {
        if (pointAnnotationManager != null) {
            pointAnnotationManager.deleteAll();
        }
    }
}