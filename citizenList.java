import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class citizenList {
	
	public static void main (String[] args) 
	{
		try {
            BufferedReader in = new BufferedReader(new FileReader("vaccine.txt"));
            LinkedList<citizen> citizenList = new LinkedList();
            citizen Citizen = null;
            String indata = null;
            
            while ((indata = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(indata, ";");
                String name = st.nextToken();
                String IC = st.nextToken();
                String state = st.nextToken();
                int age = Integer.parseInt(st.nextToken());
                String category = st.nextToken();
                String firstdose  = st.nextToken();
                String secdose = st.nextToken();
                String vaccine_completion = st.nextToken();

                Citizen = new citizen(name,IC,state,age,category,firstdose,secdose,vaccine_completion);
                citizenList.add(Citizen);
            }
            in.close();
           
          //create stack
		  Stack<citizen> stCenter1 = new Stack<>();
		  Stack<citizen> stCenter2 = new Stack<>();
		  Stack<citizen> stCenter3 = new Stack<>();
		  Stack<citizen> temp = new Stack<>();
		  Stack<citizen> temp2 = new Stack<>();
		  Stack<citizen> temp3 = new Stack<>();
		  
		  
		  //create queue
		  Queue<citizen> qCenter1 = new LinkedList<>();
		  Queue<citizen> qCenter2 = new LinkedList<>();
		  Queue<citizen> qCenter3 = new LinkedList<>();
		  Queue<citizen> completedList = new LinkedList<>();	  
		  
		  //
		  for(int i=0; i<citizenList.size(); i++)
	      {
	        	Citizen = citizenList.get(i);
	        	
	        	if (Citizen.getAge() >= 18 && Citizen.getAge() <= 30) 
	            {
	                stCenter1.push(Citizen);
	            } 
	            else if (Citizen.getAge() >= 31 && Citizen.getAge() <= 49) 
	            {
	                stCenter2.push(Citizen);
	            } 
	            else if (Citizen.getAge() >= 50)
	            {
	                stCenter3.push(Citizen);
	            }
	        }
		  
		  //welcome page
		  JOptionPane.showMessageDialog(null,"LET'S GET YOUR VACCINE! :)","WELCOME PAGE", JOptionPane.INFORMATION_MESSAGE);

		
		//instructor  
		int menu = 0;
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Please choose \nMENU 1 - ADD CITIZEN \nMENU 2 - REMOVE CITIZEN \nMENU 3 - FIRST DOSE STATUS \nMENU 4 - SECOND DOSE STATUS \nMENU 5 - EXIT"));
            if (menu==1) //add new citizen
            {
                String name = JOptionPane.showInputDialog("Enter the citizen's name: ");
                String IC = JOptionPane.showInputDialog("Enter the citizen's IC: ");
                String state = JOptionPane.showInputDialog("Enter the citizen's state:");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter the citizen's age: "));
                String category = JOptionPane.showInputDialog("Enter the citizen's category:");
                String firstdose = null;
                String secdose = null;
                String vaccompletion = null;

                Citizen = new citizen(name,IC,state,age,category,firstdose,secdose,vaccompletion);
                //create object
                citizenList.add(Citizen);

            }
            
            else if (menu ==2) //remove citizen
			{
	    		//ask user to enter the IC's number of the people they want to delete
	             String ic = JOptionPane.showInputDialog("Enter the IC's number that you want to remove");
	             for (int i = 0; i<citizenList.size(); i++)
	             {
	                 Citizen = citizenList.get(i);//retrieve object
	                 if (Citizen.getIc().equalsIgnoreCase(ic))
	                 {
	                     citizenList.remove(Citizen); //remove object
	                     
	                 }
	                 
	             } 
	    		 
	    	 }
            
			else if (menu == 3) //update first dose status
			{
				while (!stCenter1.isEmpty()) //put into stack
				{
					Citizen = stCenter1.pop();
                    Citizen.setFirstdose("complete");
					temp.push(Citizen);
					qCenter1.add(Citizen);
				}
				System.out.println("\t\t\t\t\t\t\t\t\t\t\tstCenter 1 after first dose");
				System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
                System.out.println(String.format("\t | %32s | %12s | %35s | %5s | %10s | %11s | %18s | %16s |", "Name", "IC Number", "State", "Age", "Category", "First Dose Status", "Second Dose Status", "Vaccine Certificate"));
                System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
			    System.out.println(temp); //after first dose
			    System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
				
				while (!stCenter2.isEmpty())
				{
					Citizen = stCenter2.pop();
					Citizen.setFirstdose("complete");
					temp2.push(Citizen);
					qCenter2.add(Citizen);
				}
				System.out.println("\n\n\t\t\t\t\t\t\t\t\t\tstCenter 2 after first dose");
				System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
                System.out.println(String.format("\t | %32s | %12s | %35s | %5s | %10s | %11s | %18s | %16s |", "Name", "IC Number", "State", "Age", "Category", "First Dose Status", "Second Dose Status", "Vaccine Certificate"));
                System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
			    System.out.println(temp2); //display stCenter2
			    System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
				
				while (!stCenter3.isEmpty())
				{
					Citizen = stCenter3.pop();
					Citizen.setFirstdose("complete");
					temp3.push(Citizen);
					qCenter3.add(Citizen);
				}
				System.out.println("\n\n\t\t\t\t\t\t\t\t\t\tstCenter 3 after first dose");
				System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
                System.out.println(String.format("\t | %32s | %12s | %35s | %5s | %10s | %11s | %18s | %16s |", "Name", "IC Number", "State", "Age", "Category", "First Dose Status", "Second Dose Status", "Vaccine Certificate"));
                System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
			    System.out.println(temp3); //display stCenter3
			    System.out.println("\t _____________________________________________________________________________________________________________________________________________________________________________");
			}
            
			else if (menu ==4) //update second dose status
			{
				int submenu = 0;
				do
				{
					submenu = Integer.parseInt(JOptionPane.showInputDialog("MENU 1 - UPDATE SECOND DOSE VACCINATION STATUS \nMENU 2 - DISPLAY ALL \nMENU 3 - EXIT"));
					
					if (submenu == 1) {
					while (!qCenter1.isEmpty()) //retrieve and remove element
					{
						Citizen = qCenter1.remove();
						Citizen.setSeconddose("complete");
						Citizen.setVaccompletion("CONGRATULATION! YOU ARE VACCINATED");
						completedList.add(Citizen);
					}
					
					
					while (!qCenter2.isEmpty()) //retrieve and remove element
					{
						Citizen = qCenter2.remove();
						Citizen.setSeconddose("complete");
						Citizen.setVaccompletion("CONGRATULATION! YOU ARE VACCINATED");
						completedList.add(Citizen);

					}

					while (!qCenter3.isEmpty()) //retrieve and remove element
					{
						Citizen = qCenter3.remove();
						Citizen.setSeconddose("complete");
						Citizen.setVaccompletion("CONGRATULATION! YOU ARE VACCINATED");
						completedList.add(Citizen);
					}
					}
					else if (submenu ==2)
					{
						System.out.println("\n \n \n");
						System.out.println("\t\t\t\t\t\t\t\t\t\tSECOND DOSE IS UPDATED");
						System.out.println("\t __________________________________________________________________________________________________________________________________________________________________________________________");
		                System.out.println(String.format("\t | %32s | %12s | %35s | %5s | %10s | %11s | %18s | %34s |", "Name", "IC Number", "State", "Age", "Category", "First Dose Status", "Second Dose Status", "Vaccine Certificate"));
		                System.out.println("\t ____________________________________________________________________________________________________________________________________________________________________________________________");
					    System.out.println(completedList); //display all queue
					    System.out.println("\t ____________________________________________________________________________________________________________________________________________________________________________________________");
					}
				} while (submenu != 3);
			}
            
		}while ( menu != 5);
		
		}
		catch (Exception ex)
		{
			System.out.println (ex.getMessage());
		}
		
	}

}
