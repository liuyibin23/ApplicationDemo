package com.example.utils;

import com.google.gson.Gson;

/**
 * Create By lyb on 2018/10/25
 **/
public class AccountManager {

    private static AccountManager instance;
    private UserInfo currentUserInfo = new UserInfo();
    private static Object lockObj = new Object();
    private AccountManager(){
        getCurrentUserInfo().setLogin(false);
        getCurrentUserInfo().setUsername("guest");
    }

    public static AccountManager getInstance() {
        if(instance == null){
            synchronized(lockObj){
                if(instance == null){
                    instance = new AccountManager();
                }
            }
        }
        return instance;
    }

    public UserInfo getCurrentUserInfo() {
        return currentUserInfo;
    }

    public void setCurrentUserInfo(UserInfo currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

    public String getCurrentUserInfoJson(){
        Gson g = new Gson();
        return g.toJson(currentUserInfo);
    }

}
