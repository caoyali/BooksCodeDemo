package com.example.pattern.FacadePattern.FacadePatternDemo1;

class PacedePatternDemo1 {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker(new Rectangle(), new Circle(), new Square());
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
