package com.example.library.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 文件工具类
 */
public class FileUtil {

    /**
     * 工具类不能被初始化
     */
    public FileUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 在某个地方存储一个图片文件
     */
    public static void savePng(String filePath, Bitmap bitmap){
        //得到存储的文件
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
        }
        //得到文件的输出流
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        //将图片保存到文件中
        bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
    }

    /**
     * 将一个相对的uri地址转换为真实的文件地址
     */
    public static String getRealFilePath(final Context context, final Uri uri ) {
        if ( null == uri ) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if ( scheme == null )
            data = uri.getPath();
        else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
            data = uri.getPath();
        } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
            Cursor cursor = context.getContentResolver().query( uri, new String[] { MediaStore.Images
                    .ImageColumns.DATA }, null, null, null );
            if ( null != cursor ) {
                if ( cursor.moveToFirst() ) {
                    int index = cursor.getColumnIndex( MediaStore.Images.ImageColumns.DATA );
                    if ( index > -1 ) {
                        data = cursor.getString( index );
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

}
