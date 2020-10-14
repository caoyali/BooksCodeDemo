package com.example.pattern.AbstractFactroy;

/**
 * 抽象工厂模式
 * 是基于工厂模式之上的一个工厂模式，在我看来很适合进行组装搭配类需求的实现。
 */
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
