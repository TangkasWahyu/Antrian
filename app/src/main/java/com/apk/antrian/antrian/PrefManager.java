package com.apk.antrian.antrian;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private static final String PREF_NAME = "AntrianDatabase";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_TANGGAL = "tanggal";
    public static final String KEY_ALAMAT = "alamat";
    public static final String KEY_ID = "id";

    private final SharedPreferences pref;
    private static final int PRIVARE_MODE = 0;

    public PrefManager (Context context){
        pref = context.getSharedPreferences(PREF_NAME, PRIVARE_MODE);
    }
    public void setNama(String nama){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(KEY_NAMA, nama);
        editor.apply();
    }
    public String getNama(){
        return pref.getString(KEY_NAMA,Constant.DEFAULT_NAMA);
    }
    public void setTanggal(String tanggal){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(KEY_TANGGAL, tanggal);
        editor.apply();
    }
    public String getTanggal(){
        return pref.getString(KEY_TANGGAL,Constant.DEFAULT_TANGGAL);
    }
    public void setAlamat(String alamat){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(KEY_ALAMAT, alamat);
        editor.apply();
    }
    public String getAlamat(){
        return pref.getString(KEY_ALAMAT,Constant.DEFAULT_ALAMAT);
    }
    public void setId(int id){
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(KEY_ID, id);
        editor.apply();
    }
    public int getId(){
        return pref.getInt(KEY_ID,Constant.DEFAULT_ID);
    }
}
