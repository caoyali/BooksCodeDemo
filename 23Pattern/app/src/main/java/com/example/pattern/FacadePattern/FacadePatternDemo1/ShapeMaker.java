package com.example.pattern.FacadePattern.FacadePatternDemo1;

class ShapeMaker {
    private Shape mRectangle;
    private Shape mCircle;
    private Shape mSquare;

    public ShapeMaker(Shape mRectangle, Shape mCircle, Shape mSquare) {
        this.mRectangle = mRectangle;
        this.mCircle = mCircle;
        this.mSquare = mSquare;
    }

    public void drawCircle(){
        this.mCircle.draw();
    }

    public void drawRectangle() {
        this.mRectangle.draw();
    }

    public void drawSquare() {
        this.mSquare.draw();
    }
}
