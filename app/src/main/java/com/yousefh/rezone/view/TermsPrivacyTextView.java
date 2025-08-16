package com.yousefh.rezone.utils;

import android.content.Context;
import android.graphics.Color;
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


public class TermsPrivacyTextView extends AppCompatTextView {

    public interface OnLinkClickListener {
        void onTermsClick();
        void onPrivacyClick();
    }

    private OnLinkClickListener listener;

    public TermsPrivacyTextView(Context context) {
        super(context);
        init();
    }

    public TermsPrivacyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TermsPrivacyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        String text = "By signing up, you agree to our Terms of Use and Privacy Policy.";

        // Spannable
        SpannableString spannable = new SpannableString(text);

        int colorClickable = ContextCompat.getColor(getContext(), R.color.colorPrimary);
        int colorBackground = ContextCompat.getColor(getContext(), R.color.backgroundLight);

        setTextColor(colorBackground);

        String terms = "Terms of Use";
        String privacy = "Privacy Policy";

        int startTerms = text.indexOf(terms);
        int endTerms = startTerms + terms.length();

        int startPrivacy = text.indexOf(privacy);
        int endPrivacy = startPrivacy + privacy.length();

        // Terms of Use
        spannable.setSpan(new ForegroundColorSpan(colorClickable), startTerms, endTerms, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                if (listener != null) listener.onTermsClick();
            }
        }, startTerms, endTerms, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Privacy Policy
        spannable.setSpan(new ForegroundColorSpan(colorClickable), startPrivacy, endPrivacy, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                if (listener != null) listener.onPrivacyClick();
            }
        }, startPrivacy, endPrivacy, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        setText(spannable);
        setMovementMethod(LinkMovementMethod.getInstance());
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
    }

    public void setOnLinkClickListener(OnLinkClickListener listener) {
        this.listener = listener;
    }
}

