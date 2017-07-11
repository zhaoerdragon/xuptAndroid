package com.example.library.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.Display;
import android.view.WindowManager;

/**
 * Bitmap工具类
 */
public class BitmapUtils {

    /**
     * 工具类不能被初始化
     */
    public BitmapUtils(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 图片旋转算法
     * @param bitmap 旋转的图片
     * @param angle 旋转的角度
     */
    public static Bitmap rotateBitmap(Bitmap bitmap, float angle) {

        //获取图片旋转需要的矩阵
        Matrix matrix = new Matrix();

        //将图片旋转相应的角度
        matrix.postRotate(angle);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /**
     * 压缩图片至指定大小
     * @param bgimage 准备压缩的图片
     * @param newWidth 新的宽度
     * @param newHeight 新的高度
     */
    public static Bitmap zoomBitmap(Bitmap bgimage,double newWidth,double newHeight) {
        // 获取这个图片的宽和高
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();

        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();

        // 计算宽高缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);

        //按照矩阵压缩得到相应的图片
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
                (int) height, matrix, true);
        return bitmap;
    }

    /**
     * 将图片压缩并加载到内存中
     * @param ctx 内容提供者
     * @param filePath 图片的地址
     */
    public static Bitmap getScaleBitmap(Context ctx, String filePath) {
        BitmapFactory.Options opt = new BitmapFactory.Options();

        //将这个值设为true,得到的图片便不会加载到内存中，只是返回高度和宽度。从而防止了内存泄漏。
        opt.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, opt);

        //得到图片的宽和高
        int bmpWidth = opt.outWidth;
        int bmpHeght = opt.outHeight;

        //得到屏幕的高度和宽度
        WindowManager windowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();

        //对图片进行缩放，其中inSampleSize为缩放的比例，以屏幕的宽度和高度为缩放的标准
        opt.inSampleSize = 1;
        if (bmpWidth > bmpHeght) {
            if (bmpWidth > screenWidth)
                opt.inSampleSize = bmpWidth / screenWidth;
        } else {
            if (bmpHeght > screenHeight)
                opt.inSampleSize = bmpHeght / screenHeight;
        }
        opt.inJustDecodeBounds = false;

        //到的缩放后的图片
        bmp = BitmapFactory.decodeFile(filePath, opt);
        return bmp;
    }

}
