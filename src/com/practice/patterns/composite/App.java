package com.practice.patterns.composite;

/**
 * This is driver class file to run and use Composite pattern implementation
 * @author sohil
 *
 */
public class App {

	public static void main(String[] args){
		// creating folders
		Folder folder1 = new Folder();
		Folder folder2 = new Folder();
		Folder folder3 = new Folder();
		
		folder1.setfName("root");
		folder2.setfName("home");
		folder3.setfName("usr");
		
		//creating files
		File file1 = new File();
		File file2 = new File();
		File file3 = new File();
		
		file1.setFileName("bashrc");
		file2.setFileName("bash_profile");
		file3.setFileName("prsnl");
		
		folder1.add(file1);
		folder1.add(file2);
		folder2.add(folder3);
		folder3.add(file3);
		
		
		// now displaying data 
		System.out.println("Folder 1 details...");
		folder1.doubleClick();
		System.out.println();
		System.out.println("Folder 2 details...");
		folder2.doubleClick();
		System.out.println();
		System.out.println("Folder 3 details...");
		folder3.doubleClick();
		
	}
}
