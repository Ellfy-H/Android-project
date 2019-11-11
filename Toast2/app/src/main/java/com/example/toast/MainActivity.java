package com.example.toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) findViewById(R.id.login);//获取在布局文件中定义的元素
        Button button2=(Button) findViewById(R.id.tip);

                button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final LinearLayout inflater=(LinearLayout) getLayoutInflater().inflate(R.layout.login_dialog,null);
                builder.setView(inflater)
                        .setTitle("Login")
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                /*LayoutInflater factorys = LayoutInflater.from(MainActivity.this);
                                View V1 = factorys.inflate(R.layout.login_dialog, null);*/
                                EditText edit1=(EditText) inflater.findViewById(R.id.editTextUserId);
                                EditText edit2=(EditText) inflater.findViewById(R.id.editTextPwd);
                                String s1=edit1.getText().toString();
                                String s2=edit2.getText().toString();


                                if (s1.equals("abc")&&s2.equals("123")){
                                    Toast.makeText(MainActivity.this, "登陆成功",
                                            Toast.LENGTH_LONG).show();
                                }else{
                                    Log.d("MainActivity:","id"+s1);

                                    Toast.makeText(MainActivity.this, "用户名或密码错误",
                                            Toast.LENGTH_LONG).show();
                                }

                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "用户按下了cancel按钮",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {//注册监听器
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setMessage("请先登录，输入用户名和密码")//消息内容
                        .setTitle("提示");//对话框标题

                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮",
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮",
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder2.show();

            }
        });

    }
}
