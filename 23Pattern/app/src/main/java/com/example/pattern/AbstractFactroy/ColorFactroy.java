package com.example.pattern.AbstractFactroy;

import com.example.pattern.Factroy.IShape;

public class ColorFactroy implements IDrawFactroy{
	public final static String NAME_RED = "red";
	public final static String NAME_GREEN = "green";
	public final static String NAME_BLUE = "blue";
	
	@Override
	public IColor getColor(String colorName) {
		if (NAME_RED.equals(colorName)) {
			return new RedColor();
		} else if (NAME_GREEN.equals(colorName)) {
			return new GreenColor();
		} else if (NAME_BLUE.equals(colorName)) {
			return new BlueColor();
		}
		return null;
	}
	
	@Override
	public IShape getShape(String shapeName) {
		return null;
	}
}
