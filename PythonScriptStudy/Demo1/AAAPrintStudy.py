# Print方法的用法
# print 方法可以输出点什么？
# 输出数字
print(50)
print(98.5)
# 输出子串，其实单双引号都是可以的
print('Hello World!')
print("Hello World")

# 输出表达式
print(3 + 1)

# 输出到文件当中，这个就犀利了！
# a+的意思是以读写的方式打开文件，如果这个文件存在，就在原有文件内容里面追加，如果文件不存在的话，就会创建一个
fp=open("/Demo1/AABTestPrintToFile.txt", "a+")
# 这里面有一个注意点，就是file=fp这个，file不能省略。我也不知道为啥哈哈哈哈
print("Hello World", file=fp);
fp.close()

# 假如我根本不想进行换行输出
print('hello', 'world', "Python")
