package com.example.listgouvernorat;

import static android.content.ContentValues.TAG;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

public class MyAsyncTaskLoader extends AsyncTaskLoader<String> {

    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public String loadInBackground() {

        for(int i=0; i<100; i++){
            try {
                Thread.sleep(40);
                Log.d(TAG,"LoadInBackground: "+ i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Task Result";
    }
    protected  void onStartLoding(){
        forceLoad();
    }
}
