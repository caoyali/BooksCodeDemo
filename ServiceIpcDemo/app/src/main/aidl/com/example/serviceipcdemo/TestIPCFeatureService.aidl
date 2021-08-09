// TestIPCFeatureService.aidl
package com.example.serviceipcdemo;
//import com.example.serviceipcdemo.Rect;

// Declare any non-default types here with import statements

interface TestIPCFeatureService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    long getCurrentThreadId();
    void play();
    void pause();

    Rect getRundomRect();
}