package com.ashraful.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class File_Main {
	
		String filePath = "src/FileDirectory/";	
		 
	public static void main(String[] args) throws IOException {
		ManageFile fileMenu = new ManageFile();
	
		System.out.println("Project Name: VirtualKey");
		System.out.println("A.K.M. Ashraful Alam");
		System.out.println("Dhaka Bangladesh");
		
		fileMenu.MenuList();
		fileMenu.getUserInput();
		
	}

}
