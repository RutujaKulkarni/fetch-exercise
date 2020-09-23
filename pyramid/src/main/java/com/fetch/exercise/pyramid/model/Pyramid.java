package com.fetch.exercise.pyramid.model;

public class Pyramid {

	private String string;
	private boolean isPyramid;
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public boolean isPyramid() {
		return isPyramid;
	}
	public void setPyramid(boolean isPyramid) {
		this.isPyramid = isPyramid;
	}
	public Pyramid(String string, boolean isPyramid) {
		super();
		this.string = string;
		this.isPyramid = isPyramid;
	}
	
	
	
}
