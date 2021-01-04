package com.example.vaspra555.app;

public class User {
    public static String User_ID = "TEST";
    public static String token = "TEST";
    public static String User_Name = "TEST";
    public static String User_Lucky ="TEST";

    public static String getUser() {
        return User_ID;
    }
    public static void setUser(String x){
        User_ID = x;
    }
    public static String getToken() {return  token;}
    public static void setToken(String x){
        token = x;
    }
    public static String getName() {
        return User_Name;
    }
    public static void setName(String x){ User_Name = x;}
    public static String getLucky() {
        return User_Lucky;
    }
    public static void setLucky(String x){
        User_Lucky = x;
    }
}
