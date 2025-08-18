package com.yousefh.rezone.utils;

import android.util.Patterns;

public class Validator {

    // تحقق من الإيميل
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        return Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }

    // تحقق من رقم الهاتف (يدعم عدة دول عربية)
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) return false;

        // امسح أي رموز أو مسافات
        String digits = phone.replaceAll("[^0-9]", "");

        // مصر
        if (digits.matches("^01[0-9]{9}$")) return true;

        // السعودية
        if (digits.matches("^05[0-9]{8}$")) return true;

        // الكويت
        if (digits.matches("^[569][0-9]{7}$")) return true;

        // الإمارات
        if (digits.matches("^05[0-9]{8}$")) return true;

        // لبنان
        if (digits.matches("^(03[0-9]{6}|7[0-9]{7})$")) return true;

        // البحرين
        if (digits.matches("^[367][0-9]{7}$")) return true;

        // الأردن
        if (digits.matches("^07[0-9]{8}$")) return true;

        // عُمان
        if (digits.matches("^9[0-9]{7}$")) return true;

        return false;
    }

    // تحقق من الباسورد
    public static boolean isValidPassword(String password) {
        if (password == null || password.trim().isEmpty()) return false;
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    // تحقق من الاسم
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        return name.matches("^[\\p{L} ]{2,50}$");
    }
}
