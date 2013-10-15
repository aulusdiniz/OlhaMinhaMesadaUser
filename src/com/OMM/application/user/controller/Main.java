package com.OMM.application.user.controller;
import com.OMM.application.user.dao.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParlamentarUserController.getInstance().teste();
		
		String mensagem = "Tomaz";
		ParlamentarUserController.getInstance().pesquisarParlamentarPorNome(mensagem);
	

	}

}
