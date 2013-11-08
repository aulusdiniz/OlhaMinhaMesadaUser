package com.OMM.application.user.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.OMM.application.user.helper.JSONHelper;
import com.OMM.application.user.model.Parlamentar;

public class HttpConnection {
	
	public Parlamentar performRequest(){
		
		Parlamentar parlamentar=null;		
			
			final ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
				
				public String handleResponse(HttpResponse response) throws IOException{
					StatusLine status = response.getStatusLine();
					
					HttpEntity entity = response.getEntity();
					String result = inputStreamToString(entity.getContent());
					return result;				
				}

				private String inputStreamToString(InputStream stream) throws IOException{
					
					BufferedReader br = new BufferedReader(new InputStreamReader(stream));
					StringBuilder sb = new StringBuilder();
					String line = null;
					
					while ((line = br.readLine()) != null){
						sb.append(line + "\n");
					}					
					br.close();
					return sb.toString();
				}
					
	};	
	
	return parlamentar;
	
	
	
	}
}

