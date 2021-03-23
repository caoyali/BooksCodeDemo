package com.example.pattern.FlyweightPattern.moxiedemo1;

class AbstractQizi implements XiangQi{
    final String text;

    public AbstractQizi(String text) {
        this.text = text;
    }

    @Override
    public void down(int x, int y) {
        System.out.println(text + " 要落在 x=" + x + " y=" + y + " 点，接下来计算能不能落！");
    }

    @Override
    public void down(String 其他的属性) {
        System.out.println(text + " 要落在 其他的属性=" + 其他的属性);
    }

    public String getText() {
        return text;
    }
}
