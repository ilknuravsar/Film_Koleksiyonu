package com.filmkoleksiyonu.Film.Koleksiyonu.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmkoleksiyonu.Film.Koleksiyonu.controller.dto.KullaniciKayitDto;
import com.filmkoleksiyonu.Film.Koleksiyonu.model.Kullanici;
import com.filmkoleksiyonu.Film.Koleksiyonu.model.Rol;
import com.filmkoleksiyonu.Film.Koleksiyonu.repository.KullaniciRepository;

@Service
public class KullaniciServiceImpl implements KullaniciService {

	private KullaniciRepository kullaniciRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public KullaniciServiceImpl(KullaniciRepository kullaniciRepository) {
		super();
		this.kullaniciRepository = kullaniciRepository;
	}

	@Override
	public Kullanici save(KullaniciKayitDto kayitDto) {
		Kullanici kullanici = new Kullanici(kayitDto.getAdi(), kayitDto.getSoyadi(), kayitDto.getEmail(),
				passwordEncoder.encode(kayitDto.getSifre()), Arrays.asList(new Rol("ROL_KULLANICI")));

		return kullaniciRepository.save(kullanici);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Kullanici kullanici = kullaniciRepository.findByEmail(username);
		if (kullanici == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(kullanici.getEmail(), kullanici.getSifre(),
				mapRolesToAuthorities(kullanici.getRol()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles) {
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
	}
}
