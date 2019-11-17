package com.example.insidefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*写入*/
        Button btnWrite = (Button) findViewById(R.id.save_data);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out =null;
                try {
                    FileOutputStream fileOutputStream=openFileOutput("inside",MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);
                    String name = "Ellfy";
                    String id="2017011380";
                    try {
                        out.write(name.getBytes(StandardCharsets.UTF_8));
                        out.write(id.getBytes(StandardCharsets.UTF_8));
                    }
                    finally {
                        if (out != null)
                            out.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        /*读取*/
        Button btnRead = (Button) findViewById(R.id.restore_data);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in =null;
                try {
                    FileInputStream fileInputStream = openFileInput("inside");
                    in = new BufferedInputStream(fileInputStream);

                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try {
                        while((c=in.read()) != -1){
                            stringBuilder.append((char) c);
                        }
                        Toast.makeText(MainActivity.this,stringBuilder.toString(),
                                Toast.LENGTH_LONG).show();
                    }finally {
                        if (in != null){
                            in.close();
                        }
                    }
                    }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
