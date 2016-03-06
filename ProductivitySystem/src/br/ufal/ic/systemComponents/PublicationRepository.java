package br.ufal.ic.systemComponents;
import java.util.ArrayList;

public class PublicationRepository<E> implements Repository<E>{
	private ArrayList<E> publications;

	public PublicationRepository() {
		this.publications = new ArrayList<E>();
	}
	
	public boolean isAssociated(Integer idProject){
		ArrayList<Publication> publications = (ArrayList<Publication>)this.publications;
		
		for( int i = 0; i < this.publications.size(); i++){
			if(publications.get(i).getResearchProjectAssociaed().getId().intValue() == idProject.intValue()){
				return true;
				
			}
		}
		return false;
	}
	
	@Override
	public void save(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<E> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
