package fr.assurance.dao;

import org.springframework.data.repository.CrudRepository;

import fr.assurance.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
