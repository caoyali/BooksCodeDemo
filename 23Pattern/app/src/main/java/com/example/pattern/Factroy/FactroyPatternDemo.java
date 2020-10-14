package com.example.pattern.Factroy;

public class FactroyPatternDemo {
	public static void main(String[] args) {
		IShape shape = null;
		shape = FactroyPattern.getSahpe(FactroyPattern.NAME_CIRCLE);
		shape.draw();
		
		shape = FactroyPattern.getSahpe(FactroyPattern.NAME_RECTANGLE);
		shape.draw();
		
		shape = FactroyPattern.getSahpe(FactroyPattern.NAME_SQUARE);
		shape.draw();
	}
}