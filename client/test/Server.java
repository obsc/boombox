// package com.example.boombox.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// import android.os.AsyncTask;
// import android.util.Log;

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

		URL u = null;
		HttpURLConnection conn = null;
		BufferedReader r = null;

		try {
			u = new URL(HOST + url);
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
		} catch (Exception e) {
			System.out.println("Exception at Server.get():\n" + e.getMessage());
			return null;
		} finally {
			if (conn != null)
				conn.disconnect();
		}
	}

    public static void main(String[] args) {
		System.out.println(new Server().get("hello/10"));
    }

}
