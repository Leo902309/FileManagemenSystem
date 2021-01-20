package com.filehandling.main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class FileOperation {
	 public boolean addFile(String fileName,String source,String dest) throws IOException {
		   String src=source+"/"+fileName;
		   String des=dest+"/"+fileName;
		   Path temp = Files.copy 
			        (Paths.get(src),  
			        Paths.get(des),StandardCopyOption.REPLACE_EXISTING); 
			       return temp==null?false:true;
	   }
	 
	 public boolean deleteFile(String fileName,String path) {
		 File file = new File(path+"/"+fileName); 
	     return file.delete(); 
	 }
	 
	 public  void searchFile(String fileName,File file) {
		 File[] list = file.listFiles();
	        if(list!=null) {
	        	for (File fil : list)
		        {
		            if (fil.isDirectory())
		            {
		            	searchFile(fileName,fil);
		            }
		            else if (fileName.equals(fil.getName()))
		            {
		                System.out.println("Path :"+fil.getParentFile());
		            }
		        }
	        }else {
	        	 System.out.println("No File Found..");
	        }
	 }
	 
	 public void getFileNamesInAscOrder(String path) {
		 ArrayList<String>listFiles=new ArrayList<>();
		 listf(path,listFiles);
		 if(!listFiles.isEmpty()) {
			 listFiles.forEach(file->{
				 System.out.println(file);
			 });
		 }else {
			 System.out.println("No File Found..");
		 }
	 }
	 

		public ArrayList<String> listf(String directoryName, ArrayList<String>listFiles) {
		    File directory = new File(directoryName);
		    // Get all files from a directory.
		    File[] fList = directory.listFiles();
		    if(fList != null)
		        for (File file : fList) {      
		            if (file.isFile()) {
		            	listFiles.add(file.getAbsolutePath());
		            } else if (file.isDirectory()) {
		                listf(file.getAbsolutePath(),listFiles);
		            }
		        }
		    Collections.sort(listFiles);
		    return listFiles;
		   }
	 
	
}
