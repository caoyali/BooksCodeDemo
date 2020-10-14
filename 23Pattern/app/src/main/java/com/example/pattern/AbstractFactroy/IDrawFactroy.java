package com.example.pattern.AbstractFactroy;

import com.example.pattern.Factroy.IShape;

public interface IDrawFactroy {
	IColor getColor(String colorName);
	IShape getShape(String shapeName);
}
