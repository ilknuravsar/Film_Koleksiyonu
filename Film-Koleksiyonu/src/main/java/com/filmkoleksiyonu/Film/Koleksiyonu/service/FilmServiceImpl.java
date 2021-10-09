package com.filmkoleksiyonu.Film.Koleksiyonu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmkoleksiyonu.Film.Koleksiyonu.model.Film;
import com.filmkoleksiyonu.Film.Koleksiyonu.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;

	@Override
	public List<Film> getAllFilm() {
		return filmRepository.findAll();
	}

	@Override
	public void saveFilm(Film film) {
		this.filmRepository.save(film);

	}

	@Override
	public Film getFilmById(long film_id) {
		Optional<Film> optional = filmRepository.findById(film_id);
		Film film = null;
		if (optional.isPresent()) {
			film = optional.get();
		} else {
			throw new RuntimeException("Film Bulunamadı::" + film_id);
		}
		return film;
	}

	@Override
	public void deleteFilmById(Long film_id) {
		this.filmRepository.deleteById(film_id);

	}

	@Override
	public List<Film> orderByAscending() {
		return filmRepository.orderByAscending();
	}

	@Override
	public List<Film> listAll(String keyword) {
		if (keyword != null) {
			return filmRepository.search(keyword);
		}
		return filmRepository.findAll();
	}
}
