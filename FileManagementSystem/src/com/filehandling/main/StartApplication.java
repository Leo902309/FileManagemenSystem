package com.filehandling.main;

import java.util.Scanner;

public class StartApplication {
	 public static void main(String[] args) 
	    {
		 System.out.println("doining a commit 1 in master branch");
		 System.out.println("Creating commit 2 in master branch");
		 Service service=new Service();
	     Scanner scan = new Scanner(System.in);
		 while(true) {
			 service.menuList(scan);
		 }
	    }
	
}
