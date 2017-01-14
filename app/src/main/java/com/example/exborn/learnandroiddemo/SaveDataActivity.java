package com.example.exborn.learnandroiddemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 数据持久化
 */
public class SaveDataActivity extends BaseActivity {

    private Button saveDataToPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        saveDataToPreferences = (Button)findViewById(R.id.daba_data_to_share_reference);
        saveDataToPreferences.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /* 保存数据 */
                        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                        editor.putString("name","Tom");
                        editor.putInt("age",20);
                        editor.putBoolean("married",false);
                        editor.commit();    //提交改动

                        /* 读取数据 */
                        /*
                        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                        String name = pref.getString("name", "");
                        int age = pref.getInt("age",0);
                        boolean married = pref.getBoolean("married", false);
                        */
                    }
                }
        );
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, SaveDataActivity.class);
        context.startActivity(intent);
    }


}
