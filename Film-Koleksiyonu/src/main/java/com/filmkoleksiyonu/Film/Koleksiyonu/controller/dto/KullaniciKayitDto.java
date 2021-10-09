package com.filmkoleksiyonu.Film.Koleksiyonu.controller.dto;

public class KullaniciKayitDto {

	private String adi;
	private String soyadi;
	private String email;
	private String sifre;

	public KullaniciKayitDto() {

	}

	public KullaniciKayitDto(String adi, String soyadi, String email, String sifre) {
		super();
		this.adi = adi;
		this.soyadi = soyadi;
		this.email = email;
		this.sifre = sifre;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

}
