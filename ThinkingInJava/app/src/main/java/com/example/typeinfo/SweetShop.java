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
//             前面是包名字，最后是具体的类名字。 Gum虽然是在SweetShop中写的，但是变成class文件的时候是不在这个文件里面的。
            Class.forName("com.example.typeinfo.Gum");
            // forName方法会引发静态资源的加载,但是前提是以前并没有加载过这个类。首次加载的时候就会加载里面的静态资源。
        } catch (ClassNotFoundException e) {
            Print.print("Could't find Gum e=" + e);
        }

        Print.print("After Class.forName(Gum)");
        new Cookie();
        Print.print("After creating Cookie!");
    }
}
