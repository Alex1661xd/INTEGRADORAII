package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Unit {


	private String id;
	private String description;
	private TypeUnit TypeUnit;
	private String learnedLessons;
	private String nameColabo;
	private String cargo;
	private StatusUnit StatusUnit;
	private Calendar DateConfirm;
	private String ProjectoUnidad;
	private String Publish;
	private String URL;

	private DateFormat formatter;


	public Unit(String id, String description, TypeUnit TypeUnit, String learnedLessons, String namecolabo, String cargo,StatusUnit StatusUnit, Calendar DateConfirm,String ProjectoUnidad, String Publish, String URL) {
		this.formatter = new SimpleDateFormat("dd/MM/yyyy");

		this.id = id;
		this.description = description;
		this.TypeUnit = TypeUnit;
		this.learnedLessons = learnedLessons;
		this.nameColabo = namecolabo;
		this.StatusUnit=StatusUnit;
		this.cargo=cargo;
		this.DateConfirm=DateConfirm;
		this.ProjectoUnidad=ProjectoUnidad;
		this.URL=URL;
		this.Publish=Publish;
	}

	public String getURL(String URL){
		return URL;
	}

	public void setURL(String URL){
		this.URL=URL;
	}

	public String getPublish(){
		return Publish;
	}

	public void setPublish(String Publish){
		this.Publish=Publish;
	}

	public String getProjectoUnidad(String ProjectoUnidad){
		return ProjectoUnidad;
	}

	public void setProjectUnit(String ProjectoUnidad){
		this.ProjectoUnidad=ProjectoUnidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TypeUnit getTypeUnit() {
		return TypeUnit;
	}

	public void setTypeUnit(TypeUnit TypeUnit) {
		this.TypeUnit = TypeUnit;
	}

	public StatusUnit getStatusUnit() {
		return StatusUnit;
	}

	public void setStatusUnit(StatusUnit StatusUnit) {
		this.StatusUnit = StatusUnit;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getnameColabo() {
		return nameColabo;
	}

	public void setnameColabo(String namecolabo) {
		this.nameColabo = namecolabo;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}

	public String getCargo(){
		return cargo;
	}

	public void setCargo(String Cargo){
		this.cargo=Cargo;
	}

	public Calendar getDateConfirm(){
		return getDateConfirm();
	}

	public String getDateConfirmFormated(){
		return formatter.format(this.DateConfirm.getTime());
	}

	public void setDateConfirm(Calendar DateConfirm){
		this.DateConfirm=DateConfirm;
	}
	
	public String toStringU(){
		String msg="";
		msg ="-----------------------------------"+"\n         Project: "+ProjectoUnidad+"\n-----------------------------------"+"\nIdentifier: "+ id + "\nDescription: " + description+ "\nType: "+ TypeUnit+"\nLearning obtained:"+learnedLessons+"\nStatus: "+StatusUnit+"\nContributor's name: "+nameColabo+"\nPosition of collaborator: "+cargo+"\n-----------------------------------";
		return msg;
	}

	public String toStringUM(){
		String msg="";
		msg ="Project: "+ProjectoUnidad+"\nPublished: "+Publish+"\nURL: "+URL+"\n"+"\n-Identifier: "+ id + "\nDescription: " + description+ "\n-Type: "+ TypeUnit+"\nLearning obtained:"+learnedLessons+"\n-Status: "+StatusUnit+"\nContributor's name: "+nameColabo+"\n-Collaborator's position: "+cargo+"\nApproval date: "+getDateConfirmFormated();
		return msg;
	}
	
	public String toStringUMm(){
		String msg="";
		msg ="Project: "+ProjectoUnidad+"\n-------------------------"+"\nPublished: "+Publish+"\nIdentifier: "+ id+ "\nType: "+ TypeUnit+"\nStatus: "+StatusUnit+"\n"+"-------------------------";
		return msg;
	}

	public String toStringUMmF(){
		String msg="";
		msg ="\n-------------------------"+"\nProject: "+ProjectoUnidad+"\n-------------------------"+"\nPublished: "+Publish+"\nURL: "+URL+"\nIdentifier: "+ id+ "\nType: "+ TypeUnit+"\nStatus: "+StatusUnit+"\nApproval date: "+getDateConfirmFormated()+"\n"+"-------------------------\n";
		return msg;
	}


}
