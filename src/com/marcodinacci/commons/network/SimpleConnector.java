package com.marcodinacci.commons.network;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * A wrapper around HTTPLib to easily perform GET requests.
 * It is supposed to be used with Android <= 2.1 as in 2.2 there's already
 * the AndroidHTTPlib class.
 */
public class SimpleConnector {

	private static final String TAG = SimpleConnector.class.getName();

	private static final String HTTP = "http://".intern();
	
	private HttpHost mTarget;
	private DefaultHttpClient mClient;

	/**
	 * Create a new connector for the given host
	 * 
	 * @param host A String describing the host where to connect.
	 */
	public SimpleConnector(String host) {
		Log.d(TAG, "Creating a SimpleConnector for host: " + host);
		
		mTarget = new HttpHost(host);
		mClient = new DefaultHttpClient();
	}
	
	/**
	 * Execute a GET request.
	 * 
	 * @param query The path of the request.
	 * @return a String containing the request result.
	 */
	public String get(String query) {
		Log.d(TAG, "GET " + query);
		
		String hostname = mTarget.getHostName() ;
		
		Log.d(TAG, hostname);
		
		HttpGet get = new HttpGet(HTTP + hostname + query);
		HttpEntity results = null;
		try {
			Log.d(TAG, "Executing GET");
			
			HttpResponse response = mClient.execute(mTarget, get);
			results = response.getEntity();
			
			return EntityUtils.toString(results);
		} catch (Exception e) {
			e.printStackTrace();
			Log.d(TAG, e.getMessage());
			throw new ConnectivityFailure("Web Service Failure");
		} finally {
			if (results!=null)
				try {
					results.consumeContent();
				} catch (IOException e) {}
		}
	}
}
