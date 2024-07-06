package com.google.firebase.crashlytics;

public class FirebaseCrashlytics {
    public static FirebaseCrashlytics getInstance() {
        return new FirebaseCrashlytics();
    }
    public void recordException(Exception e){}
    public void log(String msg){}
    public void setCrashlyticsCollectionEnabled(Boolean b){}
}
