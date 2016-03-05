package br.ufal.ic.systemComponents;
import java.util.ArrayList;

public class CollaboratorRepository<E> implements Repository<E> {
	
	private ArrayList<E> collaborators;
	
	public CollaboratorRepository() {
		this.collaborators = new ArrayList<E>();
	}
	
	@Override
	public void save(E element) {
		this.collaborators.add(element);
		
	}

	@Override
	public void update(E element) {
		
	}

	@Override
	public E findById(Integer id) throws Exception {
		Collaborator collaborator = null;
		
		for(int i = 0; i < this.collaborators.size(); i++){
			collaborator = (Collaborator)this.collaborators.get(i);
			collaborator.getId();
			
			if(collaborator.getId() == id.intValue()){
				return (E) collaborator;
			}
		}
		throw new Exception();
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<E> findAll() {
		return this.collaborators;
	}

}
