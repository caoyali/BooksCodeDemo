package com.example.pattern.FlyweightPattern.go;

import android.util.Printer;

class WhitePieces implements ChessPieces{
    public WhitePieces() {
        System.out.println("初始化一个白棋 thiss="  + this);
    }

    @Override
    public void downPieces(Graphics g, Point p) {

    }
}
