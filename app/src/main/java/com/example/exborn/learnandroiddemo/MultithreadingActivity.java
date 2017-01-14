package com.example.exborn.learnandroiddemo;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultithreadingActivity extends AppCompatActivity {
    public static final int UPDATE_TEXT = 1;
    private TextView text;
    private Button changeText;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
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
        setContentView(R.layout.activity_multithreading);

        text = (TextView) findViewById(R.id.multi_text_view);
        changeText = (Button) findViewById(R.id.change_text);
        changeText.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch(v.getId()) {
                            case R.id.change_text:
                                new Thread(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                Message message = new Message();
                                                message.what = UPDATE_TEXT;
                                                handler.sendMessage(message);
                                            }
                                        }
                                ).start();
                                break;
                            default:
                                break;
                        }
                    }
                }
        );
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, MultithreadingActivity.class);
        context.startActivity(intent);
    }
}
