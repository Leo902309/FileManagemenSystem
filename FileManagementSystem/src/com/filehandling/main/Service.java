package com.filehandling.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class Service {
	FileOperation fileOperation=null;
	Scanner scanner=null;
	
	public Service() {
		fileOperation=new FileOperation();
		scanner=new Scanner(System.in);
	}
	public void addFile() {
		try {
			System.out.println("Please enter the file name");
			String fileName=scanner.next();
			System.out.println("Please enetr the source path");
			String source=scanner.next();
			System.out.println("Please enter dest path");
			String dest=scanner.next();
			boolean res=fileOperation.addFile(fileName, source, dest);
			if(res) {
				System.out.println("File Added Successfully..");
				this.takeInput();
			}
		} catch (IOException e) {
			if(e instanceof NoSuchFileException) {
				System.out.println("No Such File or Directory exists,going to main menu");
			}else {
				e.printStackTrace();
				System.out.println("Something went wrong,please check the above logs,going to main menu");
			}
			this.menuList(this.scanner);
		}
	}
	public void deleteFile() {
		System.out.println("Enter fileName..");
		String fileName=scanner.next();
		System.out.println("Enter File Path..");
		String path=scanner.next();
		boolean res=fileOperation.deleteFile(fileName, path);
		if(res) {
			System.out.println("File deleted successfully..");
			this.menuList(this.scanner);
		}else {
			System.out.println("Unable to delete the file,check file path or filename..");
			this.menuList(this.scanner);
		}
	}
	
	public void searchFile() {
		System.out.println("Enter the fileName...");
		String fileName=scanner.next();
		System.out.println("Enter the directory..");
		String dir=scanner.next();
		File file=new File(dir);
		fileOperation.searchFile(fileName, file);
		takeInput();
	}
	public void viewFiles() {
		System.out.println("Enter the directory..");
		String dir=scanner.next();
		fileOperation.getFileNamesInAscOrder(dir);
		takeInput();
	}
	 public void options(int option) {
		 switch (option) {
		 case 0:
			    System.out.println("Thanks for using FileManagement System,Bye Bye!");
				System.exit(1);
				break;
		case 1:
			this.viewFiles();
			
			break;
		case 2:
			this.otherOperations(this.scanner);
			break;
		case 3:
			this.addFile();
			break;
		case 4:
			this.deleteFile();
			break;
		case 5:
			this.searchFile();
			break;
		case 6:
			this.menuList(this.scanner);
			break;
		default:
			System.out.println("No Option matched,Exiting the application");
			break;
		}
	 }

	public void menuList(Scanner scan) {
		System.out.println("\nWelcome To File Management System Develeoped by : A. Ansari");
		System.out.println("***********************************************************\n");
		System.out.println("Enter 1 to view all files");
		System.out.println("Enter 2 to other operations");
		System.out.println("Enter 0 to close the applications");
		
		int option = scan.nextInt();
		options(option);
	}
	
	public void otherOperations(Scanner scanner) {
		System.out.println("Enter 3 to add a file");
		System.out.println("Enter 4 to delete a file");
		System.out.println("Enter 5 to search a file");
		System.out.println("Enter 6 for main menu");
		System.out.println("Enter 0 to exit");
		int option = scanner.nextInt();
		options(option);
	}
	public void takeInput() {
		System.out.println("\nEnter 0 to exit or enter 6 to go to main menu");
		int opt=scanner.nextInt();
		if(opt==0) {
			options(0);
		}else if(opt==6) {
			this.menuList(this.scanner);
		}
		else {
			System.out.println("Invalid Option.Going to main menu");
			this.menuList(scanner);
		}
	}
}
