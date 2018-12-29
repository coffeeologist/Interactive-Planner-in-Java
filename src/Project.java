import java.text.SimpleDateFormat;
import java.util.*;
public class Project extends Assignment  {
	String subject;
	ArrayList<String> materialsNeeded;
	
	public Project(String name, String state, GregorianCalendar date, String course){
		super(name, state, date);
		subject = course;
		materialsNeeded = new ArrayList<String>();
		System.out.println("\nProject assignment successfully created.");
	}
	
	public Project(String name, String state, GregorianCalendar date, String course, ArrayList<String>given){
		super(name, state, date);
		subject = course;
		materialsNeeded = given;
		System.out.println("\nProject assignment successfully created.");
	}
	
	public void setSubject(String given){
		subject = given;
	}
	
	public void setMaterialsNeeded(ArrayList<String> given){
		materialsNeeded = given;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public ArrayList<String> getMaterialsNeededArrayList(){
		return materialsNeeded;
	}
	
	public String getMaterialsNeeded(){
		String toReturn = "";
		for(int i = 0; i<materialsNeeded.size()-1; i++){
			toReturn += materialsNeeded.get(i) + ", ";
		}
		if(materialsNeeded.size()>0)
			toReturn += materialsNeeded.get(materialsNeeded.size()-1);
		
		return toReturn;
	}
	
	
	public String toString(){
		String toReturn = "";
		toReturn += "[Project][" + subject + "] " + title + "\n";
		toReturn += "Due: " + toStringTime() + " - " + getStatusFull();
		if(materialsNeeded.size() != 0)
			toReturn += "\nNeed: " + getMaterialsNeeded();
		return toReturn;
	}
	private String toStringTime(){
		 SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyy");
		    fmt.setCalendar(dueDate);
		    String dateFormatted = fmt.format(dueDate.getTime());
		    return dateFormatted;
	}
	
}
