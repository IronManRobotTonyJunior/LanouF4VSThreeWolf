package com.example.dllo.bibilala.tool.exception;


import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "ExceptionHandler";
    private Activity mActivity;

    public ExceptionHandler(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "error.log");
        OutputStream os = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file, true);
            os.write(ex.getMessage().getBytes());
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                byte[] bytes = stackTraceElement.toString().getBytes();
                os.write(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Log.d(TAG, "uncaughtException() called with: thread = [" + thread + "], ex = [" + ex + "]");
    }
}
