package com.filmkoleksiyonu.Film.Koleksiyonu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmkoleksiyonu.Film.Koleksiyonu.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

	@Query("SELECT x FROM Film x WHERE CONCAT(x.film_adi, x.film_kategori, x.film_yonetmen, x.film_oyuncu) LIKE %?1%")
	public List<Film> search(String keyword);

	@Query("from Film order by film_yili asc")
	public List<Film> orderByAscending();
}
