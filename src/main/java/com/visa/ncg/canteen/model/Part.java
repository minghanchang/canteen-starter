package com.visa.ncg.canteen.model;

public class Part {
	private String name;
	private int partNum;
	
	public Part(String name, int partNum) {
		this.name = name;
		this.partNum = partNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPartNum() {
		return partNum;
	}
	public void setPartNum(int partNum) {
		this.partNum = partNum;
	}
}
