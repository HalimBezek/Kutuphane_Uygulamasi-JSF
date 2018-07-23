package com.halimbezek.jsf.model;

public class Yayin_evi {

	private int id;
	private String adi;
	private String aciklama;
	
	public Yayin_evi(int id, String adi, String aciklama) {
		super();
		this.id = id;
		this.adi = adi;
		this.aciklama = aciklama;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

}
