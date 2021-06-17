package com.ashraful.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ashraful.Interface.FileProcess;

public class SubMenuOptions implements FileProcess{
	
	String filePath = "src/FileDirectory/";
	ArrayList<String> menuList = new ArrayList<>();
	//ManageFile manageFile= new ManageFile();

	@Override
	public void MenuList() {

	    menuList.add("1. Add File");
		menuList.add("2. Search File");
		menuList.add("3. Delete File");
		menuList.add("4. Return to the main context");

		System.out.println("Menu : ");
		for (String s : menuList) {

			System.out.println(s);

		}
		menuList.clear();
		
	}
	
public void getUserInput(){
		
		System.out.println("Please Choice a Option :");
		Scanner in = new Scanner(System.in);
		   try {
			   int choiceOption = in.nextInt();
			   
			   this.MenuOption(choiceOption);
	        }
	        catch (InputMismatchException ex) {
	        	System.out.println("Invalid input");
	        	 this.MenuList();
	        	 this.getUserInput();
	        }
	}



	@Override
	public void MenuOption(int input) {
		 switch(input) {

         case 1: 
      	   
        	 this.AddFile();
        	 this.MenuList();
        	 this.getUserInput();
             break;
             
         case 2: 
        	 this.SearchFile();
        	 this.MenuList();
        	 this.getUserInput();
             break;
             
         case 3: 

        	 this.deleteFile();
        	 this.MenuList();
        	 this.getUserInput();
             break;
             
         case 4: 

        	 new ManageFile().MenuList();
        	 new ManageFile().getUserInput();
      	   break;
             
         default:
             System.out.println("Invalid Option");
             break;
     }
     
	}
	

	public void AddFile() {
		
		System.out.println("Please Enter the File Name:");
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();

		File f = new File(filePath,filename);
		try {
			if(f.createNewFile()) {
			
			System.out.println("You added a file named: " + filename);
			
			} else {
		        System.out.println("Sorry, You Can't add duplicate file !");
		      }
			
		} catch (IOException e) {
			 System.out.println("Sorry, File not added !");
       	 	this.MenuList();
       	 	this.getUserInput();
		}
		
	}
	
	
	
	public void SearchFile() {
		
		System.out.println("Please Enter the File Name:");
		Scanner in = new Scanner(System.in);
		String Dfilename = in.nextLine();

		  File directory = new File(filePath);
		  String[] flist = directory.list();
		  
		  int flag = 0;
	        if (flist == null) {
	            System.out.println("Empty directory.");
	        }
	        else {
	  
	            // Linear search in the array
	            for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                if (filename.equals(Dfilename)) {
	                    System.out.println(filename + " File found");
	                    flag = 1;
	                }
	            }
	        }
	  
	        if (flag == 0) {
	            System.out.println("File Not Found");
	        }
	    
		
	}
	
	
	public void deleteFile() {
		
		System.out.println("Please Enter the File Name:");
		Scanner in = new Scanner(System.in);
		String Dfilename = in.nextLine();
		
		//Path path = FileSystems.getDefault().getPath(filePath).toAbsolutePath();
		  File directory = new File(filePath);
		  String[] flist = directory.list();
		  File fileDelete;
		  int flag = 0;
	        if (flist == null) {
	            System.out.println("Empty directory.");
	        }
	        else {
	  
	            // Linear search in the array
	            for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                if (filename.equals(Dfilename)) {
	                	
	                	fileDelete = new File(filePath+""+Dfilename);
	                	 boolean isdeleted = fileDelete.delete();
	                	 if(isdeleted) {
	                		 
	                    System.out.println("File "+Dfilename + " Deleted.");
	                	 }else {
	                		 
	                		  System.out.println("File Not Deleted.");
	                	 }
	                    flag = 1;
	                }
	            }
	        }
	  
	        if (flag == 0) {
	            System.out.println("File Not Found");
	        }

	}

}
