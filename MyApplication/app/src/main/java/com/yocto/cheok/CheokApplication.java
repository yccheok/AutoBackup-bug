package com.yocto.cheok;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.multidex.MultiDexApplication;

public class CheokApplication extends MultiDexApplication {

    private static CheokApplication me;

    public static CheokApplication instance() {
        return me;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        me = this;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putBoolean("test", true).apply();

        android.util.Log.i("CHEOK", "CheokApplication onCreate");
    }
}
