package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.Studio;

public interface StudioRepository extends JpaRepository<Studio, String>{

}
