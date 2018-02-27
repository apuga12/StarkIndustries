package com.starkindustries.springapp.domain3;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;

@Entity
@Table(name="Series")
public class Series implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//@Size(min = 1, max = 50, message = "Login must be between 4 and 15 characters long")
	private String title;
	
	//@Min(1)
	private String numberOfEpisodes;
	
	private Date dateReleased;

	private String country;
	/**
	 * default constructor
	 */
	public Series() {
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNumberOfEpisodes() {
		return numberOfEpisodes;
	}
	public void setNumberOfEpisodes(String numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}
	public Date getDateReleased() {
		return dateReleased;
	}
	public void setDateReleased(Date dateReleased) {
		this.dateReleased = dateReleased;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
