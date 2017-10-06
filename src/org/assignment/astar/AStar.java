package org.assignment.astar;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AStar {

	static int [][]inputState=new int[3][3];
	static int [][]outputState=new int[3][3];
	int [][]newStateA=new int[3][3];
	int [][]newStateB=new int[3][3];
	int [][]newStateC=new int[3][3];
	int [][]newStateD=new int[3][3];
	int [][]state=new int[3][3];
	
	//private int iteration=0;
	
	//This static variable stores the list of states
	static ArrayList<int[][]> states=new ArrayList<>();
	
	public void checkStates(int [][]currentState, int iteration){
		//If its the first iteration
		if(iteration==0)
			states.add(currentState);
		
		boolean flag=false, flagA=false,flagB=false,flagC=false,flagD=false,matchFlag=true;
		int zeroI=0,zeroJ=0;
		//int heuristic[]={100,100,100,100};
		Map<String, Integer> sortedMap;
		List<Entry<String, Integer>> list;
		//Create a HashMap of the next states and set the default heuristic value to 100 
		HashMap<String, Integer> heuristics=new HashMap<>();
		heuristics.put("A", 100);
		heuristics.put("B", 100);
		heuristics.put("C", 100);
		heuristics.put("D", 100);
		
		//Check if the final state is reached
		for (int i=0;i<currentState.length && matchFlag==true;i++){
			for(int j=0;j<currentState[i].length && matchFlag==true;j++){
				if(currentState[i][j]!=outputState[i][j]){
					matchFlag=false;
				}
			}
		}
		
		if(matchFlag==true){
			System.out.println("Final State Reached at iteration "+iteration);
		}
		
		//If the iteration reaches beyond 100 states, trace back to the earlier states
		else if(iteration >=100){
			System.out.println("Reached 100 states");
		}
		else{
		//This loop is for checking where the zero is present 
			for (int i=0;i<currentState.length && flag==false;i++){
				for(int j=0;j<currentState[i].length && flag==false;j++){
					if(currentState[i][j]==0){
						zeroI=i;
						zeroJ=j;
						flag=true;
					}
				}
			}
			
			//Iterate only if zero is found
			if(flag==true){
				iteration++;
				for (int i=0;i<currentState.length;i++){
					for(int j=0;j<currentState[i].length;j++){
						newStateA[i][j]=currentState[i][j];
						newStateB[i][j]=currentState[i][j];
						newStateC[i][j]=currentState[i][j];
						newStateD[i][j]=currentState[i][j];
					}
				}
				
				System.out.println("In iteration "+iteration);
				
				//Get multiple states by swapping zero with its nearest elements
				//State A
				if(zeroI+1<currentState.length){
					int temp=0;
					temp=newStateA[zeroI][zeroJ];
					newStateA[zeroI][zeroJ]=newStateA[zeroI+1][zeroJ];
					newStateA[zeroI+1][zeroJ]=temp;
					System.out.println("StateA");
					for (int i=0;i<newStateA.length;i++){
						for(int j=0;j<newStateA[i].length;j++){
							System.out.print(newStateA[i][j]);
						}
						System.out.println();
					}
					//Check if the generated state is already visited
					boolean stateVisitFlag=true;
					for(int s=0;s<states.size();s++){
						state=states.get(s);
						for (int i=0;i<state.length && stateVisitFlag==true;i++){
							for(int j=0;j<state[i].length && stateVisitFlag==true;j++){
								if(state[i][j]!=newStateA[i][j]){
									stateVisitFlag=false;
								}
							}
						}
						if(stateVisitFlag==true){
							flagA=true; 
							System.out.println("The state is already visited");
							break;
						}
					}
					//If not, add the state to the list of visited states
					if(flagA==false){
						states.add(newStateA);
					}
				}
				else{
					flagA=true;
				}
				//State B
				if(zeroJ+1<currentState[zeroI].length){
					int temp=0;
					temp=newStateB[zeroI][zeroJ];
					newStateB[zeroI][zeroJ]=newStateB[zeroI][zeroJ+1];
					newStateB[zeroI][zeroJ+1]=temp;
					System.out.println("StateB");
					for (int i=0;i<newStateB.length;i++){
						for(int j=0;j<newStateB[i].length;j++){
							System.out.print(newStateB[i][j]);
						}
						System.out.println();
					}
					//Check if the generated state is already visited
					boolean stateVisitFlag=true;
					for(int s=0;s<states.size();s++){
						state=states.get(s);
						for (int i=0;i<state.length && stateVisitFlag==true;i++){
							for(int j=0;j<state[i].length && stateVisitFlag==true;j++){
								if(state[i][j]!=newStateB[i][j]){
									stateVisitFlag=false;
								}
							}
						}
						if(stateVisitFlag==true){
							flagB=true; 
							System.out.println("The state is already visited");
							break;
						}
					}
					//If not, add the state to the list of visited states
					if(flagB==false){
						states.add(newStateB);
					}
				}
				else{
					flagB=true;
				}
				//State C
				if(zeroI-1>=0){
					int temp=0;
					temp=newStateC[zeroI][zeroJ];
					newStateC[zeroI][zeroJ]=newStateC[zeroI-1][zeroJ];
					newStateC[zeroI-1][zeroJ]=temp;
					System.out.println("StateC");
					for (int i=0;i<newStateC.length;i++){
						for(int j=0;j<newStateC[i].length;j++){
							System.out.print(newStateC[i][j]);
						}
						System.out.println();
					}
					//Check if the generated state is already visited
					boolean stateVisitFlag=true;
					for(int s=0;s<states.size();s++){
						state=states.get(s);
						for (int i=0;i<state.length && stateVisitFlag==true;i++){
							for(int j=0;j<state[i].length && stateVisitFlag==true;j++){
								if(state[i][j]!=newStateC[i][j]){
									stateVisitFlag=false;
								}
							}
						}
						if(stateVisitFlag==true){
							flagC=true; 
							System.out.println("The state is already visited");
							break;
						}
					}
					//If not, add the state to the list of visited states
					if(flagC==false){
						states.add(newStateC);
					}
				}
				else{
					flagC=true;
				}
				//State D
				if(zeroJ-1>=0){
					int temp=0;
					temp=newStateD[zeroI][zeroJ];
					newStateD[zeroI][zeroJ]=newStateD[zeroI][zeroJ-1];
					newStateD[zeroI][zeroJ-1]=temp;
					System.out.println("StateD");
					for (int i=0;i<newStateD.length;i++){
						for(int j=0;j<newStateD[i].length;j++){
							System.out.print(newStateD[i][j]);
						}
						System.out.println();
					}
					//Check if the generated state is already visited
					boolean stateVisitFlag=true;
					for(int s=0;s<states.size();s++){
						state=states.get(s);
						for (int i=0;i<state.length && stateVisitFlag==true;i++){
							for(int j=0;j<state[i].length && stateVisitFlag==true;j++){
								if(state[i][j]!=newStateD[i][j]){
									stateVisitFlag=false;
								}
							}
						}
						if(stateVisitFlag==true){
							flagD=true; 
							System.out.println("The state is already visited");
							break;
						}
					}
					//If not, add the state to the list of visited states
					if(flagD==false){
						states.add(newStateD);
					}
				}
				else{
					flagD=true;
				}
				//If all the flags are true, then all the states has been covered
				if(flagA==true && flagB==true && flagC==true && flagD==true){
					System.out.println("All the states has been visited. There is no solution to this problem");
					System.exit(1);
				}
				//Calculate the heuristic of the state A using Manhattan distance
				if(flagA==false){
					int heuristic=0;
					for(int i=0;i<newStateA.length;i++){
						for(int j=0;j<newStateA.length;j++){
							secondLoop:for(int k=0;k<outputState.length;k++){
								for(int l=0;l<outputState.length;l++){
									if(newStateA[i][j]==outputState[k][l] && newStateA[i][j]!=0){
										heuristic+=Math.abs(i-k)+Math.abs(j-l);
										break secondLoop;
									}
								}
							}
						}
					}
					heuristics.put("A", heuristic);
				}
				//Calculate the heuristic of the state B using Manhattan distance
				if(flagB==false){
					int heuristic=0;
					for(int i=0;i<newStateB.length;i++){
						for(int j=0;j<newStateB.length;j++){
							secondLoop:for(int k=0;k<outputState.length;k++){
								for(int l=0;l<outputState.length;l++){
									if(newStateB[i][j]==outputState[k][l] && newStateB[i][j]!=0){
										heuristic+=Math.abs(i-k)+Math.abs(j-l);
										break secondLoop;
									}
								}
							}
						}
					}
					heuristics.put("B", heuristic);
				}
				//Calculate the heuristic of the state C using Manhattan distance
				if(flagC==false){
					int heuristic=0;
					for(int i=0;i<newStateC.length;i++){
						for(int j=0;j<newStateC.length;j++){
							secondLoop:for(int k=0;k<outputState.length;k++){
								for(int l=0;l<outputState.length;l++){
									if(newStateC[i][j]==outputState[k][l] && newStateC[i][j]!=0){
										heuristic+=Math.abs(i-k)+Math.abs(j-l);
										break secondLoop;
									}
								}
							}
						}
					}
					heuristics.put("C", heuristic);
				}
				//Calculate the heuristic of the state D using Manhattan distance
				if(flagD==false){
					int heuristic=0;
					for(int i=0;i<newStateD.length;i++){
						for(int j=0;j<newStateD.length;j++){
							secondLoop:for(int k=0;k<outputState.length;k++){
								for(int l=0;l<outputState.length;l++){
									if(newStateD[i][j]==outputState[k][l] && newStateD[i][j]!=0){
										heuristic+=Math.abs(i-k)+Math.abs(j-l);
										break secondLoop;
									}
								}
							}
						}
					}
					heuristics.put("D", heuristic);
				}
				System.out.println(Arrays.asList(heuristics));
				//Sort the HashMap in increasing value of Heuristic value
				list = new LinkedList<Entry<String, Integer>>(heuristics.entrySet());
			    Collections.sort(list, new MyComparator());
			    sortedMap = new LinkedHashMap<String, Integer>();
			    for (Entry<String, Integer> entry : list) {
			      sortedMap.put(entry.getKey(), entry.getValue());
			    }
			    Iterator<Map.Entry<String, Integer>> it=sortedMap.entrySet().iterator();
			    Map.Entry<String,Integer> entry= it.next();
			    System.out.println("The least heuristic value "+ entry.getValue());
			    System.out.println("Stored States Size "+states.size());
			    
//			    if(iteration>100){
//					System.exit(0);
//				}
			    //If state A has the least heuristic, then make a recursive call to checkStates with the state A as argument
			    if(entry.getKey()=="A" || entry.getValue() == heuristics.get("A")){
			    	//Check if the state is the final state
			    	if(entry.getValue()==0){
			    		System.out.println("Final State Reached at iteration "+iteration);
			    		System.exit(1);
			    	}
			    	checkStates(newStateA, iteration);
			    	if(it.hasNext()){
//			    		System.out.println("Has Next");
			    		Map.Entry<String,Integer> entry1= it.next();
//			    		System.out.println("Next "+ iteration+" "+entry.getValue()+" "+entry1.getValue());
			    		//Check if the next element has the same heuristic value
			    		if(entry1.getValue()==entry.getValue()){
			    			
				    		if(entry1.getKey()=="B")
				    			checkStates(newStateB, iteration);
				    		else if(entry1.getKey()=="C")
				    			checkStates(newStateC, iteration);
				    		else if(entry1.getKey()=="D")
				    			checkStates(newStateD, iteration);
			    		}
			    	}
			    }
			  //If state B has the least heuristic, then make a recursive call to checkStates with the state B as argument
			    if(entry.getKey()=="B" || entry.getValue() == heuristics.get("B")){
			    	//Check if the state is the final state
			    	if(entry.getValue()==0){
			    		System.out.println("Final State Reached at iteration "+iteration);
			    		System.exit(1);
			    	}
			    	checkStates(newStateB,iteration);
			    	if(it.hasNext()){
//			    		System.out.println("Has Next");
			    		Map.Entry<String,Integer> entry1=it.next();
//			    		System.out.println("Next "+iteration+" "+entry.getValue()+" "+entry1.getValue());
			    		//Check if the next element has the same heuristic value
			    		if(entry1.getValue()==entry.getValue()){
			    			
				    		if(entry1.getKey()=="A")
				    			checkStates(newStateA, iteration);
				    		else if(entry1.getKey()=="C")
				    			checkStates(newStateC, iteration);
				    		else if(entry1.getKey()=="D")
				    			checkStates(newStateD, iteration);
			    		}
			    	}
			    }
			  //If state C has the least heuristic, then make a recursive call to checkStates with the state C as argument
			    if(entry.getKey()=="C" || entry.getValue() == heuristics.get("C")){
			    	//Check if the state is the final state
			    	if(entry.getValue()==0){
			    		System.out.println("Final State Reached at iteration "+iteration);
			    		System.exit(1);
			    	}
			    	checkStates(newStateC,iteration);
			    	
			    	if(it.hasNext()){
			    		Map.Entry<String,Integer> entry1=it.next();
//			    		System.out.println("Next "+ iteration+" "+entry.getValue()+" "+entry1.getValue());
			    		//Check if the next element has the same heuristic value
			    		if(entry1.getValue()==entry.getValue()){
			    			
				    		if(entry1.getKey()=="B")
				    			checkStates(newStateB, iteration);
				    		else if(entry1.getKey()=="A")
				    			checkStates(newStateA, iteration);
				    		else if(entry1.getKey()=="D")
				    			checkStates(newStateD, iteration);
			    		}
			    	}
			    }
			  //If state D has the least heuristic, then make a recursive call to checkStates with the state D as argument
			    if(entry.getKey()=="D" || entry.getValue() == heuristics.get("D")){
			    	//Check if the state is the final state
			    	if(entry.getValue()==0){
			    		System.out.println("Final State Reached at iteration "+iteration);
			    		System.exit(1);
			    	}
			    	checkStates(newStateD,iteration);
			    	
			    	if(it.hasNext()){
			    		Map.Entry<String,Integer> entry1=it.next();
//			    		System.out.println("Next " + iteration +" "+entry.getValue()+" "+entry1.getValue());
			    		//Check if the next element has the same heuristic value
			    		if(entry1.getValue()==entry.getValue()){
			    			
				    		if(entry1.getKey()=="B")
				    			checkStates(newStateB, iteration);
				    		else if(entry1.getKey()=="C")
				    			checkStates(newStateC, iteration);
				    		else if(entry1.getKey()=="A")
				    			checkStates(newStateA, iteration);
			    		}
			    	}
			    }
			}
			else{
				System.out.println("Zero not found");
				System.exit(0);
			}
		}
	}
	
	public static void main(String[]args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the input state one by one");
		//Read the input state
		for (int i=0;i<inputState.length;i++){
			for(int j=0;j<inputState[i].length;j++){
				try{
					inputState[i][j]=Integer.parseInt(br.readLine());
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		//Read the output state
		System.out.println("Enter the output state one by one");
		for (int i=0;i<outputState.length;i++){
			for(int j=0;j<outputState[i].length;j++){
				try{
					outputState[i][j]=Integer.parseInt(br.readLine());
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		System.out.println("The Input state");
		for (int i=0;i<inputState.length;i++){
			for(int j=0;j<inputState[i].length;j++){
				System.out.print(inputState[i][j]);
			}
			System.out.println();
		}
		System.out.println("The Output state");
		for (int i=0;i<outputState.length;i++){
			for(int j=0;j<outputState[i].length;j++){
				System.out.print(outputState[i][j]);
			}
			System.out.println();
		}
		//Call the checkStates function with input state as the argument
		new AStar().checkStates(inputState,0);
	}

}

//Overwrite the comparator class
class MyComparator implements Comparator<Entry<String, Integer>> {
	  public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
	    return o1.getValue().compareTo(o2.getValue());
	  }
	}
