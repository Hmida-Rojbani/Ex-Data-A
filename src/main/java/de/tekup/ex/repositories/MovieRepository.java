package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{

}
