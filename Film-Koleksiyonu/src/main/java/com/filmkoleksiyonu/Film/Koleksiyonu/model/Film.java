package com.filmkoleksiyonu.Film.Koleksiyonu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long film_id;

	@Column(name = "film_adi")
	private String film_adi;

	@Column(name = "film_yili")
	private String film_yili;

	@Column(name = "film_kategori")
	private String film_kategori;

	@Column(name = "film_aciklama")
	private String film_aciklama;

	@Column(name = "film_dili")
	private String film_dili;

	@Column(name = "film_yonetmen")
	private String film_yonetmen;

	@Column(name = "film_medya")
	private String film_medya;

	@Column(name = "film_oyuncu")
	private String film_oyuncu;

	public long getFilm_id() {
		return film_id;
	}

	public void setFilm_id(long film_id) {
		this.film_id = film_id;
	}

	public String getFilm_adi() {
		return film_adi;
	}

	public void setFilm_adi(String film_adi) {
		this.film_adi = film_adi;
	}

	public String getFilm_yili() {
		return film_yili;
	}

	public void setFilm_yili(String film_yili) {
		this.film_yili = film_yili;
	}

	public String getFilm_kategori() {
		return film_kategori;
	}

	public void setFilm_kategori(String film_kategori) {
		this.film_kategori = film_kategori;
	}

	public String getFilm_aciklama() {
		return film_aciklama;
	}

	public void setFilm_aciklama(String film_aciklama) {
		this.film_aciklama = film_aciklama;
	}

	public String getFilm_dili() {
		return film_dili;
	}

	public void setFilm_dili(String film_dili) {
		this.film_dili = film_dili;
	}

	public String getFilm_yonetmen() {
		return film_yonetmen;
	}

	public void setFilm_yonetmen(String film_yonetmen) {
		this.film_yonetmen = film_yonetmen;
	}

	public String getFilm_medya() {
		return film_medya;
	}

	public void setFilm_medya(String film_medya) {
		this.film_medya = film_medya;
	}

	public String getFilm_oyuncu() {
		return film_oyuncu;
	}

	public void setFilm_oyuncu(String film_oyuncu) {
		this.film_oyuncu = film_oyuncu;
	}

}
