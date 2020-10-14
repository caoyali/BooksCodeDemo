package com.example.pattern.AbstractFactroy;

import com.example.pattern.Factroy.CircleShape;
import com.example.pattern.Factroy.IShape;
import com.example.pattern.Factroy.RectangleShape;
import com.example.pattern.Factroy.SquareShape;

public class ShapeFactroy implements IDrawFactroy{
	public final static String NAME_CIRCLE = "circle";
	public final static String NAME_SQUARE = "square";
	public final static String NAME_RECTANGLE = "rectangle";
	
	@Override
	public IColor getColor(String colorName) {
		return null;
	}
	
	@Override
	public IShape getShape(String shapeName) {
		IShape shape = null;
		if (NAME_CIRCLE.equals(shapeName)) {
			shape = new CircleShape();
		} else if (NAME_SQUARE.equals(shapeName)) {
			shape = new SquareShape();
		} else if (NAME_RECTANGLE.equals(shapeName)) {
			shape = new RectangleShape();
		} 
		return shape;
	}
}
