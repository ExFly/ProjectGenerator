package com.example.exborn.learnandroiddemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 *  HttpClient已经被弃用
 *  如今应使用URLConnection
 */
public class NetworkActivity extends AppCompatActivity {

    People peoplet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        TextView name = (TextView) findViewById(R.id.name);
        TextView age = (TextView) findViewById(R.id.age);
        Button network_change_text = (Button) findViewById(R.id.network_change_text);
        network_change_text.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendRequestWithHttpURLConnection();
                    }
                }
        );
    }
    private void sendRequestWithHttpURLConnection() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        StringBuffer chaine = new StringBuffer("");
                        try{
                            String urlString = "http://192.168.51.1:8000/people.txt";
                            URL url = new URL(urlString);
                            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                            connection.setRequestProperty("User-Agent",
                                    "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
                            connection.setRequestMethod("GET");
                            connection.setDoInput(true);
                            connection.connect();

                            InputStream inputStream = connection.getInputStream();

                            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
                            String line = "";
                            while ((line = rd.readLine()) != null) {
                                chaine.append(line);
                            }

                        }
                        catch (IOException e) {
                            // Writing exception to log
                            e.printStackTrace();
                        }
                        Log.d("NetworkActivity", chaine.toString());
                        parseJsonWithGson(chaine.toString());
                    }
                }
        ).start();
    }
    private void parseJsonWithGson(String jsonData) {
        Gson gson = new Gson();
        List<People> peoples = gson.fromJson(jsonData, new TypeToken<List<People>>() {}.getType());
        if (peoples!= null){
            try{
                for (People people:peoples) {
                    Log.d("NetworkActivity", "name: "+people.getName()+" age: "+people.getAge());
                    // 把最后一个people显示到界面中
                    peoplet = people;
                }
            }catch(Exception e){}
        }else {
            Log.d("NetworkActivity", "object peoples is null");
        }
    }
    public static void activityStart(Context context) {
        Intent intent = new Intent(context, NetworkActivity.class);
        context.startActivity(intent);
    }
}

class People {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
