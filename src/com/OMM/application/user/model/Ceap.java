package com.OMM.application.user.model;

import java.util.ArrayList;
import java.util.List;


public class Ceap implements Constantes_Ceap, Constantes_Estado {
	
	static final double QUANTIDADE_DE_MESES = 12;
	
	private double limiteCeap;
	private int tipoCeap;
	private String descricaoCeap;
	private List< Double > gastosMensais = new ArrayList< Double >();
	private Parlamentar parlamentar = null;
	private double totalGastoAnual = 0.0;
	
	public Ceap( Parlamentar politico, int tipo ) {
	
		this.set_Parlamentar( politico );
		this.set_TipoCeap(tipo);
		
		this.inicializar_GastosMensais( );
		this.configurar_DescricaoCeap( this.get_TipoCeap( ) );
	
	}

	public Ceap(){
		
		
	}
		
		
		
	
	public List< Double > get_GastosMensais( ) {
		
		return gastosMensais;
	}

	public void set_GastosMensais( List< Double > gastosMensais ) {
		
		this.gastosMensais = gastosMensais;
	}

	public Parlamentar get_Parlamentar( ) {
		
		return parlamentar;
	}

	private void set_Parlamentar( Parlamentar parlamentar ) {
		
		this.parlamentar = parlamentar;
	}
	
	public double get_ValorCeap() {
		
		return limiteCeap;
	}

	private void set_ValorCeap( double valorCeap ) {
		
		this.limiteCeap = valorCeap;
	}
	
	private void set_TipoCeap ( int tipo ) {
		
		this.tipoCeap = tipo;
	}
	
	private int get_TipoCeap( ) {
		
		return this.tipoCeap;
	}
	
	public String get_DescricaoCeap ( ) {
		
		return this.descricaoCeap;
	}
	
	private void set_descricaoCeap ( String descricao )  {
		
		this.descricaoCeap = descricao;
	}
	
	private void set_TotalGastolAnual ( double total ) {
		
		this.totalGastoAnual = total;
	}
	
	private void calcularGastoTotalAnual ( ) {
		
		double total = 0.0;
		
		for ( int i = 0 ; i < QUANTIDADE_COTAS ; i++) {
			
			total = total + gastosMensais.get( i );
		}
		
		this.set_TotalGastolAnual(total);
	}
	
	public double get_TotalGastoAnual ( ) {
		
		return this.totalGastoAnual;
	}
	
	private void configurar_DescricaoCeap ( int tipo ) {
		
		switch ( tipo ) {
			
			case TELEFONIA:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case SEGURANCA:
				this.set_descricaoCeap("TEXTO");
				break;
			
			case HOSPEDAGEM:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case ALIMENTACAO:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case COMBUSTIVEL:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case CONSULTORIA:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case PASSAGEM_AEREA:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case SERVICOS_POSTAIS:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case LOCACAO_VEICULO:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case ESCRITORIO:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case ASSINATURA_PUBLICACOES:
				this.set_descricaoCeap("TEXTO");
				break;
				
			case DIVULGACAO_PARLAMENTAR:
				this.set_descricaoCeap("TEXTO");
				break;
			
			default:
				this.set_descricaoCeap("TEXTO DEFAULT");
		}
			
	}
	
	private void inicializar_GastosMensais( ) {
		
		for (int indice = 0 ; indice < QUANTIDADE_DE_MESES ; indice++) {
			
			this.gastosMensais.add( indice, 0.0 );
		}
	}
	
	
}
