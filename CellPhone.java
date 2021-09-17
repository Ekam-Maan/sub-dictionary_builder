//--------------------------------------------------------------
//Assignment-4
//part-B
//Written By:- Sanyam Kadd(40106824) and Ekamjot Singh(40106849)
//--------------------------------------------------------------

import java.util.Scanner;
/**
 * Assignment-4(B)
 * @author Sanyam Kadd(40106824) and Ekamjot Singh(40106849) 
 *version 4.0
 *date:- 2/December/2019
 */

public class CellPhone {
	Scanner kb=new Scanner(System.in);
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * Parameterized constructor that accepts four values and initializes serialNum, brand, year and price to these passed values;
	 * @param serialNum Unique Serial Number
	 * @param brand brand of the cell phone
	 * @param year year of the cell phone
	 * @param price price of the cell phone
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * Copy constructor, which takes two parameters, a CellPhone object and a long value. The newly created object will
       be assigned all the attributes of the passed object, with the exception of the serial number. serialNum is assigned the
       value passed as the second parameter to the constructor. It is always assumed that this value will correspond to the
       unique serial number rule
	 * @param cp an object of the CellPhone class
	 * @param sr unique serial number
	 */
	public CellPhone(CellPhone cp,long sr) {
		this.serialNum=sr;
		this.brand = cp.brand;
		this.year = cp.year;
		this.price = cp.price;
	}
	/**
	 * This method will prompt the user to enter a new serial number, then creates and returns a clone of
       the calling object with the exception of the serial number, which is assigned the value entered by the user
	 */
	public CellPhone clone() {
		System.out.print("Please enter a unique serial number for the new Cell Phone: ");
		
		long tempsn=kb.nextLong();
		return(new CellPhone(this,tempsn));
	}
	/**
	 * This method returns the data of a cell phone
	 */
	public String toString() {
		return "["+this.serialNum+": "+this.brand+" "+this.price+" "+this.year+"]";
	}
	
	/**
	 *  Two cell phones are equal if they
        have the same attributes, with the exception of the serial number, which could be different
	 */
	
	public boolean equals(Object o) {
		if(o==null&&o.getClass()!=this.getClass())
			return false;
		CellPhone cp=(CellPhone)o;
		return(this.brand.equalsIgnoreCase(cp.brand)&&this.year==cp.year&&this.price==cp.price);
	}

	/**
	 * @return the serialNum
	 */
	public long getSerialNum() {
		return serialNum;
	}

	/**
	 * @param serialNum the serialNum to set
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


}
