package com.ncsoft.dataplatform.dummies.mock;

public class AuthService {
    private AuthDao dao;

    public boolean isLogin(String id) {
        boolean isLogin = dao.isLogin(id);
        if (isLogin) {
            // some code...
        }
        return isLogin;
    }
}
