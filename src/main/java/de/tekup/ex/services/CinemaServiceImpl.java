package de.tekup.ex.services;

import java.util.List;
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
		// TODO Auto-generated method stub
		return null;
	}

}
