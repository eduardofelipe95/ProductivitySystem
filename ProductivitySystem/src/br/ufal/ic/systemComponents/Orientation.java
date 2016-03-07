package br.ufal.ic.systemComponents;
import java.util.ArrayList;

public class Orientation extends AcademicProduction{
	private Integer id;
	private Collaborator advisor;
	private ArrayList<Collaborator> students;
	
	public Orientation() {
		this.students = new ArrayList<Collaborator>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Collaborator getAdvisor() {
		return advisor;
	}
	public void setAdvisor(Collaborator advisor) {
		this.advisor = advisor;
	}
	public ArrayList<Collaborator> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Collaborator> students) {
		this.students = students;
	}
	
	
	
}
