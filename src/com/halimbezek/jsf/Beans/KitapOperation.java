package com.halimbezek.jsf.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.halimbezek.jsf.model.DBHelperKutuphane;
import com.halimbezek.jsf.model.Kitap;

@ManagedBean(name="kitapOpt")
public class KitapOperation {

	 private int id;
	 private String kitap_adi;
	 private String kitap_alt_adi;
	 private String kitap_seri_adi;
	 private int kitap_isbn_no;
	 private int yazar_id;
	 private int yayin_evi_id;
	 private String kitap_aciklama;
	 
	 	 
	public KitapOperation() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKitap_adi() {
		return kitap_adi;
	}
	public void setKitap_adi(String kitap_adi) {
		this.kitap_adi = kitap_adi;
	}
	public String getKitap_alt_adi() {
		return kitap_alt_adi;
	}
	public void setKitap_alt_adi(String kitap_alt_adi) {
		this.kitap_alt_adi = kitap_alt_adi;
	}
	public String getKitap_seri_adi() {
		return kitap_seri_adi;
	}
	public void setKitap_seri_adi(String kitap_seri_adi) {
		this.kitap_seri_adi = kitap_seri_adi;
	}
	public int getKitap_isbn_no() {
		return kitap_isbn_no;
	}
	public void setKitap_isbn_no(int kitap_isbn_no) {
		this.kitap_isbn_no = kitap_isbn_no;
	}
	public int getYazar_id() {
		return yazar_id;
	}
	public void setYazar_id(int yazar_id) {
		this.yazar_id = yazar_id;
	}
	public int getYayin_evi_id() {
		return yayin_evi_id;
	}
	public void setYayin_evi_id(int yayin_evi_id) {
		this.yayin_evi_id = yayin_evi_id;
	}
	public String getKitap_aciklama() {
		return kitap_aciklama;
	}
	public void setKitap_aciklama(String kitap_aciklama) {
		this.kitap_aciklama = kitap_aciklama;
	}
	 
	public String kitapEkle() {
		
		Kitap kitap = new Kitap(id, kitap_adi, kitap_alt_adi, kitap_seri_adi,
				kitap_isbn_no, kitap_aciklama, yazar_id, yayin_evi_id);
		new DBHelperKutuphane().kitapEkle(kitap);
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
	}
	 
}
