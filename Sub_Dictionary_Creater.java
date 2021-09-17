//--------------------------------------------------------------
//Assignment-4
//part-A
//Written By:- Sanyam Kadd(40106824) and Ekamjot Singh(40106849)
//--------------------------------------------------------------
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * Assignment-4(A)
 * @author Sanyam Kadd(40106824) and Ekamjot Singh(40106849) 
 *version 4.0
 *date:- 2/December/2019
 */
public class Sub_Dictionary_Creater {
	/**
	 * it will store the name of the input file
	 */
	private static String inputFile="";
	/**
	 * It will store the each word and this will be used to process word for the correct format
	 */
	private static String word="";
	/**
	 * It will store every well formatted word,but not all of them will be in uppercase  
	 */
	private static ArrayList<String> dictionary=new ArrayList<String>();
	
	
	
	/**
	 * this method checks wheather or not the passed string contains number.
	 * @param s this will check the presence of number for this passed string
	 * @return will return true if have number, otherwise false
	 */
	private static boolean checkNumber(String s) {
		
		for(int i=0; i<s.length();i++) {
			int ch=(int)s.charAt(i);
			if(ch==48||ch==49||ch==50||ch==51||ch==52||ch==53||ch==54||ch==55||ch==56||ch==57)
				return true;
		}
		return false;
	}
	/**
	 * this method checks wheather the passed string is a single charcter or not
	 * @param w2 this parameter will be checked wheather or not it is singly character 
	 * @return return true if it is singly character ,otherwise false
	 */
	private static boolean checkSingleChar(String w2) {
		if(w2.length()==1)
			return true;
		return false;
	}
	
	/**
	 * this method returns checks that if the word has a charcters among : ?:;!,
	 * @return ture it  contains those characters, otherwise false
	 */
	private static boolean checkCharAtLast(String s) {
		char lastChar=s.charAt(s.length()-1);
		if(lastChar=='?'||lastChar=='.'||lastChar==','||lastChar==';'||lastChar==':'||lastChar=='!')
			return true;
		return false;
		
	}
	/**
	 * this method checks the presence of certain chars in between a string
	 * @param w this is the passed string for which the check will be done
	 * @param s this is the charcter of which the presence will be checked
	 * @return return ture if the passed char is present , ohterwise false
	 */
	private static boolean checkChar(String w,char s) {
			
			if(s=='\''&&w.length()>2) {
				return(w.charAt(w.length()-2)=='’');
				
			}
				
			else if(s=='=')
				for(int i=0;i<w.length();i++) {
					if(w.charAt(i)=='=')
						return true;
				}
			return false;
	}
	
	private static void sop(String s) {
		System.out.print(s);
	}
	private static void sopln(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sopln("=======================***************========================Welcome to the Dictionary Creater!========================***************=======================");
		Scanner kb=new Scanner(System.in);
		sop("Please enter the name of the input file: ");
		inputFile=kb.nextLine();
		sopln("");
		Scanner sc=null;
		try {
			sc=new Scanner(new FileInputStream(inputFile));
		}
		catch(FileNotFoundException e) {
			
			sop("Error: the file name you entered was not found! please enter a valid file name: ");
			inputFile=kb.nextLine();
			sopln("");
			
			try {
				sc=new Scanner(new FileInputStream(inputFile));
			}
			catch(FileNotFoundException e2) {
				sopln("Error: the file name you entered agian is also  not found! The program is terminating....");
				sopln("");
				sopln("========================================See you later with correct information. Good Bye!========================================");
				System.exit(0);
			}
		}
		while(sc.hasNext()) {
			word=sc.next();
			if(checkNumber(word)) // checking for number
				continue;
			if(checkCharAtLast(word)) {// checking for certain charcters
				//trim(word);
				word=word.substring(0,word.length()-1);
			} 
			if(checkChar(word,'\'')) {
				word=word.substring(0,word.length()-2);
			}
				
				//trimfor(word);
			if (checkSingleChar(word)) {
				if(!(word.equalsIgnoreCase("A")||word.equalsIgnoreCase("I")))
					continue;
					
			}
			if(checkChar(word,'=')) {
				String[] wordArr=word.split("=");
				for(int i=0;i<wordArr.length;i++) {
					if(checkNumber(wordArr[i])) // checking for number
						continue;
					if(checkCharAtLast(wordArr[i])) {// checking for certain charcters
						//trim(wordArr[0]);
						wordArr[i]=wordArr[i].substring(0,wordArr[i].length()-1);
					} 
						
					if(checkChar(wordArr[i],'\''))
						wordArr[i]=wordArr[i].substring(0,wordArr[i].length()-2);
						//trimfor(wordArr[0]);
					if (checkSingleChar(wordArr[i])) {
						if(!(wordArr[i].equalsIgnoreCase("A")||wordArr[i].equalsIgnoreCase("I")))
							continue;
					}
					if(!dictionary.contains(wordArr[i].toUpperCase()))
						dictionary.add(wordArr[i].toUpperCase());
				}
			
			}
			
			if(!dictionary.contains(word.toUpperCase()))
				dictionary.add(word.toUpperCase());
			
		}
		sc.close();
		createFile(dictionary);
		sopln("========================================The dictionary has been created successfully! Good Bye!========================================");
		
		

	}
	/**
	 * This method creates the output file  
	 * @param al this is passed array list from which data will be transfered into the output file
	 */
	private static void createFile(ArrayList<String> al) {
		Collections.sort(al);
		PrintWriter pw=null;
		try {
			pw= new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		}
		catch(FileNotFoundException e) {
			sopln("Error: file was not able to create.");
		}
		pw.println("The document produced this sub-dictionary, which includes "+dictionary.size()+" entries.");
		int j=0;
		for(int i=0;i<26;i++) {
			char letter=(char)(65+i);
			pw.println("\n"+letter+"\n==");
			while(j<dictionary.size()&&(int)(dictionary.get(j).charAt(0))==(65+i)) { // this while loop iterates un-till next alphabetical letter is detected
				pw.println(dictionary.get(j));
				j++;
			}
		}
		pw.close();
		
	}

	

}
