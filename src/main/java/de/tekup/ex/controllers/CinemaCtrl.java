package de.tekup.ex.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.ex.models.Movie;
import de.tekup.ex.models.Studio;
import de.tekup.ex.services.CinemaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cinema")
@AllArgsConstructor
public class CinemaCtrl {
	
	private CinemaService service;
	
	@GetMapping("/star/{name}/studios")
	public List<Studio> getStudios(@PathVariable("name") String starName){
		return service.getStudiosByStar(starName);
	}
	
	@GetMapping("/studio/{name}/movies")
	public List<Movie> getMovies(@PathVariable("name") String studioName){
		return service.getCloredMovieByStudio(studioName);
	}
	
	@GetMapping("/stars/{dateBegin}/{dateEnd}")
	public Map<Character, Long> getMaleAndFemaleBornInPeriod(@PathVariable("dateBegin") String dBegin,
			@PathVariable("dateEnd") String dEnd){
		LocalDate dateBegin = LocalDate.parse(dBegin);
		LocalDate dateEnd = LocalDate.parse(dEnd);
		 return service.getMaleAndFemaleBornInPeriod(dateBegin, dateEnd);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

}
