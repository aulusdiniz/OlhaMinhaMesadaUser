package com.OMM.application.user.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.OMM.application.user.helper.JSONHelper;
import com.OMM.application.user.model.CotaParlamentar;

public abstract class HttpConnection {
	
	public final static ResponseHandler<String> responseHandler = new ResponseHandler<String>()
			{

				public String handleResponse( HttpResponse response )
						throws IOException
				{
					StatusLine status = response.getStatusLine();

					HttpEntity entity = response.getEntity();
					String result = null;
					// todo: refatorar, extrair método/objeto

					BufferedReader br = new BufferedReader(new InputStreamReader(
							entity.getContent()));
					StringBuilder sb = new StringBuilder();
					String line = null;

					while ((line = br.readLine()) != null)
					{
						sb.append(line + "\n");
					}

					br.close();
					result = sb.toString();

					Message message = handler.obtainMessage();
					Bundle bundle = new Bundle();
					bundle.putString("RESPONSE", result);
					message.setData(bundle);
					handler.sendMessage(message);

					return result;
				}
			};
			
	   public static ResponseHandler<String> getResponseHandler(){
	   	
	   	return responseHandler;
	   	
	   }

		private static final Handler handler = new Handler()
		{
	
			@Override
			public void handleMessage( final Message msg )
			{
				String bundleResult = msg.getData().getString("RESPONSE");
	
				List<CotaParlamentar> ceaps = JSONHelper
						.listaCotaParlamentarFromJSON(bundleResult);
	
				String valor = "" + ceaps.get(0).getValorAgosto();
	
				// output.setText(valor);
			}
		};
}




