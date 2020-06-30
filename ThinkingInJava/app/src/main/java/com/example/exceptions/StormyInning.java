package com.example.exceptions;

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    public Inning() throws BaseballException {

    }

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike;

    public void walk() {

    }
}

class StormException extends Exception{

}

class RainedOut extends StormException{}

class PopFoul extends Foul{}

interface Storm {
    // 在接口中写public关键字相当于不写！因为接口中的接口只可能是public的
    public void event() throws RainedOut;

    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{

    /**
     * 父类的构造方法中抛出了一个异常，那么子类的重写方法中一定要写上throws
     * 父类的构造方法中没有抛出异常，那么你也不能抛出异常.
     * 因为只有这样你才可以好好利用面向对象的特性去完成一些高抽象的事情
     *
     * @throws RainedOut
     * @throws Exception
     * @throws BaseballException
     */
    public StormyInning() throws RainedOut,BaseballException{

    }

    /**
     *
     * 你可以添加重载的构造方法，但是你必须按照父类的构造方法抛出的异常。遵循，否则编译会有问题
     * @param s
     * @throws Foul
     * @throws BaseballException
     */
    public StormyInning(String s) throws Foul, BaseballException{

    }



    @Override
    public void atBat() throws Strike {

    }

    @Override
    public void rainHard() throws RainedOut {

    }

//    /**
//     * 编译错误，原因是缩小了父类的访问范围
//     */
//    void walk() {
//
//    }

//    /**
//     * 编译错误，因为父类的代码都没有抛出异常，子类是不能开拓性的抛出异常的。
//     * 否则，根据面向对象的使用习惯，父类没有异常，向上转型调用的时候肯定出错。
//     * @throws PopFoul
//     */
//    public void walk() throws PopFoul {
//
//    }

    public void walk() {

    }

//    /**
//     * 这个有一个坑啊！继承的基类和实现的接口有一样的方法，但是他们抛出不同的异常
//     * 这个时候任凭你怎么写，也会有问题
//     * @throws RainedOut
//     */
//    public void event() throws RainedOut, BaseballException {
//        // 懒得写了，一堆报错
//    }

    /**
     * 但是这个时候，不可以选择不抛出异常。这样的话，面对这种冲突是合规的。
     *
     */
    public void event() {

    }

}
