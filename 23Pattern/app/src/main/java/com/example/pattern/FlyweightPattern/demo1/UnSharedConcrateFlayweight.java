package com.example.pattern.FlyweightPattern.demo1;

/**
 * 搞笑的是例子都写完了，我还不知道这个类是干嘛用的。失败的案例加上失败的文章啊。
 */
public class UnSharedConcrateFlayweight extends FlyWeight{
    UnSharedConcrateFlayweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    protected void operation() {
        System.out.println("UnSharedConcrateFlayweight operation extrinsic=" + extrinsic + " intrinsic" + getIntrinsic());
    }
}
