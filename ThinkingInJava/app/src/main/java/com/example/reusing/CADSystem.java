package com.example.reusing;

import com.example.util.print.Print;

/**
 * the final keyword!
 * @author caoyali
 * private is final!
 */
class Shape {
	public Shape(int i) {
		Print.print("Shape cons, i=" + i);
	}

	void dispose() {
		Print.print("Shape dispose");
	}
}

class Circle extends Shape{
	 Circle(int i) {
		super(i);
		Print.print("Drawing circle");
	}
	
	@Override
	public void dispose() {
		Print.print("Erasing Ciecle");
		super.dispose();
	}
}

class Triangle extends Shape {
	Triangle(int i) {
		super(i);
		Print.print("Drawing Triangle");
	}

	@Override
	void dispose() {
		Print.print("Erasing Triangle");
		super.dispose();
	}
}

class Line extends Shape {
	private int start, end;

	Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		Print.print("Drawing line start=" + start + " end=" + end);
	}

	@Override
	void dispose() {
		Print.print("Erasing Line start=" + start + "end=" + end);
		super.dispose();
	}
}

public class CADSystem extends Shape {
	private Circle circle;
	private Triangle triangle;
	private Line[] lines = new Line[3];

	private CADSystem(int i) {
		super(i + 1);
		for (int j = 0; j <= lines.length - 1; j++) {
			lines[j] = new Line(j, j * j);
		}
		circle = new Circle(1);
		triangle = new Triangle(1);
		Print.print("Combined constructor i=" + i);
	}

	@Override
	void dispose() {
		Print.print("CADSystem.dispose()");
		triangle.dispose();
		circle.dispose();
		for (int i = lines.length - 1; i >= 0; i--) {
			lines[i].dispose();
		}
		super.dispose();
	}

	public static void main(String[] args) {
		CADSystem x = new CADSystem(47);
		try {

		} finally {
			x.dispose();
		}
	}

}
