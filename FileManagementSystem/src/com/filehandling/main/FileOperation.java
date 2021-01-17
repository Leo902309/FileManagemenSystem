package com.filehandling.main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;


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
         
	        if(file.delete()) 
	        { 
	           return true;
	        } 
	        else
	        { 
	        	return false;
	        } 
	 }
	 
	 public  void searchFile(String fileName,File file) {
		 File[] list = file.listFiles();
	        if(list!=null)
	        for (File fil : list)
	        {
	            if (fil.isDirectory())
	            {
	            	searchFile(fileName,fil);
	            }
	            else if (fileName.equalsIgnoreCase(fil.getName()))
	            {
	                System.out.println("Path :"+fil.getParentFile());
	            }
	        }
	 }
	 
	 public void getFileNamesInAscOrder(String path) {
		File file=new File(path);
		if( file.exists()) {
			 File[]files=file.listFiles();
	         Arrays.sort(files);
	         for(File f:files) {
	        	 System.out.println(f.getName());
	         }
		}else {
			System.out.println("Invalid path..");
		}
		

	 }
	 
	
}
