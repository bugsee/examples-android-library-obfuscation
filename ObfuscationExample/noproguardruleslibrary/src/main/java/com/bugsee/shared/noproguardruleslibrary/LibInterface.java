package com.bugsee.shared.noproguardruleslibrary;

import android.util.Log;

import com.bugsee.shared.noproguardruleslibrary.data.DataClass;
import com.google.gson.Gson;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
public class LibInterface {
    public boolean manipulateDataClasses() {
        DataClass instance = new DataClass(10, "Value");
        Gson gson = new Gson();
        Log.i("LibInterface", "1");
        String json = gson.toJson(instance);
        Log.i("LibInterface", "2");
        DataClass restoredInstance = gson.fromJson(json, DataClass.class);
        Log.i("LibInterface", "3");
        return instance.equals(restoredInstance);
    }
}
