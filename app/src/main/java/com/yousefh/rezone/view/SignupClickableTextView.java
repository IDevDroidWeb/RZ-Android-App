package com.yousefh.rezone.view;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.yousefh.rezone.R;

public class SignupClickableTextView extends AppCompatTextView {

    public interface OnSignupClickListener {
        void onSignupClick();
    }

    private OnSignupClickListener listener;

    public SignupClickableTextView(Context context) {
        super(context);
        init();
    }

    public SignupClickableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SignupClickableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        String text = "Don’t have an account? Signup";
        SpannableString spannable = new SpannableString(text);

        int colorClickable = ContextCompat.getColor(getContext(), R.color.colorPrimary);
        int colorBackground = ContextCompat.getColor(getContext(), R.color.backgroundLight);

        setTextColor(colorBackground);

        // تحديد كلمة Signup
        String signup = "Signup";
        int start = text.indexOf(signup);
        int end = start + signup.length();

        // لون الكلمة القابلة للضغط
        spannable.setSpan(new ForegroundColorSpan(colorClickable), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // الضغط على الكلمة
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                if (listener != null) listener.onSignupClick();
            }
        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        setText(spannable);
        setMovementMethod(LinkMovementMethod.getInstance());
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
    }

    public void setOnSignupClickListener(OnSignupClickListener listener) {
        this.listener = listener;
    }
}
