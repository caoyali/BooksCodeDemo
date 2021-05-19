package com.example.generics;

/**
 * 研究对于最初就设立泛型的类，在使用的时候会出现什么样的行为区别
 */
public class AAI_Wildcards {
    /**
     * AAB_Holder 这个类是有泛型的，但是它用作方法参数的时候故意不给它设置泛型。
     * 试试如何？
     * @param holder
     * @param arg
     */
    static void rawArgs(AAB_Holder holder, Object arg) {
        //书上说会报错，但是这里并没有报错,看来它的确在一定程度已经和过时了。
        holder.set(arg);

        //同上，书上说这个会报错，但是现在已经不会报错了。
        holder.set(new AAI_Wildcards());

        //这句话会报错，原因是，在跑代码的时候，T 是个啥？关键是T 连个类型都不是，怎么算？
//        T t = holder.get();

        //这句话是可以的。因为类型信息已经丢失了。我认为这个解释有点缺失上下文。不是很容易让人理解。
        Object obj = holder.get();
    }

    static void unboundedArgs(AAB_Holder<?> holder, Object arg) {
        // 为什么会报错？？是因为 问号的意思，让其无法解析出来到底是个啥东西吗？
//        holder.set(arg);
        // 报错，与上面同样的错误
//        holder.set(new AAI_Wildcards());

        // 报错，T 是个啥？既不是类型，又不是其他的，连声明都没有，没有办法识别。即使声明了，也依然会报错。我没有找到合理的解释。
//        T t = holder.get();

        // 这句话是可以的，但是类型信息已经丢失了。
        Object obj = holder.get();
    }

    static <T> T exact1(AAB_Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(AAB_Holder<T> holder, T args) {
        holder.set(args);
        T t = holder.get();
        return t;
    }

    static <T> T wildSupertype(AAB_Holder<? extends T> holder, T arg) {
//        报错，holder中已经被限制了，是T的子类！
//        holder.set(arg);
        T t = holder.get();
        return t;
    }
}
