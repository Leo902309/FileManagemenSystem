package com.filehandling.main;

import java.util.Scanner;

public class StartApplication {
	 public static void main(String[] args) 
	    {
		 System.out.println("creating first commit in feature branch 2");
		 Service service=new Service();
	     Scanner scan = new Scanner(System.in);
		 while(true) {
			 service.menuList(scan);
		 }
	    }
	
}
