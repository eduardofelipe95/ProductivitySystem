package br.ufal.ic.systemComponents;
import java.util.ArrayList;

import br.ufal.ic.exceptions.CollaboratorNotFound;
import br.ufal.ic.exceptions.ResearchProjectNotFoundException;

public class ResearchProjectRepository implements Repository<ResearchProject>{

	private ArrayList<ResearchProject> researchProjects;
	
	public ResearchProjectRepository() {
		this.researchProjects = new ArrayList<ResearchProject>();
	}
	
	@Override
	public void save(ResearchProject element) {
		this.researchProjects.add(element);
		
	}

	@Override
	public void update(ResearchProject element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResearchProject findById(Integer id) throws Exception {
		ResearchProject researchProject = null;
		
		for(int i = 0; i < this.researchProjects.size(); i++){
			researchProject = this.researchProjects.get(i);
			
			
			if(researchProject.getId() == id.intValue()){
				return researchProject;
			}
		}
		throw new ResearchProjectNotFoundException("**Projeto não encontrado**");
		
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ResearchProject> findAll() {
		return this.researchProjects;
	}

	public ArrayList<ResearchProject> getResearchProjects() {
		return researchProjects;
	}

	public void setResearchProjects(ArrayList<ResearchProject> researchProjects) {
		this.researchProjects = researchProjects;
	}
	
	

}
