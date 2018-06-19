package com.bwei.liumeichao_exam2.mvp.home.penceter;

import com.bwei.liumeichao_exam2.mvp.home.model.LoginModel;
import com.bwei.liumeichao_exam2.mvp.home.model.bean.LoginBean;
import com.bwei.liumeichao_exam2.mvp.home.view.iview.LoginView;

public class LoginPrescter {
    LoginView loginView;
    private final LoginModel loginModel;

    //1.写一个构造方法
    public LoginPrescter(LoginView loginView) {
        loginModel = new LoginModel();
        this.loginView = loginView;
    }


    //2.写一个需要传的方法

    public void login(String name, String pwd, String two_pwd) {

        //判断
        if (name == null) {
            if (loginView != null) {
                loginView.getError("手机号不能为空");
            }
        }





     loginModel.login(name, pwd, two_pwd, new LoginModel.LoginViewCallback() {
         @Override
         public void getSucces(LoginBean loginBean) {
             //请求成功
             if(loginView != null){
                 loginView.getSucces(loginBean);
             }
         }

         @Override
         public void getError(String error) {
            //请求失败
           if(loginView!=null){
               loginView.getError(error);
           }
         }
     });
    }

}
