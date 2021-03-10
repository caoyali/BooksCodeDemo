package com.example.pattern.FlyweightPattern.go;

import java.util.ArrayList;
import java.util.List;

class WeiQiFactory {
    private List<ChessPieces> chessPieces = new ArrayList<>();

    public WeiQiFactory() {
    }

    public List<ChessPieces> getChessPieces(String type) {
        List<ChessPieces> result = new ArrayList<>();
        for (ChessPieces chessPieces : chessPieces) {
            if ("白棋".equals(type)) {
                if (chessPieces instanceof WhitePieces) {
                    result.add(chessPieces);
                }
            } else if ("黑棋".equals(type)) {
                if (chessPieces instanceof BlackPieces) {
                    result.add(chessPieces);
                }
            }
        }
        return result;
    }
}
