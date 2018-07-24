package com.halimbezek.jsf.model;

public class Yazar {

	private int yazar_id;
	private String yazar_adi;
	private String aciklama;
	
	
	
	public Yazar(String yazar_adi, String aciklama) {
		super();
		this.yazar_adi = yazar_adi;
		this.aciklama = aciklama;
	}


	public Yazar(int yazar_id, String yazar_adi, String aciklama) {
		super();
		this.yazar_id = yazar_id;
		this.yazar_adi = yazar_adi;
		this.aciklama = aciklama;
	}
	

	public int getYazar_id() {
		return yazar_id;
	}
	public void setYazar_id(int yazar_id) {
		this.yazar_id = yazar_id;
	}
	public String getYazar_adi() {
		return yazar_adi;
	}
	public void setYazar_adi(String yazar_adi) {
		this.yazar_adi = yazar_adi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	
}
