# 变量
# 非常简单, 但是跟java不一样的是我们并不会指定类型的。至于类型到底是什么，有专门的函数可以查出来
name="玛利亚"
print(name)
# 查id的
print('标识', id(name))
# 查类型的
print('类型', type(name))
print('值', name)
# 变量的值是可以改变的，所以它叫变量
name="玛利亚" # 玛利亚被赋值之后，它就变成了内存垃圾。会被自动回收的。这点和java非常像
print(name)
# 会指向一个新的空间的。被打印id的时候，我们已经看出来这个被赋值了
print(id(name))
name="出溜冰"
print(name)
print(id(name))