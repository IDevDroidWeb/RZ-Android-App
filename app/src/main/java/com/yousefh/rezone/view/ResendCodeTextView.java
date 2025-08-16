package com.yousefh.rezone.view;

import android.content.Context;
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

public class ResendCodeTextView extends AppCompatTextView {

    public interface OnResendClickListener {
        void onResendClick();
    }

    private OnResendClickListener listener;

    public ResendCodeTextView(Context context) {
        super(context);
        init();
    }

    public ResendCodeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ResendCodeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        String text = "Didn’t receive the code? Resend code";
        SpannableString spannable = new SpannableString(text);

        int colorClickable = ContextCompat.getColor(getContext(), R.color.colorPrimary);
        int colorBackground = ContextCompat.getColor(getContext(), R.color.textPrimary);

        setTextColor(colorBackground);

        // تحديد كلمة Resend code
        String clickablePart = "Resend code";
        int start = text.indexOf(clickablePart);
        int end = start + clickablePart.length();

        // لون الكلمة القابلة للضغط
        spannable.setSpan(new ForegroundColorSpan(colorClickable), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // الضغط على الكلمة
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                if (listener != null) listener.onResendClick();
            }
        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        setText(spannable);
        setMovementMethod(LinkMovementMethod.getInstance());
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
    }

    public void setOnResendClickListener(OnResendClickListener listener) {
        this.listener = listener;
    }
}
