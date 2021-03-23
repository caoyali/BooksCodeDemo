package com.example.pattern.FlyweightPattern.moxiedemo1;

class Demo {
    public static void main(String[] args) {
        XiangQi 马 = QiziFactroy.getXiangqizi("马");
        马.down(100, 100);

        XiangQi ma2 = QiziFactroy.getXiangqizi("马");
        ma2.down(200, 200);

        XiangQi xiang1 = QiziFactroy.getXiangqizi("相");
        xiang1.down(100, 100);
    }
}
