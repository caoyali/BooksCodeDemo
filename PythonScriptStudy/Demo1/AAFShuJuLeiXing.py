# 基本数据类型
# 整数类型， 浮点类型， 布尔类型，字符串类型
# int 98
# float 3.12
# bool true
# str "hahahha"   不管什么符号被加上单引号，双引号，三引号，都是字符串

# 整数类型， 正数，负数和0
# Python中的整数是十进制
n1=90
n2=-1
n3=0
print(n1, "typen1:", type(n1))
# 正数可以表示为十进制，二进制，八进制，16进制
n4=118
# 二进制
n5=0b10101111
# 八进制,第二个是o
n6=0o222
# 16进制
n7=0x1111

print(n4, n5, n6, n7)

# 浮点类型， 所有带小数点的数都是浮点数
a=3.14159
print(a)
print(type(a))
print(id(a))
# 但是如果我们纯算这个的话，可能不会很准确。如果非要准确的话，那么要拥戴一个Decimal的类
# 这个是我从来没有想到过的新语法。java中 不会这么用，这个挺有意思。看看吧。
from decimal import Decimal
print(Decimal('1.1') + Decimal('2.2'))

# 布尔值
# true是1， false是0
f1=True
f2=False
print(f1, type(f1))
print(f2, type(f2))
print(f1+f2)

# 字符串类型
# 可以单引号双引号三引号定义，只有三引号是可以换行的， 三引号用单引号双引号都可以的。单引号和双引号的效果是一样的
# 三引号是格式的感觉是
print('''人
生
苦
短
啊''')
