package com.enums;


public enum Color {
	RED,YELLOW,BLUE;
	
	public Color getColor(String color) {
		
		for(Color c : values()) {
			if(c.toString().equals(color)) {
				return c;
			}
		}
		return null;
	}
}
