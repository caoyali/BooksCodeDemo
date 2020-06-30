package com.example.exceptions;

class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter ++;

    public void despose () {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {

}

class NeedsCleanup2 extends NeedsCleanup {
    public NeedsCleanup2() throws ConstructionException{}
}

public class CleanupIdiom {
    public static void main(String[] args) {
        NeedsCleanup nc1 = new NeedsCleanup();
        try {

        } finally {
            // 没有catch？？？可能会出问题的！
            nc1.despose();
        }

        NeedsCleanup cn2 = new NeedsCleanup();
        NeedsCleanup cn3 = new NeedsCleanup();
        try {

        } finally {
            // 这里请注意一个比较细节的东西，就是释放的顺序请尽量按照声明的
            // 倒序来进行。这样可以避免一些资源依赖性的类，因为顺序不对而发生异常。
            cn3.despose();
            cn2.despose();
        }

        try {
            NeedsCleanup2 cn4 = new NeedsCleanup2();

            try {
                NeedsCleanup2 cn5 = new NeedsCleanup2();
                try {

                } finally {
                    cn5.despose();
                }
            } catch (ConstructionException e) {
                System.out.println(e);
            } finally {
                cn4.despose();
            }

        } catch (ConstructionException e) {
            System.out.println(e);
        }
    }
}
