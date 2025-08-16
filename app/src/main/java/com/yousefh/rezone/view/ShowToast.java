package com.yousefh.rezone.view;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.yousefh.rezone.R;

public class ShowToast {

    private static void showCustomToast(Context context, String message, int bgColorId) {
        // نفخ layout مخصص للتوست
        View toastView = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);

        TextView textView = toastView.findViewById(R.id.toast_text);
        textView.setText(message);
        textView.setBackgroundColor(ContextCompat.getColor(context, bgColorId));

        // عمل التوست
        Toast toast = new Toast(context);
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);

        // وضعه في منتصف الشاشة بالأعلى
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 200);
        toast.show();
    }

    public static void success(Context context, String message) {
        showCustomToast(context, message, R.color.toastSuccess);
    }

    public static void error(Context context, String message) {
        showCustomToast(context, message, R.color.toastError);
    }

    public static void warning(Context context, String message) {
        showCustomToast(context, message, R.color.toastWarning);
    }
}
