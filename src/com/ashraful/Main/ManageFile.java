package com.ashraful.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ashraful.Interface.FileProcess;

public class ManageFile implements FileProcess {

	ArrayList<String> menuList = new ArrayList<>();
	String filePath = "src/FileDirectory/";	
	 private ArrayList<File> files = new ArrayList<File>();  
	 SubMenuOptions submenu = new SubMenuOptions();

/*	private ArrayList<File> files = new ArrayList<File>();
	Path path = FileSystems.getDefault().getPath(filePath).toAbsolutePath();
	File Dfiles = path.toFile();*/

	@Override
	public void MenuList() {
		
		menuList.add("1. Show All Files");
		menuList.add("2. Sub Menu");
		menuList.add("3. Exit");

		/*menuList.add("1. Add File");
		menuList.add("2. Search File");
		menuList.add("3. Delete File");
		menuList.add("4. Exit");*/

		System.out.println("Menu : ");
		for (String s : menuList) {

			System.out.println(s);

		}
		menuList.clear();
	//	System.out.println("Please Choice Options");
	}
	
	
	public void getUserInput(){
		
		System.out.println("Please Choice a Option :");
		Scanner in = new Scanner(System.in);
		   try {
			   int choiceOption = in.nextInt();
			   
			   MenuOption(choiceOption);
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
        	   
               this.displayAllFiles();                
               this.MenuList(); 
               this.getUserInput();
               break;
               
           case 2: 
        	   submenu.MenuList();
        	   submenu.getUserInput();
               break;
               
           case 3: 

        	   Close();
               break;
               
           case 4: 

        	// exit();
        	   break;
               
           default:
               System.out.println("Invalid Option");
               break;
       }
       
		   
	}
	
	
public  void  displayAllFiles(){
		

	    String filePath = "src/FileDirectory/";	
		Path path = FileSystems.getDefault().getPath(filePath).toAbsolutePath();
		File Dfiles = path.toFile();
        File[] directoryFiles = Dfiles.listFiles();     
    //	files.clear();
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    	}    	
    	Collections.sort(files);  
    	System.out.println("File List in Ascending Order...");
    	for(File file : files) {
    		
    		 System.out.println("File name: "+file.getName());
    	}
    	
    	files.clear();
    	
    	}
	
	
	
	
		   public static void Close() {

				 System.out.println("Program is terminated");
			       System.exit(1);

			    }
	

	
	
}
