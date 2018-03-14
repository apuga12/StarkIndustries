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

	public static void main(String[] args) {
        try {
            send();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}