package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.Star;

public interface StarRepository extends JpaRepository<Star, String>{

}
