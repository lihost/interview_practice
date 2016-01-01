package com.practice.patterns.composite;

import java.util.ArrayList;

/**
 * Composite implementation of Component type i.e. Data in this case
 * @author sohil
 *
 */
public class Folder implements Data {
	
	private String fName;
	private ArrayList<Data> folder = new ArrayList<Data>();

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Data get(){
		return folder.get(0);
	}
	
	public void add(Data d){
		this.folder.add(d);
	}

	@Override
	public void doubleClick() {
		System.out.println("Folder opened is: "+this.getfName());
		
		for(Data d: folder){
			d.doubleClick();
		}

	}

}
