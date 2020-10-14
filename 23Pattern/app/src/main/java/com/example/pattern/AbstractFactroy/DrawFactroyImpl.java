package com.example.pattern.AbstractFactroy;

import com.example.pattern.Factroy.IShape;
public class DrawFactroyImpl implements IDrawFactroy{
	public IColor getColor(String colorName) {
		return FactroyFactroy.getDrawFactroy(FactroyFactroy.NAME_COLOR).getColor(colorName);
	}
	public IShape getShape(String shapeName) {
		return FactroyFactroy.getDrawFactroy(FactroyFactroy.NAME_SHAPE).getShape(shapeName);
	}
}
