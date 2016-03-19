package com.example.edison;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;



public class PostMessageTask extends AsyncTask<String, Integer, Integer> {
	 
    @Override
    protected Integer doInBackground(String... contents) {
        String url="http://localhost:8888/test";
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
 
        ArrayList <NameValuePair> params = new ArrayList <NameValuePair>();
        params.add( new BasicNameValuePair("content", contents[0]));
 
        HttpResponse res = null;
 
        try {
            post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
            res = httpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return Integer.valueOf(res.getStatusLine().getStatusCode());
    }
 
}