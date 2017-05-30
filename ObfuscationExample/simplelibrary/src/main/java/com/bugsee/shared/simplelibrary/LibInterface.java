package com.bugsee.shared.simplelibrary;

import com.google.gson.Gson;

import com.bugsee.shared.simplelibrary.data.DataClass;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
public class LibInterface {
    public boolean manipulateDataClasses() {
        DataClass instance = new DataClass(10, "Value");
        Gson gson = new Gson();
        String json = gson.toJson(instance);
        DataClass restoredInstance = gson.fromJson(json, DataClass.class);
        return instance.equals(restoredInstance);
    }
}
