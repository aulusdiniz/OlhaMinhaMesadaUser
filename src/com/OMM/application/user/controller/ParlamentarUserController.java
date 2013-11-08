package com.OMM.application.user.controller;


import java.util.ArrayList;
import java.util.List;

import com.OMM.application.user.model.*;
//import com.OMM.application.user.requests.HttpConnection;


public class ParlamentarUserController {
	
	private static ParlamentarUserController instance;	
	Parlamentar parlamentar;
	
	
	private ParlamentarUserController(){
		
		parlamentar = new Parlamentar();
		
	}
	
	/*public void buscaParlamentar(){		
		HttpConnection hc = new HttpConnection();
		hc.performRequest();
		//String result = hc.performRequest();		
		//return result;
	}*/
	
	public static ParlamentarUserController getInstance(){
		
		if (instance == null){
			instance = new ParlamentarUserController();
		}
		
		return instance;
	}
	
	
}
	


