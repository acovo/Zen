package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.content.UriMatcher;

public class FirebaseInitProvider extends ContentProvider {
    private static final String TAG = "EmptyContentProvider";
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private static final int CODE_INVALID = 0;
    private static final int CODE_ROOT = 1;

    static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI("com.example.authority", "table", CODE_ROOT);
        return matcher;
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate called");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d(TAG, "query called with uri: " + uri);
        return null;
    }

    @Override
    public String getType(Uri uri) {
        Log.d(TAG, "getType called with uri: " + uri);
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d(TAG, "insert called with uri: " + uri);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d(TAG, "delete called with uri: " + uri);
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Log.d(TAG, "update called with uri: " + uri);
        return 0;
    }
}
