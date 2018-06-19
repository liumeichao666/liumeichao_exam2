package com.bwei.liumeichao_exam2.mvp.home.model;

import com.bwei.liumeichao_exam2.mvp.home.model.bean.LoginBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginModel {



    //1.写一个登录方法
    public  void login(final String name,String pwd,String two_pwd,final LoginViewCallback loginViewCallback){
    //3.创建ok
        OkHttpClient okHttpClient=new OkHttpClient.Builder().build();

    //4..通过表单的形式,构建一个RequestBody,通过key 和value的方式上传参数
        RequestBody requestBody=new FormBody.Builder()
                .add("source","Android")
                .add("mobile",name)
                .add("password",pwd)
                .build();

          //5.通过我们构造的requeatbody对象,去构造一个request

           Request request=new Request.Builder()
                   .url("https://www.zhaoapi.cn/user/login")
                   .post(requestBody)
                   .build();

         //6.
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               //请求成功
                String json=response.body().string();
                Gson gson=new Gson();
                LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                String code = loginBean.getCode();
                String msg = loginBean.getMsg();



                //判断如果请求成功
                if("0".equalsIgnoreCase(code)){
                  if(loginViewCallback!=null){
                     loginViewCallback.getSucces(loginBean);
                  }
                }else{

                  if(loginViewCallback!=null){
                      loginViewCallback.getError(msg);
                  }

                }



            }
        });



    }



    //2.写一个接口
    public interface LoginViewCallback{
        void getSucces(LoginBean loginBean);
        void getError(String error);
    }
}
