package com.halimbezek.jsf.Beans;

import javax.faces.bean.ManagedBean;

import com.halimbezek.jsf.model.DBHelperKutuphane;
import com.halimbezek.jsf.model.Yayin_evi;

@ManagedBean(name="yayineviOpt")
public class YayineviOperation {

	private int id;
	private String yayinevi_Adi,aciklama;
	
	public YayineviOperation() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYayinevi_Adi() {
		return yayinevi_Adi;
	}
	public void setYayinevi_Adi(String yayinevi_Adi) {
		this.yayinevi_Adi = yayinevi_Adi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	public String yayineviEkle(){
		
		Yayin_evi yayin_evi = new Yayin_evi(yayinevi_Adi, aciklama);
		new DBHelperKutuphane().yayineviEkle(yayin_evi);
		
		return "yayineviListesi";
	}
	
	public String yayineviSil(int yayinevi_id) {

		new DBHelperKutuphane().yayineviSil(yayinevi_id);
		
		return "yayineviListesi";
	}
	
}
