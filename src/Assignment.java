import java.util.*;
public class Assignment {
	String title, status;
	GregorianCalendar dueDate;
	
	public Assignment(String name, String state, GregorianCalendar date)
	{
		title = name;
		status = state;
		dueDate = date;
	}
	
	public void setTitle(String name){
		title = name;
	}
	
	public void setStatus(String state){
		status = state;
	}
	
	public void setDate(GregorianCalendar date){
		dueDate = date;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getStatus(){
		return status;
	}
	
	public String getStatusFull(){
		if(status.equals("N"))
			return "Not Started";
		else if(status.equals("O"))
			return "Ongoing";
		else
			return "Completed"; 
	}
	
	public Calendar getDueDate(){
		return dueDate;
	}
	
}
