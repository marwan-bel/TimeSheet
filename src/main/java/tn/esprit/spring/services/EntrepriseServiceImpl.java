package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	
	
	
	/////////////////////////////////// START HOUSSEM MODULE CRUD ENTREPRISE ////////////////////////////////////////
	
	
	public int ajouterEntreprise(Entreprise entreprise) {
		l.info("In  addEntreprise : " + entreprise); 
		entrepriseRepoistory.save(entreprise);
		l.info("Out of  addEntreprise. "); 
		return entreprise.getId();
	}
	
	@Override 
	public Entreprise updateEntreprise(Entreprise e) {
		l.info("In  updateEntreprise : " + e); 
		return entrepriseRepoistory.save(e);		
	}
	
	
	public void deleteEntrepriseById(int entrepriseId) {
		l.info("In  deleteEntreprise : " + entrepriseId); 
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("in  retrieveEntreprise id = " + entrepriseId);
			if( entrepriseRepoistory.existsById(entrepriseId)==false)
			{
				return null;
			}
			l.info("entreprise returned : " + entrepriseRepoistory.findById(entrepriseId).get());
			return entrepriseRepoistory.findById(entrepriseId).get();
	}
	
	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		l.info("In  retrieveAllEntreprises : "); 
		List<Entreprise> Entreprises = (List<Entreprise>) entrepriseRepoistory.findAll();  
		for (Entreprise e : Entreprises) {
			l.debug("entreprise +++ : " + e);
		}
		l.info("Out of retrieveAllEntreprises."); 
		return Entreprises;
	}
	
	///////////////////////////////////////// FINISH HOUSSEM MODULE CRUD ENTREPRISE /////////////////////////////

	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////START MODULE DEPARTEMENT//////////////////////////////////////////
	
	
	public int ajouterDepartement(Departement dep) {
		l.info("In  addDepartement : " + dep); 
		deptRepoistory.save(dep);
		l.info("Out of  addDepartement. "); 
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				l.info("In  EntrepriseId : " + entrepriseId);
				l.info("In  DepartementId : " + depId); 
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
				l.info("Out of  affectedDepartement. "); 
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.info("In  retrieveAllDepartementsNamesByEntreprise : "); 
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
			
		}
		l.info("Out of retrieveAllDepartementsNamesByEntreprise :"+depNames); 
		
		return depNames;
	}
	
	public Departement getDepartementById(int depId) {
		l.info("in  retrieveDepartement by id = " + depId);
			if( deptRepoistory.existsById(depId)==false)
			{
				return null;
			}
			l.info("dep returned : " + deptRepoistory.findById(depId).get());
			return deptRepoistory.findById(depId).get();
	}



	
	public void deleteDepartementById(int depId) {
		l.info("In  deleteEntreprise : " + depId);
		deptRepoistory.delete(getDepartementById(depId));	
	}




}
