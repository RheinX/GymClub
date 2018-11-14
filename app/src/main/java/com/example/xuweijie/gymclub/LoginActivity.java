package com.example.xuweijie.gymclub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private Button btnSubmit;
    private EditText textUsername;
    private EditText passWord;
    private static String LOGIN_URL="http://10.0.2.2:8083/spark/android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSubmit = (Button) findViewById(R.id.btn_login);
        textUsername=(EditText)findViewById(R.id.et_userName);
        passWord=(EditText)findViewById(R.id.et_password);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            //重写点击事件的处理方法onClick()
            @Override
            public void onClick(View v) {
                //验证输入内容
                String username=textUsername.getText().toString();
                String password=passWord.getText().toString();

                if("".equals(username) || "".equals(password)){
//                    System.out.println("数据不能为空!");
                    showNormalDialog();
                }

                String resposnse=LoginByPut(username,password);
                try {
                    JSONObject msg=new JSONObject(resposnse);
                    //失败
                    if ("false".equals(msg.get("result"))){
                        Toast.makeText(LoginActivity.this,
                                msg.get("msg").toString(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //成功
                    Toast.makeText(LoginActivity.this,
                            "登陆成功!", Toast.LENGTH_SHORT).show();

                    //跳转页面
                    Intent intent=new Intent(LoginActivity.this,TrainListActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("data",resposnse);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(LoginActivity.this);
        //normalDialog.setIcon(R.drawable.icon_dialog);
        normalDialog.setTitle("数据不能为空！");
        normalDialog.setMessage("请完整填写用户名和密码！");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
//        normalDialog.setNegativeButton("关闭",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //...To-do
//                    }
//                });
        // 显示
        normalDialog.show();
    }

    public static String LoginByPut(String username, String password) {
        String resp = "";
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(LOGIN_URL).openConnection();
            conn.setRequestMethod("PUT");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            String data = "username=" + username + "&password=" + password;

            // 获取输出流:
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(data);
            writer.flush();
            writer.close();

            // 获取相应流对象:
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
                response.append(line);
//            SPUtils.put(mContext, "session", conn.getHeaderField("Set-Cookie"));
            // 资源释放:
            in.close();
            // 返回字符串
//            Log.e("HEHE", response.toString());
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
