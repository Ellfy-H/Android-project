package com.example.activitytest;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);//在活动中加载布局
        /*Toast 提示*/
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

      /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            //在FirstActivity的基础上打开SecondActivity
            public void onClick(View v) {//intent 显示启动
                Intent intent= new Intent(FirstActivity.this, SecondActivity.class);//参数二，要启动的目标活动
                startActivity(intent);
            }
        });*/

      /*
        //销毁一个活动
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//菜单布局显示
        getMenuInflater().inflate(R.menu.main,menu);//参数一指定创建菜单的资源文件，参数二指定菜单添加的Menu对象
        return true;//如果返回false,创建的菜单无法显示
    }

    //定义菜单响应事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You click ADD", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
