package br.ufal.ic.systemComponents;
import java.util.ArrayList;

public interface Repository<E> {
	public void save(E element);
	public void update(E element);
	public E findById(Integer id) throws Exception;
	public void delete(Integer id);
	public ArrayList<E> findAll();
	
	

}
