package com.example.boombox.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Wrapper for the remote server. Use this to make server requests.
 * 
 * @author cheng
 * 
 */
public class Server {

	private static final String TAG = "Server";
	private static final String HOST = "http://10.32.196.116:8000/";

	/**
	 * Performs a GET request to the server using the url specified.
	 * 
	 * @return The hypertext returned by the request.
	 */
	public String get(String url) {
		GetTask t = new GetTask();
		try {
			return t.execute(url).get();
		} catch (Exception e) {
			Log.e(TAG, "Exception at Server.get():\n" + e.getMessage());
			return null;
		}
	}

	/**
	 * A separate worker thread for making a GET request. This prevents the main
	 * thread from blocking because of a network request.
	 * 
	 * @author cheng
	 * 
	 */
	private class GetTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			URL u = null;
			HttpURLConnection conn = null;
			BufferedReader r = null;

			try {
				u = new URL(HOST + params[0]);
				conn = (HttpURLConnection) u.openConnection();
				InputStream in = new BufferedInputStream(conn.getInputStream());

				// Builds string from input stream.
				StringBuilder sb = new StringBuilder();
				r = new BufferedReader(new InputStreamReader(in));
				String l;
				while ((l = r.readLine()) != null)
					sb.append(l);
				r.close();
				return sb.toString();
			} catch (IOException ex) {
				Log.e(TAG, "IOException from get(): " + ex.getMessage());
				return null;
			} finally {
				if (conn != null)
					conn.disconnect();
			}
		}

	}

}
