package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) findViewById(R.id.login);//获取在布局文件中定义的元素
        Button button2=(Button) findViewById(R.id.tip);
        button2.setOnClickListener(new View.OnClickListener() {//注册监听器
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"请先登录",
                        Toast.LENGTH_SHORT).show();//显示时长
            }
        });

    }
}
