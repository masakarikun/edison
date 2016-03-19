package com.example.edison;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener,
		OnInitListener, OnClickListener {
	String url = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(this);

		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(this);

		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			url = "http://10.248.118.249/led/on";
			exec_post(url);

			break;
		case R.id.button2:
			url = "http://10.248.118.249/led/off";
			exec_post(url);

			break;
		case R.id.button3:
			url = "http://10.248.118.249/blink/start";
			exec_post(url);

			break;
		case R.id.button4:
			url = "http://10.248.118.249/blink/stop";
			exec_post(url);

			break;
		}
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	private void exec_post(String edisonURL) {

		Log.d("posttest", "postします");
		 // String url = "http://www.ipentec.com/default.aspx";
		  AsyncHttpRequest task = new AsyncHttpRequest(this);
		  task.owner = this;
		  task.execute(edisonURL);

	}
}
