package com.OMM.application.user.dao;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketUser {

	Socket		socketUsuario;
	Scanner		entrada;
	PrintWriter saida;
	
	public SocketUser( ) {
		
		configurarRede( );
	}
	
	private void configurarRede( ) {
		
		try {
			
			socketUsuario = new Socket( "192.168.1.12", 5000 );
			saida		  = new PrintWriter( socketUsuario.getOutputStream( ) );
			entrada		  = new Scanner( socketUsuario.getInputStream( ) );
			
		} catch( Exception e ) {
			
		}
	}
	
	public void testeeee(){
		System.out.println("Olá socket!!!");
	}
	
	public Scanner getEntrada() {
		return entrada;
	}

	public void setEntrada(Scanner entrada) {
		this.entrada = entrada;
	}

	public PrintWriter getSaida() {
		return saida;
	}

	public void setSaida(PrintWriter saida) {
		this.saida = saida;
	}
}
