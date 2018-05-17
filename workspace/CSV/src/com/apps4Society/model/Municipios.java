package com.apps4Society.model;

public class Municipios {

private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	
	
	private String nome;
	private int populacao;
	private double latitude;
	private double longitude;
	private String estado;
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
	
	
	public Municipios(String estado, Double latitude , Double longitude , String nome , int populacao , String site){
		setEstado(estado);
		setLatitude(latitude);
		setLongitude(longitude);
		setNome(nome);
		setPopulacao(populacao);
		setSite(site);
	}
}
