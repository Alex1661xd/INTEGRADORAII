package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Project {
    
    private String nameProject;
    private String nameCustomer;
	private Calendar initialDate;
	private Calendar finalDate;
    private double budget;
    private String managerGName;
    private String managerGPhone;
    private String managerCName;
    private String managerCPhone;
    private Stage[] stages;
    

    
    private DateFormat formatter;

    public Project(String nameProject, String nameCustomer, Calendar initialDate ,Calendar finalDate,double budget, String managerGName, String managerGPhone,String managerCName, String managerCPhone){
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        
        this.nameProject=nameProject;
        this.nameCustomer=nameCustomer;
        this.initialDate=initialDate;
        this.finalDate=finalDate;
        this.budget=budget;
        this.managerGName=managerGName;
        this.managerGPhone=managerGPhone;
        this.managerCName=managerCName;
        this.managerCPhone=managerCPhone;
        
        stages = new Stage[6];

        Calendar dateStagePI= Calendar.getInstance();
        Calendar dateStagePF=Calendar.getInstance();
        Calendar dateStageRI=Calendar.getInstance();
        Calendar dateStageRF=Calendar.getInstance();

        stages[0] = new Stage(TypeStage.INITIATION,initialDate, dateStagePF, dateStageRI, dateStageRF, StatusStage.ACTIVE);
        stages[1] = new Stage(TypeStage.ANALYSIS, dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVE);
        stages[2] = new Stage(TypeStage.DESIGN,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVE);
        stages[3] = new Stage(TypeStage.EXECUTION,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVE);
        stages[4] = new Stage(TypeStage.CLOSING,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVE);
        stages[5] = new Stage(TypeStage.MONITORING,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVE);

    }
   
    public Stage[] getStages(){
        return stages;
    }
    public String getnameProject(){
        return nameProject;
    }

    public void setnameProject(String nameProject){
        this.nameProject=nameProject;
    }

    public String getnameCustomer(String nameCustomer){
        return nameCustomer;
    }

    public void setnameCustomer(String nameCustomer){
        this.nameCustomer=nameCustomer;
    }

    public Calendar getinitialDate(){
        return initialDate;
    }

    public String getInitialDateFormated() {
		return formatter.format(this.initialDate.getTime());
	}

    public void setInitialDate(Calendar initialDate){
        this.initialDate=initialDate;
    }

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}		


    public double getbudget(){
        return budget;
    }

    public void setbudget(double budget){
        this.budget=budget;
    }

    public String getmanagerGName(){
        return managerGName;
    }

    public void setmanagerGname(String managerGName){
        this.managerGName=managerGName;
    }

    public String getmanagerGPhone(){
        return managerGPhone;
    }

    public void setmanagerGPhone(String managerGPhone){
        this.managerGPhone=managerGPhone;
    }

    public String getmanagerCName(){
        return managerCName;
    }

    public void setmanagerCName(String managerCName){
        this.managerCName=managerCName;
    }

    public String getmanagerCPhone(){
        return managerCPhone;
    }

    public void setmanagerCPhone(String managerCPhone){
        this.managerCPhone=managerGPhone;
    }

    public int getActiveStage(){
        int nActive=-1;
        for(int i=0; i<stages.length;i++){
            if(stages[i].getStatuStage()==StatusStage.ACTIVE){
                nActive=i;  
                return nActive;
            }
          
        }
        return nActive;
        
    }

    public String toStringProject(){
		String msg="";
		msg ="Project name: "+ nameProject + "\nClient's name: " + nameCustomer+ "\nPlanned start date: "+ getInitialDateFormated() +"\nPlanned end date: "+ getFinalDateFormated()+"\nProject budget: "+budget+"\nName of manager Green: "+managerGName+"\nGreen manager phone: "+managerGPhone+"\nClient manager name: "+managerCName+"\nCustomer manager phone: "+managerGPhone;
		return msg;
	}

    public String toStringProjectminim(){
        String msg="";
        msg="Project name: "+nameProject+"\n-----------------------------------"+"\nClient's name: "+nameCustomer+"\nPlanned start date: "+getInitialDateFormated()+"\nPlanned end date: "+getFinalDateFormated()+"\nProject budget: "+budget+"\n"+"-----------------------------------\n";
        return msg;
    }

    
}
