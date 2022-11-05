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
           
          //stack
		  Stack<citizen> stCenter1 = new Stack<>();
		  Stack<citizen> stCenter2 = new Stack<>();
		  Stack<citizen> stCenter3 = new Stack<>();
		  Stack<String> fdStatus = new Stack<>();
		  Stack<String> sdStatus = new Stack<>();
		  Stack<citizen> temp = new Stack<>();	
		  
		  //queue
		  Queue<citizen> qCenter1 = new LinkedList<>();
		  Queue<citizen> qCenter2 = new LinkedList<>();
		  Queue<citizen> qCenter3 = new LinkedList<>();
		  Queue<citizen> completedList = new LinkedList<>();
		  Queue<citizen> completedList1 = new LinkedList<>();
		  Queue<citizen> completedList2 = new LinkedList<>();
		  Queue<citizen> completedList3 = new LinkedList<>();
		  
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
		
		//instructor  
		int menu = 0;
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Please choose \nMENU 1 - ADD CITIZEN \nMENU 2 - REMOVE CITIZEN \nMENU 3 - FIRST DOSE STATUS \nMENU 4-SECOND DOSE STATUS"));
            if (menu==1)
            {
                String name = JOptionPane.showInputDialog("Please enter the citizen's name : ");
                String IC = JOptionPane.showInputDialog("Please enter the citizen's IC : ");
                String state = JOptionPane.showInputDialog("Please enter the citizen's state :");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Please enter the citizen's age : "));
                String category = JOptionPane.showInputDialog("Please add the category :");
                String firstdose = null;
                String secdose = null;
                String vaccompletion = null;

                Citizen = new citizen(name,IC,state,age,category,firstdose,secdose,vaccompletion);
                citizenList.add(Citizen);

            }
			else if (menu ==2)
			{
	    		//ask user to enter serial number
	             String name = JOptionPane.showInputDialog("Enter people's name that you want to remove");
	             for (int i = 0; i<citizenList.size(); i++)
	             {
	                 Citizen = citizenList.get(i);//retrieve object
	                 if (Citizen.getName().equalsIgnoreCase(name))
	                 {
	                     citizenList.remove(Citizen); //remove object
	                 }
	                 
	             } 
	    		 
	    	 }
			else if (menu == 3)
			{
				while (!stCenter1.isEmpty())
				{
					Citizen = stCenter1.pop();
					
					if (Citizen.getFirstdose().equalsIgnoreCase("null"))
					{
						Citizen.setFirstdose("complete");
						temp.push(Citizen);
					}
				}
				System.out.println(temp);
				
				while (!stCenter2.isEmpty())
				{
					Citizen = stCenter2.pop();
					
					if (Citizen.getFirstdose().equalsIgnoreCase("null"))
					{
						Citizen.setFirstdose("complete");
						temp.push(Citizen);
					}
				}
				System.out.println(temp);
				
				while (!stCenter3.isEmpty())
				{
					Citizen = stCenter3.pop();
					
					if (Citizen.getFirstdose().equalsIgnoreCase("null"))
					{
						Citizen.setFirstdose("complete");
						temp.push(Citizen);
					}
				}
				System.out.println(temp);
			}
			else if (menu ==4)
			{
				int submenu = 0;
				do
				{
					submenu = Integer.parseInt(JOptionPane.showInputDialog("MENU 1 - UPDATE SECOND DOSE VACCINATION STATUS \nMENU 2 - DISPLAY ALL \nMENU 3 - EXIT"));
					
					if (menu == 1) {
					while (!qCenter1.isEmpty())
					{
						Citizen = qCenter1.element();
						
						if (Citizen.getSeconddose().equalsIgnoreCase("null"))
						{
							Citizen.setSeconddose("complete");
							Citizen.setVaccompletion("CONGRATULATION! YOU HAVE COMPLETE YOUR VACCINATION");
							completedList1.add(Citizen);
					    }
					}
					completedList.add(Citizen);
					
					while (!qCenter2.isEmpty())
					{
						Citizen = qCenter2.element();
						if (Citizen.getSeconddose().equalsIgnoreCase("null"))
						{
							Citizen.setSeconddose("complete");
							Citizen.setVaccompletion("CONGRATULATION! YOU HAVE COMPLETE YOUR VACCINATION");
							completedList2.add(Citizen);
                        }
					}
					completedList.add(Citizen);
					
					
					while (!qCenter3.isEmpty())
					{
						Citizen = qCenter3.element();
						if (Citizen.getSeconddose().equalsIgnoreCase("null"))
						{
							Citizen.setSeconddose("complete");
							Citizen.setVaccompletion("CONGRATULATION! YOU HAVE COMPLETE YOUR VACCINATION");
							completedList3.add(Citizen);
						}
					}
					completedList.add(Citizen);
					
					}
					else if (submenu ==2)
					{
						while(!completedList.isEmpty())
						{
							Citizen = completedList.remove();
							System.out.println(Citizen.toString());
						}
						
						
						

					}
				} while (submenu != 3);
        
     }while ( menu != 6);
      }
		catch (Exception ex)
		{
			System.out.println (ex.getMessage());
		}
		
	}

}
