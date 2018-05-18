package com.apps4Society.model;

import com.opencsv.bean.CsvBindByName;

public class Municipios {

private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	
	@CsvBindByName(column = "CEP", required = true)
	private String cep;
	
	@CsvBindByName(column = "AREA-TERRITORIAL", required = true)
	private String areaTerritorial;
	
	@CsvBindByName(column = "NOME", required = true)
	private String nome;
	
	@CsvBindByName(column = "POPULACAO", required = true)
	private int populacao;
	
	@CsvBindByName(column = "LATITUDE", required = true)
	private double latitude;
	
	@CsvBindByName(column = "LONGITUDE", required = true)
	private double longitude;
	
	@CsvBindByName(column = "ESTADO", required = true)
	private String estado;
	
	@CsvBindByName(column = "SITE", required = true)
	private String site;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public Municipios() {}
	
	
	public Municipios(String areaTerritorial,String cep,String estado, Double latitude , Double longitude , String nome , int populacao , String site){
		setCep(cep);
		setAreaTerritorial(areaTerritorial);
		setEstado(estado);
		setLatitude(latitude);
		setLongitude(longitude);
		setNome(nome);
		setPopulacao(populacao);
		setSite(site);
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getAreaTerritorial() {
		return areaTerritorial;
	}
	public void setAreaTerritorial(String areaTerritorial) {
		this.areaTerritorial = areaTerritorial;
	}
}
