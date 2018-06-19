package com.bwei.liumeichao_exam2.mvp.home.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.liumeichao_exam2.R;
import com.bwei.liumeichao_exam2.mvp.home.model.bean.LoginBean;
import com.bwei.liumeichao_exam2.mvp.home.penceter.LoginPrescter;
import com.bwei.liumeichao_exam2.mvp.home.view.iview.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginView {

    private EditText edit_name,edit_pwd,edit_queren;
    private Button button;
    private LoginPrescter loginPrescter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit_name = findViewById(R.id.edit_name);
        edit_pwd=findViewById(R.id.edit_password);
        edit_queren=findViewById(R.id.edit_querenmima);
        button = findViewById(R.id.button);
        loginPrescter = new LoginPrescter((LoginView) this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = edit_name.getText().toString();
        String pwd = edit_pwd.getText().toString();
        String queren = edit_queren.getText().toString();
        loginPrescter.login(name,pwd,queren);
    }

    @Override
    public void getSucces(LoginBean loginBean) {
        //成功
         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 Toast.makeText(LoginActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
             }
         });
    }

    @Override
    public void getError(String error) {
       //失败
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               Toast.makeText(LoginActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
           }
       });
    }
}
