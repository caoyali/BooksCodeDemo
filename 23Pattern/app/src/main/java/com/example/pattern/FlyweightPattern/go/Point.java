package com.example.pattern.FlyweightPattern.go;

class Point {
    int x, y;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"x\":")
                .append(x);
        sb.append(",\n\"y\":")
                .append(y);
        sb.append('}');
        return sb.toString();
    }
}
