package fr.assurance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.assurance.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	List<Role> findAll();
}
