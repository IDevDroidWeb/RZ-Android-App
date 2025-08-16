package com.yousefh.rezone.utils;

import com.yousefh.rezone.R;
import com.yousefh.rezone.models.Country;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final Country DEFAULT_COUNTRY = new Country("US", "United States", 1, R.drawable.flag_eg);

    public static final List<Country> COUNTRIES = Arrays.asList(
            new Country("US", "United States", 1, R.drawable.flag_eg),
            new Country("GB", "United Kingdom", 44, R.drawable.flag_eg),
            new Country("SA", "Saudi Arabia", 966, R.drawable.flag_eg),
            new Country("EG", "Egypt", 20, R.drawable.flag_eg),
            new Country("AE", "United Arab Emirates", 971, R.drawable.flag_eg)
            // Add more countries as needed
    );
}