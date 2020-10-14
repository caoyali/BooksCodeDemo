package com.example.pattern.Factroy;
/**
 * 工厂模式，主要就是封闭住创建对象的
 */

public class FactroyPattern {
	public final static String NAME_CIRCLE = "circle";
	public final static String NAME_SQUARE = "square";
	public final static String NAME_RECTANGLE = "rectangle";
	public static IShape getSahpe(String shapeName) {
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