# 转义字符
# \n, \r, \t, \b

# \n 光标开始新的一行 new line
print("Hello\nworld")
# \t table 一个\t代表的是四个空格的数量。 会向着四个来凑
print("Hello\tworld")
print("Helloooo\tworld")
# 将光标移至行头
print("Hello \r world")
# back 退一个格子
print("Helloo\bworld")
# 反斜杠，单引号，双引号， 网址的时候会用到
print("http:\\\\www.baidu.com")
# 在单引号中输出一个单引号,或者双引号
print("老师说：、\"大家好！\"")

# 原字符， 不希望转义字符起作用.在整个字符串前面加上r或者R， 但是最后一个字符不可以是反斜线
print(r"Hello\nworld")
# print(R'Hello\nword\') 这句话是错的

# unicode编码的号，会打印出来它对应的字符
print(chr(0b100111001011000))
# 反解
print(ord('乘'))

