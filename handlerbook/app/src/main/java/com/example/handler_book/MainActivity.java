package com.example.handler_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int UPADTE_TEXT = 1;
    private TextView text;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPADTE_TEXT:
                //可在这里进行UI操作
                    text.setText("Nice to meet you");
                    break;
                    default:
                        break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        Button changeText=(Button) findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.change_text:
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = UPADTE_TEXT;
                    handler.sendMessage(message);//发送Message对象
                    //text.setText("Nice to meet you");
                }
            }).start();
                break;
            default:
                break;
        }

    }
}
