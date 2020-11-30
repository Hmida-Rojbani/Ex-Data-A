package de.tekup.ex.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import de.tekup.ex.models.Movie;
import de.tekup.ex.models.Studio;

public interface CinemaService {

	public List<Studio> getStudiosByStar(String starName);
	public List<Movie> getCloredMovieByStudio(String studioName);
	public Map<Character, Long> getMaleAndFemaleBornInPeriod(LocalDate dateBegin, LocalDate dateEnd);
}
