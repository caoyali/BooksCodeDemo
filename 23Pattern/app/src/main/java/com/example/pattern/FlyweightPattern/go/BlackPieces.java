package com.example.pattern.FlyweightPattern.go;

class BlackPieces implements ChessPieces{
    public BlackPieces() {
        System.out.println("初始化一个黑棋 this=" + this);
    }

    @Override
    public void downPieces(Graphics g, Point p) {

    }
}
