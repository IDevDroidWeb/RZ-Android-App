package com.yousefh.rezone.interfaces;

import com.yousefh.rezone.models.Country;

@FunctionalInterface
public interface OnCountrySelectedListener {
    void onCountrySelected(Country country);
}