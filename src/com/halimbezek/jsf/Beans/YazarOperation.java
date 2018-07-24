package com.halimbezek.jsf.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.halimbezek.jsf.model.DBHelperKutuphane;
import com.halimbezek.jsf.model.Yazar;

@ManagedBean(name="yazarOpt")
public class YazarOperation {
	
	private int yazar_id;
	private String yazar_adi, aciklama;
	
	public YazarOperation() {
		
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

	public String yazarEkle() {


		Yazar yazar =new Yazar (yazar_adi,aciklama);
		new DBHelperKutuphane().yazarEkle(yazar);
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "yazarListesi";
	}
	
}
