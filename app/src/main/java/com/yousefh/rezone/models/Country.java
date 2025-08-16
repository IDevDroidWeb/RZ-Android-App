package com.yousefh.rezone.models;

import androidx.annotation.DrawableRes;

public class Country {

    private String code;        // رمز الدولة، مثال "US"
    private String name;        // اسم الدولة، مثال "United States"
    private int dialCode;       // كود الاتصال الدولي، مثال 1
    @DrawableRes
    private int flagResId;      // معرف الصورة (drawable) للعلم

    public Country(String code, String name, int dialCode, @DrawableRes int flagResId) {
        this.code = code;
        this.name = name;
        this.dialCode = dialCode;
        this.flagResId = flagResId;
    }

    // getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getDialCode() {
        return dialCode;
    }

    public int getFlagResId() {
        return flagResId;
    }

    // setters (اختياري)
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDialCode(int dialCode) {
        this.dialCode = dialCode;
    }

    public void setFlagResId(int flagResId) {
        this.flagResId = flagResId;
    }
}
