package br.ufal.ic.systemComponents;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ResearchProject {
	private Integer id;
	private String title;
	private Status status;
	private Calendar startDate;
	private Calendar endDate;
	private String fundingAgency;
	private double financedAmount;
	private String objective;
	private String description;
	private ArrayList<Collaborator> participants;
	
	public ResearchProject(Integer id, String title, Calendar startDate, Calendar endDate, String fundingAgency
			, double financedAmount, String objective, String description,Status status, Collaborator collaborator) {
		
			
			
			this.id = id;
			this.title = title;
			this.status = status;
			this.startDate = startDate;
			this.endDate = endDate;
			this.fundingAgency = fundingAgency;
			this.financedAmount = financedAmount;
			this.objective = objective;
			this.description = description;
			this.participants = new ArrayList<Collaborator>();
			
			this.participants.add(collaborator);
		
		
		
		
		
	}

	public ResearchProject(Integer id, Collaborator collaborator, Status status) {
		this.id = id;
		this.status = status;
		this.participants = new ArrayList<Collaborator>();
		this.participants.add(collaborator);
		
	}
	
	@Override
	public String toString() {
		String string = Integer.toString(this.id.intValue()) + " "+ this.participants.get(0).getName() +" " + this.title + " " + this.objective;
		return string;
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
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	public String getFundingAgency() {
		return fundingAgency;
	}
	public void setFundingAgency(String fundingAgency) {
		this.fundingAgency = fundingAgency;
	}
	public double getFinancedAmount() {
		return financedAmount;
	}
	public void setFinancedAmount(double financedAmount) {
		this.financedAmount = financedAmount;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Collaborator> getParticipants() {
		return participants;
	}
	public void setParticipants(ArrayList<Collaborator> participants) {
		this.participants = participants;
	}
	
	
}
