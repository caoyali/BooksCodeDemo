package com.example.pattern.FlyweightPattern.demo1;

public abstract class FlyWeight {
    private String intrinsic;
    protected final String extrinsic;

    FlyWeight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    protected abstract void operation();

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }

    public String getIntrinsic() {
        return this.intrinsic;
    }
}
