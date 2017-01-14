package com.example.exborn.learnandroiddemo.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Exborn on 2017/1/14.
 * Http请求工具类
 */
public class HttpUtil {
    private void sendRequestWithHttpURLConnection(final String url, final HttpcallbackListener listener) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        StringBuffer response = new StringBuffer("");
                        try{
                            String urlString = url;
                            URL url = new URL(urlString);
                            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                            connection.setRequestProperty("User-Agent", "");
                            connection.setRequestMethod("GET");
                            connection.setDoInput(true);
                            connection.connect();

                            InputStream inputStream = connection.getInputStream();

                            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
                            String line = "";
                            while ((line = rd.readLine()) != null) {
                                response.append(line);
                            }
                            if(listener != null){
                                listener.onFinish(response.toString());
                            }
                        }
                        catch (IOException e) {
                            // Writing exception to log
                            e.printStackTrace();
                            listener.onError(e);
                        }
                    }
                }
        ).start();
    }
}

/**
 * 回掉类
 */
class HttpcallbackListener {
    void onFinish(String response){
        Log.d("???",response);
    }
    void onError(Exception err){
        err.printStackTrace();
    }
}
