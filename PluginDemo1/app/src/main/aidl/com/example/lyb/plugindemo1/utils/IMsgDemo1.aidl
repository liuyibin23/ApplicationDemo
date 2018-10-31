// IMsgDemo1.aidl
package com.example.lyb.plugindemo1.utils;

// Declare any non-default types here with import statements

interface IMsgDemo1 {
//    /**
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    void onMsgReceived(String msg);
}
