package com.example.pattern.AbstractFactroy;

public class AbstractPatternDemo {
	public static void main(String[] args) {
		DrawFactroyImpl drawFactroyImpl = new DrawFactroyImpl();
		drawFactroyImpl.getColor(ColorFactroy.NAME_BLUE).draw();
		
		drawFactroyImpl.getShape(ShapeFactroy.NAME_SQUARE).draw();
	}
}
