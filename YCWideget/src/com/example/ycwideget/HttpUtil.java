package com.example.ycwideget;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	private static HttpClient httpClient = new DefaultHttpClient();
	
	public static String getRequest(String url)
	{
		String result = null;
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response;
		try {
			response = httpClient.execute(httpGet);
			int responseCode = response.getStatusLine().getStatusCode();
			if ( responseCode != 200)
			{
				return null;
			}
			
			result = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	public static String postRequest(String url, HashMap<String, String> data)
	{
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		Set<String> set = data.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			String key = iterator.next();
			params.add(new BasicNameValuePair(key, data.get(key)));
		}
		
		HttpResponse response = null;
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			response =httpClient.execute(httpPost);
			int responseCode = response.getStatusLine().getStatusCode();
			if ( responseCode == 200)
			{
				result = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
