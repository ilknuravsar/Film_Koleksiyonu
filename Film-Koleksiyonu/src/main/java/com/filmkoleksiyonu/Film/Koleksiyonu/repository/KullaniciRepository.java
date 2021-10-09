package com.filmkoleksiyonu.Film.Koleksiyonu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmkoleksiyonu.Film.Koleksiyonu.model.Kullanici;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
	Kullanici findByEmail(String email);
}
