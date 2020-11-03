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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTests {
	
	@Autowired 
	IEmployeService es; 
	IContratService cs;

	
	
	/////////////////////////////////// START MODULE CONTRAT ////////////////////////////////////////

	@Test
	public void testajouterContrat() throws ParseException {
		
		Contrat c = new Contrat(null, "type0", 0);
		int contratAdded= es.ajouterContrat(c); 
		
		assertEquals(c.getEmploye(), contratAdded);
	}
	
	 
	 
	
	 
	
	///////////////////////////////////////// FINISH MODULE CONTRAT /////////////////////////////

	
	
	
	
	
	

}
