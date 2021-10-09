package com.filmkoleksiyonu.Film.Koleksiyonu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filmkoleksiyonu.Film.Koleksiyonu.controller.dto.KullaniciKayitDto;
import com.filmkoleksiyonu.Film.Koleksiyonu.service.KullaniciService;

@Controller
@RequestMapping("/kayit")
public class KullaniciKayitController {

	private KullaniciService kullaniciService;

	public KullaniciKayitController(KullaniciService kullaniciService) {
		super();
		this.kullaniciService = kullaniciService;
	}

	@ModelAttribute("kullanici")
	public KullaniciKayitDto kullaniciKayitDto() {
		return new KullaniciKayitDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		return "kayit";
	}

	@PostMapping
	public String kullaniciKayitHesabı(@ModelAttribute("kullanici") KullaniciKayitDto kayitDto) {
		kullaniciService.save(kayitDto);
		return "redirect:/kayit?success";

	}

}
