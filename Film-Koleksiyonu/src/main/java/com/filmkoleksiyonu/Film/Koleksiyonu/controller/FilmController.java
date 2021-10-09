package com.filmkoleksiyonu.Film.Koleksiyonu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.filmkoleksiyonu.Film.Koleksiyonu.model.Film;
import com.filmkoleksiyonu.Film.Koleksiyonu.service.FilmService;

@Controller
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		model.addAttribute("listFilm", filmService.getAllFilm());
		List<Film> listFilm = filmService.listAll(keyword);

		model.addAttribute("listFilm", listFilm);
		model.addAttribute("keyword", keyword);

		return "index";
	}

	@GetMapping("/showNewFilmForm")
	public String showNewFilmForm(Model model) {
		Film film = new Film();
		model.addAttribute("film", film);
		return "film_ekle";
	}

	@PostMapping("/saveFilm")
	public String saveFilm(@ModelAttribute("film") Film film) {
		filmService.saveFilm(film);
		return "redirect:/";

	}

	@GetMapping("/showFormForDetay/{film_id}")
	public String showFormForView(@PathVariable(value = "film_id") long film_id, Model model) {

		Film film = filmService.getFilmById(film_id);

		model.addAttribute("film", film);
		return "film_detay";
	}

	@GetMapping("/showFormForGuncelle/{film_id}")
	public String showFormForUpdate(@PathVariable(value = "film_id") long film_id, Model model) {

		Film film = filmService.getFilmById(film_id);

		model.addAttribute("film", film);
		return "film_güncelle";
	}

	@GetMapping("/deleteFilm/{film_id}")
	public String deleteFilm(@PathVariable(value = "film_id") long film_id) {

		this.filmService.deleteFilmById(film_id);
		return "redirect:/";
	}

	@GetMapping("/sortByYear")
	public String sortByYear(Model model) {
		model.addAttribute("listFilm", filmService.orderByAscending());
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
