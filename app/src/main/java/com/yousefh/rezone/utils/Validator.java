package com.yousefh.rezone.utils;

public class Validator {

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()) return false;
        // Remove all non-digit characters
        String digits = phone.replaceAll("[^0-9]", "");
        // Validate based on your requirements (e.g., 10 digits for US numbers)
        return digits.length() >= 10;
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) return false;
        // Minimum 6 characters
        return password.length() >= 6;
    }
}