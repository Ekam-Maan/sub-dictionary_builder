//--------------------------------------------------------------
//Assignment-4
//part-B
//Written By:- Sanyam Kadd(40106824) and Ekamjot Singh(40106849)
//--------------------------------------------------------------
/**
 * Assignment-4(B)
 * @author Sanyam Kadd(40106824) and Ekamjot Singh(40106849) 
 *version 4.0
 *date:- 2/December/2019
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CellListUtilization {
	static ArrayList<CellPhone> cpar=new ArrayList<CellPhone>(20);
	//CellPhone[] cp=new CellPhone

	/**
	 * This the main method which execute and check the correctness of the code. 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*************************WELCOME TO THE CELL PHONE RECORD SOFTWARE*************************");
		long sn;// Serial number
		String brand;// brand
	    double pr; // price
	    int yr; // year
		CellList cl1=new CellList(); // a cellList
		CellList cl2=null; // an empty cell list
		Scanner sc=null;
		try {
			sc=new Scanner (new FileInputStream("Cell_Info.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: File coiuld not be found.");
			System.exit(0);
		}
		
		while (sc.hasNextLine()) { //  reading file
			sn=sc.nextLong();
			brand=sc.next();
			pr=sc.nextDouble();
			yr=sc.nextInt();
		
			
			CellPhone cp= new CellPhone(sn,brand,yr,pr);
			if(!(cl1.contains(sn)))
				cl1.addToStart(cp);
			
		}
	  
		cl1.showContent();
		System.out.println("**************************************************************");
		Scanner kb=new Scanner(System.in);
		
		
	   
	    
	    int option=0;
	    while(true) { // prompt user to choose an option untill he/she presses 0 to exit program
	    	boolean bool2=true;
	    	while(bool2) {
	    		System.out.println("<---------------------------------->");
		    	System.out.println("Choose one of the following:-");
	    		System.out.println("<---------------------------------->");

		    	System.out.println("");
		    	System.out.println("1. Enter \"1\" to use copy contructer.");
		    	System.out.println("2. Enter \"2\" to use deleteFromStart() method.");
		    	System.out.println("3. Enter \"3\" to use addtoStart() method.");
		    	System.out.println("4. Enter \"4\" to use insertAtIndex() method.");
		    	System.out.println("5. Enter \"5\" to use deleteFromIndex() method.");
		    	System.out.println("6. Enter \"6\" to use replaceAtIndex() method.");
		    	System.out.println("7. Enter \"7\" to use find() method.");
		    	System.out.println("8. Enter \"8\" to compare to CellList(equlas() method).");
		    	System.out.println("9. Enter \"9\" to view the content of the list.");
		    	System.out.println("0. Enter \"0\" to exit this program.");
		    	System.out.print("Please enter your option: ");
		    	option=kb.nextInt();
		    	if(option<0||option>9) 
			    	System.out.println("Please enter correct option. It should be between 1 and 8 inclusively.");
		    	else
		    		bool2=false;
			 
	    	}
	    	if(option==1) { // testing copy constructer
	    		System.out.println("Using copy constructor:-");
	    		System.out.println("===========================");
	    	    cl2=new CellList(cl1);
	    	}
	    	else if(option==2) { // testing delete function
	    		System.out.println("Deleting first element of the cl1 CellList...");
	    		cl1.deleteFromStart();
	    		System.out.println("Element deleted successfully.");
	    	}
	    	else if(option==3) {// testing addToStart function
	    		System.out.println("====Please fill some details of the new phone to be added.====");
	    		System.out.print("Please enter unique serial Number for your new CellPhone: ");
	    		sn=kb.nextLong();
	    		if(cl1.contains(sn)) continue;
	    		System.out.print("Please enter brand name for your new CellPhone: ");
				brand=kb.next();
				System.out.print("Please enter price for your new CellPhone: ");
				pr=kb.nextDouble();
				System.out.print("Please enter year for your new CellPhone: ");
				yr=kb.nextInt();
	    		
	    		CellPhone cp =new CellPhone(sn,brand,yr,pr);
	    		cl1.addToStart(cp);
	    		System.out.println("Element added to the start successfully.");
	    	}
	    	else if(option==4) {// testing insertAtIndex function
	    		int index=0;
	    		System.out.println("====Please fill some details of the new phone which is to be inserted.====");
	    		System.out.print("Please enter unique serial Number for your new CellPhone: ");
	    		sn=kb.nextLong();
	    		if(cl1.contains(sn)) continue;
	    		System.out.print("Please enter brand name for your new CellPhone: ");
				brand=kb.next();
				System.out.print("Please enter price for your new CellPhone: ");
				pr=kb.nextDouble();
				System.out.print("Please enter year for your new CellPhone: ");
				yr=kb.nextInt();
	    		
	    		CellPhone cp =new CellPhone(sn,brand,yr,pr);
	    		System.out.print("Please enter the index where you want to insert: ");
	    		index=kb.nextInt();
	    		
	    		try{
	    			cl1.insertAtIndex(cp, index);
	    		}
	    		catch(NoSuchElementException e) {
	    			System.out.println("\nError:\nElement Cannot be replaced! You entered an invalid index.\n");
	    			continue;
	    		}
	    		
	    		System.out.println("Element inserted at index "+index+" successfully.");
	    		
	    	}
	    	else if(option==5) {// testing deleteFromIndex function
	    		int index=0;
	    		System.out.print("Please enter the index of node you want to delete: ");
	    		index=kb.nextInt();
	    		
	    		try{
	    			cl1.deleteFromIndex(index);
	    		}
	    		catch(NoSuchElementException e) {
	    			System.out.println("\nError:\nElement Cannot be deleted! You entered an invalid index.\n");
	    			continue;
	    		}
	    		System.out.println("Element deleted at index "+index+" successfully.");
	
	    	}
	    	else if(option==6) {// checking replaceAtIndex Functio
	    		int index=0;
	    		System.out.print("Please enter the index where you want to replace: ");
	    		index=kb.nextInt();
	    		System.out.println("\n=====Please fill some details of the new phone which is to be inserted.====");
	    		System.out.print("Please enter unique serial Number for your new CellPhone: ");
	    		sn=kb.nextLong();
	    		if(cl1.contains(sn)) continue;
	    		System.out.print("Please enter brand name for your new CellPhone: ");
				brand=kb.next();
				System.out.print("Please enter price for your new CellPhone: ");
				pr=kb.nextDouble();
				System.out.print("Please enter year for your new CellPhone: ");
				yr=kb.nextInt();
	    		
	    		CellPhone cp =new CellPhone(sn,brand,yr,pr);
	    		try{
	    			cl1.replaceAtIndex(cp, index);
	    		}
	    		catch(NoSuchElementException e) {
	    			System.out.println("Element Cannot be replaced! You entered an invalid index.");
	    		}
	    		System.out.println("Element replaced at index "+index+" successfully.");
	
	    	}
	    	else if(option==7) { // using find function
	    		System.out.print("Please enter the serial number you want to search for: ");
	    		cl1.find(kb.nextLong());
	
	    	}
	    	else if(option==9) { // using showContent function  
	    		int option2=0;
	    		System.out.print("Please enter\"1\" for \"cl1\" Celllist or enter \"2\" for \"cl2\" CellList(to which copy constructer copied data).");
	    		option2=kb.nextInt();
	    		while(option2<1||option2>2) {
	    			System.out.println("Please enter a valid number (1 or 2).");
	    			System.out.print("Please enter\"1\" for \"cl1\" Celllist or enter \"2\" for \"cl2\" CellList(to which copy constructer copied data).");
		    		option2=kb.nextInt();
	    			
	    		}
	    		if(option2==1)
	    		cl1.showContent();
	    		if(option2==2)
		    		cl2.showContent();
	    	}
	    	else if(option==8) { // option to exit program
	    		if(cl1.equals(cl2))
	    			System.out.println("\nThe Two Lists are Equals.\n");
	    		else
	    			System.out.println("\nThe Two Lists NOT are Equals.\n");
	    	
	
	    	}
	    	else{
	    		System.out.println("\nTerminating program....");
	    		System.out.println("****************************************Have good day. Bye!****************************************");
	    		System.exit(0);
	    	}
	    	

	    	
	    	
	    	
	    }
		 
		
		

	}

}
