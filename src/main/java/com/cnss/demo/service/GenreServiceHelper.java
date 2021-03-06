package com.cnss.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnss.demo.domain.Genre;
import com.cnss.demo.repository.GenreRepository;

@Service
public class GenreServiceHelper {
	
	@Autowired
	private GenreRepository repository;
	
	private static HashMap<String, Genre> ALL_GENRES = new HashMap<String,Genre>(){{
		put("ROM", new Genre("ROM", "Roman"));
		put("POE", new Genre("POE", "Poésie"));
		put("THE", new Genre("THE", "Théatre"));
		put("NOU", new Genre("NOU", "nouvelle"));
		put("AUT", new Genre("AUT", "autobigraphie"));
	}};

	public List<Genre> findAll() {
		return new ArrayList<Genre>(ALL_GENRES.values());
	}

	public static Genre findOne(String genreCode) {
		Genre genre = new Genre();
		Genre oldGenre =  ALL_GENRES.get(genreCode);
		genre.setCode(oldGenre.getCode());
		genre.setDescription(oldGenre.getDescription());
		return genre;
	}
	
	public Genre getByCode(String code) {
		return repository.findByCode(code);
	}
	
	public void saveDefaultGenre() {
		repository.save(ALL_GENRES.values());
	}
	

}
