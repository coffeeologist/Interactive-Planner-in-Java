import java.text.SimpleDateFormat;
import java.util.*;
public class Reminder extends Assignment {
		ArrayList<String> objects, relatedPpl;
		
		public Reminder(String name, String state, GregorianCalendar date){
			super(name, state, date);
			objects = null;
			relatedPpl = new ArrayList<String>();
			System.out.println("\nReminder assignment successfully created.");
		}
		
		public Reminder(String name, String state, GregorianCalendar date, ArrayList<String>items){
			super(name, state, date);
			objects = items;
			relatedPpl = new ArrayList<String>();
			System.out.println("\nReminder assignment successfully created.");
		}

		public Reminder(String name, String state, GregorianCalendar date, ArrayList<String>items, ArrayList<String>ppls){
			super(name, state, date);
			objects = items;
			relatedPpl = ppls;
			System.out.println("\nReminder assignment successfully created.");
		}

		public void setObjectsNeeded(ArrayList<String> items){
			objects = items;
		}
		
		public void setRelatedPpl(ArrayList<String> ppls){
			relatedPpl = ppls;
		}
		
		public ArrayList<String> getObjectArrayList(){
			return objects;
		}
		
		public ArrayList<String> getRelatedPplArrayList(){
			return relatedPpl;
		}

		public String getObjectsNeeded(){
			String toReturn = "";
			for(int i = 0; i<objects.size()-1; i++){
				toReturn += objects.get(i) + ", ";
			}
			if(objects.size()>0)
			toReturn += objects.get(objects.size()-1);
			
			return toReturn;
		}
		
		public String getRelatedPpl(){
			String toReturn = "";
			for(int i = 0; i<relatedPpl.size()-1; i++){
				toReturn += relatedPpl.get(i) + ", ";
			}
			if(relatedPpl.size()>0)
			toReturn += relatedPpl.get(relatedPpl.size()-1);
			
			return toReturn;
		}
		
		public String toString(){
			String toReturn = "";
			toReturn += "[Reminder] "+ title + "\n";
			toReturn += "Due: " + toStringTime() + " - " + getStatusFull();
			if(objects.size() != 0)
				toReturn += "\nNeed: " + getObjectsNeeded();
			if(relatedPpl.size() != 0)
				toReturn += "\nWorking with: " + getRelatedPpl();
			return toReturn;
		}
		
		private String toStringTime(){
			 SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
			    fmt.setCalendar(dueDate);
			    String dateFormatted = fmt.format(dueDate.getTime());
			    return dateFormatted;
		}
}

