money=100;
s=int(input("请输入取款金额"))
if (s < 0):
    print("余额不够")
else:
    print("可以取钱")
    money=money-s
print("最终的取款为：", money)

fenshu=int(input("输入你考了多少分："))
if fenshu > 90:
    print("90分以上")
elif fenshu > 80:
    print("80分以上")
elif fenshu > 70:
    print("70分以上")
elif fenshu > 60:
    print("刚及格")
else:
    print("不及格，重考去吧你！")

print("使用条件表达式")
# print(  if   )
