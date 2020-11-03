package tn.esprit.spring;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {

	@Autowired 
	IEntrepriseService us; 
	@Autowired
	DepartementRepository deptRepoistory;
	
	@Test
	public void testajouterDep() throws ParseException {
		
		Departement d = new Departement("Telecom");
		int departementAdded= us.ajouterDepartement(d); 
		
		assertEquals(d.getId(), departementAdded);
	}
	@Test
	public void testaffecterDepartementAEntreprise() throws ParseException {
		
		
		 us.affecterDepartementAEntreprise(10,1);
		 List<String>  depRetrieved = us.getAllDepartementsNamesByEntreprise(1);
		 String dep =us.getDepartementById(10).getName();
		 assertThat(depRetrieved, hasItems(dep));

					
	}
	
	@Test
	public void testRetrieveDepByEntreId() {
		List<String> depRetrieved = us.getAllDepartementsNamesByEntreprise(1); 
		assertEquals(1, depRetrieved.size());
	}
	
	@Test
	public void testdeleteDep() throws ParseException {


		us.deleteDepartementById(13); 
		//assertNull(us.getDepartementById(13));			

			
	}
	
	
	

}
