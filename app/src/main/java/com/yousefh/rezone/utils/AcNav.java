package com.yousefh.rezone.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class AcNav {

    // Open new Activity without close current Activity
    public static void open(Context context, Class<? extends Activity> target) {
        Intent intent = new Intent(context, target);
        context.startActivity(intent);
    }

    // Open new Activity and close current Activity
    public static void openFinish(Activity current, Class<? extends Activity> target) {
        Intent intent = new Intent(current, target);
        current.startActivity(intent);
        current.finish();
    }

    // Open new Activity and close all Activities (finishAffinity)
    public static void openClearAll(Activity current, Class<? extends Activity> target) {
        Intent intent = new Intent(current, target);
        current.startActivity(intent);
        current.finishAffinity();
    }

    // Open new Activity with passing data (Extras)
    public static void openExtras(Context context, Class<? extends Activity> target, Intent extrasIntent) {
        Intent intent = new Intent(context, target);
        if (extrasIntent != null && extrasIntent.getExtras() != null) {
            intent.putExtras(extrasIntent.getExtras());
        }
        context.startActivity(intent);
    }
}

/*
Intent extras = new Intent();
extras.putExtra("user_id", "123");
AcNav.openExtras(this, MainActivity.class, extras);
*/