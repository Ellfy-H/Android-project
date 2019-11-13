package com.example.comeback;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.comeback.R;

import static java.lang.System.out;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);//在活动中加载布局

        Button button1=(Button) findViewById(R.id.button_1);
         /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.activitytest.ACTION_START");//隐式启动
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });*/

      button1.setOnClickListener(new View.OnClickListener() {

            @Override
            //在FirstActivity的基础上打开SecondActivity
            public void onClick(View v) {//intent 显示启动
                /*String data="Hello SecondActivity";*/
                Intent intent= new Intent(FirstActivity.this, SecondActivity.class);//参数二，要启动的目标活动
                intent.putExtra("name","张三");//传递字符串toSecond*/
                intent.putExtra("age",20);
                 startActivityForResult(intent,0);
            }
        });

    }
    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==0&&resultCode==0){
            String str=data.getStringExtra("result");
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        }
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
