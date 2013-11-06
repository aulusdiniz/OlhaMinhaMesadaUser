package com.OMM.application.user.pojo;

public class ParlamentarPO {

	
	private String cod_parlamentar;
	private String nome_parlamentar;
	
	
	public ParlamentarPO(){}
	public ParlamentarPO(String cod_parlamentar,String nome_parlamentar)
	{
		this.cod_parlamentar=cod_parlamentar;
		this.nome_parlamentar=nome_parlamentar;
	}
	
	
	
	public String getNome_parlamentar()
	{
		return this.nome_parlamentar;
	}
	public String getCod_parlamentar()
	{
		return this.cod_parlamentar;
	}
	public void setNome_parlamentar(String nome_parlamentar)
	{
		this.nome_parlamentar=nome_parlamentar;
	}
	public void setCod_parlamentar(String cod_parlamentar)
	{
		this.cod_parlamentar=cod_parlamentar;
	}
	
}
