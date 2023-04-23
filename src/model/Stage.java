package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stage {
    private TypeStage TypeStage;
    private StatusStage StatusStage;
    private Calendar dateStagePI;
    private Calendar dateStagePF;
    private Calendar dateStageRI;
    private Calendar dateStageRF;
    private Unit[] Units;


    private DateFormat formatter;



    public Stage(TypeStage TypeStage, Calendar dateStagePI, Calendar dateStagePF, Calendar dateStageRI, Calendar dateStageRF, StatusStage StatusStage){
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.TypeStage=TypeStage;
        this.StatusStage=StatusStage;
        this.dateStagePI=dateStagePI;
        this.dateStagePF=dateStagePF;
        this.dateStageRI=dateStageRI;
        this.dateStageRF=dateStageRF;

        Units= new Unit[50];
    }

    public Unit[] getUnits(){
        return Units;
    }

    public StatusStage getStatuStage(){
        return StatusStage;
    }

    public void setStatusStage(StatusStage StatusStage){
        this.StatusStage=StatusStage;
    }  

    public TypeStage getTypeStage(){
        return TypeStage;
    }

    public void setTypeStage(TypeStage TypeStage){
        this.TypeStage=TypeStage;
    }  

    public Calendar getdateStagePI(){
        return dateStagePI;
    }

    public String getdateStagePIFormated(){
        return formatter.format(this.dateStagePI.getTime());
    }
    
    public void setdateStagePI(Calendar dateStagePI) {
        this.dateStagePI = dateStagePI;
    }
    
    public void setdateStagePF(Calendar dateStagePF) {
        this.dateStagePF = dateStagePF;
    }
    
    public Calendar getdateStagePF(){
        return dateStagePF;
    }

    public String getdateStagePFFormated(){
        return formatter.format(this.dateStagePF.getTime());
    }

    public Calendar getdateStageRI(){
        return dateStageRI;
    }

    public String getdateStageRIFormated(){
        return formatter.format(this.dateStageRI.getTime());
    }

    public void setdateStageRI(Calendar dateStageRI) {
        this.dateStageRI = dateStageRI;
    }

    public Calendar getdateStageRF(){
        return dateStageRF;
    }

    public String getdateStageRFFormated(){
        return formatter.format(this.dateStageRF.getTime());
    }

    public void setdateStageRF(Calendar dateStageRF) {
        this.dateStageRF = dateStageRF;
    }

 
    public String toStringStage(){
		String msg="";
		msg ="-------------------------------\n"+"        Stage: "+ TypeStage +"\n-------------------------------\n"+"Status Stage: " + StatusStage+"\nPREDEFINED DATES:"+"\nPlanned start date "+ getdateStagePIFormated() +"\nPlanned end date: "+ getdateStagePFFormated()+"\n-------------------------------\n";
		return msg;
	}

    public String toStringStageMaxMin(){
		String msg="";
		msg ="Stage: "+ TypeStage +"\n-------------------------------"+"\nStatus Stage: " + StatusStage+"\nPlanned start date: "+ getdateStagePIFormated() +"\nPlanned end date: "+ getdateStagePFFormated()+"\n-------------------------------\n";
		return msg;
	}

    
    public String toStringStageMax(){
		String msg="";
		msg ="-------------------------------\n"+"      Stage: "+ TypeStage +"\n-------------------------------"+"\nStatus Stage: " + StatusStage+"\nPlanned start date: "+ getdateStagePIFormated() +"\nPlanned end date: "+ getdateStagePFFormated()+"\nReal start date: "+getdateStageRIFormated()+"\nReal end date: "+getdateStageRFFormated()+"\n-------------------------------\n";
		return msg;
	}


}
