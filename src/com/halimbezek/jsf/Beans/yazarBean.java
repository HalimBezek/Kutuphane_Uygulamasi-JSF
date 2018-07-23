package com.halimbezek.jsf.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.halimbezek.jsf.model.DBHelperKutuphane;
import com.halimbezek.jsf.model.Yazar;

//@SessionScoped
@ManagedBean
public class yazarBean {

	List<Yazar> yazarList = new ArrayList<>();

	
	public yazarBean() {
		System.out.println("user beanda");
		yazarList = new DBHelperKutuphane().yazarListesi();
	}

	public List<Yazar> getYazarList() {
		return yazarList;
	}

	public void setYazarList(List<Yazar> yazarList) {
		this.yazarList = yazarList;
	}
	
	
}
