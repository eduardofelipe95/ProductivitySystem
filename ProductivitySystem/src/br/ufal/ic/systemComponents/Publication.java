package br.ufal.ic.systemComponents;
import java.util.ArrayList;
import java.util.Calendar;

public class Publication extends AcademicProduction{
	private Integer id;
	private String title;
	private String conferenceName;
	private Calendar yearOfPublication;
	private ResearchProject researchProjectAssociaed;
	private ArrayList<Collaborator> authors;
	
	public Publication() {
		this.authors = new ArrayList<Collaborator>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}

	public Calendar getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Calendar yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public ResearchProject getResearchProjectAssociaed() {
		return researchProjectAssociaed;
	}

	public void setResearchProjectAssociaed(ResearchProject researchProjectAssociaed) {
		this.researchProjectAssociaed = researchProjectAssociaed;
	}

	public ArrayList<Collaborator> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Collaborator> authors) {
		this.authors = authors;
	}
	
}
