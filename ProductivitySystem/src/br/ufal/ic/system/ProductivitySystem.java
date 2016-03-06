package br.ufal.ic.system;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.ufal.ic.exceptions.CollaboratorNotFound;
import br.ufal.ic.exceptions.ResearchProjectNotFoundException;
import br.ufal.ic.exceptions.TypeException;
import br.ufal.ic.exceptions.WrongChoiceException;
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
	
	public static void main(String[] args) throws InputMismatchException{
		ProductivitySystem productivitySystem = new ProductivitySystem();
		int id = 0, input;
		boolean end = false;
		Scanner scanner = new Scanner(System.in);
		
	
		Collaborator collaborator = new Collaborator(new Integer(0), "ed", "dsd", TypeCollaborator.GRADUATION_STUDENT);
		collaborator.setType(TypeCollaborator.PHD_STUDENT);
		if(collaborator.getType() == TypeCollaborator.PHD_STUDENT)
			System.out.println("deu ceto");
		
		while(!end){
			System.out.println("Digite sua opção:\n" + "1-Adicionar projeto\n" + "2-Adicionar colaborador\n" +
		"3-Alterar status\n" + "10-Imprimir projetos");
			try{
				scanner = new Scanner(System.in);
				input = scanner.nextInt();
				
				if(input == 1){
					productivitySystem.createProject(new Integer(id));
					id++;
				}else if(input == 2){
					productivitySystem.addCollaborator();
				}else if(input == 10){
					productivitySystem.printResearchProject();
				}else if(input == 3){
					productivitySystem.changeStatus();
				}
				else{
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e){
				System.out.println("**Digite uma opção válida**");
			}
			
			
		}
		
		scanner.close();
		
		
		
		
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
	
	public void createProject(Integer idProject){
		try{
			Scanner scanner = new Scanner(System.in);// para inteiros
			Scanner scanner2 = new Scanner(System.in);//para Strings
			Scanner scanner3 = new Scanner(System.in);//para double
			
			int input, id;
			double financedAmount;
			String title, startDate, endDate,fundingAgency, objective, description;
			
			System.out.println("Deseja informar as informações básicas do projeto?\n" + "1-Sim\n" + "2-não");
			input = scanner.nextInt();
			
			if(!(input == 1 || input == 2)){
				throw new WrongChoiceException("Essa opção não existe");
			}
			
			if(input == 1){
				System.out.println("Digite o id do professor responsável pela criação do projeto");
				
				input = scanner.nextInt();
				
				Collaborator collaborator = (Collaborator)this.collaboratorRepository.findById(new Integer(input));
				
				if(collaborator.getType() != TypeCollaborator.TEACHER){
					throw new TypeException("**O colaborador não pode criar projeto, ele não é um professor**");
				}
				
				System.out.println("Digite o título do projeto");
				title = scanner2.nextLine();
				
				System.out.println("Digite a data de início no formato dd/mm/aaaa");
				startDate = scanner2.nextLine();
				
				System.out.println("Digite a data de término no formato dd/mm/aaaa");
				endDate = scanner2.nextLine();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(startDate));
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(sdf2.parse(endDate));
				
				System.out.println("Digite o nome da agência financiadora");
				fundingAgency = scanner2.nextLine();
				
				System.out.println("Digite o valor financiado");
				financedAmount = scanner3.nextDouble();
				
				System.out.println("Digite o objetivo");
				objective = scanner2.nextLine();
				
				System.out.println("Digite a descrição");
				description = scanner2.nextLine();
				
				
				ResearchProject researchProject = new ResearchProject(idProject, title, cal, cal2,
						fundingAgency, financedAmount, objective, description, Status.IN_PREPARATION, collaborator);

				collaborator.getHistoricOfProjects().add(researchProject);
				this.projectRepository.save(researchProject);
			}else if(input == 2){
				Collaborator collaborator = (Collaborator)this.collaboratorRepository.findById(new Integer(input));
				
				if(collaborator.getType() != TypeCollaborator.TEACHER){
					throw new TypeException("**O colaborador não pode criar projeto, ele não é um professor**");
				}
				
				ResearchProject researchProject = new ResearchProject(idProject, collaborator,Status.IN_PREPARATION);
				
				collaborator.getHistoricOfProjects().add(researchProject);
				this.projectRepository.save(researchProject);
				
			}
			
			
			
		}catch (InputMismatchException e) {
			System.out.println("**Valor inválido**");
			System.out.println("**Não foi possível criar um projeto**");
			
		}catch(WrongChoiceException w){
			System.out.println(w.getMessage());
			System.out.println("**Não foi possível criar um projeto**");
		
		}catch (TypeException t) {
			System.out.println(t.getMessage());
			System.out.println("**Não foi possível criar um projeto**");
		
		}catch (ParseException p) {
			System.out.println("**Data errada**");
			System.out.println("**Não foi possível criar um projeto**");
			
		}
		catch(CollaboratorNotFound c){
			System.out.println(c.getMessage());
			System.out.println("**Não foi possível criar um projeto**");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("**Não foi possível criar um projeto**");
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
			
			if(researchProject.getStatus() == Status.IN_PREPARATION){
				researchProject.getParticipants().add(collaborator);
			}else{
				throw new Exception("**O projeto não está em processo de elaboração**");
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	public void changeStatus(){
		int input;
		ArrayList<ResearchProject> listProjects = new ArrayList<ResearchProject>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1-Modificar status para em andamento\n2-Modificar status para concuído");
		input = scanner.nextInt();
		
		if(input == 1){
			for(int i = 0; i < this.projectRepository.getResearchProjects().size(); i++){
				if(this.projectRepository.getResearchProjects().get(i).getStatus() == Status.IN_PREPARATION
						&& projectRepository.getResearchProjects().get(i).containsBasicData()){
					listProjects.add(this.projectRepository.getResearchProjects().get(i));
				}
			}
			for(int i = 0; i < listProjects.size(); i++){
				System.out.println(i +"| ->"+ listProjects.get(i).getId());
			}
			int  input2;
			Scanner scanner2 = new Scanner(System.in);
			if(!listProjects.isEmpty()){
				System.out.println("Qual projeto você quer editar?");
				input2 = scanner2.nextInt();
				
				if(input2 >= 0 && input2 < listProjects.size()){
					listProjects.get(input2).setStatus(Status.IN_PROGRESS);
				}else{
					System.out.println("**Erro**");
				}
				
				if(listProjects.get(input2).getStatus() == Status.IN_PROGRESS){
					System.out.println("Deu ceto");
				}
			}
		}else if(input == 2){
			for(int i = 0; i < this.projectRepository.getResearchProjects().size(); i++){
				if(this.projectRepository.getResearchProjects().get(i).getStatus() == Status.IN_PROGRESS){
					listProjects.add(this.projectRepository.getResearchProjects().get(i));
				}
			}
			for(int i = 0; i < listProjects.size(); i++){
				System.out.println(i +"| ->"+ listProjects.get(i).getId());
			}
			
			if(!listProjects.isEmpty()){
				int  input2;
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("Qual projeto você quer editar?");
				input2 = scanner2.nextInt();
				
				if(input2 >= 0 && input2 < listProjects.size()){
					if(this.publicationRepository.isAssociated(listProjects.get(input2).getId())){
						listProjects.get(input2).setStatus(Status.COMPLETED);
					}else{
						System.out.println("O projeto não contém nenhuma publicação associada");
					}
					
				}else{
					System.out.println("**Erro**");
				}
				
				if(listProjects.get(input2).getStatus() == Status.COMPLETED){
					System.out.println("Deu ceto");
				}
			}
		}
		
		
	}
	
	
}
