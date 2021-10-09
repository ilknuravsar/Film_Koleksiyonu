package com.filmkoleksiyonu.Film.Koleksiyonu.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.filmkoleksiyonu.Film.Koleksiyonu.controller.dto.KullaniciKayitDto;
import com.filmkoleksiyonu.Film.Koleksiyonu.model.Kullanici;

public interface KullaniciService extends UserDetailsService {

	Kullanici save(KullaniciKayitDto kayitDto);

}
