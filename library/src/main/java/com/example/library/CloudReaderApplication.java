package com.example.library;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;

/**
 * Application应用类
 */
public class CloudReaderApplication extends Application {

    private static CloudReaderApplication cloudReaderApplication;

    public static CloudReaderApplication getInstance() {
        return cloudReaderApplication;
    }
}
