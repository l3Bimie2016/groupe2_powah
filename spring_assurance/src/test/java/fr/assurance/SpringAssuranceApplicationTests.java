package fr.assurance;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.assurance.dao.QuoteRepository;
import fr.assurance.dao.RoleRepository;
import fr.assurance.dao.UserRepository;
import fr.assurance.entities.Quote;
import fr.assurance.entities.Role;
import fr.assurance.entities.User;
import fr.assurance.entities.VehiculeQuote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringAssuranceApplication.class)
@WebAppConfiguration
public class SpringAssuranceApplicationTests {
	@Autowired
	private RoleRepository roleManager;
	
	@Autowired
	private UserRepository userManager;
	
	@Autowired
	private QuoteRepository quoteManager;
	
	@Test
	public void createRole() {
		Role role = new Role();
		role.setName("Test");
		roleManager.save(role);
	}
	
	@Test
	public void getRole() {
		Role role = roleManager.findOne(1);
		assertEquals("Test", role.getName());
	}
	
	@Test
	public void updateRole() {
		Role role = roleManager.findOne(1);
		role.setName("UpdatedName");
		roleManager.save(role);
		
		Role updatedRole = roleManager.findOne(1);
		assertEquals("UpdatedName", updatedRole.getName());
	}
	
	@Test
	public void createUser() throws ParseException {
		User user = new User();
		user.setForename("Lucien");
		user.setName("Bramard");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		user.setLicence_date(format.parse("21/12/2012"));
		user.setNb_crashes(0);
		user.setUsername("lucien.bramard");
		userManager.save(user);
	}
	
	@Test
	public void createQuote() {
		VehiculeQuote quote = new VehiculeQuote();
		quote.setName("TestQuote");
		quote.setDate(new Date());
		quote.setStreet("TestStreet");
		quote.setZip_code("35000");
		quote.setCity("AZER");
		quote.setBrand("TESTBrand");
		quote.setModel("TestModel");
		quote.setFiscal_horse_power("45WW");
		quote.setBonus_malus(23);
		quote.setSecond_driver("SecondDriver");
		quote.setIn_garage(true);
		quote.setContract_type("TestContract");
		quote.setTotal_price(new Float(22.3));
		quote.setStep(2);
		
		User user = userManager.findOne(1);
		quote.setOwner(user);
		
		quoteManager.save(quote);
	}
	
	@Test
	public void getUserQuotes() {
		User user = userManager.findOne(1);
		List<Quote> quotes = quoteManager.findByDone(true);
		for (Quote quote : quotes) {
			System.out.println(quote.getClass());
		}
	}
}
