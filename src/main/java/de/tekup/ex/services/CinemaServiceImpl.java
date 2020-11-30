package de.tekup.ex.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.tekup.ex.models.Movie;
import de.tekup.ex.models.Star;
import de.tekup.ex.models.Studio;
import de.tekup.ex.repositories.MovieRepository;
import de.tekup.ex.repositories.StarRepository;
import de.tekup.ex.repositories.StudioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService{
	
	private StarRepository reposStar;
	private StudioRepository reposStudio;
	private MovieRepository reposMovie;

	@Override
	public List<Studio> getStudiosByStar(String starName) {
		Star star = reposStar.findById(starName)
				.orElseThrow(()-> new NoSuchElementException("No Star with this name"));
		
		return star.getMovies().stream()
								.map(movie -> movie.getStudio())
								.distinct()
								.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getCloredMovieByStudio(String studioName) {
		Studio studio = reposStudio.findById(studioName)
				.orElseThrow(()-> new NoSuchElementException("No Studio with this name"));
		
		return studio.getMovies()
				.stream()
				.filter(movie -> movie.getColor() == 1)
				.collect(Collectors.toList());
	}

	@Override
	public Map<Character, Long> getMaleAndFemaleBornInPeriod(LocalDate dateBegin, LocalDate dateEnd) {
		/**
		List<Star> stars = reposStar.findAll();
		List<Star> acceptedStars  = new ArrayList<>();
		int male=0, female=0;
		for (Star star : stars) {
			if(star.getBirthDate().isAfter(dateBegin) && star.getBirthDate().isBefore(dateEnd)) {
				acceptedStars.add(star);
			}
		}
		
		for (Star star : acceptedStars) {
			if(star.getGendre()=='F' || star.getGendre()=='f') {
				female++;
			}else {
				male++;
			}
		}
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('F', female);
		map.put('M', male);
		
		//return map;
		*/
		return reposStar.findAll()
				.stream()
				.filter(star -> star.getBirthDate().isAfter(dateBegin) && star.getBirthDate().isBefore(dateEnd))
				.collect(Collectors.groupingBy(star-> star.getGendre(), Collectors.counting()));
	}

}
