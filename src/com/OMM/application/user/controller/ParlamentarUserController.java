package com.OMM.application.user.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.OMM.application.user.model.*;
import com.OMM.application.user.dao.*;

public class ParlamentarUserController {
	
	private static ParlamentarUserController instance;	
	SocketUser socketUser;
	Parlamentar parlamentar;
	
	
	private ParlamentarUserController(){
		
		socketUser = new SocketUser();
		parlamentar = new Parlamentar();
		
	}
	
	
	public static ParlamentarUserController getInstance(){
		
		if (instance == null){
			instance = new ParlamentarUserController();
		}
		
		return instance;
	}
	
	public void teste(){
		System.out.println("Oii");
		socketUser.testeeee();
	}
	
	public void pesquisarParlamentarPorNome (String nome) {

		socketUser.getSaida().print(nome);
		socketUser.getSaida().flush();
	}
	

}
