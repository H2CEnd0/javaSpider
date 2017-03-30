package com.wsw.j2se.url;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class HtmlRequest {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.baidu.com");
		String urlsource = getURLSource(url);
		System.out.println(urlsource);
	}
	
	public static String getURLSource(URL url) throws Exception {
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		InputStream inStream = conn.getInputStream();
		byte[] data = readInputStream(inStream);
		String htmlSource = new String(data);
		return htmlSource;
	}
	public static byte[] readInputStream(InputStream instream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1204];
		int len = 0;
		while((len = instream.read(buffer)) != -1){
			outStream.write(buffer,0,len);
		}
		instream.close();
		return outStream.toByteArray();
	}
}
