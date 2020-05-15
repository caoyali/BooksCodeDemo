package com.example.typeinfo;

import com.example.util.print.Print;

/**
 *  电子书395页，关于ForName的用法
 */
class Candy {
    static {
        Print.print("loading Candy");
    }
}

class Gum {
    static {
        Print.print("loading Gum");
    }
}

class Cookie {
    static {
        Print.print("loading cookie");
    }
}
public class SweetShop {
    public static void main(String[] args) {
        Print.print("inside main!");
        new Candy();
        Print.print("after create Candy");
        try {
            // 前面的是文件名字，后面的是类名。，后面的Gum，由于是一个类文件里面的其他类，也不是内部类哈。要找到这个类还是
            Class.forName("com.example.typeinfo.SweetShop.Gum");
        } catch (ClassNotFoundException e) {
            Print.print("Could't find Gum");
        }

        Print.print("After Class.forName(Gum)");
        new Cookie();
        Print.print("After creating Cookie!");
    }
}
