package br.ufal.ic.system;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import br.ufal.ic.systemComponents.Collaborator;
import br.ufal.ic.systemComponents.CollaboratorRepository;
import br.ufal.ic.systemComponents.Orientation;
import br.ufal.ic.systemComponents.OrientationRepository;
import br.ufal.ic.systemComponents.Publication;
import br.ufal.ic.systemComponents.PublicationRepository;
import br.ufal.ic.systemComponents.ResearchProject;
import br.ufal.ic.systemComponents.ResearchProjectRepository;
import br.ufal.ic.systemComponents.Status;
import br.ufal.ic.systemComponents.TypeCollaborator;

public class ProductivitySystem {
	private CollaboratorRepository<Collaborator> collaboratorRepository;
	private ResearchProjectRepository<ResearchProject> projectRepository;
	private OrientationRepository<Orientation> orientationRepository;
	private PublicationRepository<Publication> publicationRepository;
	
	public ProductivitySystem() {
		this.collaboratorRepository = new CollaboratorRepository<Collaborator>();
		this.projectRepository = new ResearchProjectRepository<ResearchProject>();
		this.orientationRepository = new OrientationRepository<Orientation>();
		this.publicationRepository = new PublicationRepository<Publication>();
		
		
		this.collaboratorRepository.save(new Collaborator(1, "Rodrigo", "rodrigo@ic.ufal.br", TypeCollaborator.TEACHER));
		this.collaboratorRepository.save(new Collaborator(2, "Baldoino", "baldoino@ic.ufal.br", TypeCollaborator.TEACHER));
		this.collaboratorRepository.save(new Collaborator(3, "Márcio", "marcio@ic.ufal.br", TypeCollaborator.TEACHER));
	
		this.collaboratorRepository.save(new Collaborator(4, "Júlia","julia@ic.ufal.br" , TypeCollaborator.RESEARCH));
		this.collaboratorRepository.save(new Collaborator(5, "Mario", "mario@ic.ufal.br", TypeCollaborator.RESEARCH));
		this.collaboratorRepository.save(new Collaborator(6, "Maria", "maria@ic.ufal.br", TypeCollaborator.RESEARCH));
		this.collaboratorRepository.save(new Collaborator(7, "José", "jose@ic.ufal.br", TypeCollaborator.RESEARCH));
		this.collaboratorRepository.save(new Collaborator(8, "Carlos", "carlos@ic.ufal.br", TypeCollaborator.RESEARCH));
		
		this.collaboratorRepository.save(new Collaborator(9, "André", "andre@ic.ufal.br", TypeCollaborator.GRADUATION_STUDENT));
		this.collaboratorRepository.save(new Collaborator(10, "Eduardo", "eduardo@ic.ufal.br", TypeCollaborator.GRADUATION_STUDENT));
		this.collaboratorRepository.save(new Collaborator(11, "Andressa", "andressa@ic.ufal.br", TypeCollaborator.GRADUATION_STUDENT));
		this.collaboratorRepository.save(new Collaborator(12, "Mayara", "mayara@ic.ufal.br", TypeCollaborator.GRADUATION_STUDENT));
		this.collaboratorRepository.save(new Collaborator(13, "Bruno", "bruno@ic.ufal.br", TypeCollaborator.GRADUATION_STUDENT));
		
		this.collaboratorRepository.save(new Collaborator(14, "Olga", "olga@ic.ufal.br", TypeCollaborator.MASTERS_DEGREE));
		this.collaboratorRepository.save(new Collaborator(15, "Marcos", "marcos@ic.ufal.br", TypeCollaborator.MASTERS_DEGREE));
		this.collaboratorRepository.save(new Collaborator(16, "Sandra", "sandra@ic.ufal.br", TypeCollaborator.MASTERS_DEGREE));
		this.collaboratorRepository.save(new Collaborator(17, "Gilmar", "gilmar@ic.ufal.br", TypeCollaborator.MASTERS_DEGREE));
		this.collaboratorRepository.save(new Collaborator(18, "Douglas", "douglas@ic.ufal.br", TypeCollaborator.MASTERS_DEGREE));
		
		this.collaboratorRepository.save(new Collaborator(19, "Jonas", "jonas@ic.ufal.br", TypeCollaborator.PHD_STUDENT));
		this.collaboratorRepository.save(new Collaborator(20, "Gabriel", "gabriel@ic.ufal.br", TypeCollaborator.PHD_STUDENT));
		this.collaboratorRepository.save(new Collaborator(21, "Gabriela", "gabriela@ic.ufal.br", TypeCollaborator.PHD_STUDENT));
		this.collaboratorRepository.save(new Collaborator(22, "Heitor", "heitor@ic.ufal.br", TypeCollaborator.PHD_STUDENT));
		this.collaboratorRepository.save(new Collaborator(23, "Fábio", "fabio@ic.ufal.br", TypeCollaborator.PHD_STUDENT));
	
	}
	
	public static void main(String[] args){
		ProductivitySystem productivitySystem = new ProductivitySystem();
		
		productivitySystem.createProject(3, "Novo tipo de banco de dados", "5/3/2016", "05/03/2018", "CAPES",
				2000000, "Contribuir com um método mais rápido de busca", "fadfadfdada", 1);
		
		productivitySystem.addCollaborator();
		productivitySystem.addCollaborator();
		try{
			productivitySystem.printListParticipants(productivitySystem.projectRepository.findById(new Integer(1)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public CollaboratorRepository<Collaborator> getCollaboratorRepository() {
		return collaboratorRepository;
	}
	public void setCollaboratorRepository(CollaboratorRepository<Collaborator> collaboratorRepository) {
		this.collaboratorRepository = collaboratorRepository;
	}
	public ResearchProjectRepository<ResearchProject> getProjectRepository() {
		return projectRepository;
	}
	public void setProjectRepository(ResearchProjectRepository<ResearchProject> projectRepository) {
		this.projectRepository = projectRepository;
	}
	public OrientationRepository<Orientation> getOrientationRepository() {
		return orientationRepository;
	}
	public void setOrientationRepository(OrientationRepository<Orientation> orientationRepository) {
		this.orientationRepository = orientationRepository;
	}
	public PublicationRepository<Publication> getPublicationRepository() {
		return publicationRepository;
	}
	public void setPublicationRepository(PublicationRepository<Publication> publicationRepository) {
		this.publicationRepository = publicationRepository;
	}
	
	
	public void createProject(Integer id, String title, String startDate, String endDate,
			String fundingAgency,double financedAmount, String objective, String description, Integer idProject){
		try{
			
			Collaborator collaborator = (Collaborator)this.collaboratorRepository.findById(id);
			
			if(collaborator.getType() != TypeCollaborator.TEACHER){
				throw new Exception();
			}
			
			ResearchProject researchProject = new ResearchProject(idProject, title, startDate, endDate,
					fundingAgency, financedAmount, objective, description, Status.IN_PREPARATION, collaborator);
			
			collaborator.getHistoricOfProjects().add(researchProject);
			this.projectRepository.save(researchProject);
			
		}catch(Exception e){
			System.out.println("Erro na criação do projeto");
		}
		
	}
	
	public void printResearchProject(){
		
		ArrayList<ResearchProject> researchProjects = (ArrayList<ResearchProject>)this.projectRepository.findAll(); 
		
		for(int i = 0; i < researchProjects.size(); i++){
			System.out.println(researchProjects.get(i).toString());
		}
	}
	
	public void printCollaborators(){
		ArrayList<Collaborator> collaborators = (ArrayList<Collaborator>)this.getCollaboratorRepository().findAll();
		
		for(int i = 0; i < collaborators.size(); i++){
			System.out.println(collaborators.get(i).toString());
		}
	
	}

	public void printListParticipants(ResearchProject researchProject){
		ArrayList<Collaborator> collaborators = researchProject.getParticipants();
		
		for(int i = 0; i < collaborators.size(); i++){
			System.out.println(collaborators.get(i).getName());
		}
	}
	
	public void addCollaborator(){
		Scanner scanner = new Scanner(System.in);
		int id, idProject;
		Collaborator collaborator;
		ResearchProject researchProject;
		
		try{
			System.out.println("Digite o id do colaborador");
			id = scanner.nextInt();
			
			System.out.println("Digite o id do projeto");
			idProject = scanner.nextInt();
			
			collaborator = (Collaborator)this.collaboratorRepository.findById(new Integer(id));
			researchProject = this.projectRepository.findById(new Integer(idProject));
			
			researchProject.getParticipants().add(collaborator);
			
		}catch(Exception e){
			System.out.println("Colaborador não encontrado ou projeto não encontrado");
		}
		
	}
}
