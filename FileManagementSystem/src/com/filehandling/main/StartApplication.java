package com.filehandling.main;

import java.util.Scanner;

public class StartApplication {
	 public static void main(String[] args) 
	    {
		  System.out.println("Hot fix selcted...");
		 Service service=new Service();
	     Scanner scan = new Scanner(System.in);
		 while(true) {
			 service.menuList(scan);
		 }
	    }
	
}
