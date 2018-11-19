package com.example.xuweijie.gymclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        Button button = (Button) findViewById(R.id.btn_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username=(EditText)findViewById(R.id.et_userName);
                EditText other=(EditText)findViewById(R.id.et_other);
                EditText topic=(EditText)findViewById(R.id.et_topic);
                EditText content=(EditText)findViewById(R.id.etc_content);

                Intent email = new Intent(android.content.Intent.ACTION_SEND);
                //邮件发送类型：无附件，纯文本
                email.setType("plain/text");
                //邮件接收者（数组，可以是多位接收者）
                String[] emailReciver = new String[]{username.getText().toString()};

                String  emailTitle = topic.getText().toString();
                String emailContent = content.getText().toString();
                //设置邮件地址
                email.putExtra(android.content.Intent.EXTRA_EMAIL, emailReciver);
                //设置邮件标题
                email.putExtra(android.content.Intent.EXTRA_SUBJECT, emailTitle);
                //设置发送的内容
                email.putExtra(android.content.Intent.EXTRA_TEXT, emailContent);
                //调用系统的邮件系统
                startActivity(Intent.createChooser(email, "请选择邮件发送软件"));

            }
        });
    }
}
