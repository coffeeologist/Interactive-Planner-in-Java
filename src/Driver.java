//By Amy Liu

import java.util.*;
public class Driver {

	public static void main(String[] args){
		 MainPlanner planner = new MainPlanner();
		 String placeHolder = "";
		 String end = "";
		do{
			Scanner scan = new Scanner(System.in);
			placeHolder = planner.runMain();
			if(placeHolder.equals("VA")){
				placeHolder = planner.runViewAssignment();
				if(placeHolder.equals("SVAA")){
						if(planner.viewAll().equals(""))
							System.out.println("(/^O^)/ There is nothing to view~");
						else
							System.out.println(planner.viewAll());
				}else if(placeHolder.equals("SVDA")){
					System.out.println("Do you want to set a time limit? Y / N");
					String finalOrder = scan.nextLine();
					if(finalOrder.equalsIgnoreCase("Y")||
						finalOrder.equalsIgnoreCase("yes")){
						System.out.println("It is currently " + planner.currentTime()
									+ "\nPlease enter your time limit in MM/DD/YYYY form:");
						String time = scan.nextLine();
						String[] tempTime = time.split("/");
						tempTime[0] = tempTime[0].replaceFirst("^0", "");
						GregorianCalendar temp = new GregorianCalendar(Integer.parseInt(tempTime[2]), Integer.parseInt(tempTime[0])-1, Integer.parseInt(tempTime[1]));
						if(planner.whatIsDue(temp).equals(""))
							System.out.println("(/^O^)/ There is nothing due~");
						else
							System.out.println(planner.whatIsDue(temp));
					}else if(finalOrder.equalsIgnoreCase("N")||
						finalOrder.equalsIgnoreCase("No")){
						if(planner.whatIsDue().equals(""))
							System.out.println("(/^O^)/ There is nothing due~");
						else
							System.out.println(planner.whatIsDue());;
					}
				}else if(placeHolder.equals("SVOA")){
					if(planner.whatIsOverDue().equals(""))
						System.out.println("(/^O^)/ There is nothing over due~");
					else
						System.out.println(planner.whatIsOverDue());
				}else if(placeHolder.equals("SVAOS")){
					System.out.println("What status of assignments do you want to see?"
							+ "\n\t(->*'3`)-> Not Started"
							+ "\n\t(->*'3`)-> Ongoing"
							+ "\n\t(->*'3`)-> Completed");
					String temp = scan.nextLine();
					if(temp.equalsIgnoreCase("not started")||
						temp.equalsIgnoreCase("not")||
						temp.equalsIgnoreCase("started")){
						if(planner.whatIsNotStarted().equals(""))
							System.out.println("(/^O^)/ There is nothing here~");
						else
							System.out.println(planner.whatIsNotStarted());
					}else if(temp.equalsIgnoreCase("ongoing")){
						if(planner.whatIsOngoing().equals(""))
							System.out.println("(/^O^)/ There is nothing here~");
						else
						System.out.println(planner.whatIsOngoing());
					}else if(temp.equalsIgnoreCase("completed")){
						if(planner.whatIsCompleted().equals(""))
							System.out.println("(/^O^)/ There is nothing here~");
						else
							System.out.println(planner.whatIsCompleted());
					}
				}
			}else if(placeHolder.equals("QC")){
				if(planner.whatIsOverDue().equals("") && planner.whatIsNotStarted().equals(""))
					System.out.println("(/^O^)/ There is nothing you need to do here~ You are all set!");
				else{
					System.out.println("Better get started on these!");
					System.out.println(planner.whatIsOverDue());
					System.out.println(planner.whatIsNotStarted());
				}
			}else if(placeHolder.equals("MA")){
				placeHolder = planner.runManageAssignment();
				if(placeHolder.equals("SCAA")){
					planner.deleteAllAssignment();
					System.out.println("The planner now holds no assignment");
				}else if(placeHolder.equals("SDCA")){
					planner.deleteAllCompleted();
					System.out.println("The planner now only holds ongoing or not started assignments");	
				}else if(placeHolder.equals("SAA")){
					System.out.print("d(· 3 <) Ok! Let's give it a name first. \nEnter the assignment title: ");
					String tempName = scan.nextLine();
					System.out.print("d(· 3 <) Ok! A due date? (in MM/DD/YYYY format): ");
					String tempTimeTime = scan.nextLine();
					String[] tempTime = tempTimeTime.split("/");
					tempTime[0] = tempTime[0].replaceFirst("^0", "");
					System.out.print("d(· 3 <) Ok! Is this a Homework or a Project or a Reminder? ");
					String tempType = scan.nextLine();
					
					if(tempType.equalsIgnoreCase("homework")){
						System.out.print("d(· 3 <) Gotchu! What subject is this assignment for? ");
						String tempCourse = scan.nextLine();
						System.out.print("d(· 3 <) Almost there! Is there any materials you need for this assignment?"
								+ "\nWhen listing, spereate items by \", \": "
								+ "\nIf there is nothing you need, just press ENTER ");
						String tempMaterialString = scan.nextLine();
						if(!tempMaterialString.equals("")){
							ArrayList<String> tempMaterialList = new ArrayList<String>(Arrays.asList(tempMaterialString.split(", ")));
							planner.addAssignment(new Homework(tempName, "N", new GregorianCalendar(Integer.parseInt(tempTime[2]), (Integer.parseInt(tempTime[0])-1), Integer.parseInt(tempTime[1])), tempCourse, tempMaterialList));
						}else
							planner.addAssignment(new Homework(tempName, "N", new GregorianCalendar(Integer.parseInt(tempTime[2]), Integer.parseInt(tempTime[0])-1, Integer.parseInt(tempTime[1])), tempCourse));
						
					}else if(tempType.equalsIgnoreCase("project")){
						System.out.print("d(· 3 <) Gotchu! What subject is this assignment for? ");
						String tempCourse = scan.nextLine();
						System.out.print("d(· 3 <) Almost there! Is there any materials you need for this assignment?"
								+ "\nWhen listing, spereate items by \", \": "
								+ "\nIf there is nothing you need, just press ENTER ");
						String tempMaterialString = scan.nextLine();
						if(!tempMaterialString.equals("")){
							ArrayList<String> tempMaterialList = new ArrayList<String>(Arrays.asList(tempMaterialString.split(", ")));
							planner.addAssignment(new Project(tempName, "N", new GregorianCalendar(Integer.parseInt(tempTime[2]), Integer.parseInt(tempTime[0])-1, Integer.parseInt(tempTime[1])), tempCourse, tempMaterialList));
						}else
							planner.addAssignment(new Project(tempName, "N", new GregorianCalendar(Integer.parseInt(tempTime[2]), Integer.parseInt(tempTime[0])-1, Integer.parseInt(tempTime[1])), tempCourse));
					
					}else if(tempType.equalsIgnoreCase("reminder")){
						System.out.print("d(· 3 <) Almost there! Is there any object you need for this assignment?"
								+ "\nWhen listing, spereate items by \", \": "
								+ "\nIf there is nothing you need, just press ENTER ");
						String tempObjectString = scan.nextLine();
						if(tempObjectString.equals("")){
							planner.addAssignment(new Reminder(tempName, "N", new GregorianCalendar(Integer.parseInt(tempTime[2]), Integer.parseInt(tempTime[0])-1, Integer.parseInt(tempTime[1]))));
						}else{
							ArrayList<String> tempObjectList = new ArrayList<String>(Arrays.asList(tempObjectString.split(", ")));
							System.out.print("d(· 3 <) Last Part! Are there related people of this assignment?"
									+ "\nWhen listing, spereate items by \", \": "
									+ "\nIf there is no one you need to see, just press ENTER ");
							String tempPplString = scan.nextLine();
							if(!tempPplString.equals("")){
								ArrayList<String> tempPplList = new ArrayList<String>(Arrays.asList(tempPplString.split(", ")));
								planner.addAssignment(new Reminder(tempName, "N", new GregorianCalendar(Integer.parseInt(tempTime[2]), Integer.parseInt(tempTime[0])-1, Integer.parseInt(tempTime[1])), tempObjectList, tempPplList));
							}else
								planner.addAssignment(new Reminder(tempName, "N", new GregorianCalendar(Integer.parseInt(tempTime[2]), Integer.parseInt(tempTime[0])-1, Integer.parseInt(tempTime[1]))));
						}
							
					}
				} else if(placeHolder.equals("SCAS")){
					planner.changeStatus();
				}
			}else if(placeHolder.equals("VRI")){
				placeHolder = planner.runRelatedInfo();
				if(placeHolder.equals("SVSL"))
					System.out.println(planner.whatIsShoppingList());
				else if(placeHolder.equals("SVPOI")){
					System.out.println(planner.needToSee());
				}
			}
		
		System.out.println("\n(o'v'o)DONE~!");
		System.out.print("\nDo you want to continue using this Planner or nah? ");
		String finalResponse = scan.nextLine();
		
		if(finalResponse.equalsIgnoreCase("no")||
			finalResponse.equalsIgnoreCase("nah")||
			finalResponse.equalsIgnoreCase("N")||
			finalResponse.equalsIgnoreCase("naw")||
			finalResponse.equalsIgnoreCase("nope")){
			end = "terminate";
			}
		}while(!end.equals("terminate"));
		
		planner.GoingToSleep();
	}

}