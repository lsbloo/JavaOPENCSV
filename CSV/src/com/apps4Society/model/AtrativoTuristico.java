package com.apps4Society.model;

public class AtrativoTuristico {

	private long id;
	
	
	public void setId(long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	private String nome;
	private double latitude;
	private double longitude;
	private String comoChegar;
	private String site;
	private String infoContato;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getComoChegar() {
		return comoChegar;
	}
	public void setComoChegar(String comoChegar) {
		this.comoChegar = comoChegar;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getInfoContato() {
		return infoContato;
	}
	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}

	public AtrativoTuristico() {}
	
	public AtrativoTuristico(String nome , double latitude , double longitude , String comoChegar, String site , String infoContato){
		setNome(nome);
		setLatitude(latitude);
		setLongitude(longitude);
		setComoChegar(comoChegar);
		setSite(site);
		setInfoContato(infoContato);
	}
	

}
