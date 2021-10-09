package com.filmkoleksiyonu.Film.Koleksiyonu.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "kullanici", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Kullanici {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "adi")
	private String adi;

	@Column(name = "soyadi")
	private String soyadi;

	private String email;
	private String sifre;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "kullanici_rol", joinColumns = @JoinColumn(name = "kullanici_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))

	private Collection<Rol> rol;

	public Kullanici() {

	}

	public Kullanici(String adi, String soyadi, String email, String sifre, Collection<Rol> rol) {
		super();
		this.adi = adi;
		this.soyadi = soyadi;
		this.email = email;
		this.sifre = sifre;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<Rol> getRol() {
		return rol;
	}

	public void setRol(Collection<Rol> rol) {
		this.rol = rol;
	}
}
