package ui;


import java.util.Scanner;
import model.ControllerP;

public class Executable {

	private Scanner reader;
	private ControllerP controllerP;
	

	public Executable() {
		reader = new Scanner(System.in);
		controllerP= new ControllerP();
	}


	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();

	}

	public void menu() {
		System.out.println("\nWelcome to GreenSQA :)");
		boolean cond=false;

		while(!cond){
            System.out.println("\n-  Enter a number  -");
            System.out.println("\n1. Creat a Project");
            System.out.println("2. Edit project stages");
            System.out.println("3. Culminate project stages");
			System.out.println("4. Register capsule");
			System.out.println("5. Approve capsule");
			System.out.println("6. Other functions");
			System.out.println("\n7. Exit");
            int opcion=reader.nextInt();

            switch(opcion){
                case 1:
					registerProject();
                 break;

                case 2:
					editStage();
                break;

                case 3:
					CulminateStage();
                break;
      
                case 4:
					registerUnits();
                break;

				case 5:
					approveKnowledgeUnit();
				break;

				case 6:
					System.out.println("-Enter a number-");
					System.out.println("1. Consult Capsules created");
					System.out.println("2. Publis Capsule");
					System.out.println("3. General Information");
					System.out.println("4. Back to main menu");
					int menu2=reader.nextInt();
						switch(menu2){
							case 1:
							SearchPSU();
							break;

							case 2:
							publishKnowledgeUnit();
							break;

							case 3:
							numberTypeUnit();
							break;

							case 4:
							break;

							default:
							break;
						}
				break;
					
				case 7:
				System.out.println("See you later :)");
                cond=true;
				break;


            }
        }
	}

	/**
	 * Description: This method is in charge of registering a project
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */

	private void registerProject(){
		reader.nextLine();
		
		System.out.println("Enter the following information to create a project:");
		System.out.println("Enter project name");
		String nameProject=reader.nextLine();
		System.out.println("Enter customer name");
		String nameCustomer=reader.nextLine();
		System.out.println("\n -PLANNED START DATE-");
		System.out.println("Enter the day (In Numbers)");
		int diaIPlan=reader.nextInt();
		System.out.println("Enter the month (In numbers)");
		int mesIPlan=reader.nextInt();
		System.out.println("Enter the year (In numbers)");
		int añoIPlan=reader.nextInt();

		System.out.println("\n-PLANNED END DATE-");
		System.out.println("Enter the day (In Numbers)");
		int diaFPlan=reader.nextInt();
		System.out.println("Enter the month (In Numbers)");
		int mesFPlan=reader.nextInt();
		System.out.println("Enter the year (In Numbers)");
		int añoFPlan=reader.nextInt();
		
		System.out.println("\nEnter the project budget");
		double budget=reader.nextDouble();
		reader.nextLine();
		System.out.println("Enter the name of Green's manager");
		String managerGname=reader.nextLine();
		System.out.println("Enter Green's manager phone number");
		String managerGPhone=reader.nextLine();
		System.out.println("Enter the client's manager name");
		String managerCName=reader.nextLine();
		System.out.println("Enter the customer's manager's phone number");
		String managerCPhone=reader.nextLine();

		if (controllerP.registerProject(nameProject,nameCustomer,diaIPlan,(mesIPlan-1),añoIPlan,diaFPlan,(mesFPlan-1),añoFPlan,budget,managerGname,managerGPhone,managerCName,managerCPhone)){
			System.out.println("\n     -Project successfully registered-");
			System.out.println("First Stage START created with default values");
		}else{
			System.out.println("     -Unable to register. Memory full-");
		}
		
	}

	/**
	 * Description: This method is responsible for editing a stage
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */
	
	private void editStage(){
		reader.nextLine();
		String Consulta=controllerP.showProjects();
		if(Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("These are the projects created:");
			System.out.println(controllerP.showProjects());
			System.out.println("\nEnter WITH A NUMBER to which project you want to edit the stage ");
			int opcionStage=reader.nextInt();
			opcionStage=opcionStage-1;
			System.out.println("\n-This is the current stage of this project:");
			System.out.println(controllerP.showStagesActive(opcionStage)); 
		
			System.out.println("          -EDIT MODE-");
			int Consulta2=controllerP.getprojects()[opcionStage].getActiveStage();
			if(Consulta2!=0){
				System.out.println("Enter the day of the planned start date");
				int dia=reader.nextInt();
				System.out.println("Enter the month");
				int mes=reader.nextInt();
				System.out.println("Enter the year");
				int año=reader.nextInt();
				System.out.println("       PLANNED END DATE\n");
				System.out.println("\nEnter the number of months that the stage will take");
				int meses=reader.nextInt();
				if(controllerP.editStage(opcionStage, dia, (mes-1) ,año ,meses)){
					System.out.println("\n-Stage edited correctly-");
					System.out.println(controllerP.showStagesActive(opcionStage)); 
				}else{
					System.out.println("Cannot edit the stage");
				}
			}else{
				int dia=0;
				int mes=0;
				int año=0;
				System.out.println("       PLANNED END DATE\n");
				System.out.println("Enter the number of months that the stage will take");
				int meses=reader.nextInt();
				if(controllerP.editStage(opcionStage, dia, (mes-1) ,año ,meses)){
				System.out.println("\n-Stage edited correctly-");
				System.out.println(controllerP.showStagesActive(opcionStage)); 
				}else{
				System.out.println("Cannot edit the stage");
				}
			}
			
			
		}
	

	}

	/**
	 * Description: This method is responsible for the completion of a stage
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */

	private void CulminateStage(){
		String Consulta=controllerP.showProjects();
		if(Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("These are the projects created:");
			System.out.println(controllerP.showProjects());
			System.out.println("\nEnter WITH A NUMBER to which project you want to complete the stage ");
			int opcionStage=reader.nextInt();
			System.out.println("\n-This is the current stage of this project:");
			System.out.println(controllerP.showStagesActive(opcionStage-1)); 
			
			System.out.println("\n-SPACE OF CULMINATION-");
			System.out.println("\nEnter the actual start date");
			System.out.println("-Enter the day");
			int dateDIR=reader.nextInt();
			System.out.println("\n-Enter the month");
			int dateMIR=reader.nextInt();
			System.out.println("\n-Enter the year");
			int dateAIR=reader.nextInt();
	
			System.out.println("\nEnter the actual end date");
			System.out.println("-Enter the day");
			int dateDFR=reader.nextInt();
			System.out.println("\n-Enter the month");
			int dateMFR=reader.nextInt();
			System.out.println("\n-Enter the year");
			int dateAFR=reader.nextInt();
	
	
			if (controllerP.CulminateStage((opcionStage-1), dateDIR, (dateMIR-1), dateAIR, dateDFR, (dateMFR-1), dateAFR)){
				System.out.println("\n  -Stage completed successfully-");
				System.out.println("   This is how the stage ended:");
				System.out.println("\n"+controllerP.showLastStages(opcionStage-1));
				System.out.println("-The next stage is available now-");
			}else{
				System.out.println("   -Could not be completed-");
			}
		}
	
	}
	
	/**
	 * Description: This method registers a capsule in the selected project.
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */

	private void registerUnits() {
		String Consulta=controllerP.showProjects();
		if (Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controllerP.showProjects());
			System.out.println("¿To which project would you like to register the capsule?- Enter A NUMBER");
			int opcionProject=reader.nextInt();
			System.out.println("\nThe capsule will be registered to the next stage:");
			System.out.println(controllerP.showStagesActive((opcionProject-1)));
			System.out.println("\n    KNOWLEDGE CAPSULE CREATION");
			System.out.println("Enter the capsule identifier (Ex. A004)");
			reader.nextLine();
			String id=reader.nextLine();
			System.out.println("Add a description of the capsule");
			System.out.println("Mark with a ¨#¨ at the beginning and end of each keyword.");
			String description=reader.nextLine();
			System.out.println("\nEnter the type of capsule with ONE NUMBER");
			System.out.println("1.Technical\n2.Management\n3.Domain\n4.Expertise");
			int typeUnit=reader.nextInt();
			reader.nextLine();
			System.out.println("Enter learning obtained");
			System.out.println("Mark with a ¨#¨ at the beginning and end of each keyword.");
			String learnedLessons=reader.nextLine();
			System.out.println("Enter the name of the collaborator");
			String nameColabo=reader.nextLine();
			System.out.println("Enter the position of "+nameColabo);
			String cargo=reader.nextLine();
			

			if (controllerP.registerUnit(id, description, typeUnit, learnedLessons,nameColabo,cargo, opcionProject-1)){
				System.out.println("\n-Capsule successfully registered-");
				System.out.println("-This is how your capsule looked-");
				System.out.println(controllerP.showLastUnit(opcionProject-1)); 
			}else{
				System.out.println("\n-Memory full, the capsule could not be registered.-");
			}
		}


	}	

	
	/**
	 * Description: This method approves a capsule in the selected project.
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */

	private void approveKnowledgeUnit() {
		String consulta= controllerP.showProjects();
		

		if(consulta.equals("")){
            System.out.println("Nothing is created");
        }else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controllerP.showProjects());
			System.out.println("Which project would you like to approve the capsule for? - Enter a number");
			int opcionProject=reader.nextInt();
			System.out.println(controllerP.showStagesHistorial(opcionProject-1));
			System.out.println("At which stage would you like to approve the capsule");
			int opcionStage=reader.nextInt();
			String consulta1=controllerP.showAllUnit(opcionProject-1);
			if(consulta1.equals("")){
				System.out.println("\nThis stage has no registered capsules");
			}else{
				System.out.println(controllerP.showAllUnit(opcionProject-1));
			System.out.println("\nWhich capsule do you wish to approve?");
			int numUnit=reader.nextInt();
			reader.nextLine();
            
            if(controllerP.approveKnowledgeUnit(opcionProject-1, opcionStage-1,numUnit-1)){
				System.out.println("\n-Capsule correctly edited-");
				System.out.println("This is how your capsule looked:");
			System.out.println(controllerP.showUnitSelect(opcionProject-1, numUnit-1));
			}else{
				System.out.println("An unexpected error occurred");
			}
			}
			
        }

	}

	/**
	 * Description: This method is responsible for publishing an approved capsule in the selected project.
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */

	private void publishKnowledgeUnit(){
		String consulta= controllerP.showProjects();
		if(consulta.equals("")){
            System.out.println("Nothing is created");
        }else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controllerP.showProjects());
			System.out.println("¿In which project is the capsule located? - Enter a NUMBER");
			int opcionProject=reader.nextInt();
			System.out.println(controllerP.showStagesHistorial(opcionProject-1));
			System.out.println("¿What stage is the capsule in?- Enter a NUMBER");
			int opcionStage=reader.nextInt();
			String consulta1=controllerP.showApproveUnit(opcionProject-1, opcionStage-1);
			if(consulta1.equals("")){
				System.out.println("This stage does not have approved capsules");
			}else{
				System.out.println("\n"+controllerP.showApproveUnit(opcionProject-1, opcionStage-1));
			System.out.println("\nWhich capsule would you like to publish?");
			int numUnit=reader.nextInt();
			reader.nextLine();
			System.out.println("Enter the URL");
			String URL=reader.nextLine();
			if(controllerP.publishKnowledgeUnit(opcionProject-1, opcionStage-1, numUnit-1, URL)){
				System.out.println("\n-Capsule published successfully-");
				System.out.println("This is how his capsule looked:");
				System.out.println("\n"+controllerP.showLastpublisUnit(opcionProject-1, opcionStage-1));
			}else{
				System.out.println("An unexpected error occurred");
			}
		
        }
	}
	}

	/**
	 * Description: This method searches for a word in the capsule of each stage of each project.
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */


	private void SearchPSU() {
		System.out.println("Please enter the word to search for");
		reader.nextLine();
		String wordSearch=reader.nextLine();
		String consulta=controllerP.searchPSU(wordSearch);
        if(consulta.equals("")){
            System.out.println("\n-The word is not found-");
        }else{
            System.out.println(controllerP.searchPSU(wordSearch));
        }
	}

	/**
	 * Description: This method displays a counter of the types of capsules created.
	 * pre:
	 * pos:
	 * @param
	 * @return void
	 */
	private void numberTypeUnit(){
		String Consulta=controllerP.numberTypeUnit();

		if(Consulta.equals("")){
			System.out.println("No capsules created:");
		}else{
			System.out.println(controllerP.numberTypeUnit());
			System.out.println(controllerP.projectMoreCapsules());
			System.out.println("\nLessons learned from the approved capsules:");
			System.out.println(controllerP.projectLessonslearned());
		}

		


	}

}