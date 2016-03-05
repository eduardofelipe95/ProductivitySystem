package br.ufal.ic.systemComponents;
import java.util.ArrayList;
import java.util.Calendar;

public class Publication extends AcademicProduction{
	private Integer id;
	private String title;
	private String conferenceName;
	private Calendar yearOfPublication;
	private ArrayList<ResearchProject> researchProjectAssociaed;
	private ArrayList<Collaborator> authors;
}
