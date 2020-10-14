package com.digi.pay.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.digi.pay.view_models.SignUpPojo;
import com.google.gson.Gson;


/**
 * Created by Arul Harsh on 08/02/18.
 */

public class PreferenceManger {

    /**
     * preference keys
     */
    public static String AA_APP_PREFS = "digi_app_preferences";
    public static String MODE_PREF = "mode_preferences";
    public static String SUB_MODE_PREF = "sub_mode_preferences";

    public static String SUB_SUB_MODE_PREF = "sub_sub_mode_preferences";

    public static String ONE_TIME_CREATION = "created";


    private static SharedPreferences preferences;

    private PreferenceManger() {
    }

    private static synchronized SharedPreferences getInstance() {
        if (preferences == null) {
            preferences = Digi_App.getInstance().getSharedPreferences(AA_APP_PREFS, Context.MODE_PRIVATE);
        }
        return preferences;
    }

    private static SharedPreferences.Editor getEditor() {
        return getInstance().edit();
    }

    public static void remove(String key) {
        SharedPreferences.Editor editor = getEditor();
        editor.remove(key);
        editor.apply();
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, value);
        editor.apply();
    }


    public static void putInt(String key, int value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public static void putObject(String key, SignUpPojo obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, json);
        editor.apply();
    }
   /* public static void putEducationObject(String key, EducationRowPojo obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, json);
        editor.apply();
    }*/
    public static SignUpPojo getObject(String key){
        Gson gson = new Gson();
        SharedPreferences.Editor editor = getEditor();
        String json = getInstance().getString(key, "");
        return gson.fromJson(json, SignUpPojo.class);
    }
   /* public static EducationRowPojo getEducationObject(String key){
        Gson gson = new Gson();
        SharedPreferences.Editor editor = getEditor();
        String json = getInstance().getString(key, "");
        return gson.fromJson(json, EducationRowPojo.class);
    }*/

    public static String getStringValue(String key) {
        return getInstance().getString(key, "");
    }

    public static boolean getBooleanValue(String key) {
        return getInstance().getBoolean(key, false);
    }

    public static int getIntegerValue(String key) {
        return getInstance().getInt(key, 0);
    }


    public static void logoutUser() {
        SharedPreferences.Editor editor = getEditor();
        editor.clear();
        editor.commit();
    }
}