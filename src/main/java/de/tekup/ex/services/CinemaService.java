package de.tekup.ex.services;

import java.util.List;

import de.tekup.ex.models.Movie;
import de.tekup.ex.models.Studio;

public interface CinemaService {

	public List<Studio> getStudiosByStar(String starName);
	public List<Movie> getCloredMovieByStudio(String studioName);
}
