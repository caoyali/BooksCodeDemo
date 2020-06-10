package com.example.exceptions;

/**
 * 
 */
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {

}
public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
          LostMessage im = new LostMessage();
          try {
              im.f();
          } finally {
              // 注意这里，如果外层嵌套的话，不进行catch，在语法上也是可以的！但是保不齐会出问题！
              // 比如在此种语句下，VeryImportantException是会被丢掉的！当然，以我的习惯，我可能不会写出这样的代码哈哈哈哈！
              im.dispose();
          }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
