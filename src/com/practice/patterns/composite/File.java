package com.practice.patterns.composite;

/**
 * leaf or individual object implementation of composite pattern
 * @author sohil
 *
 */
public class File implements Data {
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void doubleClick() {
		System.out.println("File opened is: "+this.getFileName());
	}

}
