package br.ufal.ic.systemComponents;
import java.util.ArrayList;

public class Collaborator {
	private Integer id;
	private String name;
	private String email;
	private TypeCollaborator type;
	private  ArrayList<ResearchProject> historicOfProjects;
	private ArrayList<Publication> academicProduction;
	
	public Collaborator(Integer id, String name, String email, TypeCollaborator type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.historicOfProjects = new ArrayList<ResearchProject>();
		this.academicProduction = new ArrayList<Publication>();
		this.type = type;
	}
	
	@Override
	public String toString() {
		String string = Integer.toString(this.id) + " " + this.name + " " + this.email;
		return string;
	}
	
	public TypeCollaborator getType() {
		return type;
	}

	public void setType(TypeCollaborator type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<ResearchProject> getHistoricOfProjects() {
		return historicOfProjects;
	}

	public ArrayList<Publication> getAcademicProduction() {
		return academicProduction;
	}

	
	
	
	
}
