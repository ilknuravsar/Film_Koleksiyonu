package com.filmkoleksiyonu.Film.Koleksiyonu.service;

import java.util.List;

import com.filmkoleksiyonu.Film.Koleksiyonu.model.Film;

public interface FilmService {
	List<Film> getAllFilm();

	void saveFilm(Film film);

	Film getFilmById(long id);

	void deleteFilmById(Long film_id);

	public List<Film> orderByAscending();

	List<Film> listAll(String keyword);

}
