package com.bwei.liumeichao_exam2.mvp.home.view.iview;

import com.bwei.liumeichao_exam2.mvp.home.model.bean.LoginBean;

public interface LoginView {

    void getSucces(LoginBean loginBean);
    void getError(String error);
}
