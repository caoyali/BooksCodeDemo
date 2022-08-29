# range是一个内置函数，是管干嘛的呢？用于生成一个整数序列
# range的三种创建方式
# range到底是什么意思，生成一个等差数列，你没有指定的话，就是10个，步长是1
# 从0开始到10结束，不包含10，步长为1
r=range(10)
print(r)
print(type(r))
print(list(r))

# 使用range的好处是，如果是等差数列的话，我根本不用记录这个数列的内容，只需要记下数列的规则即可
# 这样的话，如果这个数列有很多值，但是事实上我们根本就没有记录，只是记住了规律
# 另外一种指定的方式
# 从1开始到10结束，不包含10，步长为1
R1=range(1, 10)
print(list(R1))

# range是一个可迭代对象
# 从1开始到10结束，步长为2
R2=range(1, 10, 2)
print(list(R2))
# 指定的整数是不是在里面
print(10 in R2)
print(10 not in R2)

while不讲了

for item in "yayali":
    print(item)

# 循环中，如果循环中根本用不到自定义的每个item，可将自定义变量为_
for _ in range(10):
    # 看看这里的下划线，纯粹就是
    print("人生苦短，我用python")