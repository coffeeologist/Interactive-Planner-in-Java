import java.util.*;
import java.text.*;
public class MainPlanner {

	private ArrayList<Homework> homeworks;
	private ArrayList<Project> projects;
	private ArrayList<Reminder> reminders;
	
	private GregorianCalendar gregorianCalendar;
	
	public Scanner scan;
	
	public MainPlanner(){
		homeworks = new ArrayList<Homework>();
		projects = new ArrayList<Project>();
		reminders = new ArrayList<Reminder>();
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-"
				+ "\nWelcome to BWAHAHAMUAHAHAMWWAAAHAHAA Planner. \nThe planner that helps you to stop procrastinating."
				+ "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-"); 

		gregorianCalendar=new GregorianCalendar();   
		scan = new Scanner(System.in);
	
	}
	
	public String runMain(){
		 String command = "";
			 boolean validOrder = false;
			 String whatever = "";
			 while(!validOrder){
				 command = "";
				 System.out.println("\nIt is currently " + currentTime()
				 		 + ". What would you like to do?"
						 + "\n\t(->*'3`)-> View Assignments"
						 + "\n\t(->*'3`)-> Quick Check on Need-To-Do"
						 + "\n\t(->*'3`)-> Manage Assignments"
						 + "\n\t(->*'3`)-> View Related Information\n");
				 command = scan.nextLine();
				 
				 if(command.equalsIgnoreCase("assignments") ||
					command.equalsIgnoreCase("view") ||
					command.equalsIgnoreCase("assignment")){
					 System.out.println("^(??.___.)^ Sorry, can't process your order because it was ambigious"
					 		+ "\nPRESS ENTER, then please retype your command. \n"); 
					 whatever = scan.nextLine();
				 } else if(command.equalsIgnoreCase("view assignments")||
						 command.equalsIgnoreCase("view assignment")){
					 validOrder = true;
					 command = "VA";
				 } else if(command.equalsIgnoreCase("quick check")||
						 command.equalsIgnoreCase("need to do")||
						 command.equalsIgnoreCase("quick check on need to do")||
						 command.equalsIgnoreCase("quick check on need-to-do")||
						 command.equalsIgnoreCase("check on need to do")||
						 command.equalsIgnoreCase("check on need-to-do")){
					 validOrder = true;
					 command = "QC";
				 } else if(command.equalsIgnoreCase("manage")||
						 command.equalsIgnoreCase("manage assignments")||
						 command.equalsIgnoreCase("manage assigment")){
					 validOrder = true;
					 command = "MA";
				 } else if(command.equalsIgnoreCase("related")||
						 command.equalsIgnoreCase("information")||
						 command.equalsIgnoreCase("informations")||
						 command.equalsIgnoreCase("related information")||
						 command.equalsIgnoreCase("related informations")||
						 command.equalsIgnoreCase("view information")||
						 command.equalsIgnoreCase("view informations")||
						 command.equalsIgnoreCase("view related information")||
						 command.equalsIgnoreCase("view related informations")){
					 validOrder = true;
					 command = "VRI";
				 } else{
					 System.out.print("(OvO) uh... See, I'm not an AI system."
					 		+ "\nEither fix your spelling or type something I can understand. PRESS ENTER\n");
					 whatever = scan.nextLine();
				 } 			 	
			 }
			 
			 return command;
	}
	
	public String runViewAssignment(){
		 String whatever = "";
		 String subCommand = "";
		 boolean validOrder = false;
		 while(!validOrder){
			 System.out.println("VIEWING ASSIGNMENTS"
			 		+ "\nOk! How would you like to view the assignments?"
					 + "\n\t(->*'3`)-> View all assignments"
					 + "\n\t(->*'3`)-> View due assignments"
					 + "\n\t(->*'3`)-> View overdue assignments"
					 + "\n\t(->*'3`)-> View assingments of a status\n");	
			 subCommand = scan.nextLine();
			 
			 if(subCommand.equalsIgnoreCase("view") ||
					 subCommand.equalsIgnoreCase("assignment")||
					 subCommand.equalsIgnoreCase("assignments")||
					 subCommand.equalsIgnoreCase("view assignment")||
					 subCommand.equalsIgnoreCase("view assignments")){
				 System.out.println("^(??.___.)^  YEA, I KNOW, please BE MORE SPECIFIC!"
				 		+ "\nPRESS ENTER, then please re-enter an order. ");	
				 whatever = scan.nextLine(); 
			 } else if(subCommand.equalsIgnoreCase("all")||
					 subCommand.equalsIgnoreCase("all assignment")||
					 subCommand.equalsIgnoreCase("all assignments")||
					 subCommand.equalsIgnoreCase("view all")||
					 subCommand.equalsIgnoreCase("view all assignment")||
					 subCommand.equalsIgnoreCase("view all assignments")){
				 subCommand = "SVAA";
				 validOrder = true;
			 } else if(subCommand.equalsIgnoreCase("due")||
					 subCommand.equalsIgnoreCase("due assignment")||
					 subCommand.equalsIgnoreCase("due assignments")||
					 subCommand.equalsIgnoreCase("view due assignment")||
					 subCommand.equalsIgnoreCase("view due assignments")){
				 subCommand = "SVDA";
				 validOrder = true;
			 }else if(subCommand.equalsIgnoreCase("overdue")||
					 subCommand.equalsIgnoreCase("overdue assignment")||
					 subCommand.equalsIgnoreCase("overdue assignments")||
					 subCommand.equalsIgnoreCase("view overdue assignment")||
					 subCommand.equalsIgnoreCase("view overdue assignments")){
				 subCommand = "SVOA";
				 validOrder = true;
			 }else if(subCommand.equalsIgnoreCase("status")||
					 subCommand.equalsIgnoreCase("a status")||
					 subCommand.equalsIgnoreCase("assignment of a status")||
					 subCommand.equalsIgnoreCase("assignments of a status")||
					 subCommand.equalsIgnoreCase("view assignments of a status")||
					 subCommand.equalsIgnoreCase("view assignment of a status")){
				 subCommand = "SVAOS";
				 validOrder = true;
			 } else {
				 System.out.print("(OvO) uh... See, I'm not an AI system."
					 		+ "\nEither fix your spelling or type something I can understand. PRESS ENTER\n");
					 whatever = scan.nextLine();
			 }
		 }
		 
		 return subCommand;
	}
	
	public String runManageAssignment(){
		String whatever = "";
		 String subCommand = "";
		 boolean validOrder = false;
		 while(!validOrder){
			 System.out.println("MANAGING ASSIGNMENTS"
			 		+ "\nOk! How would you like to manage the assignments?"
					 + "\n\t(->*'3`)-> Add assignments"
					 + "\n\t(->*'3`)-> Delete completed assignments"
					 + "\n\t(->*'3`)-> Clear all assignments"
					 + "\n\t(->*'3`)-> Change assignment status\n");	
			 subCommand = scan.nextLine();
			 
			 if(subCommand.equalsIgnoreCase("assignment")||
					 subCommand.equalsIgnoreCase("assignments")){
				 System.out.println("^(??.___.)^  YEA, please I KNOW, BE MORE SPECIFIC!"
				 		+ "\nPRESS ENTER, then please re-enter an order. ");	
				 whatever = scan.nextLine(); 
			 } else if(subCommand.equalsIgnoreCase("all")||
					 subCommand.equalsIgnoreCase("clear")||
					 subCommand.equalsIgnoreCase("clear all")||
					 subCommand.equalsIgnoreCase("all assignment")||
					 subCommand.equalsIgnoreCase("all assignments")||
					 subCommand.equalsIgnoreCase("clear all assignment")||
					 subCommand.equalsIgnoreCase("clear all assignments")){
				 subCommand = "SCAA";
				 validOrder = true;
			 } else if(subCommand.equalsIgnoreCase("delete")||
					 subCommand.equalsIgnoreCase("completed")||
					 subCommand.equalsIgnoreCase("completed assignment")||
					 subCommand.equalsIgnoreCase("completed assignments")||
					 subCommand.equalsIgnoreCase("delete completed assignment")||
					 subCommand.equalsIgnoreCase("delete completed assignments")){
				 subCommand = "SDCA";
				 validOrder = true;
			 }else if(subCommand.equalsIgnoreCase("add")||
					 subCommand.equalsIgnoreCase("add assignment")||
					 subCommand.equalsIgnoreCase("add assignments")){
				 subCommand = "SAA";
				 validOrder = true;
			 }else if(subCommand.equalsIgnoreCase("status")||
					 subCommand.equalsIgnoreCase("change")||
					 subCommand.equalsIgnoreCase("change status")||
					 subCommand.equalsIgnoreCase("assignment status")||
					 subCommand.equalsIgnoreCase("change assignment status")){
				 subCommand = "SCAS";
				 validOrder = true;
			 } else {
				 System.out.print("(OvO) uh... See, I'm not an AI system."
					 		+ "\nEither fix your spelling or type something I can understand. PRESS ENTER\n");
					 whatever = scan.nextLine();
			 }
		 }
		 
		 return subCommand;
		
	}
	
	public String runRelatedInfo(){
		 String whatever = "";
		 String subCommand = "";
		 boolean validOrder = false;
		 while(!validOrder){
			 System.out.println("VIEWING RELATED INFORMATION"
			 		+ "\nOk! What related information do you want to view?"
					 + "\n\t(->*'3`)-> View shopping list"
					 + "\n\t(->*'3`)-> View people of interest");	
			 subCommand = scan.nextLine();
			 
			 if(subCommand.equalsIgnoreCase("view")){
				 System.out.println("^(??.___.)^ YEA, I KNOW, please BE MORE SPECIFIC!"
				 		+ "\nPRESS ENTER, then please re-enter an order. ");	
				 whatever = scan.nextLine(); 
			 } else if(subCommand.equalsIgnoreCase("list")||
					 subCommand.equalsIgnoreCase("shopping list")||
					 subCommand.equalsIgnoreCase("view shopping list")){
				 subCommand = "SVSL";
				 validOrder = true;
			 } else if(subCommand.equalsIgnoreCase("people")||
					 subCommand.equalsIgnoreCase("people of interest")||
					 subCommand.equalsIgnoreCase("view people of interest")){
				 subCommand = "SVPOI";
				 validOrder = true;
			 } else {
				 System.out.print("(OvO) uh... See, I'm not an AI system."
					 		+ "\nEither fix your spelling or type something I can understand. PRESS ENTER\n");
					 whatever = scan.nextLine();
			 }
		 }
		 
		 return subCommand;
	}
	
	
	public GregorianCalendar getCalendar(){
		return gregorianCalendar;
	}
  //**********MANAGE ASSIGNMENTS************//
	public void addAssignment(Homework given){
		homeworks.add(given);
	}
	
	public void addAssignment(Project given){
		projects.add(given);
	}
	
	public void addAssignment(Reminder given){
		reminders.add(given);
	}
	
	public void deleteAllAssignment(){
		homeworks.clear();
		projects.clear();
		reminders.clear();
	}
	
	public void deleteAllCompleted(){
		for(int i = 0; i<homeworks.size(); i++){
			if(homeworks.get(i).getStatus().equals("C")){
				homeworks.remove(i);
				i--;
			}
		}
		for(int i = 0; i<projects.size(); i++){
			if(projects.get(i).getStatus().equals("C")){
				projects.remove(i);
				i--;
			}
		}
		for(int i = 0; i<reminders.size(); i++){
			if(reminders.get(i).getStatus().equals("C")){
				reminders.remove(i);
				i--;
			}
		}
	}
	
	public void changeStatus(){
		System.out.println("What type of assignment's status would you like to change? "
				+ "\n\t+ Homework"
				+ "\n\t+ Project"
				+ "\n\t+ Reminder");
		String tempOrder = scan.nextLine();
		
		if(tempOrder.equalsIgnoreCase("Homework")){
			if(homeworks.size() == 0){
				System.out.println("w(O_O!!)w OH NO! There are no homework assignments in here! Try another action/category!"	);
				return;
			}
			System.out.println(toStringHomework(homeworks));
			System.out.print("Please enter the # of the assignment you want to change status of ");
			int tempIndex = scan.nextInt() - 1;
			
			System.out.print("The assignment [" + homeworks.get(tempIndex).getTitle() + "] is currently "+ homeworks.get(tempIndex).getStatusFull()
					+ "\nWhat status do you want to change it to?"
					+ "\nEnter \"N\" for not started; \"O\" for ongoing; and \"C\" for completed: ");
			String tempStatus = scan.next();
			
			if(tempStatus.equalsIgnoreCase("n")){
				homeworks.get(tempIndex).setStatus("N");
			}else if(tempStatus.equalsIgnoreCase("o")){
				homeworks.get(tempIndex).setStatus("O");
			}else if(tempStatus.equalsIgnoreCase("c")){
				homeworks.get(tempIndex).setStatus("C");
			}	
		}else if(tempOrder.equalsIgnoreCase("Project")){
			if(projects.size() == 0){
				System.out.println("w(O_O!!)w OH NO! There are no projects assignments in here! Try another action/category!"	);
				return;
			}
			System.out.println(toStringProject(projects));
			System.out.print("Please enter the # of the assignment you want to change status of ");
			int tempPIndex = scan.nextInt() - 1;
			
			System.out.print("The assignment [" + projects.get(tempPIndex).getTitle() + "] is currently "+ projects.get(tempPIndex).getStatusFull()
					+ "\nWhat status do you want to change it to?"
					+ "\nEnter \"N\" for not started; \"O\" for ongoing; and \"C\" for completed: ");
			String tempPStatus = scan.next();
			
			if(tempPStatus.equalsIgnoreCase("n")){
				projects.get(tempPIndex).setStatus("N");
			}else if(tempPStatus.equalsIgnoreCase("o")){
				projects.get(tempPIndex).setStatus("O");
			}else if(tempPStatus.equalsIgnoreCase("c")){
				projects.get(tempPIndex).setStatus("C");
			}
		}else if(tempOrder.equalsIgnoreCase("Reminder")){
			if(reminders.size() == 0){
				System.out.println("w(O_O!!)w OH NO! There are no reminder assignments in here! Try another action/category!"	);
				return;
			}
			System.out.println(toStringReminder(reminders));
			System.out.print("Please enter the # of the assignment you want to change status of ");
			int tempRIndex = scan.nextInt() - 1;
			
			System.out.print("The assignment [" + reminders.get(tempRIndex).getTitle() + "] is currently "+ reminders.get(tempRIndex).getStatusFull()
					+ "\nWhat status do you want to change it to?"
					+ "\nEnter \"N\" for not started; \"O\" for ongoing; and \"C\" for completed: ");
			String tempRStatus = scan.next();
			
			if(tempRStatus.equalsIgnoreCase("n")){
				reminders.get(tempRIndex).setStatus("N");
			}else if(tempRStatus.equalsIgnoreCase("o")){
				reminders.get(tempRIndex).setStatus("O");
			}else if(tempRStatus.equalsIgnoreCase("c")){
				reminders.get(tempRIndex).setStatus("C");
			}
	}
		
	System.out.println("The status was successfully changed!");
	}
	
  //**********VIEW ASSIGNMENTS************//
  //**********QUICK CHECK************//
	
	public String viewAll(){
		
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
			toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
			cursorIndex++;
		}
		for(int i = 0; i<projects.size(); i++){
			toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
			cursorIndex++;
		}
		for(int i = 0; i<reminders.size(); i++){
			toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
			cursorIndex++;
		}
		
		return toReturn;
	}

	public String whatIsDue(){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
			if(homeworks.get(i).getDueDate().compareTo(gregorianCalendar) >= 0 &&
				!homeworks.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<projects.size(); i++){
			if(projects.get(i).getDueDate().compareTo(gregorianCalendar) >= 0 &&
				!projects.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<reminders.size(); i++){
			if(reminders.get(i).getDueDate().compareTo(gregorianCalendar) >= 0 &&
				!reminders.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		return toReturn;
	}
	
	public String whatIsDue(GregorianCalendar time){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
			if((homeworks.get(i).getDueDate().compareTo(gregorianCalendar) >= 0 &&
				homeworks.get(i).getDueDate().compareTo(time) <= 0) &&
					!homeworks.get(i).getStatus().equals("C")	){
				toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<projects.size(); i++){
			if((projects.get(i).getDueDate().compareTo(gregorianCalendar) >= 0 &&
				projects.get(i).getDueDate().compareTo(time) <= 0 ) &&
					!projects.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<reminders.size(); i++){
			if((reminders.get(i).getDueDate().compareTo(gregorianCalendar) >= 0 &&
				reminders.get(i).getDueDate().compareTo(time) <= 0 )&&
				!reminders.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		return toReturn;
	}
	
	public String whatIsOverDue(){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
			if(homeworks.get(i).getDueDate().compareTo(gregorianCalendar) <= 0 &&
				!homeworks.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<projects.size(); i++){
			if(projects.get(i).getDueDate().compareTo(gregorianCalendar) <= 0 &&
					!projects.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<reminders.size(); i++){
			if(reminders.get(i).getDueDate().compareTo(gregorianCalendar) <= 0 &&
					!reminders.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		return toReturn;
	}
	
	
	public String whatIsNotStarted(){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
			if(homeworks.get(i).getStatus().equals("N")){
				toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<projects.size(); i++){
			if(projects.get(i).getStatus().equals("N")){
				toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<reminders.size(); i++){
			if(reminders.get(i).getStatus().equals("N")){
				toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		return toReturn;
	}
	
	public String whatIsOngoing(){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
			if(homeworks.get(i).getStatus().equals("O")){
				toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<projects.size(); i++){
			if(projects.get(i).getStatus().equals("O")){
				toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<reminders.size(); i++){
			if(reminders.get(i).getStatus().equals("O")){
				toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		return toReturn;
	}
	
	public String whatIsCompleted(){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
			if(homeworks.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<projects.size(); i++){
			if(projects.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		for(int i = 0; i<reminders.size(); i++){
			if(reminders.get(i).getStatus().equals("C")){
				toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
				cursorIndex++;
			}
		}
		return toReturn;
	}
	
  //**********VIEW RELATED INFOMRATION************//
	public String whatIsShoppingList(){
		String toReturn = "You need: ";
		if(homeworks.size() != 0){
			for(int i = 0; i<homeworks.size(); i++){
				if(!homeworks.get(i).equals("")){
					toReturn += homeworks.get(i).getMaterialsNeeded() + ", ";
				}
			}
		}
		if(projects.size() != 0){
			for(int i = 0; i<projects.size(); i++){
				if(!projects.get(i).equals("")){
					toReturn += projects.get(i).getMaterialsNeeded() + ", ";
				}
			}
		}
		toReturn += "and that's all!";
		
		if(toReturn.equals("You need: and that's all!")){
			toReturn = "(�bo�b)/ No materials needed!";
		}
		return toReturn;
	}
	
	public String needToSee(){
		String toReturn = "You need to see: ";
		if(reminders.size() != 0){
			for(int i = 0; i<reminders.size(); i++){
				if(!reminders.get(i).equals("")){
					toReturn += reminders.get(i).getRelatedPpl() + ", ";
				}
			}
		}
		toReturn += "and that's all!";
		if(toReturn.equals("You need to see: and that's all!")){
			toReturn = "(�bo�b)/ No people of interest!";
		}
		return toReturn;
	}
	
	
  //**********TERMINATE************//
	public void GoingToSleep(){
		GregorianCalendar tomorrow = new GregorianCalendar();
		tomorrow.add(tomorrow.DAY_OF_YEAR, 1);
		if(!whatIsDue(tomorrow).equals("")){
			System.out.println("\nJust a quick alert that for tomorrow, you have: "
					+ "\n" + whatIsDue(tomorrow));
		}
		System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-"
				+ "\nThank you for using BWAHAHAMUAHAHAMWWAAAHAHAA Planner!"
				+ "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-"
				+ "\nGoing to sleep... (-v-*) Z z z");
	}
	
	public String currentTime(){
	    SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	    fmt.setCalendar(gregorianCalendar);
	    String dateFormatted = fmt.format(gregorianCalendar.getTime());
	    return dateFormatted;
	}
	
	private String toStringHomework(ArrayList<Homework> given){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<homeworks.size(); i++){
				toReturn += cursorIndex + ". " + homeworks.get(i).toString()+ "\n";
				cursorIndex++;
		}
		return toReturn;
	}
	
	private String toStringProject(ArrayList<Project> given){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<projects.size(); i++){
				toReturn += cursorIndex + ". " + projects.get(i).toString()+ "\n";
				cursorIndex++;
		}
		return toReturn;
	}
	
	private String toStringReminder(ArrayList<Reminder> given){
		String toReturn = "";
		int cursorIndex = 1;
		for(int i = 0; i<reminders.size(); i++){
				toReturn += cursorIndex + ". " + reminders.get(i).toString()+ "\n";
				cursorIndex++;
		}
		return toReturn;
	}

}
