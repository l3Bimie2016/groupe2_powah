package fr.assurance.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private int version;
	
	@NotNull
	private String name;
	
	@NotNull
	private String forename;
	
	@NotNull
	private String username;
	
	private Date licence_date;
	
	@NotNull
	private Integer nb_crashes;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "userId", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "roleId",
                    nullable = false, updatable = false) })
    private List<Role> roles;

	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	private List<Quote> quotes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLicence_date() {
		return licence_date;
	}

	public void setLicence_date(Date licence_date) {
		this.licence_date = licence_date;
	}

	public Integer getNb_crashes() {
		return nb_crashes;
	}

	public void setNb_crashes(Integer nb_crashes) {
		this.nb_crashes = nb_crashes;
	}
	
	public boolean add(fr.assurance.entities.Role role) {
		return roles.add(role);
	}

	public boolean contains(Role role) {
		return roles.contains(role);
	}

	public boolean remove(Role role) {
		return roles.remove(role);
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public boolean add(Quote e) {
		return quotes.add(e);
	}

}
