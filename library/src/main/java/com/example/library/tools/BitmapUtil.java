package com.example.library.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.Display;
import android.view.WindowManager;

import java.io.ByteArrayOutputStream;

/**
 * Bitmap工具类
 */
public class BitmapUtil {

    /**
     * 工具类不能被初始化
     */
    public BitmapUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 将Bitmap转换成byte数组
     * @param bitmap
     * @return
     */
    public static byte[] bitmapToByte(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 将byte数组转换为Bitmap
     * @param bytes
     * @return
     */
    public static Bitmap byteToBitmap(byte[] bytes) {
        return (bytes == null || bytes.length == 0) ? null : BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    /**
     * 将Drawable转换为Bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        return drawable == null ? null : ((BitmapDrawable) drawable).getBitmap();
    }

    /**
     * 讲Bitmap转换为Drawable
     * @param bitmap
     * @return
     */
    public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return bitmap == null ? null : new BitmapDrawable(bitmap);
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

    /**
     * 将Drawable图像变成String类型
     * @param drawable
     * @return
     */
    public static String drawableToByte(Drawable drawable) {

        if (drawable != null) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            int size = bitmap.getWidth() * bitmap.getHeight() * 4;

            // 创建一个字节数组输出流,流的大小为size
            ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
            // 设置位图的压缩格式，质量为100%，并放入字节数组输出流中
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            // 将字节数组输出流转化为字节数组byte[]
            byte[] imagedata = baos.toByteArray();

            String icon = Base64.encodeToString(imagedata, Base64.DEFAULT);
            return icon;
        }
        return null;
    }

}
