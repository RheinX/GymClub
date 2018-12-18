package com.example.xuweijie.gymclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class QQLoginActivity extends AppCompatActivity {
    private static final String APP_ID = "101536648";//官方获取的APPID
    private static Tencent mTencent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqlogin);

        mTencent=Tencent.createInstance(APP_ID, this.getApplicationContext());
        Button buttonLogin=(Button)findViewById(R.id.btn_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        LoginListener myListener = new LoginListener();

        if (!mTencent.isSessionValid()){
            mTencent.login(this, "all", myListener);
        }
    }
    private class LoginListener implements IUiListener {
        @Override
        public void onComplete(Object o) {

        }

        @Override
        public void onError(UiError uiError) {

        }

        @Override
        public void onCancel() {

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LoginListener myListener = new LoginListener();
        Tencent.onActivityResultData(requestCode,resultCode,data,myListener);
    }
}
