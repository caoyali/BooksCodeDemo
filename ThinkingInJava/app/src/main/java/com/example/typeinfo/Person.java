package com.example.typeinfo;

/**
 * 纸质书341页
 */
class Person {
    public static final Person NULL = new NullPerson();

    public final String first; //如果在最早的时候不给final修饰的内容加上赋值的话，那么java要求的是在构造方法中必须要给值。否则是会报错的。
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class NullPerson extends Person implements Null{ //自己补一个，好吧，没有Null这个接口。
        public NullPerson() {
            super("null", "null", "null");
        }

        @Override
        public String toString() {
            return super.toString();
        }

    }

}

interface Null{}
