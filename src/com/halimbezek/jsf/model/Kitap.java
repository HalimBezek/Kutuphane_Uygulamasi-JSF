package com.halimbezek.jsf.model;

public class Kitap {

	 private int id;
	 private String kitap_adi;
	 private String kitap_alt_adi;
	 private String kitap_seri_adi;
	 private int kitap_isbn_no;
	 private String yazar_adi;
	 private String yayin_evi_adi;
	 private String kitap_aciklama;
	 private int yazar_id;
	 private int yayin_evi_id;
	 

	public Kitap(int id, String kitap_adi, String kitap_alt_adi, String kitap_seri_adi, int kitap_isbn_no,
			String kitap_aciklama, int yazar_id, int yayin_evi_id) {
		super();
		this.id = id;
		this.kitap_adi = kitap_adi;
		this.kitap_alt_adi = kitap_alt_adi;
		this.kitap_seri_adi = kitap_seri_adi;
		this.kitap_isbn_no = kitap_isbn_no;
		this.kitap_aciklama = kitap_aciklama;
		this.yazar_id = yazar_id;
		this.yayin_evi_id = yayin_evi_id;
	}



	public Kitap(int id, String kitap_adi, String kitap_alt_adi, String kitap_seri_adi, int kitap_isbn_no, String yazar_adi,
			String yayin_evi_adi, String kitap_aciklama) {
		super();
		this.id = id;
		this.kitap_adi = kitap_adi;
		this.kitap_alt_adi = kitap_alt_adi;
		this.kitap_seri_adi = kitap_seri_adi;
		this.kitap_isbn_no = kitap_isbn_no;
		this.yazar_adi = yazar_adi;
		this.yayin_evi_adi = yayin_evi_adi;
		this.kitap_aciklama = kitap_aciklama;
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



	public String getYazar_adi() {
		return yazar_adi;
	}



	public void setYazar_adi(String yazar_adi) {
		this.yazar_adi = yazar_adi;
	}



	public String getYayin_evi_adi() {
		return yayin_evi_adi;
	}



	public void setYayin_evi_adi(String yayin_evi_adi) {
		this.yayin_evi_adi = yayin_evi_adi;
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

	public String getKitap_aciklama() {
		return kitap_aciklama;
	}
	public void setKitap_aciklama(String kitap_aciklama) {
		this.kitap_aciklama = kitap_aciklama;
	}

	 
	 
}
