package com.halimbezek.jsf.Beans;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.halimbezek.jsf.model.DBHelperKutuphane;
import com.halimbezek.jsf.model.Yayin_evi;

@ManagedBean
public class yayineviBean {

	List<Yayin_evi> yayineviListesi = new ArrayList<>();

	
	
	public yayineviBean() {
	
		yayineviListesi = new DBHelperKutuphane().yayineviListesi();
	}

	public List<Yayin_evi> getYayineviListesi() {
		return yayineviListesi;
	}

	public void setYayineviListesi(List<Yayin_evi> yayineviListesi) {
		this.yayineviListesi = yayineviListesi;
	}
	
	
}
