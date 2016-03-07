package br.ufal.ic.systemComponents;
import java.util.ArrayList;

public class PublicationRepository implements Repository<Publication>{
	private ArrayList<Publication> publications;

	public PublicationRepository() {
		this.publications = new ArrayList<Publication>();
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
	public void save(Publication element) {
		this.publications.add(element);
		
	}

	@Override
	public void update(Publication element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Publication findById(Integer id) throws Exception {
		Publication publication = null;
		
		for(int i = 0; i < this.publications.size(); i++){
			publication = this.publications.get(i);
			System.out.println(publication.getId().intValue());
			
			if(publication.getId() == id.intValue()){
				return publication;
			}
		}
		throw new Exception("Publicação não encontrada");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Publication> findAll() {
		return this.publications;
	}

}
