package com.model;

public class Smart {
	private String color;
	private float screen;

	public Smart(String color, float screen) {
		this.color = color;
		this.screen = screen;
	}

	public void display() {
		System.out.println("color:" + color + "," + "screen:" + screen);
	}
}
