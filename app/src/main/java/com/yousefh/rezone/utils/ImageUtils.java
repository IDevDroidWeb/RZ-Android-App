package com.yousefh.rezone.utils;

import android.app.Activity;
import android.content.Intent;

public class ImageUtils {

    public static final int REQUEST_CODE_PICK_IMAGE = 1001;

    // Open Gallery
    public static void showImagePicker(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        activity.startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    // check choose result
    public static boolean isImagePickerResult(int requestCode, int resultCode, Intent data) {
        return requestCode == REQUEST_CODE_PICK_IMAGE
                && resultCode == Activity.RESULT_OK
                && data != null
                && data.getData() != null;
    }
}
