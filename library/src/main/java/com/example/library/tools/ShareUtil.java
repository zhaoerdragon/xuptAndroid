package com.example.library.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.library.R;

/**
 * 分享工具类
 */
public class ShareUtil {

    /**
     * 工具类不能被初始化
     */
    public ShareUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 分享数据给你的朋友们
     * @param context
     * @param stringRes
     */
    public static void share(Context context, int stringRes) {
        share(context, context.getString(stringRes));
    }

    /**
     * 分享图片和标题
     * @param context
     * @param uri
     * @param title
     */
    public static void shareImage(Context context, Uri uri, String title) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(shareIntent, title));
    }

    /**
     * 分享文字
     * @param context
     * @param extraText
     */
    public static void share(Context context, String extraText) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, extraText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(
                Intent.createChooser(intent, "分享"));
    }
}
