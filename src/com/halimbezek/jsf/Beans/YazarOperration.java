package com.halimbezek.jsf.Beans;

public class YazarOperration {
	
	private int yazar_id;
	private String yazar_adi, aciklma;
	
	public YazarOperration() {
		super();
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
	public String getAciklma() {
		return aciklma;
	}
	public void setAciklma(String aciklma) {
		this.aciklma = aciklma;
	}
	
}
