//--------------------------------------------------------------
//Assignment-4
//part-B
//Written By:- Sanyam Kadd(40106824) and Ekamjot Singh(40106849)
//--------------------------------------------------------------

import java.util.NoSuchElementException;
/**
 * Assignment-4(B)
 * @author Sanyam Kadd(40106824) and Ekamjot Singh(40106849) 
 * version 4.1
 * Date:- 2/december/2019
 */
public class CellList {
  
	private class CellNode{
		/**
		 * an object of cell phone
		 */
		private CellPhone cp;
		/**
		 * a pointer to a CellNode
		 */
		private CellNode next;
		/**
	     * a default constructer 
		 */
		public CellNode(){
			cp=null;
			next=null;
			size++;
		}
		
		/**
		 * parameterised consturcter 
		 * @param cp an object of cell phone
		 * @param next a default constructer
		 */
		public CellNode(CellPhone cp, CellNode next) {
			this.cp = cp;
			this.next = next;
			size++;
		}
		
		/**
		 * copy constructer
		 * @param cn an object 
		 */
		public CellNode(CellNode cn) {
			this.cp=cn.cp.clone();
			this.next=cn.next;
			size++;
		}
		/**
		 * Clone method
		 */
		public CellNode clone() {
			return(new CellNode(this));
		}
		/**
		 * getter for cellPhone
		 * @return an Object of CellPhone
		 */
		public CellPhone getCp() {
			return cp;
		}
		/**
		 * setter for CellPhone
		 * @param cp CellPhone
		 */
		public void setCp(CellPhone cp) {
			this.cp = cp;
		}
		/**
		 * getter for NextNode
		 * @return nextNode
		 */
		public CellNode getNext() {
			return next;
		}
		/**
		 * setter for nextNode
		 * @param next next node
		 */
		public void setNext(CellNode next) {
			this.next = next;
		}
		
	}
	/**
	 * head of the link list
	 */
	private CellNode head;
	/**
	 * Size of the link list
	 */
	private long size;
	/**
	 * default constructer
	 */
	public CellList() {
		head=null;
	}
	/**
	 * copy constructer which  which accepts a CellList object and creates a copy of it.
	 * @param cl copy of the passed CellList
	 */
	public CellList(CellList cl) {
		CellNode t1=cl.head;
		CellNode t2;
		head=t2=null;
		if(t1==null)
			head=null;
		else {
				while(t1!=null) {
					if(head==null) {
						CellPhone tempcp=t1.cp.clone();
						while(cl.contains(tempcp.getSerialNum())) {
							System.out.println("Duplicate entry detected for the Serial number. Please enter a unique serial number");
							tempcp=t1.cp.clone();
						}
						head=new CellNode(tempcp,null);
						t2=head;
					}
					else {

						CellPhone tempcp=t1.cp.clone();
						while(cl.contains(tempcp.getSerialNum())|| this.contains(tempcp.getSerialNum())) {
							System.out.println("Duplicate entry detected for the Serial number. Please enter a unique serial number");
							tempcp=t1.cp.clone();
						}
						t2.next=new CellNode(tempcp,null);

						
						t2=t2.next;
					}
					t1=t1.next;
					
				}
				t2=null;
			}
			
		}
	/**
	 *  addToStart(), which accepts one parameter, an object from CellPhone class. The method then
        creates a node with that passed object and inserts this node at the head of the list
	 * @param cp1 an object from CellPhone
	 */
	public void addToStart(CellPhone  cp1) {
		head=new CellNode(cp1,head);
	}
	
	/**
	 *  insertAtIndex(), which accepts two parameters, an object from CellPhone class, and an integer
        representing an index. If the index is not valid (a valid index must have a value between 0 and size-1), the method
        must throw a NoSuchElementException and terminate the program. If the index is valid, then the method creates 
        a node with the passed CellPhone object and inserts this node at the given index. The method must properly handle
        all special cases
	 * @param cp1 an object from CellPhone
	 * @param index index where to insert
	 * @throws NoSuchElementException
	 */
	public void insertAtIndex(CellPhone cp1,int index)throws NoSuchElementException {
		CellNode t=head;
		int indexctr=0;
		
		if(index<0||index>size-1)
			throw(new NoSuchElementException());
		else if(index==0)
			head=new CellNode(cp1,head);
		else {
			while(t.next!=null) {
				indexctr++;
				if(indexctr==index) {
					t.next=new CellNode(cp1,t.next);
					break;
				}
				t=t.next; 
			}
		}
	}
	
	/**
	 * which accepts one integer parameter representing an index. Again, if the
      index is not valid, the method must throw a NoSuchElementException and terminate the program. Otherwise; the
      node pointed by that index is deleted from the list
	 * @param index index where to insert
	 * @throws NoSuchElementException
	 */
	public void deleteFromIndex(int index) throws NoSuchElementException {
		CellNode t=head;
		int indexctr=0;
		if(index<0||index>size-1)
			throw(new NoSuchElementException());
		else if(index==0) {
			head=head.next;
			size--;
		}
			
		else {
			while(t.next!=null) {
				indexctr++;
				if(indexctr==index) {
					t.next=t.next.next;
					size--;
					break;
				}
				t=t.next; 
			}
		}
		
	}
	
	/**
	 *  deleteFromStart(), which deletes the first node in the list (the one pointed by head)
	 */
	public void deleteFromStart() {
		if(head==null)
			System.out.println("The list is empty. Could not delete from the start..");
		else {
			size--;
			head=head.next;
		}
	}
	/**
	 * replaceAtIndex(), which accepts two parameters, an object from CellPhone class, and an
       integer representing an index. If the index is not valid, the method simply returns; otherwise the object in the node at
       the passed index is to be replaced by the passed object;
	 * @param cp an object from CellPhone
	 * @param index index where to replace
	 */
	public void replaceAtIndex(CellPhone cp,int index) {
		CellNode t= head;
		if(index<0||index>size-1) {
			System.out.println("You entered invalid index...");
			return;
		} 
		int indexctr=0;
		if(index==0) {
			head=head.next;
			size--;
			head=new CellNode(cp,head);
			return;
		}
		else {
			while(t.next!=null) {
				indexctr++;
				if(indexctr==index) {
					t.next=t.next.next;
					size--;
					t.next=new CellNode(cp,t.next);
					return;
				}
				t=t.next;
			}
		
		}
	}
	/**
	 * find(), which accepts one parameter of type long representing a serial number. The method then
       searches the list for a node with a cell phone with that serial number. If such an object is found, then the method
       returns a pointer to that node where the object is found; otherwise, the method returns null. The method must keep
       track of how many iterations were made before the search finally finds the phone or concludes that it is not in the list
	 * @param sn long representing a serial number
	 * @return CellNode if it found; otherwise null;
	 */
	// This method leaks the privacy.
	// The privacy leak is due to because we are returning the location of the CellNode; which can be used by an user do evil things.
	public CellNode find(long sn) {
		int itr=0;
		CellNode t=head;
		while(t!=null) {
			itr++;
			if(t.cp.getSerialNum()==sn) {
				System.out.println("\nCell phone with the passed serial number found!.It took "+itr+" iterations to find the cell phone.");
				return t;
			}
			t=t.next;
		}
		System.out.println("\nThere is no cell phone found in the list with the passed serial number.");
		return null;
		
	}
	
	/**
	 *  contains(), which accepts one parameter of type long representing a serial number. The method
        returns true if an object with that serial number is in the list; otherwise, the method returns false
	 * @param sn serial number
	 * @return true if object with serial number is found ;ohterwise false.
	 */
	public boolean contains(long sn) {
		
		CellNode t=head;
		while(t!=null) {
			
			if(t.cp.getSerialNum()==sn) {
				return true;
			}
			t=t.next;
		}
		return false;
	}
	
	/**
	 * which displays the contents of the list
	 */
	public void showContent() {
		System.out.println("\nThe current size of the list is "+size+" .Here is the content of the list:-");
		System.out.println("============================================================================");
		CellNode t=head;
		while(t!=null) {
			System.out.print(t.cp+"-->");
			t=t.next;
		}
		System.out.println("X");
	}
	/**
	 *  which accepts one parameter of type CellList. The method returns true if the two
        lists contain similar objects; otherwise the method returns false. Recall that two CellPhone objects are equal if
        they have the same values with the exception of the serial number
	 * @param cl an object of cellList to compare with.
	 * @return true if the two lists are equals; otherwise false
	 */
	public boolean equals(CellList cl) {
	
		if(cl==null)
			return false;
		if(this.size!=cl.size)
			return false;
		else {
			CellNode t1=cl.head;
			CellNode t2=head;
			while(t1!=null&&t2!=null) {
				if(!(t2.cp.equals(t1.cp)))
					return false;
				t1=t1.next;
				t2=t2.next;
			}
			return true;
		
		}
	}
	
	
	
	
	
	}
	
	
	
	
	
	
	

