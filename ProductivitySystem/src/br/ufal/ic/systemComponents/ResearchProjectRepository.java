package br.ufal.ic.systemComponents;
import java.util.ArrayList;

import br.ufal.ic.exceptions.CollaboratorNotFound;
import br.ufal.ic.exceptions.ResearchProjectNotFoundException;

public class ResearchProjectRepository<E> implements Repository<E>{

	private ArrayList<E> researchProjects;
	
	public ResearchProjectRepository() {
		this.researchProjects = new ArrayList<E>();
	}
	
	@Override
	public void save(E element) {
		this.researchProjects.add(element);
		
	}

	@Override
	public void update(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E findById(Integer id) throws Exception {
		ResearchProject researchProject = null;
		
		for(int i = 0; i < this.researchProjects.size(); i++){
			researchProject = (ResearchProject)this.researchProjects.get(i);
			
			
			if(researchProject.getId() == id.intValue()){
				return (E) researchProject;
			}
		}
		throw new ResearchProjectNotFoundException("**Projeto não encontrado**");
		
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<E> findAll() {
		return this.researchProjects;
	}

	public ArrayList<E> getResearchProjects() {
		return researchProjects;
	}

	public void setResearchProjects(ArrayList<E> researchProjects) {
		this.researchProjects = researchProjects;
	}
	
	

}
