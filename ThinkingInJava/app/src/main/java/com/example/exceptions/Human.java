package com.example.exceptions;
// 烦恼，使人烦恼的事
class Annoyance extends Exception {

}

// 喷嚏
class Sneeze extends Annoyance {

}

public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance annoyance) {
            System.out.println("Caught Annoyance");
        }

        try {
            throw new Sneeze();
        } catch (Annoyance annoyance) {
            System.out.println("Caught Annoyance");
        }
        // 如果父类在前面被捕获，此时，不管这个子类有多精准，多么匹配，都会
        // 在编译期时报错！
//        catch (Sneeze sneeze) {
//            System.out.println("");
//        }
    }
}
