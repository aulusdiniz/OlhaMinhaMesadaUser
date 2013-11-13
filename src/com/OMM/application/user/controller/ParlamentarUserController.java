package com.OMM.application.user.controller;


import com.OMM.application.user.helper.JSONHelper;
import com.OMM.application.user.model.Parlamentar;


public class ParlamentarUserController {
	
	private static ParlamentarUserController instance;	
	Parlamentar parlamentar;
	
	
	private ParlamentarUserController(){
		
		parlamentar = new Parlamentar();
		
	}
	
	public Parlamentar buscaParlamentar(String json){
		
		Parlamentar parlamentar = JSONHelper.listaParlamentarFromJSON(json).get(0);
		
		return parlamentar;		
	}
	
	public static ParlamentarUserController getInstance(){
		
		if (instance == null){
			instance = new ParlamentarUserController();
		}
		
		return instance;
	}
	
	
}
	


