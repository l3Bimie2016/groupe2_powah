package fr.assurance.entities;

import javax.persistence.Entity;

@Entity
public class HouseQuote extends Quote {
	private String house_type;
	private Float surface;
	private Integer nb_rooms;
	private Integer floor;
	private Integer nb_bathrooms;
	private Boolean garage;
	private Float garden_area;
	private Float terrace_area;
	private String heating_type;
	private String formula;
	
	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public Float getSurface() {
		return surface;
	}
	public void setSurface(Float surface) {
		this.surface = surface;
	}
	public Integer getNb_rooms() {
		return nb_rooms;
	}
	public void setNb_rooms(Integer nb_rooms) {
		this.nb_rooms = nb_rooms;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getNb_bathrooms() {
		return nb_bathrooms;
	}
	public void setNb_bathrooms(Integer nb_bathrooms) {
		this.nb_bathrooms = nb_bathrooms;
	}
	public Boolean getGarage() {
		return garage;
	}
	public void setGarage(Boolean garage) {
		this.garage = garage;
	}
	public Float getGarden_area() {
		return garden_area;
	}
	public void setGarden_area(Float garden_area) {
		this.garden_area = garden_area;
	}
	public Float getTerrace_area() {
		return terrace_area;
	}
	public void setTerrace_area(Float terrace_area) {
		this.terrace_area = terrace_area;
	}
	public String getHeating_type() {
		return heating_type;
	}
	public void setHeating_type(String heating_type) {
		this.heating_type = heating_type;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
}
