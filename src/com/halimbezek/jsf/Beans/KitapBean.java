package com.halimbezek.jsf.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.halimbezek.jsf.model.DBHelperKutuphane;
import com.halimbezek.jsf.model.Kitap;

@SessionScoped
@ManagedBean(name="kitapBean")
public class KitapBean {

	List<Kitap> kitapListesi = new  ArrayList<>();

	public KitapBean() {
		
		kitapListesi =  new DBHelperKutuphane().kitapListesi();
	}

	public List<Kitap> getKitapListesi() {
		return kitapListesi;
	}

	public void setKitapListesi(List<Kitap> kitapListesi) {
		this.kitapListesi = kitapListesi;
	}
	
	
}
