# coding=UTF-8
# 字符编码设置

# 字符串格式化 %-formatting(最早 Python 的格式化字串)
# %-formatting、str-format（Python 2.6+）、f-string （Python 3.6+）
str = r"%s-%s.jpg" % (2,4)
print(str)

temp = "I am {first_name} {middle_name}. {last_name}".format(
     first_name='li',
     middle_name='shi',
     last_name='min'
)
print(temp)

# 字符串连接f-string
name = "Django"
age = 4
print(f'My name is {name} and I am {age} years old')

fresh_fruit = {
    'apple': 10,
    'banana': 8,
    'lemon': 5,
}

# :=海象运算符
if (count := fresh_fruit.get('lemon', 0)) >=5:
	print(count)

'''
weight = float(input("请输入你的体重（Kg）："))
height = float(input("请输入你的身高（m）："))
BMI = weight / height ** 2
if BMI < 0:
   print("输入错误")    
elif BMI < 18.5 :
   print("偏瘦")
elif BMI < 25 :
   print("正常")
elif BMI < 30 :
   print("偏胖")
elif BMI < 35 :
   print("肥胖")
else:
   print("重度肥胖")

'''

# 高级解析式
price_list = [1.34, 19.01, -4.2, 6, 8.78, -1,1]
normalized_price_list = [price if price > 0 else price*-1 for price in price_list]
print(normalized_price_list)

# 集合解析式
string = "Excellent"
unique_string = {letter for letter in string}
print(unique_string)

# 字典解析式
string = "Words are but wind"
word_order = {el: ind+1 for ind, el in enumerate(string.split())}
print(word_order)