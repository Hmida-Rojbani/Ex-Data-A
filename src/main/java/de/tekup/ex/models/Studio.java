package de.tekup.ex.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
@Table(name = "studios")
public class Studio {
	
	@Id
	@Column(length = 30)
	private String name;
	@Column(length = 70)
	private String address;
	@JsonIgnore
	@OneToMany(mappedBy = "studio")
	private List<Movie> movies;

}
