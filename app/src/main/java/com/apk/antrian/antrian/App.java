package com.apk.antrian.antrian;

import android.app.Application;

public class App extends Application {
    public static final String TAG = App.class.getSimpleName();
    private static App mInstance;
    private PrefManager pref;

    @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this;
        pref = new PrefManager(this);
    }

    public static synchronized  App getmInstance(){
        return mInstance;
    }
    public PrefManager getPref(){
        if(pref == null){
            pref = new PrefManager(this);
        }
        return pref;
    }
    public static synchronized App getInstance(){
        return mInstance;
    }
}
