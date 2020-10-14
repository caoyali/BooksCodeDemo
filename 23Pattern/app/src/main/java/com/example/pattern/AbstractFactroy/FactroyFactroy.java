package com.example.pattern.AbstractFactroy;

public class FactroyFactroy{
	public static final String NAME_SHAPE = "shape";
	public static final String NAME_COLOR = "color";
	public static IDrawFactroy getDrawFactroy(String name) {
		if (NAME_SHAPE.equals(name)) {
			return new ShapeFactroy();
		} else if (NAME_COLOR.equals(name)) {
			return new ColorFactroy();
		}
		return null;
	}

}
