package actionClassStudy;

import java.util.Date;

public class TimeStameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date);
	  // System.out.println(	date.toString());
	   String newEmail=date.toString().replace("   ", " _ ").replace(" : ", " _").concat("@gmail.com");
	   System.out.println(newEmail);

	}

}
