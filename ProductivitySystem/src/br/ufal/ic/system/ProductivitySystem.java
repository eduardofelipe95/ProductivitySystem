package br.ufal.ic.system;
import java.lang.reflect.Array;
import java.text.DateFormat;
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
	private CollaboratorRepository collaboratorRepository;
	private ResearchProjectRepository projectRepository;
	private OrientationRepository orientationRepository;
	private PublicationRepository publicationRepository;
	
	public ProductivitySystem() {
		this.collaboratorRepository = new CollaboratorRepository();
		this.projectRepository = new ResearchProjectRepository();
		this.orientationRepository = new OrientationRepository();
		this.publicationRepository = new PublicationRepository();
		
		
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
		int id = 4, input, idPublication = 0;
		boolean end = false;
		Scanner scanner = new Scanner(System.in);
		
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse("12/12/12"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		DateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		sdf2.setLenient(false);
		Calendar cal2 = Calendar.getInstance();
		try {
			cal2.setTime(sdf2.parse("12/12/12"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			productivitySystem.projectRepository.save(new ResearchProject(1, "Teste1", cal, cal2, "Capes", 12, "nada", "nada", Status.IN_PREPARATION, productivitySystem.collaboratorRepository.findById(new Integer(1))));
		} catch (CollaboratorNotFound e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		Calendar cal4 = Calendar.getInstance();
		
		try {
			cal4.setTime(sdf2.parse("12/12/14"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			productivitySystem.projectRepository.save(new ResearchProject(2, "Teste2", cal, cal4, "Capes", 12, "nada", "nada", Status.IN_PREPARATION, productivitySystem.collaboratorRepository.findById(new Integer(1))));
		} catch (CollaboratorNotFound e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Calendar cal5 = Calendar.getInstance();
		try {
			
			cal5.setTime(sdf2.parse("12/12/13"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			productivitySystem.projectRepository.save(new ResearchProject(3, "Teste3", cal, cal5, "Capes", 12, "nada", "nada", Status.IN_PREPARATION, productivitySystem.collaboratorRepository.findById(new Integer(1))));
		} catch (CollaboratorNotFound e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("****Já existem colaboradores cadastrados e 3 projetos cadastrados, projeto 1, projeto 2 e projeto 3***\n");
		
		while(!end){
			System.out.println("\nDigite sua opção:\n" + "1-Adicionar projeto\n" +"2-Editar projeto\n" + "3-Adicionar colaborador\n" +
		"4-Alterar status\n"+ "5-Adicionar produção acadêmica\n"+ "6-Editar publicação\n" +"7-consultar\n"+"8-Relatório do sistema\n");
			try{
				scanner = new Scanner(System.in);
				input = scanner.nextInt();
				
				if(input == 1){
					productivitySystem.createProject(new Integer(id));
					id++;
				}else if(input == 2){
					productivitySystem.editProject();
				}else if(input == 3){
					productivitySystem.addCollaborator();
				}else if(input == 4){
					productivitySystem.changeStatus();
				}else if(input == 5){
					productivitySystem.addAcademicProduction(idPublication);
					idPublication++;
				}else if(input == 6){
					productivitySystem.editPublication();
				}else if(input == 7){
					productivitySystem.consultations();
				}else if(input == 8){
					productivitySystem.report();
				}else{
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e){
				System.out.println("**Digite uma opção válida**");
			}
			
			
		}
		
		scanner.close();
		
		
		
		
	}
	
	public CollaboratorRepository getCollaboratorRepository() {
		return collaboratorRepository;
	}
	public void setCollaboratorRepository(CollaboratorRepository collaboratorRepository) {
		this.collaboratorRepository = collaboratorRepository;
	}
	public ResearchProjectRepository getProjectRepository() {
		return projectRepository;
	}
	public void setProjectRepository(ResearchProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	public OrientationRepository getOrientationRepository() {
		return orientationRepository;
	}
	public void setOrientationRepository(OrientationRepository orientationRepository) {
		this.orientationRepository = orientationRepository;
	}
	public PublicationRepository getPublicationRepository() {
		return publicationRepository;
	}
	public void setPublicationRepository(PublicationRepository publicationRepository) {
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
				
				Collaborator collaborator = this.collaboratorRepository.findById(new Integer(input));
				
				if(collaborator.getType() != TypeCollaborator.TEACHER){
					throw new TypeException("**O colaborador não pode criar projeto, ele não é um professor**");
				}
				
				System.out.println("Digite o título do projeto");
				title = scanner2.nextLine();
				
				System.out.println("Digite a data de início no formato dd/mm/aaaa");
				startDate = scanner2.nextLine();
				
				System.out.println("Digite a data de término no formato dd/mm/aaaa");
				endDate = scanner2.nextLine();
				
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.setLenient(false);
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(startDate));
				
				
				DateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
				sdf2.setLenient(false);
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(sdf2.parse(endDate));
				
				if(cal.after(cal2)){
					throw new Exception("**Erro nas datas de início e término**");
				}
				
				System.out.println("Digite o nome da agência financiadora");
				fundingAgency = scanner2.nextLine();
				
				System.out.println("Digite o valor financiado");
				financedAmount = scanner3.nextDouble();
				
				if(financedAmount < 0){
					throw new Exception("**Valor inválido**");
				}
				
				System.out.println("Digite o objetivo");
				objective = scanner2.nextLine();
				
				System.out.println("Digite a descrição");
				description = scanner2.nextLine();
				
				
				ResearchProject researchProject = new ResearchProject(idProject, title, cal, cal2,
						fundingAgency, financedAmount, objective, description, Status.IN_PREPARATION, collaborator);

				collaborator.getHistoricOfProjects().add(researchProject);
				this.projectRepository.save(researchProject);
			}else if(input == 2){
				int id2;
				Scanner scanner4 = new Scanner(System.in);
				
				System.out.println("digite o id do Professor responsável");
				id2 = scanner4.nextInt();
				
				Collaborator collaborator = this.collaboratorRepository.findById(new Integer(id2));
				
				if(collaborator.getType() != TypeCollaborator.TEACHER){
					throw new TypeException("**O colaborador não pode criar projeto, ele não é um professor**");
				}
				
				ResearchProject researchProject = new ResearchProject(idProject, collaborator,Status.IN_PREPARATION);
				
				collaborator.getHistoricOfProjects().add(researchProject);
				this.projectRepository.save(researchProject);
				
			}
			
			System.out.println("id do projeto ->  " + idProject.intValue());
			
			
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
		
		ArrayList<ResearchProject> researchProjects = this.projectRepository.findAll(); 
	
		for(int i = 0; i < researchProjects.size(); i++){
			System.out.println(researchProjects.get(i).toString());
		}
	}
	
	public void printCollaborators(){
		ArrayList<Collaborator> collaborators = this.getCollaboratorRepository().findAll();
		
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
			
			collaborator = (Collaborator)this.collaboratorRepository.findById(new Integer(id));
			
			System.out.println("Digite o id do projeto");
			idProject = scanner.nextInt();
			
			researchProject = this.projectRepository.findById(new Integer(idProject));
			
			if(researchProject.getStatus() == Status.IN_PREPARATION){
				collaborator.getHistoricOfProjects().add(researchProject);
				researchProject.getParticipants().add(collaborator);
			}else{
				throw new Exception("**O projeto não está em processo de elaboração**");
			}
			
		}catch (InputMismatchException I) {
			System.out.println("**Digite uma opção válida**");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	public void changeStatus(){
		int input;
		ArrayList<ResearchProject> listProjects = new ArrayList<ResearchProject>();
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("1-Modificar status para em andamento\n2-Modificar status para concuído");
			input = scanner.nextInt();
		
			if(input == 1){
				for(int i = 0; i < this.projectRepository.findAll().size(); i++){
					if(this.projectRepository.findAll().get(i).getStatus() == Status.IN_PREPARATION
							&& projectRepository.findAll().get(i).containsBasicData()){
						listProjects.add(this.projectRepository.findAll().get(i));
					}
				}
				for(int i = 0; i < listProjects.size(); i++){
					System.out.println("número do projeto ->" + i +"| id do projeto ->"+ listProjects.get(i).getId());
				}
				int  input2;
				Scanner scanner2 = new Scanner(System.in);
				if(!listProjects.isEmpty()){
					System.out.println("Escolha o número do projeto que você deseja mudar o status");
					input2 = scanner2.nextInt();
					
					if(input2 >= 0 && input2 < listProjects.size() && checkConditionOfUndergraduates(listProjects.get(input2).getParticipants())){
						listProjects.get(input2).setStatus(Status.IN_PROGRESS);
					}else{
						System.out.println("**Erro**");
					}
				}
			}else if(input == 2){
				for(int i = 0; i < this.projectRepository.findAll().size(); i++){
					if(this.projectRepository.findAll().get(i).getStatus() == Status.IN_PROGRESS){
						listProjects.add(this.projectRepository.findAll().get(i));
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
				}else{
					throw new Exception("**Digite uma opção válida**");
				}
			}
		}catch(InputMismatchException i){
			System.out.println("**Digite uma opção válida**");
		} catch (Exception e) {
			System.out.println("**Digite uma opção válida**");
		}
		
		
	}
	
	public boolean checkConditionOfUndergraduates(ArrayList<Collaborator> collaborators){
			int input;
			Scanner scanner;
		try{
			for(int i = 0; i < collaborators.size(); i++){
				if(collaborators.get(i).getType() == TypeCollaborator.GRADUATION_STUDENT
						&& collaborators.get(i).engagedInMoreThanOneProjectInProgress()){
					
					System.out.println("O aluno " + collaborators.get(i).getName() + 
							" já está em outro projeto, deseja remove-ĺo?\n1-sim\n2-não");
					while(true){
						scanner = new Scanner(System.in);
						input = scanner.nextInt();
						if(input == 1 || input == 2){
							break;
						}else{
							System.out.println("**Escolha uma opção válida**");
						}
					}
					if(input == 1){
						collaborators.remove(i);
						i--;
					}else{
						return false;
					}
				}
			}
		}catch(InputMismatchException inputMismatchException){
			System.out.println("Digite uma opção válida");
		}
			return true;
			
	}
	public void addAcademicProduction(Integer idPublication){
		int input, id, idAluno; 
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		try{
			System.out.println("1-Orientação\n2-Publicação");
			input = scanner.nextInt();
			if(input == 1){
				Collaborator collaborator, advisor;
				System.out.println("Digite o id do orientador");
				id = scanner.nextInt();
				advisor = this.collaboratorRepository.findById(id);
				
				System.out.println("Digite o id do aluno");
				idAluno = scanner.nextInt();
				collaborator = this.collaboratorRepository.findById(idAluno);
				System.out.println(collaborator.getName());
				
				if(collaborator.getType() == TypeCollaborator.RESEARCH || collaborator.getType() == TypeCollaborator.TEACHER){
					throw new TypeException("O colaborador não é um aluno");
				}
				Orientation orientation;
				try{
					orientation = this.orientationRepository.findById(new Integer(id));
					orientation.getStudents().add(collaborator);
					
				}catch (Exception e) {
					
					orientation = new Orientation();
					orientation.setAdvisor(advisor);
					orientation.setId(id);
					orientation.getStudents().add(collaborator);
					this.orientationRepository.findAll().add(orientation);
				}
				
				
				
				
			}else if(input == 2){
				String title, conferenceName, date;
				int idProject,idAuthor;
				Scanner scanner2 = new Scanner(System.in);
				Scanner scanner3 = new Scanner(System.in);
				
				System.out.println("Digite o título da publicação");
				title = scanner2.nextLine();
				
				if(title.length() == 0){
					throw new Exception("você não digitou nada");
				}
				
				System.out.println("Digite o nome da conferência");
				conferenceName = scanner2.nextLine();
				
				if(conferenceName.length() == 0){
					throw new Exception("você não digitou nada");
				}
				System.out.println("Digie o ano de publicação");
				Scanner scanner4 = new Scanner(System.in);
				int year = scanner4.nextInt();
				
				if(year <= 0){
					throw new Exception("Digite um valor válido");
				}
				
				System.out.println("Digite o id do projeto de pesquisa associado");
				idProject = scanner3.nextInt();
				
				ResearchProject researchProject = this.projectRepository.findById(idProject);
				
				if(researchProject.getStatus() != Status.IN_PROGRESS){
					researchProject = null;
					System.out.println("A publicação não foi associada ao projeto, ele não está em progresso");
				}
				
				System.out.println("Digite o id do autor");
				idAuthor = scanner3.nextInt();
				
				Collaborator collaborator = this.collaboratorRepository.findById(new Integer(idAuthor));
				
				
				
				Publication publication = new Publication();
				
				publication.getAuthors().add(collaborator);
				publication.setConferenceName(conferenceName);
				publication.setId(idPublication);
				publication.setResearchProjectAssociaed(researchProject);
				publication.setTitle(title);
				publication.setYearOfPublication(year);
				
				this.publicationRepository.save(publication);
				collaborator.getAcademicProduction().add(publication);
			
				System.out.println("id da publicação -> " + idPublication.intValue());
			}
		}catch(CollaboratorNotFound c){
			System.out.println(c.getMessage());
		}catch (InputMismatchException i) {
			System.out.println("Digite um valor válido");
		} catch (TypeException t) {
			System.out.println(t.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public void editProject(){
		int id;
		ResearchProject researchProject;
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		
		
		
		try {
			System.out.println("digite o id do projeto que deseja modificar");
			id = scanner.nextInt();
			int input2;
			Scanner scan = new Scanner(System.in);
			researchProject = this.projectRepository.findById(id);
			
			if(researchProject.getStatus() != Status.IN_PREPARATION){
				throw new ResearchProjectNotFoundException("Projeto não pode ser modificado");
			}
			
			System.out.println("Deseja modificar o título?\n1-Sim\n2-Não");
			input2 = scan.nextInt();
			
			
			if(input2 == 1){
				System.out.println("Digite o título do projeto");
				String title = scanner2.nextLine();
				researchProject.setTitle(title);
			}else if(input2 != 2){
				throw new Exception("**Digite uma opção válida**");
			}
			
			System.out.println("Deseja modificar as datas?\n1-Sim\n2-Não");
			input2 = scan.nextInt();
			
			if(input2 == 1){
				System.out.println("Digite as data de início no formato dd/mm/aaaa");
				String startDate = scanner2.nextLine();
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.setLenient(false);
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(startDate));
				
				
				System.out.println("Digite a data de término no formato dd/mm/aaaa");
				String endDate = scanner2.nextLine();
				
				DateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
				sdf2.setLenient(false);
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(sdf2.parse(endDate));
				
				
				if(cal.after(cal2)){
					throw new Exception("**Erro nas datas de início e término**");
				}
				researchProject.setStartDate(cal2);
				researchProject.setEndDate(cal);
				
			}else if(input2 != 2){
				throw new Exception("**Digite uma opção válida**");
			}
			
			System.out.println("Deseja modificar a agência financiadora?\n1-Sim\n2-Não");
			input2 = scan.nextInt();
			
			if(input2 == 1){
				System.out.println("Digite o nome da agência financiadora");
				String fundingAgency = scanner2.nextLine();
				researchProject.setFundingAgency(fundingAgency);
			}else if(input2 != 2){
				throw new Exception("**Digite uma opção válida**");
			}
			
			System.out.println("Deseja modificar o valor financiado?\n1-Sim\n2-Não");
			input2 = scan.nextInt();
			
			if(input2 == 1){
			
				System.out.println("Digite o valor financiado");
				Scanner scanner3 = new Scanner(System.in);
				double financedAmount = scanner3.nextDouble();
				if(financedAmount < 0){
					throw new Exception("Valor inválido");
				}
				researchProject.setFinancedAmount(financedAmount);
			}else if(input2 != 2){
				throw new Exception("**Digite uma opção válida**");
			}
				
			System.out.println("Deseja modificar o objetivo?\n1-Sim\n2-Não");
			input2 = scan.nextInt();
			
			if(input2 == 1){
			
				System.out.println("Digite o objetivo");
				String objective = scanner2.nextLine();
				researchProject.setObjective(objective);
			}else if(input2 != 2){
				throw new Exception("**Digite uma opção válida**");
			}

			System.out.println("Deseja modificar o descrição?\n1-Sim\n2-Não");
			input2 = scan.nextInt();
			
			if(input2 == 1){
				System.out.println("Digite a descrição");
				String description = scanner2.nextLine();
				
				researchProject.setDescription(description);
			}else if(input2 != 2){
				throw new Exception("**Digite uma opção válida**");
			}
			
			
		} catch (ResearchProjectNotFoundException r) {
			System.out.println(r.getMessage());
		} catch (ParseException e) {
			System.out.println("Data errada");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public void printOrientation(){
		int id;
		Scanner scanner = new Scanner(System.in);
		
		id = scanner.nextInt();
		
		
		Orientation orientation;
		try {
			orientation = this.orientationRepository.findById(id);
			for(int i = 0; i < orientation.getStudents().size(); i++){
				System.out.println(orientation.getStudents().get(i).getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public void printPublication(){
		int id;
		
		
		try {
			ArrayList<Publication> publications = this.publicationRepository.findAll();
			for(int i = 0; i < publications.size(); i++){
				System.out.println(publications.get(i).getId().intValue() + publications.get(i).getTitle());
			}
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public void editPublication(){
		Scanner scanner = new Scanner(System.in);
		int input, id, idProject, idPublication;
		
		
		try{
			System.out.println("Digite o id da publicação");
			idPublication = scanner.nextInt();
			
			Publication publication = this.publicationRepository.findById(new Integer(idPublication));
			
			System.out.println("1-Adicionar autor\n2-Adicionar projeto de pesquisa relacionado");
			input = scanner.nextInt();
			
			
			
			if(!(input == 1 || input == 2)){
				throw new Exception("Digite uma opção válida");
			}
			
			if(input == 1){
				Collaborator collaborator;
				
				System.out.println("Digite o id do autor");
				id = scanner.nextInt();
				
				collaborator = this.collaboratorRepository.findById(new Integer(id));
				
				publication.getAuthors().add(collaborator);
				
				
			}else{
				if(publication.getResearchProjectAssociaed() != null){
					throw new Exception("Já existe um projeto relacionadao");
				}
				
				System.out.println("Digite o id do projeto relacionado");
				idProject = scanner.nextInt();
				
				ResearchProject researchProject = this.projectRepository.findById(new Integer(idProject));
				
				publication.setResearchProjectAssociaed(researchProject);
					
				
				
			}
		}catch(ResearchProjectNotFoundException r){
			System.out.println(r.getMessage());
			
		}catch(CollaboratorNotFound c){
			System.out.println(c.getMessage());
		}
		
		catch(InputMismatchException i){
			System.out.println(i.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			
	}
	public void consultations(){
		int input;
		Scanner scanner = new Scanner(System.in);
		
		
		try{
			System.out.println("1-consultar colaborador\n2-consultar projeto");
			input = scanner.nextInt();
			
			if(!(input == 1 || input == 2)){
				throw new Exception("**Digite uma opção válida**");
			}
			
			if(input == 1){
				int idCollaborator, n, n2;
				Collaborator collaborator;
				ArrayList<Publication> publications;
				ArrayList<ResearchProject> researchProjects;
				ArrayList<Publication> publications2 = new ArrayList<Publication>();
				ArrayList<ResearchProject> researchProjects2 = new ArrayList<ResearchProject>();
				Collaborator collaborator2;
				
				Scanner scanner2 = new Scanner(System.in);
				
				System.out.println("Digite o id do colaborador");
				idCollaborator = scanner2.nextInt();
				
				collaborator = this.collaboratorRepository.findById(new Integer(idCollaborator));
				
			
				
				publications2 = collaborator.getAcademicProduction();
				publications = (ArrayList<Publication>) publications2.clone();
				
				researchProjects2 = collaborator.getHistoricOfProjects();
				researchProjects = (ArrayList<ResearchProject>) researchProjects2.clone();

				
				n = researchProjects.size();
				
				n2 = 0;
				System.out.println("Projetos relacionados");
				int j = 0;
				for(int i = 0; i < n; i++){
					for(j = 0; j < researchProjects.size(); j++){
						if(!researchProjects.get(n2).getEndDate().after(researchProjects.get(j).getEndDate())){
							n2 = j;
						}
					}
					System.out.println("|Título\t" + researchProjects.get(n2).getTitle() + 
							" || " + researchProjects.get(n2).getEndDate().getTime());
					researchProjects.remove(n2);
					n2 = 0;
					
				}
				
				System.out.println("Publicações relacionadas\n");
				
				n = publications.size();
				for(int i = 0; i < n; i++){
					for(j = 0; j < publications.size(); j++){
						if(publications.get(n2).getYearOfPublication() < publications.get(j).getYearOfPublication()){
							n2 = j;
						}
					}
					System.out.println("| título\t" + publications.get(n2).getTitle() + "| ano\t" + publications.get(n2).getYearOfPublication() + "|");
					publications.remove(n2);
					n2 = 0;
				}
				
				System.out.println();
				
			}else{
				int idProject, n, k, n2;
				System.out.println("Digite o id do projeto");
				
				idProject = scanner.nextInt();
				
				ResearchProject researchProject = this.projectRepository.findById(new Integer(idProject));
				System.out.println("Título: " + researchProject.getTitle() + " Descrição:" + researchProject.getDescription()
				+ " Valor financiado: "+ researchProject.getFinancedAmount() + 
				" Agência financeadora:" +researchProject.getFundingAgency() + 
				" Objetivo:" + researchProject.getObjective() + "\n");
				
				ArrayList<Collaborator> collaborators = researchProject.getParticipants();
				ArrayList<Publication> publications = this.publicationRepository.findAll();
				ArrayList<Publication> publications2 = new ArrayList<Publication>();
				
				
				for(int i = 0; i < publications.size(); i++){
					if(publications.get(i).getResearchProjectAssociaed().getId().intValue() == idProject){
						publications2.add(publications.get(i));
					}
				}
				
				for(int i = 0; i < collaborators.size(); i++){
					System.out.print("|" + collaborators.get(i).getName() + " " + 
				collaborators.get(i).getEmail() + "|\n");
				}
				
				publications = new ArrayList<Publication>();
				
				
				publications2 = (ArrayList<Publication>) publications2.clone();
				n = publications2.size();
				n2 = 0;
				int j = 0;
				publications = new ArrayList<Publication>();
				for(int i = 0; i < n; i++){
					for(j = 0; j < publications2.size(); j++){
						if(publications2.get(j).getYearOfPublication() > publications2.get(n2).getYearOfPublication()){
							n2 = j;
						}
					}
					System.out.println("| título\t" + publications2.get(n2).getTitle() + "| ano\t" + publications2.get(n2).getYearOfPublication() + "|");
					publications2.remove(n2);
					n2 = 0;
					
				}
				
				
				
				
				
				
			}
		}catch(InputMismatchException i){
			System.out.println("**Digite uma opção válida**");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void report(){
		int inProgress = 0, completed = 0, inPreparation = 0, orientations = 0;
		
		System.out.println("Número de collaboradores -> " + this.collaboratorRepository.findAll().size());
		
		for(int i = 0; i < this.projectRepository.findAll().size(); i++){
			if(this.projectRepository.findAll().get(i).getStatus() == Status.IN_PREPARATION){
				inPreparation++;
			}else if(this.projectRepository.findAll().get(i).getStatus() == Status.IN_PROGRESS){
				inProgress++;
			}else{
				completed++;
			}
		}
		
		
		System.out.println("Número de projetos em elaboração -> " + inProgress);
		System.out.println("Número de projetos em andamento -> " + inPreparation);
		System.out.println("Número de projetos concluídos - > " + completed);
		System.out.println("Número total de projetos -> " + this.projectRepository.findAll().size());
		
		
		for(int i = 0; i < this.orientationRepository.findAll().size(); i++){
			orientations = this.orientationRepository.findAll().get(i).getStudents().size();
		}
		
		System.out.println("Número de orientações -> " + orientations);
		
		System.out.println("Número de publicações ->" + this.publicationRepository.findAll().size());
		
	
	}
	
}
