package br.ufal.ic.systemComponents;
import java.util.ArrayList;

import br.ufal.ic.exceptions.CollaboratorNotFound;

public class CollaboratorRepository implements Repository<Collaborator> {
	
	private ArrayList<Collaborator> collaborators;
	
	public CollaboratorRepository() {
		this.collaborators = new ArrayList<Collaborator>();
	}
	
	@Override
	public void save(Collaborator element) {
		this.collaborators.add(element);
		
	}

	@Override
	public void update(Collaborator element) {
		
	}

	@Override
	public Collaborator findById(Integer id) throws Exception {
		Collaborator collaborator = null;
		
		for(int i = 0; i < this.collaborators.size(); i++){
			collaborator = this.collaborators.get(i);
			collaborator.getId();
			
			if(collaborator.getId() == id.intValue()){
				return collaborator;
			}
		}
		throw new CollaboratorNotFound("**Colaborador não encontrado**");
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Collaborator> findAll() {
		return collaborators;
	}

}
