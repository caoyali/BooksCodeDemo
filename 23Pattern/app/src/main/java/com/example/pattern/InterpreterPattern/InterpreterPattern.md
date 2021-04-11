# Interpreter Pattern
解释器模式
#### 简述
解释器模式，我看了一些相关的文章，第一个感觉就是，不常用。另外一个感觉就是，这玩意儿解决的问题特别局限。也就是分析分析简单语句，写个脚本命令解析啥的。我工作几年，一次这种模式一次都没有用过。

#### 它有什么历史

#### 是碰到了什么问题，才出现的它
假设目前有一个题目，给你任意一个a+b+c这类的字符串，比较简单，只有加减法。你得出正确结果！你自己设计一个算法吧。是任意长度欧！
其实这就需要一个简单的解释器了，因为语句再长，实际上他们是符合一定规律的。
解：
```java
// 抽象出来一个操作，它可以是一个备操作数，也可以是一个操作
public interface IOperation {
    int operate();
}
// 操作父类
abstract class ColOpration implements IOperation{
    IOperation a;
    IOperation b;

    public ColOpration(IOperation a, IOperation b) {
        this.a = a;
        this.b = b;
    }
}
// 加法
class AddOperation extends ColOpration{

    public AddOperation(IOperation a, IOperation b) {
        super(a, b);
    }

    @Override
    public int operate() {
        return a.operate() + b.operate();
    }

    @Override
    public String toString() {
        return "(" + a + "+" + b + ")";
    }
}
// 减法
class SubOperation extends ColOpration{

    public SubOperation(IOperation a, IOperation b) {
       super(a, b);
    }

    @Override
    public int operate() {
        int r =  a.operate() - b.operate();
        return r;
    }

    @NonNull
    @Override
    public String toString() {
        return "(" + a + "-" + b + ")";
    }
}

// 被操作数
class Value implements IOperation{
    int value = 0;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int operate() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
// 解析语法，这里面含有大量的逻辑用语建树。最后只需要调用根节点，所有的结果就可以计算出来了。、
// 想象如果支持的命令多的话，光这块也得写不少代码，而且对于新的操作，估计要加很多对应的类。再复杂点估计还得在老类的基础上再
// 加代码。
class InterpreterHelper {
    public static int addAndSub(String str) {
        System.out.println("计算str=" + str);
        Stack<IOperation> operations = new Stack<>();
        char tempChar;
        int i = 0;
        while (i < str.length()) {
            tempChar = str.charAt(i);
            System.out.println("现在遍历到的参数是 tempChar=" + tempChar);
            if ('+' == tempChar) {
                // i= 1；
                IOperation old = operations.pop();
                if (i + 1 < str.length()) {
                    int ind = findNextOptionIndex(str, i + 1);
                    IOperation nextValue = new Value(getSubNextNumber(str, i + 1, ind));
                    AddOperation addOperation = new AddOperation(old, nextValue);
                    operations.push(addOperation);
                    i = ind;
                } else {
                    break;
                }
            } else if ('-' == tempChar) {
                IOperation old = operations.pop();
                if (i + 1 < str.length()) {
                    int ind = findNextOptionIndex(str, i + 1);
                    IOperation nextValue = new Value(getSubNextNumber(str, i + 1, ind));
                    SubOperation addOperation = new SubOperation(old, nextValue);
                    operations.push(addOperation);
                    i = ind;
                } else {
                    break;
                }
            } else {
                //普通数字
                int ind = findNextOptionIndex(str, i);
                IOperation value = new Value(getSubNextNumber(str, i, ind));
                operations.push(value);
                i = ind;
            }
        }
        IOperation operation = operations.pop();
        System.out.println("得到解释器解释：" + operation);
        int result = operation.operate();
        return result;
    }

    public static int getSubNextNumber(String str, int start, int end) {
        String sub = str.substring(start, end);
        System.out.println("截取数字：" + sub);
        return Integer.parseInt(sub);
    }

    public static int findNextOptionIndex(String str, int startIndex) {
        while (startIndex < str.length()) {
            char c = str.charAt(startIndex);
            if ('-' == c || '+' == c) {
                break;
            }
            startIndex ++;
        }
        System.out.println("str=" + str + " 下一个操作符坐标=" + startIndex);
        return startIndex;
    }
}

```
main方法调用
```java
class Client {
    public static void main(String[] args) {
        int result = InterpreterHelper.addAndSub("30+74+50-6+7");
        System.out.println("计算出来的结果是 result=" + result);
    }
}
```
#### 它是什么(粗略的)
- 语法<font color=ff0000>树</font>, 是树哈，这点是比较关键的。平常我们工作中会输入很多命令，这些命令都具备一些语法。例如，一个操作符后面跟上几个参数， 操作符与操作符也可以进行匹配。  例如我们经常用到的：shell dumpsys system activity， 解析这种问题，想来用树这种结构处理是比较容易理解的。
- 适用于将一些归纳总结有一定规律的东西抽象的表达出来。例如   加法，减法这类简单的，例如我们经常用到的命令。要不是经常出现并使用，谁没事儿造这么多命令。此处应当感叹科学家们的伟大智慧啊，让我们可以用代码描述万物。
#### 它是用来解决什么问题的，什么类的(目的)

#### 这个东西的具体是什么(详细的)

#### 这个东西的优势是什么（用处）

#### 如果这个东西用的不好，会出现什么问题(用错了，理解错了会怎样)

#### 总结

