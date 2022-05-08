package com.example.forev.mycodelibrary.utils;

import android.util.Log;

public class MCLLog {
    private static final String TAG = "MCLLog";
    private static final String DEFAULT_TAG = "df";
    private static int LOG_MAX_LENGTH = 2000;

    public MCLLog() {
    }

    public static void v(String msg) {
        printLog(DEFAULT_TAG, msg, MCLLog.Level.Verbose);
    }

    public static void i(String msg) {
        printLog(DEFAULT_TAG, msg, MCLLog.Level.Info);
    }

    public static void d(String msg) {
        printLog(DEFAULT_TAG, msg, MCLLog.Level.Debug);
    }

    public static void w(String msg) {
        printLog(DEFAULT_TAG, msg, MCLLog.Level.Warn);
    }

    public static void e(String msg) {
        printLog(DEFAULT_TAG, msg, MCLLog.Level.Error);
    }

    public static void a(String msg) {
        printLog(DEFAULT_TAG, msg, MCLLog.Level.Assert);
    }

    public static void v(String tag, String msg) {
        printLog(tag, msg, MCLLog.Level.Verbose);
    }

    public static void i(String tag, String msg) {
        printLog(tag, msg, MCLLog.Level.Info);
    }

    public static void d(String tag, String msg) {
        printLog(tag, msg, MCLLog.Level.Debug);
    }

    public static void w(String tag, String msg) {
        printLog(tag, msg, MCLLog.Level.Warn);
    }

    public static void e(String tag, String msg) {
        printLog(tag, msg, MCLLog.Level.Error);
    }

    public static void a(String tag, String msg) {
        printLog(tag, msg, MCLLog.Level.Assert);
    }

    private static void printLog(String tag, String msg, MCLLog.Level level) {
        String detailInfo = getStackDetailInfo(tag, msg);
        print(level, tag, detailInfo);
    }

    private static String getStackDetailInfo(String subTag, String msg) {
        StackTraceElement ste = null;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int defaultLevel = 5;
        if (defaultLevel < stackTraceElements.length) {
            ste = stackTraceElements[defaultLevel];
        }

        if (null != ste) {
            int lineNumber = ste.getLineNumber();
            String methodName = ste.getMethodName();
            String fileName = ste.getFileName();
            StringBuilder builder = new StringBuilder("");
            builder.append("TAG:").append(subTag).append(" ")
                    .append("[")
                    .append(fileName).append(" ").append(lineNumber).append("] ")
                    .append(methodName).append("()-> ")
                    .append(msg)
                    .append(" [").append("TID:").append(Thread.currentThread().getId()).append("]");
            return builder.toString();
        } else {
            return msg;
        }
    }

    private static void print(MCLLog.Level level, String tag, String msg) {
        int strLength = msg.length();
        int start = 0;
        int end = LOG_MAX_LENGTH;

        try {
            for(int i = 0; i < 100; ++i) {
                if (strLength <= end) {
                    print(level, msg.substring(start, strLength));
                    break;
                }

                print(level, i + " :-> " + msg.substring(start, end));
                start = end;
                end += LOG_MAX_LENGTH;
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    private static void print(MCLLog.Level level, String msg) {
        switch(level) {
            case Verbose:
                Log.v(TAG, msg);
                break;
            case Info:
                Log.i(TAG, msg);
                break;
            case Debug:
                Log.d(TAG, msg);
                break;
            case Warn:
                Log.w(TAG, msg);
                break;
            case Error:
            case Assert:
                Log.e(TAG, msg);
        }

    }

    private static enum Level {
        Verbose,
        Info,
        Debug,
        Warn,
        Error,
        Assert;

        private Level() {
        }
    }
}
