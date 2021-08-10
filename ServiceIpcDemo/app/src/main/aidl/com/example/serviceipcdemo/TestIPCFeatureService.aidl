// TestIPCFeatureService.aidl
package com.example.serviceipcdemo;

// Declare any non-default types here with import statements

interface TestIPCFeatureService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.TestIPCFeatureService
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    long getCurrentThreadId();
    void play();
    void pause();
}