package production_ready;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;



public class Interview{	

	private HashMap<String, Integer> stateCounts = new LinkedHashMap<String, Integer>();
	private HashMap<String, String> stateNames = new LinkedHashMap<String, String>();
	private List<InputData> inputList = new ArrayList<InputData>();

	//This method loads the data in to the 'stateNames' instance variable
	public void loadStateNames(){
		stateNames.put("TX", "Texas");
		stateNames.put("NY", "New York");
		stateNames.put("KY", "Kentucky");
	}	

	//This method loads the data in to the 'inputList' instance variable of 'InputData' object type
	public void loadInputList(){
		inputList.add(new InputData("Mary Jane Smith", "TX"));
		inputList.add(new InputData("John Jones", "NY"));
		inputList.add(new InputData("Madonna", "NY"));
		inputList.add(new InputData("Mark Anthony Lewis", "KY"));
		inputList.add(new InputData("Sue Reed", "TX"));
		inputList.add(new InputData("Tim Oscar Steele", "TX"));
	}

	//This method accumulates state codes and updates the counter
	public void accumilateStateCounters(){
		for(InputData aEntry : inputList){
			if(stateCounts.containsKey(aEntry.getStateCd())){
				stateCounts.put(aEntry.getStateCd(), stateCounts.get(aEntry.getStateCd())+1);
			} else {			
				stateCounts.put(aEntry.getStateCd(), 1);
			}
		}
	}

	//The method to display the results
	public void display(){
		for(String aState: stateNames.keySet()){
			System.out.println(stateNames.get(aState)+" ("+stateCounts.get(aState)+")");

			for(int i=0; i<inputList.size(); i++){
				if(aState.equals(inputList.get(i).getStateCd())){
					System.out.println("\t"+inputList.get(i).getFirstLastName());				
				}
			}
		}				
	}

	//This method is to execute all the other methods in the class
	public void driver(){
		try {
			loadStateNames();
			loadInputList();
			accumilateStateCounters();
			display();
		} catch(Exception e){
			System.out.println("Exception Caught: "+e.getMessage()+". Cause: "+e.getCause());
		}
	}

}

//Immutable class
final class InputData{

	private final String fullName;
	private final String stateCd;

	//Constructor to initialize instance variables
	public InputData(String fullName, String stateCd){
		this.fullName = fullName;
		this.stateCd = stateCd;

	}

	//Method to return the state code
	String getStateCd(){
		return stateCd;		
	}

	//Method to return full name
	String getFullName(){ 	
		return fullName; 	
	}

	//Method to return first and last name if exists
	String getFirstLastName(){		
		String[] splitFullName=fullName.split(" ");
		return splitFullName[0]+" "+(splitFullName.length==3?splitFullName[2]:splitFullName.length==2?splitFullName[1]:"");
	}
}