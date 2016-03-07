package br.ufal.ic.systemComponents;
import java.util.ArrayList;

public class OrientationRepository implements Repository<Orientation>{
	
	private ArrayList<Orientation> orientation;
	
	public OrientationRepository() {
		this.orientation = new ArrayList<Orientation>();
	}

	@Override
	public void save(Orientation element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Orientation element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orientation findById(Integer id) throws Exception {
		Orientation orientation = null;
		
		for(int i = 0; i < this.orientation.size(); i++){
			orientation = this.orientation.get(i);
			
			
			if(orientation.getId() == id.intValue()){
				return orientation;
			}
		}
		throw new Exception();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Orientation> findAll() {
		return this.orientation;
	}

}
