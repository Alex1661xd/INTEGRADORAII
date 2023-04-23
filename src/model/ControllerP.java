package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllerP {
    private Project[] projects;
    

    public ControllerP(){

        projects= new Project[10];
    }
    
    /**
	 * Description: This method is in charge of registering a project
	 * pre:
	 * pos:
	 * @param nameProject name of project
     * @param nameCustomer name of customer
     * @param diaIPlan Initial planned day
     * @param mesIPlan Initial planned month
     * @param añoIPlan Initial planned year
     * @param diaFPlan Final planned day
     * @param mesFPlan Final planned month
     * @param añoFPlan Final planned year
     * @param budget Budget of project
     * @param managerGname Name of Greens manager
     * @param managerGphone Phone of Greens manager
     * @param managerCname Name of Custome
     * @param managerCphone phone of customer
	 * @return boolean
	 */

    public boolean registerProject(String nameProject, String nameCustomer, int diaIPlan,int mesIPlan,int añoIPlan, int diaFPlan, int mesFPlan, int añoFPlan,  double budget, String managerGname, String managerGPhone, String managerCName, String managerCPhone){
        Calendar initialDate=createfecha(diaIPlan, mesIPlan, añoIPlan);
        Calendar finalDate=createfecha(diaFPlan, mesFPlan, añoFPlan);
        Project nuevoproyecto= new Project(nameProject, nameCustomer, initialDate, finalDate,budget, managerGname, managerGPhone, managerCName, managerCPhone);

        boolean indicador1=false;
      
        for (int i=0; i<projects.length;i++){
        
            if (projects[i]==null && !indicador1){
                projects[i]=nuevoproyecto;
                indicador1=true;
        }
    }
        return indicador1;
    }
     /**
	 * Description: This method is responsible for displaying all created projects.
	 * pre:
	 * pos:
	 * @param
	 * @return String
	 */
    public String showProjects(){
        String msg="";
        for (int i=0; i<projects.length;i++){
            if(projects[i] == null){
				return msg;
			} else {
				msg +="-----------------------------------"+"\n"+(i+1)+". "+ projects[i].toStringProjectminim();
			}
			} 
            return msg;
        }
    
    /**
	 * Description: This method is responsible for editing a stage
	 * pre:
	 * pos:
	 * @param opcionStage num of selected project
     * @param dia day of new Initial planned stage
     * @param mes month of new Initial planned stage
     * @param año year of new Initial planned stage
     * @param Cantidadmeses Total of months that requiere stage
	 * @return boolean
	 */

    public boolean editStage(int opcionStage,int dia, int mes, int año, int Cantidadmeses){
            boolean indicador3=false;
    
            if(indicador3==false){
                int StageActive=projects[opcionStage].getActiveStage();
                if(StageActive!=0){
                    Calendar newFechaI=createfecha(dia, mes, año);
                    projects[opcionStage].getStages()[StageActive].setdateStagePI(newFechaI);
                    Calendar mesI=projects[opcionStage].getStages()[StageActive].getdateStagePI();
                    Calendar mesF=new GregorianCalendar();
                    mesF.setTime(mesI.getTime());
                    mesF.add(Calendar.MONTH, Cantidadmeses);
                    projects[opcionStage].getStages()[StageActive].setdateStagePF(mesF);
                }else{
                    Calendar mesI=projects[opcionStage].getStages()[StageActive].getdateStagePI();
                    Calendar mesF=new GregorianCalendar();
                    mesF.setTime(mesI.getTime());
                    mesF.add(Calendar.MONTH, Cantidadmeses);
                    projects[opcionStage].getStages()[StageActive].setdateStagePF(mesF);
                }
                
    
                indicador3=true;
            }
    
            return indicador3;
    
    }
    /**
	 * Description: This method is responsible for editing a stage
	 * pre:
	 * pos:
	 * @param opcionStage num of selected project
     * @param dateDIR day of new Initial real stage
     * @param dateMIR month of new Initial real stage
     * @param dateAIR year of new Initial real stage
     * @param dateDFR day of new Final real stage
     * @param dateMFR month of new Final real stage
     * @param dateAFR year of new Final real stage
	 * @return boolean
	 */
    
    public boolean CulminateStage(int opcionStage, int dateDIR, int dateMIR, int dateAIR, int dateDFR,int dateMFR, int dateAFR){
        boolean indicador4=false;
            
    
        Calendar nuevafecharealI=createfecha(dateDIR, dateMIR,dateAIR);
        Calendar nuevafecharealF=createfecha(dateDFR, dateMFR, dateAFR);
    
        if (indicador4==false){
            int StageActive=projects[opcionStage].getActiveStage();
            projects[opcionStage].getStages()[StageActive].setdateStageRI(nuevafecharealI);
            projects[opcionStage].getStages()[StageActive].setdateStageRF(nuevafecharealF);
            projects[opcionStage].getStages()[StageActive].setStatusStage(StatusStage.INACTIVE);
            projects[opcionStage].getStages()[StageActive+1].setStatusStage(StatusStage.ACTIVE);
            indicador4=true;
        }

        return indicador4;
    }
    /**
	 * Description: This method is responsible for displaying the stage that is active in a project.
	 * pre:
	 * pos:
	 * @param opcionStage num of selected stage
	 * @return String
	 */
    public String showStagesActive(int opcionStage){
        String msg="";
               
        int StageActive=projects[opcionStage].getActiveStage();
        msg=projects[opcionStage].getStages()[StageActive].toStringStage();
       
        return msg;
       }
       /**
	 * Description: This method is responsible for displaying the stage prior to the active stage.
	 * pre:
	 * pos:
	 * @param opcionStage num of selected stage
	 * @return String
	 */
       public String showLastStages(int opcionStage){
           String msg="";
           int StageActive=projects[opcionStage].getActiveStage();
           msg=projects[opcionStage].getStages()[StageActive-1].toStringStageMax();
    
           return msg;
       }
    /**
	 * Description: This method is responsible for displaying all the stages of each project.
	 * pre:
	 * pos:
	 * @param opcionStage num of selected stage
	 * @return String
	 */
       public String showStagesHistorial(int opcionStage){
            String msg="";
            int StageActive=projects[opcionStage].getActiveStage();
            for (int i=0;i<StageActive+1;i++){
                msg+="-------------------------------"+"\n"+(i+1)+". "+projects[opcionStage].getStages()[i].toStringStageMaxMin();
            }
            return msg;
       }
     /**
	 * Description: This method is in charge of recording a capsule in a project
	 * pre:
	 * pos:
	 * @param id identifier of Capsule
     * @param description Description of Capsule
     * @param typeUnit Type Capsule
     * @param learnedLessons Learned Lessons of Capsule
     * @param namecolabo Collaborators name of Capsule
     * @param cargo position of Collaborator
     * @param opcionProject num of selected Project
	 * @return boolean
	 */

    public boolean registerUnit(String id, String description, int typeUnit, String learnedLessons, String namecolabo, String cargo, int opcionProject) {
        Project ProjectoUnit=projects[opcionProject];
        String ProjectoUnidad=ProjectoUnit.getnameProject();
        String Publicada="-NO";
        String URL="-None";
        boolean indicador5=false;
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50;i++){
            if (projects[opcionProject].getStages()[StageActive].getUnits()[i]==null){
                if(typeUnit==1){
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.TECHNICAL, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                } else if(typeUnit==2){
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.MANAGEMENT, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                }else if(typeUnit==3){
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.DOMAIN, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                }else{
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.EXPERTISE, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                }
                
                indicador5=true;
                return indicador5;
            }
            
        }
   
		
		return indicador5;
	}
    /**
	 * Description: This method is in charge of displaying all capsules in each project and stage.
	 * pre:
	 * pos:
	 * @param opcionProject num of selected Project
	 * @return String
	 */

    public String showAllUnit(int opcionProject){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50; i++){
            if (projects[opcionProject].getStages()[StageActive].getUnits()[i]==null){
                return msg;
            }else{
                msg+="\n"+"-------------------------"+"\n"+(i+1)+"."+projects[opcionProject].getStages()[StageActive].getUnits()[i].toStringUMm();
            }
        }
        return msg;
    }
    /**
	 * Description: This method is in charge of displaying the last capsule.
	 * pre:
	 * pos:
	 * @param opcionProject num of selected Project
	 * @return String
	 */
    
    public String showLastUnit(int opcionProject){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50; i++){
            if (i>0 && projects[opcionProject].getStages()[StageActive].getUnits()[i]==null){
                msg+=projects[opcionProject].getStages()[StageActive].getUnits()[i-1].toStringU();
                return msg;
            }
        }
        return msg;
    }
     /**
	 * Description: This method displays the selected capsule.
	 * pre:
	 * pos:
	 * @param opcionProject num of selected Project
     * @param numUnit num of selected Capsule
	 * @return String
	 */
    public String showUnitSelect(int opcionProject, int numUnit){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        msg=projects[opcionProject].getStages()[StageActive].getUnits()[numUnit].toStringUMmF();
        return msg;
    }
     /**
	 * Description: This method approves the selected capsule.
	 * pre:
	 * pos:
	 * @param opcionProject num of selected Project
     * @param opcionStage num of selected Stage
     * @param numUnit num of selected Capsule
	 * @return boolean
	 */
    public boolean approveKnowledgeUnit(int opcionProject, int opcionStage,int numUnit ) {
		boolean indicador=false;
        
        if(indicador==false){
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setStatusUnit(StatusUnit.APROBADA);
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setDateConfirm(Calendar.getInstance());;
            indicador=true;
        }

        return indicador;
	}
     /**
	 * Description: This method is responsible for publishing the selected capsule.
	 * pre:
	 * pos:
	 * @param opcionProject num of selected Project
     * @param opcionStage num of selected Stage
     * @param numUnit num of selected Capsule
     * @param URL new URL of Capsule
	 * @return boolean
	 */

    public boolean publishKnowledgeUnit(int opcionProject, int opcionStage, int numUnit, String URL){
        boolean indicador=false;
        if(indicador==false){
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setURL(URL);
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setPublish("-YES");
            
            indicador=true;
        }
       return indicador;
    }
    /**
	 * Description: This method is in charge of displaying the last capsule published.
	 * pre:
	 * pos:
	 * @param opcionProject num of selected Project
     * @param opcionStage num of selected Stage
	 * @return String
	 */
    public String showLastpublisUnit(int opcionProject, int opcionStage){
        String msg="";
        for(int i=0; i<50; i++){
            if(projects[opcionProject].getStages()[opcionStage].getUnits()[i]==null){
                return msg;
            }else{
                String consulta=projects[opcionProject].getStages()[opcionStage].getUnits()[i].getPublish();
                if(consulta.equals("-YES")){
                    msg=projects[opcionProject].getStages()[opcionStage].getUnits()[i].toStringUMmF();
                }
            }
        }
        return msg;
    }
    /**
	 * Description: This method is responsible for displaying all published capsules.
	 * pre:
	 * pos:
	 * @param opcionProject num of selected Project
     * @param opcionStage num of selected Stage
	 * @return String
	 */

    public String showApproveUnit(int opcionProject, int opcionStage){
        String msg="";
        boolean indicador=false;
        if(indicador==false){
            for(int i=0; i<50; i++){
                if(projects[opcionProject].getStages()[opcionStage].getUnits()[i]==null){
                    return msg;
                }else if(projects[opcionProject].getStages()[opcionStage].getUnits()[i].getStatusUnit()==StatusUnit.APROBADA){
                    msg+=(i+1)+". "+projects[opcionProject].getStages()[opcionStage].getUnits()[i].toStringUMmF();
                }else{
                    return msg;
                }     
            }
            indicador=true;
        }
        return msg;
    }
    /**
	 * Description: This method searches for a word in the capsule of each stage of each project.
	 * pre:
     * pos:
	 * @param wordSearch word to search in the capsule
	 * @return String
	 */

    public String searchPSU(String wordSearch){
        String msg="";
        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getStages()[j].getUnits()[s]!=null){
                                if(projects[i].getStages()[j].getUnits()[s].getDescription().contains(wordSearch)){
                                    msg+="\nWord found in: \n";
                                    msg+="Project: "+projects[i].getnameProject()+"\n";
                                    msg+="Stage: "+projects[i].getStages()[j].getTypeStage()+"\n";
                                    msg+="Capsule Identifier: "+projects[i].getStages()[j].getUnits()[s].getId()+"\n";
                                }
                            }
                        }
                    }
                    
        
                } 
        }
    
        return msg;
    }
    /**
	 * Description: This method displays a counter of the types of capsules created.
	 * pre:
     * pos:
	 * @param
	 * @return String
	 */

    public String numberTypeUnit(){
        String msg="";
        int ContadorT=0;
        int ContadorG=0;
        int ContadorD=0;
        int ContadorE=0;

        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getStages()[j].getUnits()[s]!=null){
                                if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.TECHNICAL){
                                   ContadorT++;
                                }else if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.MANAGEMENT){
                                    ContadorG++;
                                }else if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.EXPERTISE){
                                    ContadorE++;
                                }else if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.DOMAIN){
                                    ContadorD++;
                                }

                                
                            }
                        }
                    }
                    
        
                }
                                
        }
        msg+="\nNumber Type of Capsules created in Total\n";
        msg+="-Technical: "+ContadorT+"\n";
        msg+="-Management: "+ContadorG+"\n";
        msg+="-Domain: "+ContadorD+"\n";
        msg+="-Experiences: "+ContadorE+"\n"; 
    
        return msg;
    }

    public String projectMoreCapsules(){
        String msg="";
        String msg1="";
        int maxCapsules=0;
        

        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                int capsulesCount=0;
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getStages()[j].getUnits()[s]!=null){
                                capsulesCount++;
                            }

                        }
                    }

                    if(capsulesCount>maxCapsules){
                        maxCapsules=capsulesCount;
                        msg="The project with the most capsules created is: --"+projects[i].getnameProject()+"--";
                        msg1="\n-With a total of "+maxCapsules+" capsules created.";
                    }
                } 
        }
        return msg+msg1;
    
    }

    public String projectLessonslearned(){
        String msg="";
        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getStages()[j].getUnits()[s]!=null){
                                if(projects[i].getStages()[j].getUnits()[s].getStatusUnit()==StatusUnit.APROBADA||projects[i].getStages()[j].getUnits()[s].getPublish().equals("-YES")){
                                    msg+="\nProject: "+projects[i].getnameProject();
                                    msg+="\nIdentifier Capsule: "+projects[i].getStages()[j].getUnits()[s].getId();
                                    msg+="\nLearned lesson: "+projects[i].getStages()[j].getUnits()[s].getLearnedLessons()+"\n";
                                }  
                            }
                        }
                    }
                    
        
                }
                                
        }
        return msg;

    }
    /**
	 * Description: This method is responsible for creating a date as Calendar type
	 * pre:
     * pos:
	 * @param dia the day of the new date
     * @param mes the month of the new date
     * @param año the year of the new date
	 * @return Calendar
	 */
    public static Calendar createfecha(int dia, int mes, int año){
        Calendar fecha = new GregorianCalendar(año,mes,dia);
        return fecha;
    }
    /**
	 * Description: This method is in charge of returning all the stages of the project
	 * pre:
     * pos:
	 * @param
	 * @return Project[]
	 */

    public Project[] getprojects(){
        return projects;
    }
}




