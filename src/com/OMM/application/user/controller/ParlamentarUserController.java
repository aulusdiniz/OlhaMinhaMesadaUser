package com.OMM.application.user.controller;


import java.util.ArrayList;
import java.util.List;

import com.OMM.application.user.model.*;


public class ParlamentarUserController {
	
	private static ParlamentarUserController instance;	
	Parlamentar parlamentar;
	
	
	private ParlamentarUserController(){
		
		parlamentar = new Parlamentar();
		
	}
	
	
	public static ParlamentarUserController getInstance(){
		
		if (instance == null){
			instance = new ParlamentarUserController();
		}
		
		return instance;
	}
	
	
}
	


