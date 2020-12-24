package tn.esprit.spring;

import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;







@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTests {
	 ////
	@Autowired 
	IEmployeService us; 

	
	

	@Test
	public void testajouterEmploye() throws ParseException {
		
		Employe e = new Employe(0, "new", "world", null, null, false, null);
		int employeAdded= us.ajouterEmploye(e); 
		
		assertEquals(e.getId(), employeAdded);
	}
	
	@Test
	public void testupdateemploye() throws ParseException {
		
		Employe e = new Employe(3,"update", "world", null, null, false, null);

		Employe employeAdded= us.updateEmploye(e); 
		assertEquals(e.getPrenom(), employeAdded.getPrenom());
		assertEquals(e.getNom(), employeAdded.getNom());
	}
	
	@Test
	public void testdeleteEmploye() throws ParseException {

		us.deleteEmployeById(74); 		
	    			
	}
	
	
	
	@Test
	public void testRetrieveAllEmploye() {
		
		List<Employe> Employes = us.getAllEmployes(); 
		assertEquals(89, Employes.size());
	}
	

	
	
	
	
	
	

}
