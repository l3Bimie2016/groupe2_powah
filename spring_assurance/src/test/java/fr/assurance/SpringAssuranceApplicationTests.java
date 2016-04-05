package fr.assurance;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.assurance.dao.RoleRepository;
import fr.assurance.entities.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringAssuranceApplication.class)
@WebAppConfiguration
public class SpringAssuranceApplicationTests {
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void createRole() {
		Role role = new Role();
		role.setName("Test");
		roleRepository.save(role);
	}
	
	@Test
	public void getRole() {
		Role role = roleRepository.findOne(1);
		assertEquals("Test", role.getName());
	}
	
	@Test
	public void updateRole() {
		Role role = roleRepository.findOne(1);
		role.setName("UpdatedName");
		roleRepository.save(role);
		
		Role updatedRole = roleRepository.findOne(1);
		assertEquals("UpdatedName", updatedRole.getName());
	}
	
	@Test
	public void deleteRole() {
		Role role = roleRepository.findOne(1);
		roleRepository.delete(role);
		assertNull(roleRepository.findOne(1));
	}
}
