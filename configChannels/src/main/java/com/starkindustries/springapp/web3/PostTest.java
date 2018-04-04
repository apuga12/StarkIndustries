package com.starkindustries.springapp.web3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class PostTest {
	public static void send() throws IOException {
		
		// Params = txtNombre=a&txtApellido=b&txtEmail=d&txtCiudad=f&botonValidar=Procesar
		
		URL url = new URL("http://localhost:8080/configChannels/bookAjax/3_validador");
		Map<String, Object> params = new LinkedHashMap<>();

		params.put("txtNombre", "apuga@izzi.mx");
		params.put("txtApellido", "Puga");
		params.put("txtEmail", "apuga@izzi.mx");

		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);

		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		for (int c = in.read(); c != -1; c = in.read())
			System.out.print((char) c);
	}
	public static void sendS1() throws IOException {
			
		String contact = "{\"fields\": {\"first_name\": \"RAMON\",\"last_name\": \"DIAZ\",\"phone_1\": \"\",\"phone_2\": \"5533358294\",\"external_id\": \"17777019\",\"email\": \"pugabdk@hotmail.com\"},\"accounts\": [{\"account_ext_id\": \"pugabdk@hotmail.com\",\"name\": \"RAMON DIAZ\",\"source\": \"email\",\"account\": \"pugabdk@hotmail.com\"}] }";
		String message = "{\"content\": \"Favor de contactar al siguiente cliente\",\"subject\": \"Generar lead ventas\",\"ext_date\": \"2018-03-08 12:00:00\",\"ext_id\": \"10000001\",\"source\": \"email\",\"cpg_id\": \"468341\" }";
		String ET = "YXM1Szd6T3dCY0VtMFJobnFNSFJMQWtRTzA4MW9YbXJpMTBQUHJ3WkEwekNDWTFQcmtxSlJTTmJCL0JHalJRTU1ZK1lyb1RabG15RjdqZDNXWkFEYWF5QlVhOW0yRHorcVNnYzdtbGVqZ2pHa0VSZjlTY2ZIZzJDOG1XdzlFanU0cDM2eGVJK05mQm05dlVXUUhLc1dzMkk3L00xbFE3aDgzc1dad1pUTnErdmRBQTIwQ3liS2dlaGphdEM0ZGt2RGYzZE05bHpmUUV5NG1qK1dDdDdzUT09";
			
		URL url = new URL("https://qa.s1gateway.com/api/channel/ext_case.php");
		Map<String, Object> params = new LinkedHashMap<>();
	
		params.put("contact", contact);
		params.put("message", message);
		params.put("ET", ET);
	
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);
	
		//Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		
		StringBuilder sb = new StringBuilder();
	    String line;
	    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    //JSONObject json = new JSONObject(sb.toString());
	    System.out.print(sb);
	}
	
	public static void main(String[] args) {
        try {
            //sendLocal();
        	sendS1();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}