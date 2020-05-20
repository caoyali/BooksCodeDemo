package com.example.zhujie;
/*
    @Target, @Retention @Inherited @Documented
    这四个是对注解进行注解的元注解，负责自定义的注解的属性
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 表示注解的作用对象。 ElementType.TYPE 表示类， ElementType.METHOD表示方法
@Target({ElementType.TYPE, ElementType.METHOD})
// 表示注解的保留机制， RetentionPolicy.RUNTIME表示运行时注解
@Retention(RetentionPolicy.RUNTIME)
// 表示该注解可继承
@Inherited
// 表示该注解可以生成文档
@Documented
public @interface Design {
    // 注解成员， 如果注解只有一个成员， 则成员的名字必须是value(), 成员类型只能是原始类型
    String author();

    // 注解成员， 默认值为0
    int data() default 0;
}
