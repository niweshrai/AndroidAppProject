package com.example.sumankhatiwada.vehiclebazzar.mvp.model.sessionmanagement;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.sumankhatiwada.vehiclebazzar.R;

import javax.inject.Inject;



public class SharedPreferenceManager {

    private static final String EMPTY_STRING = "";
    private static SharedPreferenceManager instance;
    @Inject
    SharedPreferences sharedPreferences;

    /**
     * Create a shared instance of the class
     * @return instance of the class
     */
    public static SharedPreferenceManager getSharedInstance() {
        if(instance == null)
            instance = new SharedPreferenceManager();
        return instance;
    }

    /**
     * Default Constructor to register Observables
     */
    public SharedPreferenceManager() {
        super();



    }

    /**
     * Method to initiate Shared Preferences
     */
    public void initiateSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    /**
     * Method to set string in preferences
     * @param key
     * @param value
     * @return editor commit
     */
    private boolean setStringInPreferences(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * Method to get string from preferences
     * @param key
     * @return data
     */
    private String getStringFromPreferences(String key) {
        String data = sharedPreferences.getString(key, EMPTY_STRING);
        return data;
    }

    /**
     * Method to set int in preferences
     * @param key
     * @param value
     * @return editor commit
     */
    private boolean setIntInPreferences(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * Method to get int from preferences
     * @param key
     * @return data
     */
    private int getIntFromPreferences(String key) {
        int data = sharedPreferences.getInt(key, -1);
        return data;
    }

    /**
     * Method to set double in preferences
     * @param key
     * @param value
     * @return editor commit
     */
    private boolean setDoubleInPreferences(String key, Double value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, Double.doubleToLongBits(value));
        return editor.commit();
    }

    /**
     * Method to get double from preferences
     * @param key
     * @return data
     */
    private Double getDoubleFromPreferences(String key) {
        Double data = Double.longBitsToDouble(sharedPreferences.getLong(key, Double.doubleToLongBits(-1.0)));
        return data;
    }

    /**
     * Method to set boolean in preferences
     * @param key
     * @param value
     * @return editor commit
     */
    private boolean setBooleanInPreferences(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * Method to get boolean from preferences
     * @param key
     * @return data
     */
    private boolean getBooleanFromPreferences(String key) {
        boolean data = sharedPreferences.getBoolean(key, false);
        return data;
    }

    /**
     * Method to set long in preferences
     * @param key
     * @param value
     * @return data
     */
    private boolean setLongInPreferences(String key, long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * Method to get long from preferences
     * @param key
     * @return data
     */
    private long getLongFromPreferences(String key) {
        long data = sharedPreferences.getLong(key, -1);
        return data;
    }

    /**
     * Method to set float in preferences
     * @param key
     * @param value
     * @return data
     */
    private boolean setFloatInPreferences(String key, float value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    /**
     * Method to get float from preferences
     * @param key
     * @return data
     */
    private float getFloatFromPreferences(String key) {
        float data = sharedPreferences.getFloat(key, -1.0f);
        return data;
    }

    /**
     * Method to delete data on specific key from preferences
     * @param key
     * @return data
     */
    private boolean deleteDataFromPreferences(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        return editor.commit();
    }

    /**
     * Removing all preferences.
    */
    public void clearAllPreferences(){
        sharedPreferences.edit().clear().commit();
    }

    public void saveUserModel(UserModel userModel)
    {

        if(userModel==null)
            return;
        Log.e("UserModelRegister",userModel.userEmail + AppConstants.SharedPreferenceKeys.USER_ID.getKey());
        setStringInPreferences(AppConstants.SharedPreferenceKeys.USER_ID.getKey(),userModel.uid);
        setStringInPreferences(AppConstants.SharedPreferenceKeys.USER_PASSWORD.getKey(), userModel.userPassword);
        setStringInPreferences(AppConstants.SharedPreferenceKeys.USER_EMAIL.getKey(), userModel.userEmail);
        setStringInPreferences(AppConstants.SharedPreferenceKeys.NAME.getKey(),userModel.name);

    }

    public UserModel getUserModelFromPreferences()
    {
        UserModel userModel =null;
        String name = getStringFromPreferences(AppConstants.SharedPreferenceKeys.USER_EMAIL.getKey());
      String userPassword =  getStringFromPreferences(AppConstants.SharedPreferenceKeys.USER_PASSWORD.getKey());

       // Log.e("USernameLogin",name);
       // Log.e("USernameLogin",uid);
        if(!TextUtils.isEmpty(name)||!TextUtils.isEmpty(userPassword)) {
            userModel = new UserModel();
            userModel.userPassword = name;
            userModel.name = getStringFromPreferences(AppConstants.SharedPreferenceKeys.NAME.getKey());
            userModel.userEmail = getStringFromPreferences(AppConstants.SharedPreferenceKeys.USER_EMAIL.getKey());



        }
//        Log.e("Loaded value",userModel.uid);
        return userModel;
    }



}